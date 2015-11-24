package com.talentservice.domain;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Long sid;
	private School school;
	private String name;
	private String gravatar;
	private String sex;
	private String birthday;
	private String nativeplace;
	private String address;
	private String mail;
	private String phone;
	private String professional;
	private String degree;
	private String enrollment;
	private Integer focus;
	private Integer integral;
	private String introduction;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(School school, String name, String gravatar, String sex,
			String birthday, String nativeplace, String address, String mail,
			String phone, String professional, String degree,
			String enrollment, Integer focus, Integer integral,
			String introduction) {
		this.school = school;
		this.name = name;
		this.gravatar = gravatar;
		this.sex = sex;
		this.birthday = birthday;
		this.nativeplace = nativeplace;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
		this.professional = professional;
		this.degree = degree;
		this.enrollment = enrollment;
		this.focus = focus;
		this.integral = integral;
		this.introduction = introduction;
	}

	// Property accessors

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
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

	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEnrollment() {
		return this.enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
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