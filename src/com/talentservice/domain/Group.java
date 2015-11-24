package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Long gid;
	private User user;
	private Project project;
	private String groupnumber;
	private String groupname;
	private String foundtime;
	private Set groupUsers = new HashSet(0);
	private Set chats = new HashSet(0);
	private Set chats_1 = new HashSet(0);
	private Set groupUsers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** full constructor */
	public Group(User user, Project project, String groupnumber,
			String groupname, String foundtime, Set groupUsers, Set chats,
			Set chats_1, Set groupUsers_1) {
		this.user = user;
		this.project = project;
		this.groupnumber = groupnumber;
		this.groupname = groupname;
		this.foundtime = foundtime;
		this.groupUsers = groupUsers;
		this.chats = chats;
		this.chats_1 = chats_1;
		this.groupUsers_1 = groupUsers_1;
	}

	// Property accessors

	public Long getGid() {
		return this.gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
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

	public String getGroupnumber() {
		return this.groupnumber;
	}

	public void setGroupnumber(String groupnumber) {
		this.groupnumber = groupnumber;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getFoundtime() {
		return this.foundtime;
	}

	public void setFoundtime(String foundtime) {
		this.foundtime = foundtime;
	}

	public Set getGroupUsers() {
		return this.groupUsers;
	}

	public void setGroupUsers(Set groupUsers) {
		this.groupUsers = groupUsers;
	}

	public Set getChats() {
		return this.chats;
	}

	public void setChats(Set chats) {
		this.chats = chats;
	}

	public Set getChats_1() {
		return this.chats_1;
	}

	public void setChats_1(Set chats_1) {
		this.chats_1 = chats_1;
	}

	public Set getGroupUsers_1() {
		return this.groupUsers_1;
	}

	public void setGroupUsers_1(Set groupUsers_1) {
		this.groupUsers_1 = groupUsers_1;
	}

}