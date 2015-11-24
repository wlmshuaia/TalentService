package com.talentservice.domain;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Long sid;
	private User userByTouserId;
	private User userByFromuserId;
	private Project project;
	private String content;
	private String scoretime;
	private String overall;
	private String quality;
	private String speed;
	private String attitude;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** full constructor */
	public Score(User userByTouserId, User userByFromuserId, Project project,
			String content, String scoretime, String overall, String quality,
			String speed, String attitude) {
		this.userByTouserId = userByTouserId;
		this.userByFromuserId = userByFromuserId;
		this.project = project;
		this.content = content;
		this.scoretime = scoretime;
		this.overall = overall;
		this.quality = quality;
		this.speed = speed;
		this.attitude = attitude;
	}

	// Property accessors

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
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

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScoretime() {
		return this.scoretime;
	}

	public void setScoretime(String scoretime) {
		this.scoretime = scoretime;
	}

	public String getOverall() {
		return this.overall;
	}

	public void setOverall(String overall) {
		this.overall = overall;
	}

	public String getQuality() {
		return this.quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getSpeed() {
		return this.speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getAttitude() {
		return this.attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

}