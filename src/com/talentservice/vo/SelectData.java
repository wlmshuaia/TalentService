package com.talentservice.vo;

import java.io.Serializable;

public class SelectData implements Serializable {

	private static final long serialVersionUID = 384580164649253015L;
	
	private int id ;
	private String content ;
	
	public SelectData(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
