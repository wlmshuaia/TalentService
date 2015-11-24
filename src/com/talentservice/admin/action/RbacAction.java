package com.talentservice.admin.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Admin;
import com.talentservice.domain.Node;
import com.talentservice.domain.Role;

@Controller("rbacAction")
@Scope("prototype")
public class RbacAction extends BaseAction {
	
	private static final long serialVersionUID = 3792002582097649838L;
	
	public void roleList() {
		List<Role> roleList = (List<Role>) this.baseService.getAll(Role.class) ;
		
		JSONArray jsonArray = new JSONArray() ;
		JSONObject jsonobj = new JSONObject() ;
		for(Role r : roleList){
			jsonobj.put("id", r.getRid()) ;
			jsonobj.put("rolename", r.getRolename()) ;
			jsonobj.put("remark", r.getRemark()) ;
			if(r.getStatus() == 1){
				jsonobj.put("status", "开启") ;
			}else{
				jsonobj.put("status", "关闭") ;
			}
			jsonArray.add(jsonobj) ;
		}
		writeToPage(roleList.size(), jsonArray) ;
	}
	
	public void roleUserList() {
		List<Admin> adminList = (List<Admin>) this.baseService.getAll(Admin.class) ;
		
		JSONArray jsonArray = new JSONArray() ;
		JSONObject jsonobj = new JSONObject() ;
		for(Admin a : adminList){
			jsonobj.put("id", a.getAid()) ;
			jsonobj.put("adminname", a.getAdminname()) ;
			jsonobj.put("lastlogintime", a.getLastlogintime()) ;
			jsonobj.put("lastloginip", a.getLastloginip()) ;
			jsonArray.add(jsonobj) ;
		}
		writeToPage(adminList.size(), jsonArray) ;
	}
	
	public void nodeList() {
		List<Node> nodeList = (List<Node>) this.baseService.getAll(Node.class) ;
		
		JSONArray jsonArray = new JSONArray() ;
		JSONObject jsonobj = new JSONObject() ;
		for(Node n : nodeList){
			jsonobj.put("id", n.getNid()) ;
			jsonobj.put("nodename", n.getNodename()) ;
			jsonobj.put("remark", n.getRemark()) ;
			jsonobj.put("title", n.getTitle()) ;
			jsonobj.put("status", n.getStatus()) ;
			jsonobj.put("sort", n.getSort()) ;
			jsonobj.put("pid", n.getPid()) ;
			jsonArray.add(jsonobj) ;
		}
		writeToPage(nodeList.size(), jsonArray) ;
	}
	
	public Object getModel() {
		return null;
	}
	
}
