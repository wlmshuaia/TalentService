package com.talentservice.domain;

/**
 * Projectlog entity. @author MyEclipse Persistence Tools
 */

public class Projectlog implements java.io.Serializable {

	// Fields

	private Long lid;
	private Project project;
	private String handle;
	private String handletime;

	// Constructors

	/** default constructor */
	public Projectlog() {
	}

	/** full constructor */
	public Projectlog(Project project, String handle, String handletime) {
		this.project = project;
		this.handle = handle;
		this.handletime = handletime;
	}

	// Property accessors

	public Long getLid() {
		return this.lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getHandle() {
		return this.handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getHandletime() {
		return this.handletime;
	}

	public void setHandletime(String handletime) {
		this.handletime = handletime;
	}

}