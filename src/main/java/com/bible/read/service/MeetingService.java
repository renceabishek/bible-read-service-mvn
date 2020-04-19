package com.bible.read.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Activity;
import com.bible.read.model.Meeting;

public interface MeetingService {

	public List<Meeting> getMeetings();
	
	public HashMap<String,Object> createMeetings(Meeting meeting, List<MultipartFile> files);
	
	public List<String> updateMeeting(String uniqueId, Meeting meeting, List<MultipartFile> files, List<String> deletedPicsUrl);
	
	public void deleteMeeting(String uniqueId, List<String> picsUrl);
}
