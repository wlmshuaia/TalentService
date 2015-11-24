package com.talentservice.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Long cid;
	private Province province;
	private String cityname;
	private Set counties = new HashSet(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Province province) {
		this.province = province;
	}

	/** full constructor */
	public City(Province province, String cityname, Set counties) {
		this.province = province;
		this.cityname = cityname;
		this.counties = counties;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Set getCounties() {
		return this.counties;
	}

	public void setCounties(Set counties) {
		this.counties = counties;
	}

}