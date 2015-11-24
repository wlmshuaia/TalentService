package com.talentservice.lucene;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LuceneSearchAction implements Action {
	private String searchContent;
	private List house_list;

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List getHouse_list() {
		return house_list;
	}

	public void setHouse_list(List house_list) {
		this.house_list = house_list;
	}

	public String execute() throws Exception {
		/*Lucene lucene = new Lucene();
		lucene.indexCreateUtil();
		lucene.indexSearchUtil(searchContent);
		ActionContext.getContext().getSession()
				.put("house_list", lucene.getList());*/
		return SUCCESS;
	}
}