package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long uid;
	private String username;
	private String password;
	private Short type;
	private Long userId;
	private Set groupUsers = new HashSet(0);
	private Set reviewsForTouserId = new HashSet(0);
	private Set groups = new HashSet(0);
	private Set circles = new HashSet(0);
	private Set userLabels = new HashSet(0);
	private Set scoresForFromuserId = new HashSet(0);
	private Set scoresForTouserId = new HashSet(0);
	private Set interviewsForIntervieweeId = new HashSet(0);
	private Set evaluatesForTouserId = new HashSet(0);
	private Set userCategories = new HashSet(0);
	private Set userUsersForUserId = new HashSet(0);
	private Set interviewsForInterviewerId = new HashSet(0);
	private Set chats = new HashSet(0);
	private Set messagesForTouserId = new HashSet(0);
	private Set chats_1 = new HashSet(0);
	private Set reviewsForFromuserId = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set reviewsForTouserId_1 = new HashSet(0);
	private Set reviewsForFromuserId_1 = new HashSet(0);
	private Set groups_1 = new HashSet(0);
	private Set projectsForUndertakerId = new HashSet(0);
	private Set scoresForFromuserId_1 = new HashSet(0);
	private Set messagesForFromuserId = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set teachers_1 = new HashSet(0);
	private Set scoresForTouserId_1 = new HashSet(0);
	private Set userFocusesForFocusId = new HashSet(0);
	private Set userFocusesForUserId = new HashSet(0);
	private Set evaluatesForFromuserId = new HashSet(0);
	private Set bids = new HashSet(0);
	private Set userUsersForFriendId = new HashSet(0);
	private Set userCircles = new HashSet(0);
	private Set topics = new HashSet(0);
	private Set groupUsers_1 = new HashSet(0);
	private Set projectsForFounderId = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Short type) {
		this.type = type;
	}

	/** full constructor */
	public User(String username, String password, Short type, Long userId,
			Set groupUsers, Set reviewsForTouserId, Set groups, Set circles,
			Set userLabels, Set scoresForFromuserId, Set scoresForTouserId,
			Set interviewsForIntervieweeId, Set evaluatesForTouserId,
			Set userCategories, Set userUsersForUserId,
			Set interviewsForInterviewerId, Set chats, Set messagesForTouserId,
			Set chats_1, Set reviewsForFromuserId, Set comments,
			Set reviewsForTouserId_1, Set reviewsForFromuserId_1, Set groups_1,
			Set projectsForUndertakerId, Set scoresForFromuserId_1,
			Set messagesForFromuserId, Set teachers, Set teachers_1,
			Set scoresForTouserId_1, Set userFocusesForFocusId,
			Set userFocusesForUserId, Set evaluatesForFromuserId, Set bids,
			Set userUsersForFriendId, Set userCircles, Set topics,
			Set groupUsers_1, Set projectsForFounderId) {
		this.username = username;
		this.password = password;
		this.type = type;
		this.userId = userId;
		this.groupUsers = groupUsers;
		this.reviewsForTouserId = reviewsForTouserId;
		this.groups = groups;
		this.circles = circles;
		this.userLabels = userLabels;
		this.scoresForFromuserId = scoresForFromuserId;
		this.scoresForTouserId = scoresForTouserId;
		this.interviewsForIntervieweeId = interviewsForIntervieweeId;
		this.evaluatesForTouserId = evaluatesForTouserId;
		this.userCategories = userCategories;
		this.userUsersForUserId = userUsersForUserId;
		this.interviewsForInterviewerId = interviewsForInterviewerId;
		this.chats = chats;
		this.messagesForTouserId = messagesForTouserId;
		this.chats_1 = chats_1;
		this.reviewsForFromuserId = reviewsForFromuserId;
		this.comments = comments;
		this.reviewsForTouserId_1 = reviewsForTouserId_1;
		this.reviewsForFromuserId_1 = reviewsForFromuserId_1;
		this.groups_1 = groups_1;
		this.projectsForUndertakerId = projectsForUndertakerId;
		this.scoresForFromuserId_1 = scoresForFromuserId_1;
		this.messagesForFromuserId = messagesForFromuserId;
		this.teachers = teachers;
		this.teachers_1 = teachers_1;
		this.scoresForTouserId_1 = scoresForTouserId_1;
		this.userFocusesForFocusId = userFocusesForFocusId;
		this.userFocusesForUserId = userFocusesForUserId;
		this.evaluatesForFromuserId = evaluatesForFromuserId;
		this.bids = bids;
		this.userUsersForFriendId = userUsersForFriendId;
		this.userCircles = userCircles;
		this.topics = topics;
		this.groupUsers_1 = groupUsers_1;
		this.projectsForFounderId = projectsForFounderId;
	}

	// Property accessors

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set getGroupUsers() {
		return this.groupUsers;
	}

	public void setGroupUsers(Set groupUsers) {
		this.groupUsers = groupUsers;
	}

	public Set getReviewsForTouserId() {
		return this.reviewsForTouserId;
	}

	public void setReviewsForTouserId(Set reviewsForTouserId) {
		this.reviewsForTouserId = reviewsForTouserId;
	}

	public Set getGroups() {
		return this.groups;
	}

	public void setGroups(Set groups) {
		this.groups = groups;
	}

	public Set getCircles() {
		return this.circles;
	}

	public void setCircles(Set circles) {
		this.circles = circles;
	}

	public Set getUserLabels() {
		return this.userLabels;
	}

	public void setUserLabels(Set userLabels) {
		this.userLabels = userLabels;
	}

	public Set getScoresForFromuserId() {
		return this.scoresForFromuserId;
	}

	public void setScoresForFromuserId(Set scoresForFromuserId) {
		this.scoresForFromuserId = scoresForFromuserId;
	}

	public Set getScoresForTouserId() {
		return this.scoresForTouserId;
	}

	public void setScoresForTouserId(Set scoresForTouserId) {
		this.scoresForTouserId = scoresForTouserId;
	}

	public Set getInterviewsForIntervieweeId() {
		return this.interviewsForIntervieweeId;
	}

	public void setInterviewsForIntervieweeId(Set interviewsForIntervieweeId) {
		this.interviewsForIntervieweeId = interviewsForIntervieweeId;
	}

	public Set getEvaluatesForTouserId() {
		return this.evaluatesForTouserId;
	}

	public void setEvaluatesForTouserId(Set evaluatesForTouserId) {
		this.evaluatesForTouserId = evaluatesForTouserId;
	}

	public Set getUserCategories() {
		return this.userCategories;
	}

	public void setUserCategories(Set userCategories) {
		this.userCategories = userCategories;
	}

	public Set getUserUsersForUserId() {
		return this.userUsersForUserId;
	}

	public void setUserUsersForUserId(Set userUsersForUserId) {
		this.userUsersForUserId = userUsersForUserId;
	}

	public Set getInterviewsForInterviewerId() {
		return this.interviewsForInterviewerId;
	}

	public void setInterviewsForInterviewerId(Set interviewsForInterviewerId) {
		this.interviewsForInterviewerId = interviewsForInterviewerId;
	}

	public Set getChats() {
		return this.chats;
	}

	public void setChats(Set chats) {
		this.chats = chats;
	}

	public Set getMessagesForTouserId() {
		return this.messagesForTouserId;
	}

	public void setMessagesForTouserId(Set messagesForTouserId) {
		this.messagesForTouserId = messagesForTouserId;
	}

	public Set getChats_1() {
		return this.chats_1;
	}

	public void setChats_1(Set chats_1) {
		this.chats_1 = chats_1;
	}

	public Set getReviewsForFromuserId() {
		return this.reviewsForFromuserId;
	}

	public void setReviewsForFromuserId(Set reviewsForFromuserId) {
		this.reviewsForFromuserId = reviewsForFromuserId;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getReviewsForTouserId_1() {
		return this.reviewsForTouserId_1;
	}

	public void setReviewsForTouserId_1(Set reviewsForTouserId_1) {
		this.reviewsForTouserId_1 = reviewsForTouserId_1;
	}

	public Set getReviewsForFromuserId_1() {
		return this.reviewsForFromuserId_1;
	}

	public void setReviewsForFromuserId_1(Set reviewsForFromuserId_1) {
		this.reviewsForFromuserId_1 = reviewsForFromuserId_1;
	}

	public Set getGroups_1() {
		return this.groups_1;
	}

	public void setGroups_1(Set groups_1) {
		this.groups_1 = groups_1;
	}

	public Set getProjectsForUndertakerId() {
		return this.projectsForUndertakerId;
	}

	public void setProjectsForUndertakerId(Set projectsForUndertakerId) {
		this.projectsForUndertakerId = projectsForUndertakerId;
	}

	public Set getScoresForFromuserId_1() {
		return this.scoresForFromuserId_1;
	}

	public void setScoresForFromuserId_1(Set scoresForFromuserId_1) {
		this.scoresForFromuserId_1 = scoresForFromuserId_1;
	}

	public Set getMessagesForFromuserId() {
		return this.messagesForFromuserId;
	}

	public void setMessagesForFromuserId(Set messagesForFromuserId) {
		this.messagesForFromuserId = messagesForFromuserId;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getTeachers_1() {
		return this.teachers_1;
	}

	public void setTeachers_1(Set teachers_1) {
		this.teachers_1 = teachers_1;
	}

	public Set getScoresForTouserId_1() {
		return this.scoresForTouserId_1;
	}

	public void setScoresForTouserId_1(Set scoresForTouserId_1) {
		this.scoresForTouserId_1 = scoresForTouserId_1;
	}

	public Set getUserFocusesForFocusId() {
		return this.userFocusesForFocusId;
	}

	public void setUserFocusesForFocusId(Set userFocusesForFocusId) {
		this.userFocusesForFocusId = userFocusesForFocusId;
	}

	public Set getUserFocusesForUserId() {
		return this.userFocusesForUserId;
	}

	public void setUserFocusesForUserId(Set userFocusesForUserId) {
		this.userFocusesForUserId = userFocusesForUserId;
	}

	public Set getEvaluatesForFromuserId() {
		return this.evaluatesForFromuserId;
	}

	public void setEvaluatesForFromuserId(Set evaluatesForFromuserId) {
		this.evaluatesForFromuserId = evaluatesForFromuserId;
	}

	public Set getBids() {
		return this.bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public Set getUserUsersForFriendId() {
		return this.userUsersForFriendId;
	}

	public void setUserUsersForFriendId(Set userUsersForFriendId) {
		this.userUsersForFriendId = userUsersForFriendId;
	}

	public Set getUserCircles() {
		return this.userCircles;
	}

	public void setUserCircles(Set userCircles) {
		this.userCircles = userCircles;
	}

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

	public Set getGroupUsers_1() {
		return this.groupUsers_1;
	}

	public void setGroupUsers_1(Set groupUsers_1) {
		this.groupUsers_1 = groupUsers_1;
	}

	public Set getProjectsForFounderId() {
		return this.projectsForFounderId;
	}

	public void setProjectsForFounderId(Set projectsForFounderId) {
		this.projectsForFounderId = projectsForFounderId;
	}

}