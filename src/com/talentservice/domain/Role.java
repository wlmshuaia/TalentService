package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Long rid;
	private String rolename;
	private Long pid;
	private Short status;
	private String remark;
	private Set adminRoles = new HashSet(0);
	private Set adminRoles_1 = new HashSet(0);
	private Set roleNodes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String rolename, Long pid, Short status, String remark,
			Set adminRoles, Set adminRoles_1, Set roleNodes) {
		this.rolename = rolename;
		this.pid = pid;
		this.status = status;
		this.remark = remark;
		this.adminRoles = adminRoles;
		this.adminRoles_1 = adminRoles_1;
		this.roleNodes = roleNodes;
	}

	// Property accessors

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Set getRoleNodes() {
		return this.roleNodes;
	}

	public void setRoleNodes(Set roleNodes) {
		this.roleNodes = roleNodes;
	}

}