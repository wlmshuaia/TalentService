package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Long cid;
	private String catename;
	private String description;
	private Set userCategories = new HashSet(0);
	private Set projects = new HashSet(0);
	private Set circles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String catename, String description, Set userCategories,
			Set projects, Set circles) {
		this.catename = catename;
		this.description = description;
		this.userCategories = userCategories;
		this.projects = projects;
		this.circles = circles;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getUserCategories() {
		return this.userCategories;
	}

	public void setUserCategories(Set userCategories) {
		this.userCategories = userCategories;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	public Set getCircles() {
		return this.circles;
	}

	public void setCircles(Set circles) {
		this.circles = circles;
	}

}