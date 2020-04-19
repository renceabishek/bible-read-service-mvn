package com.bible.read.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.integration.MeetingIntegration;
import com.bible.read.model.Activity;
import com.bible.read.model.Meeting;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MeetingServiceImp implements MeetingService {

	@Autowired
	private MeetingIntegration meetingIntegration;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Meeting> getMeetings() {
		return meetingIntegration.getMeetings().entrySet().stream().map(k -> {
			Meeting meeting = objectMapper.convertValue(k.getValue(), Meeting.class);
			meeting.setUniqueId(k.getKey());
			makeEmptyStringList(meeting);
			return meeting;
		}).collect(Collectors.toList());
	}

	@Override
	public HashMap<String,Object> createMeetings(Meeting meeting, List<MultipartFile> files) {
		HashMap<String,Object> hm=new HashMap();
		List<String> picsUrl = new ArrayList();
		if (files != null && !files.isEmpty()) {
			picsUrl = meetingIntegration.saveMeetingPics(files, meeting.getDate());
			meeting.setPicsUrl(picsUrl);
		}
		String uniqueId =  meetingIntegration.createMeeting(meeting);
		
		hm.put("uniqueId", uniqueId);
		hm.put("picsUrl", picsUrl);
		return hm;
	}

	@Override
	public List<String> updateMeeting(String uniqueId, Meeting meeting, List<MultipartFile> files, List<String> deletedPicsUrl) {
		
		List<String> picsUrl = null;
		if(deletedPicsUrl!=null && !deletedPicsUrl.isEmpty()) {
			meetingIntegration.deletePicsFromFirebaseStorage(deletedPicsUrl);
		}
		
		if (files != null && !files.isEmpty()) {
			 picsUrl = meetingIntegration.saveMeetingPics(files, meeting.getDate());
			if(meeting.getPicsUrl()!=null ) {
				meeting.getPicsUrl().addAll(picsUrl);
			} else {
				meeting.setPicsUrl(picsUrl);
			}			
		}
		meetingIntegration.updateMeeting(uniqueId, meeting);
		return picsUrl;
	}

	@Override
	public void deleteMeeting(String uniqueId, List<String> picsUrl) {
		meetingIntegration.deletePicsFromFirebaseStorage(picsUrl);
		meetingIntegration.deleteMeeting(uniqueId);
	}

	private void makeEmptyStringList(Meeting meeting) {
		List<String> emptyList = new ArrayList<String>();
		if (meeting.getMoc() == null) {
			meeting.setMoc(emptyList);
		}
		if (meeting.getArrangements() == null) {
			meeting.setArrangements(emptyList);
		}
		if (meeting.getWorshipers() == null) {
			meeting.setWorshipers(emptyList);
		}
		if (meeting.getMusicians() == null) {
			meeting.setMusicians(emptyList);
		}
		if (meeting.getSingers() == null) {
			meeting.setSingers(emptyList);
		}
		if (meeting.getTestimony() == null) {
			meeting.setTestimony(emptyList);
		}
		if (meeting.getWog() == null) {
			meeting.setWog(emptyList);
		}
		if (meeting.getOthers() == null) {
			meeting.setOthers(emptyList);
		}
		if (meeting.getPicsUrl() == null) {
			meeting.setPicsUrl(emptyList);
		}
	}
}
