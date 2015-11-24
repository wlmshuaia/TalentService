package com.talentservice.admin.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.talentservice.action.base.BaseAction;
import com.talentservice.domain.Category;
import com.talentservice.utils.JsonUtils;

@Component("acategoryAction")
@Scope("prototype")
public class ACategoryAction extends BaseAction {

	private static final long serialVersionUID = -7616759794747507213L;
	private Category category = new Category() ;
	
	/**
	 * 分类列表
	 * @throws UnsupportedEncodingException
	 */
	public void list() throws UnsupportedEncodingException {
		
		List<Category> categoryList = (List<Category>) this.baseService.getAll(Category.class);
		
		JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        
        for(Category cate : categoryList){
        	jsonobj.put("id", cate.getCid());
        	jsonobj.put("catename", cate.getCatename());
        	jsonobj.put("description", cate.getDescription());
        	jsonArray.add(jsonobj) ;
        }
        writeToPage(categoryList.size(), jsonArray);
	}
	
	/**
	 * 添加分类
	 */
	public void add(){
		if(this.baseService.save(category) != null){
			String content = JsonUtils.getSuccessJson("成功添加！") ;
			writeJson(content) ;
		}else{
			String content = JsonUtils.getErrorJson("添加失败！") ;
			writeJson(content) ;
		}
	}
	
	public void update(){
		if(this.baseService.update(category) != null){
			String content = JsonUtils.getSuccessJson("修改成功！") ;
			writeJson(content) ;
		}else{
			String content = JsonUtils.getErrorJson("修改失败！") ;
			writeJson(content) ;
		}
	}
	
	public Object getModel() {
		return category;
	}
	
}
