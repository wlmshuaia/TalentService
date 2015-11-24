package com.talentservice.domain;

/**
 * Chat entity. @author MyEclipse Persistence Tools
 */

public class Chat implements java.io.Serializable {

	// Fields

	private Long cid;
	private Group group;
	private User user;
	private String content;
	private String sendtime;

	// Constructors

	/** default constructor */
	public Chat() {
	}

	/** full constructor */
	public Chat(Group group, User user, String content, String sendtime) {
		this.group = group;
		this.user = user;
		this.content = content;
		this.sendtime = sendtime;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

}