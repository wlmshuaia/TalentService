package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Long aid;
	private String adminname;
	private String adminpassword;
	private String lastlogintime;
	private String lastloginip;
	private Set adminRoles = new HashSet(0);
	private Set adminRoles_1 = new HashSet(0);
	private Set approves = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String adminname, String adminpassword, String lastlogintime,
			String lastloginip, Set adminRoles, Set adminRoles_1, Set approves) {
		this.adminname = adminname;
		this.adminpassword = adminpassword;
		this.lastlogintime = lastlogintime;
		this.lastloginip = lastloginip;
		this.adminRoles = adminRoles;
		this.adminRoles_1 = adminRoles_1;
		this.approves = approves;
	}

	// Property accessors

	public Long getAid() {
		return this.aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getAdminname() {
		return this.adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return this.adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getLastloginip() {
		return this.lastloginip;
	}

	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}

	public Set getAdminRoles() {
		return this.adminRoles;
	}

	public void setAdminRoles(Set adminRoles) {
		this.adminRoles = adminRoles;
	}

	public Set getAdminRoles_1() {
		return this.adminRoles_1;
	}

	public void setAdminRoles_1(Set adminRoles_1) {
		this.adminRoles_1 = adminRoles_1;
	}

	public Set getApproves() {
		return this.approves;
	}

	public void setApproves(Set approves) {
		this.approves = approves;
	}

}