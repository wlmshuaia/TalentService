package com.talentservice.domain;

/**
 * Planfile entity. @author MyEclipse Persistence Tools
 */

public class Planfile implements java.io.Serializable {

	// Fields

	private Long pfid;
	private Plan plan;
	private String name;
	private String url;

	// Constructors

	/** default constructor */
	public Planfile() {
	}

	/** full constructor */
	public Planfile(Plan plan, String name, String url) {
		this.plan = plan;
		this.name = name;
		this.url = url;
	}

	// Property accessors

	public Long getPfid() {
		return this.pfid;
	}

	public void setPfid(Long pfid) {
		this.pfid = pfid;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}