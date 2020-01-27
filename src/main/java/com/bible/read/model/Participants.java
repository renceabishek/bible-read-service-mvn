package com.bible.read.model;

import com.google.firebase.database.Exclude;

public class Participants {

	@Exclude
	private String uniqueId;
	private String name;
	private String file;

	public Participants() {

	}

	public Participants(String uniqueId, String name, String file) {
		super();
		this.uniqueId = uniqueId;
		this.name = name;
		this.file = file;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
