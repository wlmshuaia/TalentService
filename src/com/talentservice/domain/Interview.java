package com.talentservice.domain;

import java.util.Date;

/**
 * Interview entity. @author MyEclipse Persistence Tools
 */

public class Interview implements java.io.Serializable {

	// Fields

	private Long iid;
	private User userByIntervieweeId;
	private User userByInterviewerId;
	private Project project;
	private Date interviewtime;
	private String length;
	private String round;
	private String content;

	// Constructors

	/** default constructor */
	public Interview() {
	}

	/** full constructor */
	public Interview(User userByIntervieweeId, User userByInterviewerId,
			Project project, Date interviewtime, String length, String round,
			String content) {
		this.userByIntervieweeId = userByIntervieweeId;
		this.userByInterviewerId = userByInterviewerId;
		this.project = project;
		this.interviewtime = interviewtime;
		this.length = length;
		this.round = round;
		this.content = content;
	}

	// Property accessors

	public Long getIid() {
		return this.iid;
	}

	public void setIid(Long iid) {
		this.iid = iid;
	}

	public User getUserByIntervieweeId() {
		return this.userByIntervieweeId;
	}

	public void setUserByIntervieweeId(User userByIntervieweeId) {
		this.userByIntervieweeId = userByIntervieweeId;
	}

	public User getUserByInterviewerId() {
		return this.userByInterviewerId;
	}

	public void setUserByInterviewerId(User userByInterviewerId) {
		this.userByInterviewerId = userByInterviewerId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getInterviewtime() {
		return this.interviewtime;
	}

	public void setInterviewtime(Date interviewtime) {
		this.interviewtime = interviewtime;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getRound() {
		return this.round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}