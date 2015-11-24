package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project implements java.io.Serializable {

	// Fields

	private Long pid;
	private User userByUndertakerId;
	private Category category;
	private User userByFounderId;
	private String title;
	private String description;
	private String budget;
	private String phone;
	private String mail;
	private String biddingend;
	private String projectend;
	private String foundtime;
	private String undertaketime;
	private String approvetime;
	private String status;
	private Set approves = new HashSet(0);
	private Set bids = new HashSet(0);
	private Set scores = new HashSet(0);
	private Set scores_1 = new HashSet(0);
	private Set groups = new HashSet(0);
	private Set approves_1 = new HashSet(0);
	private Set projectLabels = new HashSet(0);
	private Set projectlogs = new HashSet(0);
	private Set plans = new HashSet(0);
	private Set evaluates = new HashSet(0);
	private Set files = new HashSet(0);
	private Set groups_1 = new HashSet(0);
	private Set projectLabels_1 = new HashSet(0);
	private Set interviews = new HashSet(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** full constructor */
	public Project(User userByUndertakerId, Category category,
			User userByFounderId, String title, String description,
			String budget, String phone, String mail, String biddingend,
			String projectend, String foundtime, String undertaketime,
			String approvetime, String status, Set approves, Set bids,
			Set scores, Set scores_1, Set groups, Set approves_1,
			Set projectLabels, Set projectlogs, Set plans, Set evaluates,
			Set files, Set groups_1, Set projectLabels_1, Set interviews) {
		this.userByUndertakerId = userByUndertakerId;
		this.category = category;
		this.userByFounderId = userByFounderId;
		this.title = title;
		this.description = description;
		this.budget = budget;
		this.phone = phone;
		this.mail = mail;
		this.biddingend = biddingend;
		this.projectend = projectend;
		this.foundtime = foundtime;
		this.undertaketime = undertaketime;
		this.approvetime = approvetime;
		this.status = status;
		this.approves = approves;
		this.bids = bids;
		this.scores = scores;
		this.scores_1 = scores_1;
		this.groups = groups;
		this.approves_1 = approves_1;
		this.projectLabels = projectLabels;
		this.projectlogs = projectlogs;
		this.plans = plans;
		this.evaluates = evaluates;
		this.files = files;
		this.groups_1 = groups_1;
		this.projectLabels_1 = projectLabels_1;
		this.interviews = interviews;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public User getUserByUndertakerId() {
		return this.userByUndertakerId;
	}

	public void setUserByUndertakerId(User userByUndertakerId) {
		this.userByUndertakerId = userByUndertakerId;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUserByFounderId() {
		return this.userByFounderId;
	}

	public void setUserByFounderId(User userByFounderId) {
		this.userByFounderId = userByFounderId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBiddingend() {
		return this.biddingend;
	}

	public void setBiddingend(String biddingend) {
		this.biddingend = biddingend;
	}

	public String getProjectend() {
		return this.projectend;
	}

	public void setProjectend(String projectend) {
		this.projectend = projectend;
	}

	public String getFoundtime() {
		return this.foundtime;
	}

	public void setFoundtime(String foundtime) {
		this.foundtime = foundtime;
	}

	public String getUndertaketime() {
		return this.undertaketime;
	}

	public void setUndertaketime(String undertaketime) {
		this.undertaketime = undertaketime;
	}

	public String getApprovetime() {
		return this.approvetime;
	}

	public void setApprovetime(String approvetime) {
		this.approvetime = approvetime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getApproves() {
		return this.approves;
	}

	public void setApproves(Set approves) {
		this.approves = approves;
	}

	public Set getBids() {
		return this.bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

	public Set getScores_1() {
		return this.scores_1;
	}

	public void setScores_1(Set scores_1) {
		this.scores_1 = scores_1;
	}

	public Set getGroups() {
		return this.groups;
	}

	public void setGroups(Set groups) {
		this.groups = groups;
	}

	public Set getApproves_1() {
		return this.approves_1;
	}

	public void setApproves_1(Set approves_1) {
		this.approves_1 = approves_1;
	}

	public Set getProjectLabels() {
		return this.projectLabels;
	}

	public void setProjectLabels(Set projectLabels) {
		this.projectLabels = projectLabels;
	}

	public Set getProjectlogs() {
		return this.projectlogs;
	}

	public void setProjectlogs(Set projectlogs) {
		this.projectlogs = projectlogs;
	}

	public Set getPlans() {
		return this.plans;
	}

	public void setPlans(Set plans) {
		this.plans = plans;
	}

	public Set getEvaluates() {
		return this.evaluates;
	}

	public void setEvaluates(Set evaluates) {
		this.evaluates = evaluates;
	}

	public Set getFiles() {
		return this.files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}

	public Set getGroups_1() {
		return this.groups_1;
	}

	public void setGroups_1(Set groups_1) {
		this.groups_1 = groups_1;
	}

	public Set getProjectLabels_1() {
		return this.projectLabels_1;
	}

	public void setProjectLabels_1(Set projectLabels_1) {
		this.projectLabels_1 = projectLabels_1;
	}

	public Set getInterviews() {
		return this.interviews;
	}

	public void setInterviews(Set interviews) {
		this.interviews = interviews;
	}

}