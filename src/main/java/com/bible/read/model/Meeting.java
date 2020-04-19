package com.bible.read.model;

import java.util.List;

public class Meeting {

	private String date;
	private String uniqueId;
	private List<String> moc;
	private List<String> arrangements;
	private List<String> worshipers;
	private List<String> musicians;
	private List<String> singers;
	private String songs;
	private List<String> testimony;
	private List<String> wog;
	private String aboutWog;
	private List<String> others;
	private String othersAbout;
	private String remarks;
	private List<String> picsUrl;
	
	public Meeting() {
		
	}
	
	public Meeting(String date, String uniqueId, List<String> moc, List<String> arrangements, List<String> worshipers,
			List<String> musicians, List<String> singers, String songs, List<String> testimony, List<String> wog,
			String aboutWog, List<String> others, String othersAbout, String remarks, List<String> picsUrl) {
		super();
		this.date = date;
		this.uniqueId = uniqueId;
		this.moc = moc;
		this.arrangements = arrangements;
		this.worshipers = worshipers;
		this.musicians = musicians;
		this.singers = singers;
		this.songs = songs;
		this.testimony = testimony;
		this.wog = wog;
		this.aboutWog = aboutWog;
		this.others = others;
		this.othersAbout = othersAbout;
		this.remarks = remarks;
		this.picsUrl =picsUrl;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public List<String> getMoc() {
		return moc;
	}
	public void setMoc(List<String> moc) {
		this.moc = moc;
	}
	public List<String> getArrangements() {
		return arrangements;
	}
	public void setArrangements(List<String> arrangements) {
		this.arrangements = arrangements;
	}
	public List<String> getWorshipers() {
		return worshipers;
	}
	public void setWorshipers(List<String> worshipers) {
		this.worshipers = worshipers;
	}
	public List<String> getMusicians() {
		return musicians;
	}
	public void setMusicians(List<String> musicians) {
		this.musicians = musicians;
	}
	public List<String> getSingers() {
		return singers;
	}
	public void setSingers(List<String> singers) {
		this.singers = singers;
	}
	public String getSongs() {
		return songs;
	}
	public void setSongs(String songs) {
		this.songs = songs;
	}
	public List<String> getTestimony() {
		return testimony;
	}
	public void setTestimony(List<String> testimony) {
		this.testimony = testimony;
	}
	public List<String> getWog() {
		return wog;
	}
	public void setWog(List<String> wog) {
		this.wog = wog;
	}
	public String getAboutWog() {
		return aboutWog;
	}
	public void setAboutWog(String aboutWog) {
		this.aboutWog = aboutWog;
	}
	public List<String> getOthers() {
		return others;
	}
	public void setOthers(List<String> others) {
		this.others = others;
	}
	public String getOthersAbout() {
		return othersAbout;
	}
	public void setOthersAbout(String othersAbout) {
		this.othersAbout = othersAbout;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<String> getPicsUrl() {
		return picsUrl;
	}

	public void setPicsUrl(List<String> picsUrl) {
		this.picsUrl = picsUrl;
	}
	
	
	
	
	
}
