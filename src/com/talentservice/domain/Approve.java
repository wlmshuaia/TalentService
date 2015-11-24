package com.talentservice.domain;

/**
 * Approve entity. @author MyEclipse Persistence Tools
 */

public class Approve implements java.io.Serializable {

	// Fields

	private Long aid;
	private Admin admin;
	private Project project;
	private String content;
	private String approvetime;
	private String isApprove;

	// Constructors

	/** default constructor */
	public Approve() {
	}

	/** full constructor */
	public Approve(Admin admin, Project project, String content,
			String approvetime, String isApprove) {
		this.admin = admin;
		this.project = project;
		this.content = content;
		this.approvetime = approvetime;
		this.isApprove = isApprove;
	}

	// Property accessors

	public Long getAid() {
		return this.aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getApprovetime() {
		return this.approvetime;
	}

	public void setApprovetime(String approvetime) {
		this.approvetime = approvetime;
	}

	public String getIsApprove() {
		return this.isApprove;
	}

	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}

}