package com.bible.read.model;

public class ProfilesGet {
	
	private String name;
	private String uniqueId;
	
	public ProfilesGet() {
		
	}
	
	public ProfilesGet(String name, String uniqueId) {
		this.name = name;
		this.uniqueId = uniqueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
