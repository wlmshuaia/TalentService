package com.talentservice.domain;

/**
 * Street entity. @author MyEclipse Persistence Tools
 */

public class Street implements java.io.Serializable {

	// Fields

	private Long sid;
	private County county;
	private String streetname;

	// Constructors

	/** default constructor */
	public Street() {
	}

	/** minimal constructor */
	public Street(County county) {
		this.county = county;
	}

	/** full constructor */
	public Street(County county, String streetname) {
		this.county = county;
		this.streetname = streetname;
	}

	// Property accessors

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public County getCounty() {
		return this.county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public String getStreetname() {
		return this.streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

}