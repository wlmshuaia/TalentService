package com.talentservice.admin.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Category;
import com.talentservice.domain.Circle;
import com.talentservice.domain.Project;
import com.talentservice.domain.User;

@Component("acircleAction")
@Scope("prototype")
public class ACircleAction extends BaseAction {
	
	private static final long serialVersionUID = -7731571019304768343L;
	
	private Circle circle = new Circle() ;
	
	public void list() throws UnsupportedEncodingException {
		
		List<Circle> circleList = (List<Circle>) this.baseService.getAll(Circle.class) ;
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(Circle circle : circleList){
        	jsonobj.put("id", circle.getCid());
        	jsonobj.put("circlename", circle.getCirclename());
        	jsonobj.put("description", circle.getDescription());
        	jsonobj.put("category_id", circle.getCategory().getCatename());
        	jsonobj.put("foundtime", circle.getFoundtime());
        	jsonobj.put("founder_id", circle.getUser().getUsername());
        	jsonArray.add(jsonobj) ;
        }
        writeToPage(circleList.size(), jsonArray);
	}
	
	public Object getModel() {
		return circle;
	}
	
}
