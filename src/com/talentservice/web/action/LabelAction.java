package com.talentservice.web.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Label;
import com.talentservice.domain.Project;
import com.talentservice.service.base.BaseService;

@Controller("labelAction")
@Scope("prototype")
public class LabelAction extends BaseAction {
	
	private Label label = new Label() ;
	
	
	public void add(){
		
	}

	public Object getModel() {
		return label;
	}
	
	
}
