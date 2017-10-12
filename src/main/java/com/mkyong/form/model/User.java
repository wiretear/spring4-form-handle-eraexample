package com.mkyong.form.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class User {
	// form:hidden - hidden value
	Integer id;
	  public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	List<MultipartFile> images;
	String name;

	// form:input - textbox
	String email;

	// form:textarea - textarea
	String address;

	String padt;
	// form:textarea - textarea
	String databases;
	// form:textarea - textarea
	String education;
	public String getLtt() {
		return ltt;
	}

	public void setLtt(String ltt) {
		this.ltt = ltt;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	// form:input - textbox
	String designation;
	// form:textarea - textarea
	String ltt;
	// form:textarea - textarea
	String os;
	// form:textarea - textarea
	String tc;
	// form:textarea - textarea
	String td;
	// form:input - password
	String password;
	// form:input - password
	String confirmPassword;

	// form:checkbox - single checkbox
	boolean newsletter;

	// form:checkboxes - multiple checkboxes
	List<String> framework;

	// form:radiobutton - radio button
	String sex;

	// form:radiobuttons - radio button
	Integer number;

	// form:select - form:option - dropdown - single select
	String country;

	// form:select - multiple=true - dropdown - multiple select
	List<String> skill;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public List<String> getFramework() {
		return framework;
	}

	public void setFramework(List<String> framework) {
		this.framework = framework;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public String getPadt() {
		return padt;
	}

	public void setPadt(String padt) {
		this.padt = padt;
	}

	public String getDatabases() {
		return databases;
	}

	public void setDatabases(String databases) {
		this.databases = databases;
	}

	public String getLt() {
		return ltt;
	}

	public void setLt(String ltt) {
		this.ltt = ltt;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getTd() {
		return td;
	}

	public void setTd(String td) {
		this.td = td;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", framework=" + framework + ", sex=" + sex
				+ ", country=" + country + ",padt=" + padt + ",databases=" + databases + ",ltt=" +ltt +",os="+ os +",tc=" + tc + ",td=" + td +",education="+education+",designation="+designation+",skill=" + skill+"]" + isNew();
	}

}
