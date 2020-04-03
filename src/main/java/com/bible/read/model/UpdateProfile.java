package com.bible.read.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UpdateProfile {
	
	private String name;
	private String dob;
	private String sex;
	private boolean isBibleReader;
	private String role;
	private List<String> skills;
	private String about;
	private String profileUrl;
	private String updatedDate;
	
	public UpdateProfile() {
		
	}
	
	public UpdateProfile(String name, String dob, String sex, boolean isBibleReader, String role, List<String> skills,
			String about, String profileUrl, String updatedDate) {
		super();
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.isBibleReader = isBibleReader;
		this.role = role;
		this.skills = skills;
		this.about = about;
		this.profileUrl = profileUrl;
		this.updatedDate = updatedDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean getIsBibleReader() {
		return isBibleReader;
	}
	public void setBibleReader(boolean isBibleReader) {
		this.isBibleReader = isBibleReader;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
	

}
