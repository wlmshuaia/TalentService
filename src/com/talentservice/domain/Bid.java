package com.talentservice.domain;

/**
 * Bid entity. @author MyEclipse Persistence Tools
 */

public class Bid implements java.io.Serializable {

	// Fields

	private Long bid;
	private User user;
	private Project project;
	private String bidmoney;
	private String bidcycle;
	private String phone;
	private String mail;
	private String plan;
	private String bidtime;
	private String issuccess;

	// Constructors

	/** default constructor */
	public Bid() {
	}

	/** full constructor */
	public Bid(User user, Project project, String bidmoney, String bidcycle,
			String phone, String mail, String plan, String bidtime,
			String issuccess) {
		this.user = user;
		this.project = project;
		this.bidmoney = bidmoney;
		this.bidcycle = bidcycle;
		this.phone = phone;
		this.mail = mail;
		this.plan = plan;
		this.bidtime = bidtime;
		this.issuccess = issuccess;
	}

	// Property accessors

	public Long getBid() {
		return this.bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getBidmoney() {
		return this.bidmoney;
	}

	public void setBidmoney(String bidmoney) {
		this.bidmoney = bidmoney;
	}

	public String getBidcycle() {
		return this.bidcycle;
	}

	public void setBidcycle(String bidcycle) {
		this.bidcycle = bidcycle;
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

	public String getPlan() {
		return this.plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getBidtime() {
		return this.bidtime;
	}

	public void setBidtime(String bidtime) {
		this.bidtime = bidtime;
	}

	public String getIssuccess() {
		return this.issuccess;
	}

	public void setIssuccess(String issuccess) {
		this.issuccess = issuccess;
	}

}