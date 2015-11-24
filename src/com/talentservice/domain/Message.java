package com.talentservice.domain;

import java.util.Date;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Long mid;
	private User userByTouserId;
	private User userByFromuserId;
	private String content;
	private Date sendtime;
	private String state;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(User userByTouserId, User userByFromuserId, String content,
			Date sendtime, String state) {
		this.userByTouserId = userByTouserId;
		this.userByFromuserId = userByFromuserId;
		this.content = content;
		this.sendtime = sendtime;
		this.state = state;
	}

	// Property accessors

	public Long getMid() {
		return this.mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public User getUserByTouserId() {
		return this.userByTouserId;
	}

	public void setUserByTouserId(User userByTouserId) {
		this.userByTouserId = userByTouserId;
	}

	public User getUserByFromuserId() {
		return this.userByFromuserId;
	}

	public void setUserByFromuserId(User userByFromuserId) {
		this.userByFromuserId = userByFromuserId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}