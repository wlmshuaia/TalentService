package com.talentservice.ikanalyzer;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Project;

@Controller("luceneAction")
@Scope("prototype")
public class LuceneAction extends BaseAction {
	
	private String field ;
	
	public String getSearch(){
		LuceneDao luceneProcess = new LuceneDao("F:/index");
        try {
        	List<Project> plist = (List<Project>) this.baseService.getAll(Project.class);
            luceneProcess.createIndex(plist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //查询测试
        String [] fields = {"description", "title"};
        Map<String, Object> val = luceneProcess.search(fields, field) ;
        List<Project> list = (List<Project>) val.get("result") ;
        for(int i = 0; i < list.size(); i ++){
            Project project = list.get(i);
            System.out.println("("+project.getPid()+") title: "+project.getTitle()+", description: "+project.getDescription());
        }
		
        ActionContext.getContext().put("dataList", list);
		return "searchResult" ;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public Object getModel() {
		return null;
	}
}
