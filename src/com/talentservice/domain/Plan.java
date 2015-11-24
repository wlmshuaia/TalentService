package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Plan entity. @author MyEclipse Persistence Tools
 */

public class Plan implements java.io.Serializable {

	// Fields

	private Long pid;
	private Project project;
	private String uploadtime;
	private String planmoney;
	private String completedate;
	private String standard;
	private String state;
	private Set planfiles = new HashSet(0);
	private Set planfiles_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Plan() {
	}

	/** full constructor */
	public Plan(Project project, String uploadtime, String planmoney,
			String completedate, String standard, String state, Set planfiles,
			Set planfiles_1) {
		this.project = project;
		this.uploadtime = uploadtime;
		this.planmoney = planmoney;
		this.completedate = completedate;
		this.standard = standard;
		this.state = state;
		this.planfiles = planfiles;
		this.planfiles_1 = planfiles_1;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getPlanmoney() {
		return this.planmoney;
	}

	public void setPlanmoney(String planmoney) {
		this.planmoney = planmoney;
	}

	public String getCompletedate() {
		return this.completedate;
	}

	public void setCompletedate(String completedate) {
		this.completedate = completedate;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set getPlanfiles() {
		return this.planfiles;
	}

	public void setPlanfiles(Set planfiles) {
		this.planfiles = planfiles;
	}

	public Set getPlanfiles_1() {
		return this.planfiles_1;
	}

	public void setPlanfiles_1(Set planfiles_1) {
		this.planfiles_1 = planfiles_1;
	}

}