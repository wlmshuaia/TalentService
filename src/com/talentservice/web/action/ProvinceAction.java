package com.talentservice.web.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Category;
import com.talentservice.domain.Province;

@Controller("provinceAction")
@Scope("prototype")
public class ProvinceAction extends BaseAction {
	
	private Province province = new Province() ;
	
	public void list() throws UnsupportedEncodingException {
		
		List<Province> provinces = (List<Province>) this.baseService.getAll(Province.class) ;
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(Province province : provinces){
        	jsonobj.put("id", province.getPid());
        	jsonobj.put("provincename", province.getProvincename());
        	jsonArray.add(jsonobj) ;
        }
        writeToPage(provinces.size(), jsonArray);
	}
	
	public void add(){
		
	}

	public Object getModel() {
		return province;
	}
	
}
