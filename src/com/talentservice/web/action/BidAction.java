package com.talentservice.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Bid;
import com.talentservice.domain.Project;
import com.talentservice.domain.Projectlog;
import com.talentservice.domain.User;
import com.talentservice.service.WorkflowManager;
import com.talentservice.utils.DataUtils;
import com.talentservice.utils.DateUtils;
import com.talentservice.utils.JsonUtils;
import com.talentservice.utils.OAUtils;

@Controller("bidAction")
@Scope("prototype")
public class BidAction extends BaseAction {
	
	private static final long serialVersionUID = -9106532980555152422L;
	
	@Resource(name="workflowManager")
	private WorkflowManager workflowManager ;
	
	private Bid bid = new Bid() ;
	// 项目主键id
	private String pid ;
	// 任务ID
	private String taskId ;
	// 前台用户主键 ID
	private String uid ;
	
	/**
	 * 提交竞标方案
	 * 	* 保存竞标方案
	 * 	* 传递json数据到前台
	 * @return
	 */
	public void bid() {
		User user = (User) OAUtils.fromSession("user") ;
		if(user != null){
			Project p = (Project) this.baseService.getById(Project.class, Long.parseLong(pid)) ;
			bid.setBidtime(DateUtils.formatDateTime(new Date())) ;
			bid.setUser(user) ;
			bid.setProject(p) ;
			bid.setIssuccess("等待审核中") ;
			this.baseService.save(bid) ;
			writeJson(JsonUtils.getSuccessJson("提交成功")) ;
			//return "" ;
		}else{
			writeJson(JsonUtils.getErrorJson("请先登录")) ;
			//return ERROR ;
		}
	}
	
	/**
	 * 选择承接人
	 * 	* 结束 bidding 流程任务
	 * 		* 结束任务
	 * 		* 设定流程变量 ==> 设定 bidder 流程变量值
	 * 	* 修改项目状态为进行中
	 * 	* 更新项目承接人
	 * 	* 修改bid ==> 竞标方案表 isSuccess 属性  ==> 不是必须
	 * 	* 增加项目日志
	 * 	* 推送选择竞标信息给承接人
	 *  * 返回成功信息到前台
	 * 
	 */
	public String bidChoose() {
		System.out.println("bidChoose: "+pid);
		
		Project p = (Project) this.baseService.getById(Project.class, Long.parseLong(pid)) ;
		
		// 设定bidder流程变量，结束 bidding 流程任务
		User user = (User) this.baseService.getById(User.class, Long.parseLong(uid)) ;
		Map<String, Object> variables = new HashMap<String, Object>() ;
		variables.put("bidder", user.getUsername()) ;
		this.workflowManager.completeTaskByTaskId(taskId, DataUtils.TO_MAKEPLAN, variables) ;
		
		// 修改项目状态
		p.setStatus(DataUtils.PROJECT_UNDERWAY) ;
		User bidder = (User) this.baseService.getById(User.class, Long.parseLong(uid)) ;
		p.setUndertaketime(DateUtils.formatDate(new Date())) ;
		p.setUserByUndertakerId(bidder) ;
		this.baseService.update(p) ;
		
		// 增加项目日志
		Projectlog pl = new Projectlog() ;
		pl.setHandle(DataUtils.PROJECT_CHOOSE) ;
		pl.setHandletime(DateUtils.formatDateTime(new Date())) ;
		pl.setProject(p) ;
		this.baseService.save(pl) ;
		
		// 推送选择竞标信息给承接人
		
		// 返回成功信息到前台
		//writeJson(JsonUtils.getSuccessJson("选定")) ;
		return "personalProjectList" ;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Object getModel() {
		return bid;
	}
}
