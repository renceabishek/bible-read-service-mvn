package com.bible.read.model;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

import com.google.firebase.database.Exclude;

public class Profile {

	@Exclude
	private String uniqueId;
	private String name;
	private String dob;
	private String sex;
	private boolean isBibleReader;
	private String role;
	private List<String> skills;
	private String about;
	private String profileUrl;
	private String createdDate;
	private String updatedDate;
	private int totalBibleWords;
	private int bronze;
	private int silver;
	private int gold;
	

	public Profile() {

	}
	
	
	public Profile(String name, String dob, String sex, boolean isBibleReader, String role, List<String> skills,
			String about, String createdDate, String updatedDate, int totalBibleWords, int bronze, int silver,
			int gold, String profileUrl) {
		super();
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.isBibleReader = isBibleReader;
		this.role = role;
		this.skills = skills;
		this.about = about;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.totalBibleWords = totalBibleWords;
		this.bronze = bronze;
		this.silver = silver;
		this.gold = gold;
		this.profileUrl = profileUrl;
	}
	
	



	public String getProfileUrl() {
		return profileUrl;
	}


	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
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


	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
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
