package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Enterprise entity. @author MyEclipse Persistence Tools
 */

public class Enterprise implements java.io.Serializable {

	// Fields

	private Long eid;
	private String gravatar;
	private String introduction;
	private String homepage;
	private String region;
	private String address;
	private String mail;
	private String phone;
	private Integer focus;
	private Integer integral;
	private Set workmans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Enterprise() {
	}

	/** full constructor */
	public Enterprise(String gravatar, String introduction, String homepage,
			String region, String address, String mail, String phone,
			Integer focus, Integer integral, Set workmans) {
		this.gravatar = gravatar;
		this.introduction = introduction;
		this.homepage = homepage;
		this.region = region;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
		this.focus = focus;
		this.integral = integral;
		this.workmans = workmans;
	}

	// Property accessors

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getGravatar() {
		return this.gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getFocus() {
		return this.focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Set getWorkmans() {
		return this.workmans;
	}

	public void setWorkmans(Set workmans) {
		this.workmans = workmans;
	}

}