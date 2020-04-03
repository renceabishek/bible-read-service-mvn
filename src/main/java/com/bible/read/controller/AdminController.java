package com.bible.read.controller;

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

import com.bible.read.model.Profile;
import com.bible.read.model.ProfilesGet;
import com.bible.read.model.UpdateProfile;
import com.bible.read.service.ProfileService;


@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private ProfileService profileService;
	
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
	
	@PostMapping(value="/sample/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveSampleProfiles(@RequestParam(name ="file",required=false) MultipartFile file, 
			@RequestPart(name ="profile",required=true) Profile profile) {
		return profile.getName();
		//return profileService.saveProfile(profile, file);
	}
}
