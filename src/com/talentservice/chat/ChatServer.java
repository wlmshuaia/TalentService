package com.talentservice.chat;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.BeanFactory;

import com.talentservice.domain.Chat;
import com.talentservice.domain.Group;
import com.talentservice.domain.User;
import com.talentservice.helper.BeanFactoryHelper;
import com.talentservice.service.base.BaseService;
import com.talentservice.utils.DateUtils;

/**
 * 聊天服务器类
 * 
 */
@ServerEndpoint("/websocket/{groupId}/{uid}")
public class ChatServer {
	// 最大通话数量
	private static final int MAX_COUNT = 20;
	private static final long MAX_TIME_OUT = 30 * 60 * 1000;
	// 嵌套，用于保存小组，user和对应的id
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 日期格式化
	private static final Map<String, Map<String, Session>> sessions = Collections.synchronizedMap(new HashMap<String, Map<String, Session>>());
	
	private BaseService baseService ;
	
	public ChatServer() {
		BeanFactory factory = BeanFactoryHelper.getFactory(); 
		baseService = (BaseService) factory.getBean("baseService") ;
	}
	
	@OnOpen
	public void open(Session session, @PathParam("groupId") String groupId, @PathParam("uid") String uid) {
		// 添加初始化操作
		session.setMaxIdleTimeout(MAX_TIME_OUT);
		if (sessions.get(groupId) == null) {
			Map<String, Session> tempMap = Collections.synchronizedMap(new HashMap<String, Session>());
			tempMap.put(uid, session);
			sessions.put(groupId, tempMap);
		} else {
			sessions.get(groupId).put(uid, session);
		}
		
		// 发送用户列表
		sendUserList(groupId) ;
		
		System.out.println("新增加小组用户:uid=" + uid);
	}

	/**
	 * 接受客户端的消息，并把消息发送给所有连接的会话
	 * 
	 * @param message
	 *            客户端发来的消息
	 * @param session
	 *            客户端的会话
	 */
	@OnMessage
	public void getMessage(String message, Session session) {
		System.out.println(message);
		
		// 把客户端的消息解析为JSON对象
		JSONObject jsonObject = JSONObject.fromObject(message);
		
		// 在消息中添加发送日期
		jsonObject.put("date", DATE_FORMAT.format(new Date()));
		
		Map<String, Session> tempMap = sessions.get(jsonObject.getString("groupid"));
		// 把消息发送给对应小组的所有成员会话
		Iterator iter = tempMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			// Object key = entry.getKey();
			Session openSession = (Session) entry.getValue();
			// 添加本条消息是否为当前会话本身发的标志
			jsonObject.put("isSelf", openSession.equals(session));
			// 类型为 ==> 聊天消息
			jsonObject.put("type", "message");
			// 发送JSON格式的消息
			openSession.getAsyncRemote().sendText(jsonObject.toString());
		}
		
		// 保存用户聊天信息
		String content = jsonObject.getString("content") ;
		String groupid = jsonObject.getString("groupid") ;
		String uid = jsonObject.getString("obj") ;
		
		Group group = (Group) this.baseService.getById(Group.class, Long.parseLong(groupid));
		User user = (User) this.baseService.getById(User.class, Long.parseLong(uid));
		Chat chat = new Chat() ;
		chat.setContent(content);
		chat.setSendtime(DateUtils.formatDateTime(new Date()));
		chat.setGroup(group);
		chat.setUser(user);
		this.baseService.save(chat) ;
	}
	
	/**
	 * 下线的时候从列表中删除
	 * 
	 */
	@OnClose
	public void close(@PathParam("groupId") String groupId, @PathParam("uid") String uid) {
		// 添加关闭会话时的操作
		System.out.println("websocket closed...");
		
		sessions.get(groupId).remove(uid) ;
		sendUserList(groupId) ;
	}

	@OnError
	public void error(Throwable t) {
		// 添加处理错误的操作
		System.out.println("websocket error...");
	}
	
	/**
	 * 发送用户列表
	 * 
	 * @param groupId
	 */
	public void sendUserList(String groupId){
		System.out.println("sendUserList...");
		JSONArray jsonArray = new JSONArray() ;
		JSONObject jsonObject = new JSONObject();
		// 把消息发送给对应小组的所有成员会话
		Iterator iter = sessions.get(groupId).entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			jsonObject.put("user", entry.getKey());
			User u = (User) this.baseService.getById(User.class, Long.parseLong((String) entry.getKey()));
			jsonObject.put("username", u.getUsername());
			jsonArray.add(jsonObject);
		}
		
		JSONObject jsonobj = new JSONObject() ;
		Map<String, Object> json = new HashMap<String, Object>() ;
		json.put("type", "user") ;
		json.put("userList", jsonArray) ;
		jsonobj = jsonobj.fromObject(json) ;
		
		// 发送用户列表
		iter = sessions.get(groupId).entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Session openSession = (Session) entry.getValue();
			openSession.getAsyncRemote().sendText(jsonobj.toString());
		}
		System.out.println("jsonobj: "+jsonobj.toString());
	}
	
}