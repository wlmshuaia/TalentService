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
import com.talentservice.domain.Label;
import com.talentservice.domain.Project;
import com.talentservice.domain.User;

@Component("alabelAction")
@Scope("prototype")
public class ALabelAction extends BaseAction {

	private static final long serialVersionUID = 941628472791716536L;
	
	private Label label = new Label() ;
	
	public void list() throws UnsupportedEncodingException {
		
		List<Label> labelList = (List<Label>) this.baseService.getAll(Label.class) ;
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(Label label : labelList){
        	jsonobj.put("id", label.getLid());
        	jsonobj.put("labelname", label.getLabelname());
        	jsonArray.add(jsonobj) ;
        }
        writeToPage(labelList.size(), jsonArray);
	}

	public Object getModel() {
		return label;
	}
	
}
