package com.talentservice.domain;

/**
 * Profession entity. @author MyEclipse Persistence Tools
 */

public class Profession implements java.io.Serializable {

	// Fields

	private Long pid;
	private College college;
	private String name;
	private String develop;

	// Constructors

	/** default constructor */
	public Profession() {
	}

	/** full constructor */
	public Profession(College college, String name, String develop) {
		this.college = college;
		this.name = name;
		this.develop = develop;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDevelop() {
		return this.develop;
	}

	public void setDevelop(String develop) {
		this.develop = develop;
	}

}