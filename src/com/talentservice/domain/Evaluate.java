package com.talentservice.domain;

/**
 * Evaluate entity. @author MyEclipse Persistence Tools
 */

public class Evaluate implements java.io.Serializable {

	// Fields

	private Long eid;
	private User userByTouserId;
	private User userByFromuserId;
	private Project project;
	private String content;
	private String evaluatetime;

	// Constructors

	/** default constructor */
	public Evaluate() {
	}

	/** full constructor */
	public Evaluate(User userByTouserId, User userByFromuserId,
			Project project, String content, String evaluatetime) {
		this.userByTouserId = userByTouserId;
		this.userByFromuserId = userByFromuserId;
		this.project = project;
		this.content = content;
		this.evaluatetime = evaluatetime;
	}

	// Property accessors

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public User getUserByTouserId() {
		return this.userByTouserId;
	}

	public void setUserByTouserId(User userByTouserId) {
		this.userByTouserId = userByTouserId;
	}

	public User getUserByFromuserId() {
		return this.userByFromuserId;
	}

	public void setUserByFromuserId(User userByFromuserId) {
		this.userByFromuserId = userByFromuserId;
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

	public String getEvaluatetime() {
		return this.evaluatetime;
	}

	public void setEvaluatetime(String evaluatetime) {
		this.evaluatetime = evaluatetime;
	}

}