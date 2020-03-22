package com.bible.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.read.model.Profile;
import com.bible.read.service.ProfileService;


@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping(value="/profile/all")
	public String[] getProfiles() {
		return profileService.getProfiles();
	}

	@GetMapping(value="/profile/{uniqueId}")
	public Profile getProfile(@PathVariable String uniqueId) {
		return profileService.getProfile(uniqueId);
	}
	
	@PostMapping(value="/profile", consumes = "application/json")
	public String saveProfiles(@RequestBody Profile profile) {
		return profileService.saveProfile(profile);
	}
	
	@PutMapping(value="/profile/{uniqueId}", consumes = "application/json")
	public void updateProfile(@RequestBody Profile profile, @PathVariable String uniqueId) {
		 profileService.updateProfile(profile,uniqueId);
	}
	
	@DeleteMapping(value="/profile/{uniqueId}")
	public void deleteProfiles(@PathVariable String uniqueId) {
		 profileService.deleteProfile(uniqueId);
	}
}
