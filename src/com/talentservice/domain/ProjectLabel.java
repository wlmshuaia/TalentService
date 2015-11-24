package com.talentservice.domain;

/**
 * ProjectLabel entity. @author MyEclipse Persistence Tools
 */

public class ProjectLabel implements java.io.Serializable {

	// Fields

	private Long id;
	private Label label;
	private Project project;

	// Constructors

	/** default constructor */
	public ProjectLabel() {
	}

	/** full constructor */
	public ProjectLabel(Label label, Project project) {
		this.label = label;
		this.project = project;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}