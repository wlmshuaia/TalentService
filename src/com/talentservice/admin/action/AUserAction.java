package com.talentservice.admin.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.User;

@Component("auserAction")
@Scope("prototype")
public class AUserAction extends BaseAction {

	private static final long serialVersionUID = -4528089472965175145L;
	
	private User user = new User();
	
	public void list() {
		List<User> userList = (List<User>) this.baseService.getAll(User.class);
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(User user : userList){
        	jsonobj.put("id", user.getUid());
        	jsonobj.put("username", user.getUsername());
        	jsonobj.put("type", user.getType()) ;
        	jsonobj.put("user_id", user.getUserId()) ;
        	jsonArray.add(jsonobj) ;
        }
        
        writeToPage(userList.size(), jsonArray);
	}
	
	public Object getModel() {
		return user;
	}
	
}
