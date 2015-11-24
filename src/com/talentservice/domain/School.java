package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Long sid;
	private String gravatar;
	private String introduction;
	private String homepage;
	private String region;
	private String address;
	private String mail;
	private String phone;
	private String goodfield;
	private Integer focus;
	private Integer integral;
	private Set students = new HashSet(0);
	private Set colleges = new HashSet(0);
	private Set colleges_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public School() {
	}

	/** full constructor */
	public School(String gravatar, String introduction, String homepage,
			String region, String address, String mail, String phone,
			String goodfield, Integer focus, Integer integral, Set students,
			Set colleges, Set colleges_1) {
		this.gravatar = gravatar;
		this.introduction = introduction;
		this.homepage = homepage;
		this.region = region;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
		this.goodfield = goodfield;
		this.focus = focus;
		this.integral = integral;
		this.students = students;
		this.colleges = colleges;
		this.colleges_1 = colleges_1;
	}

	// Property accessors

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
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

	public String getGoodfield() {
		return this.goodfield;
	}

	public void setGoodfield(String goodfield) {
		this.goodfield = goodfield;
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

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getColleges() {
		return this.colleges;
	}

	public void setColleges(Set colleges) {
		this.colleges = colleges;
	}

	public Set getColleges_1() {
		return this.colleges_1;
	}

	public void setColleges_1(Set colleges_1) {
		this.colleges_1 = colleges_1;
	}

}