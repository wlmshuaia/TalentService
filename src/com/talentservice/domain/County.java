package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * County entity. @author MyEclipse Persistence Tools
 */

public class County implements java.io.Serializable {

	// Fields

	private Long cid;
	private City city;
	private String countyname;
	private Set streets = new HashSet(0);

	// Constructors

	/** default constructor */
	public County() {
	}

	/** minimal constructor */
	public County(City city) {
		this.city = city;
	}

	/** full constructor */
	public County(City city, String countyname, Set streets) {
		this.city = city;
		this.countyname = countyname;
		this.streets = streets;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCountyname() {
		return this.countyname;
	}

	public void setCountyname(String countyname) {
		this.countyname = countyname;
	}

	public Set getStreets() {
		return this.streets;
	}

	public void setStreets(Set streets) {
		this.streets = streets;
	}

}