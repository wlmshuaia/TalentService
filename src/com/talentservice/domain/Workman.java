package com.talentservice.domain;

/**
 * Workman entity. @author MyEclipse Persistence Tools
 */

public class Workman implements java.io.Serializable {

	// Fields

	private Long wid;
	private Enterprise enterprise;
	private String name;
	private String gravatar;
	private String sex;
	private String birthday;
	private String nativeplace;
	private String address;
	private String mail;
	private String phone;
	private String position;
	private Integer focus;
	private Integer integral;
	private String introduction;

	// Constructors

	/** default constructor */
	public Workman() {
	}

	/** full constructor */
	public Workman(Enterprise enterprise, String name, String gravatar,
			String sex, String birthday, String nativeplace, String address,
			String mail, String phone, String position, Integer focus,
			Integer integral, String introduction) {
		this.enterprise = enterprise;
		this.name = name;
		this.gravatar = gravatar;
		this.sex = sex;
		this.birthday = birthday;
		this.nativeplace = nativeplace;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
		this.position = position;
		this.focus = focus;
		this.integral = integral;
		this.introduction = introduction;
	}

	// Property accessors

	public Long getWid() {
		return this.wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public Enterprise getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGravatar() {
		return this.gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNativeplace() {
		return this.nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getFocus() {
		return this.focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}