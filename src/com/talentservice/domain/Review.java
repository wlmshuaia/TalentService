package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Review entity. @author MyEclipse Persistence Tools
 */

public class Review implements java.io.Serializable {

	// Fields

	private Long rid;
	private Review review;
	private User userByTouserId;
	private User userByFromuserId;
	private String content;
	private String time;
	private Set reviews = new HashSet(0);
	private Set reviews_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Review() {
	}

	/** full constructor */
	public Review(Review review, User userByTouserId, User userByFromuserId,
			String content, String time, Set reviews, Set reviews_1) {
		this.review = review;
		this.userByTouserId = userByTouserId;
		this.userByFromuserId = userByFromuserId;
		this.content = content;
		this.time = time;
		this.reviews = reviews;
		this.reviews_1 = reviews_1;
	}

	// Property accessors

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Review getReview() {
		return this.review;
	}

	public void setReview(Review review) {
		this.review = review;
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

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set getReviews() {
		return this.reviews;
	}

	public void setReviews(Set reviews) {
		this.reviews = reviews;
	}

	public Set getReviews_1() {
		return this.reviews_1;
	}

	public void setReviews_1(Set reviews_1) {
		this.reviews_1 = reviews_1;
	}

}