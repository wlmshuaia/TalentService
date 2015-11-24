package com.talentservice.web.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Category;
import com.talentservice.service.base.BaseService;

@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction {
	
	private Category category = new Category() ;
	
	
	
	public void add(){
		
	}
	
	public Object getModel() {
		return category;
	}
	
}
