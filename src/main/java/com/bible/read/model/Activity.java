package com.bible.read.model;

import java.util.List;

public class Activity {
	
	private String title;
	private String content;
	private String uniqueId;
	private String date;
	private List<String> organizedBy;
	private List<String> participatedBy;
	private List<String> helpedBy;
	
	
	public Activity() {
		
	}
	public Activity(String title, String content, String uniqueId, String date, List<String> organizedBy,
			List<String> participatedBy, List<String> helpedBy) {
		super();
		this.title = title;
		this.content = content;
		this.uniqueId = uniqueId;
		this.date = date;
		this.organizedBy = organizedBy;
		this.participatedBy = participatedBy;
		this.helpedBy = helpedBy;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<String> getOrganizedBy() {
		return organizedBy;
	}
	public void setOrganizedBy(List<String> organizedBy) {
		this.organizedBy = organizedBy;
	}
	public List<String> getParticipatedBy() {
		return participatedBy;
	}
	public void setParticipatedBy(List<String> participatedBy) {
		this.participatedBy = participatedBy;
	}
	public List<String> getHelpedBy() {
		return helpedBy;
	}
	public void setHelpedBy(List<String> helpedBy) {
		this.helpedBy = helpedBy;
	}
	
	
}
