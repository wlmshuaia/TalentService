package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College implements java.io.Serializable {

	// Fields

	private Long cid;
	private School school;
	private String gravatar;
	private String introduction;
	private Set professions = new HashSet(0);
	private Set professions_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public College() {
	}

	/** full constructor */
	public College(School school, String gravatar, String introduction,
			Set professions, Set professions_1) {
		this.school = school;
		this.gravatar = gravatar;
		this.introduction = introduction;
		this.professions = professions;
		this.professions_1 = professions_1;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
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

	public Set getProfessions() {
		return this.professions;
	}

	public void setProfessions(Set professions) {
		this.professions = professions;
	}

	public Set getProfessions_1() {
		return this.professions_1;
	}

	public void setProfessions_1(Set professions_1) {
		this.professions_1 = professions_1;
	}

}