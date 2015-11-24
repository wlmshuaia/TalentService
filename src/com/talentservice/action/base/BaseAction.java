package com.talentservice.action.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.talentservice.domain.Enterprise;
import com.talentservice.domain.School;
import com.talentservice.domain.Student;
import com.talentservice.domain.Teacher;
import com.talentservice.domain.User;
import com.talentservice.domain.Workman;
import com.talentservice.service.base.BaseService;
import com.talentservice.utils.JsonUtils;

/**
 * 封装一些共用的东西
 * @author Administrator
 *
 */
public abstract class BaseAction extends ActionSupport implements ModelDriven<Object> {
	
	@Resource(name="baseService")
	protected BaseService baseService ;
	
	protected String ids ;
	
	public static final String LISTACTION = "listAction" ;
	public static final String ADDUI = "addUI" ;
	public static final String UPDATEUI = "updateUI" ;
	public static final String ACTION2ACTION = "action2action" ;
	public static final String GETINFO = "getInfo" ;
	
	public String listAction = LISTACTION ;
	public String addUI = ADDUI ;
	public String updateUI = UPDATEUI ;
	public String action2action = ACTION2ACTION ;
	public String getInfo = GETINFO ;
	
	/**
	 * 读出列表
	 */
	
	
	/**
	 * 保存
	 */
	public void save() {
		
	}
	
	/**
	 * 修改数据
	 */
	public void update() {
		
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Object model = getModel();
		if("".equals(ids)){
			writeJson(JsonUtils.getSuccessJson("删除失败！")) ;
		}else{
			this.baseService.deleteByIds(model.getClass(), ids) ;
			writeJson(JsonUtils.getSuccessJson("成功删除"+ids.split(",").length+"条记录！")) ;
		}
	}
	
	/**
	 * 后台 datagrid json格式数据
	 * @param collectionSize
	 * @param jsonArray
	 */
	public void writeToPage(int collectionSize, JSONArray jsonArray) {
		JSONObject jsonobj = new JSONObject();
		Map<String, Object> json = new HashMap<String, Object>();
        
		json.put("total", collectionSize); // total键 存放总记录数，必须的
        json.put("rows", jsonArray); // rows键 存放每页记录 list
        
        jsonobj = JSONObject.fromObject(json); // 格式化result一定要是JSONObject
        
		System.out.println("writetopage: "+jsonobj);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(jsonobj);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 向前台返回指定名称json数据
	 * @param name
	 * @param jsonArray
	 */
	public void writeOneToPage(String name, JSONArray jsonArray) {
		JSONObject jsonobj = new JSONObject();
		Map<String, Object> json = new HashMap<String, Object>();
        
        json.put("values", jsonArray); // rows键 存放每页记录 list
        
        jsonobj = JSONObject.fromObject(json); // 格式化result一定要是JSONObject
        
		System.out.println("writeonetopage: "+jsonobj);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(jsonobj);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 返回 json 格式串
	 */
	public void writeJson(String content) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("writeJson: "+content);
		
		PrintWriter out = null ;
		try {
			out = response.getWriter() ;
			out.write(content) ;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush() ;
			out.close() ;
		}
	}
	
	/**
	 * 返回头像地址
	 * @param u
	 * @return
	 */
	public String getGravatar(User u) {
		short type = u.getType() ;
		String gravatar = "" ;
		switch(type) {
		case 0:
			Student student = (Student) this.baseService.getById(Student.class, u.getUserId()) ;
			gravatar = student.getGravatar() ;
			break ;
		case 1:
			School school = (School) this.baseService.getById(School.class, u.getUserId()) ;
			gravatar = school.getGravatar() ;
			break ;
		case 2:
			Workman workman = (Workman) this.baseService.getById(Workman.class, u.getUserId()) ;
			gravatar = workman.getGravatar() ;
			break ;
		case 3:
			Enterprise enterprise = (Enterprise) this.baseService.getById(Enterprise.class, u.getUserId()) ;
			gravatar = enterprise.getGravatar() ;
			break ;
		case 4:
			Teacher teacher = (Teacher) this.baseService.getById(Teacher.class, u.getUserId()) ;
			gravatar = teacher.getGravatar() ;
			break ;
		}
		return gravatar ;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
