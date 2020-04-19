package com.bible.read.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Activity;
import com.bible.read.model.Meeting;
import com.bible.read.model.Profile;
import com.bible.read.model.ProfilesGet;
import com.bible.read.model.UpdateProfile;
import com.bible.read.service.ActivityService;
import com.bible.read.service.MeetingService;
import com.bible.read.service.ProfileService;


@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private MeetingService meetingService;
	
	@GetMapping(value="/profile/all")
	public List<ProfilesGet> getProfiles() {
		return profileService.getProfiles();
	}

	@GetMapping(value="/profile/{uniqueId}")
	public Profile getProfile(@PathVariable String uniqueId) {
		return profileService.getProfile(uniqueId);
	}
	
	@PostMapping(value="/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveProfiles(@RequestParam(name ="file",required=false) MultipartFile file, 
			@RequestPart(name ="profile",required=true) Profile profile) {
		return profileService.saveProfile(profile, file);
	}
	
	@PatchMapping(value="/profile/{uniqueId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void updateProfile(@RequestParam(name ="file",required=false) MultipartFile file, 
			@RequestPart(name ="profile",required=true) UpdateProfile profile, @PathVariable String uniqueId) {
		profileService.updateProfile(profile, file, uniqueId);
	}
	
	@DeleteMapping(value="/profile/{uniqueId}")
	public void deleteProfiles(@PathVariable String uniqueId) {
		 profileService.deleteProfile(uniqueId);
	}
	
	@GetMapping(value="/activity/all")
	public List<Activity> getActivities() {
		return activityService.getActivities();
	}
	
	@PostMapping(value = "/activity", consumes = "application/json")
	public String createActivity(@RequestBody Activity activity) {
		return activityService.createActivity(activity);
	}
	
	@PutMapping(value = "/activity/{uniqueId}", consumes = "application/json")
	public void updateActivity(@RequestBody Activity activity, @PathVariable String uniqueId) {
		 activityService.updateActivity(uniqueId,activity);
	}
	
	@DeleteMapping(value = "/activity/{uniqueId}")
	public void deleteActivity(@PathVariable String uniqueId) {
		 activityService.deleteActivity(uniqueId);
	}
	
	@GetMapping(value="/meeting/all")
	public List<Meeting> getMeetings() {
		return meetingService.getMeetings();
	}
	
	
	@PostMapping(value="/meeting", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public HashMap<String,Object> createMeeting(@RequestParam(name ="files",required=false) List<MultipartFile> files, 
			@RequestPart(name ="meeting",required=true) Meeting meeting) {
		System.out.println("files are "+files);
		return meetingService.createMeetings(meeting, files);
	}
	
	@PatchMapping(value="/meeting/{uniqueId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<String> updateMeeting(@RequestParam(name ="files",required=false) List<MultipartFile> files, 
			@RequestPart(name ="meeting",required=true) Meeting meeting, @PathVariable String uniqueId,
			@RequestPart(name ="deletedPicsUrl",required=false) List<String> deletedPicsUrl) {
		System.out.println("files are "+files);
			return meetingService.updateMeeting(uniqueId, meeting, files, deletedPicsUrl);
	}
	
	@DeleteMapping(value = "/meeting/{uniqueId}", consumes = "application/json")
	public void deleteMeeting(@PathVariable String uniqueId, @RequestBody List<String> picUrl) {
		meetingService.deleteMeeting(uniqueId, picUrl); 
	}
}
