package com.bible.read.model;

import java.util.Date;

import com.google.firebase.database.Exclude;

public class Profile {

	@Exclude
	private String uniqueId;
	private String name;
	private String dob;
	private String sex;
	private boolean isBibleReader;
	private String role;
	private String[] skills;
	private String about;
	private String file;
	private Date createdDate;
	private Date updatedDate;
	private int totalBibleWords;
	private int bronze;
	private int silver;
	private int gold;
	

	public Profile() {

	}
	
	
	public Profile(String name, String dob, String sex, boolean isBibleReader, String role, String[] skills,
			String about, String file, Date createdDate, Date updatedDate, int totalBibleWords, int bronze, int silver,
			int gold) {
		super();
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.isBibleReader = isBibleReader;
		this.role = role;
		this.skills = skills;
		this.about = about;
		this.file = file;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.totalBibleWords = totalBibleWords;
		this.bronze = bronze;
		this.silver = silver;
		this.gold = gold;
	}
	
	



	public String getUniqueId() {
		return uniqueId;
	}


	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
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

	public boolean isBibleReader() {
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

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getTotalBibleWords() {
		return totalBibleWords;
	}

	public void setTotalBibleWords(int totalBibleWords) {
		this.totalBibleWords = totalBibleWords;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	

}
