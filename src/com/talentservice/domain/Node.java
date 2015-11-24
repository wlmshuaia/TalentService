package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Node entity. @author MyEclipse Persistence Tools
 */

public class Node implements java.io.Serializable {

	// Fields

	private Long nid;
	private String nodename;
	private String title;
	private Short status;
	private String remark;
	private Short sort;
	private Long pid;
	private Short level;
	private Set roleNodes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Node() {
	}

	/** full constructor */
	public Node(String nodename, String title, Short status, String remark,
			Short sort, Long pid, Short level, Set roleNodes) {
		this.nodename = nodename;
		this.title = title;
		this.status = status;
		this.remark = remark;
		this.sort = sort;
		this.pid = pid;
		this.level = level;
		this.roleNodes = roleNodes;
	}

	// Property accessors

	public Long getNid() {
		return this.nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}

	public String getNodename() {
		return this.nodename;
	}

	public void setNodename(String nodename) {
		this.nodename = nodename;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Short getSort() {
		return this.sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public Set getRoleNodes() {
		return this.roleNodes;
	}

	public void setRoleNodes(Set roleNodes) {
		this.roleNodes = roleNodes;
	}

}