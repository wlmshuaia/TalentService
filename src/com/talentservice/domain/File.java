package com.talentservice.domain;

/**
 * File entity. @author MyEclipse Persistence Tools
 */

public class File implements java.io.Serializable {

	// Fields

	private Long fid;
	private Project project;
	private String filename;
	private String url;

	// Constructors

	/** default constructor */
	public File() {
	}

	/** minimal constructor */
	public File(Project project) {
		this.project = project;
	}

	/** full constructor */
	public File(Project project, String filename, String url) {
		this.project = project;
		this.filename = filename;
		this.url = url;
	}

	// Property accessors

	public Long getFid() {
		return this.fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}