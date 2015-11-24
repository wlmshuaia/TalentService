package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Label entity. @author MyEclipse Persistence Tools
 */

public class Label implements java.io.Serializable {

	// Fields

	private Long lid;
	private String labelname;
	private Set userLabels = new HashSet(0);
	private Set projectLabels = new HashSet(0);
	private Set projectLabels_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Label() {
	}

	/** full constructor */
	public Label(String labelname, Set userLabels, Set projectLabels,
			Set projectLabels_1) {
		this.labelname = labelname;
		this.userLabels = userLabels;
		this.projectLabels = projectLabels;
		this.projectLabels_1 = projectLabels_1;
	}

	// Property accessors

	public Long getLid() {
		return this.lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public String getLabelname() {
		return this.labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public Set getUserLabels() {
		return this.userLabels;
	}

	public void setUserLabels(Set userLabels) {
		this.userLabels = userLabels;
	}

	public Set getProjectLabels() {
		return this.projectLabels;
	}

	public void setProjectLabels(Set projectLabels) {
		this.projectLabels = projectLabels;
	}

	public Set getProjectLabels_1() {
		return this.projectLabels_1;
	}

	public void setProjectLabels_1(Set projectLabels_1) {
		this.projectLabels_1 = projectLabels_1;
	}

}