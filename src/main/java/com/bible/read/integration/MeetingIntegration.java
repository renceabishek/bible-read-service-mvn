package com.bible.read.integration;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Activity;
import com.bible.read.model.Meeting;

public interface MeetingIntegration {
	
	HashMap<String, Meeting> getMeetings();

	void deleteMeeting(String uniqueId);

	String createMeeting(Meeting meeting);
	
	List<String> saveMeetingPics(List<MultipartFile> files, String date);

	void updateMeeting(String uniqueId, Meeting meeting);
	
	void deletePicsFromFirebaseStorage(List<String> picsUrl);

}
