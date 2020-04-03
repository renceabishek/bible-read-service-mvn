package com.bible.read.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.integration.ProfileIntegration;
import com.bible.read.model.DailyData;
import com.bible.read.model.Profile;
import com.bible.read.model.ProfilesGet;
import com.bible.read.model.UpdateProfile;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProfileServiceImp implements ProfileService {
	
	@Autowired
	ProfileIntegration profileIntegration;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<ProfilesGet> getProfiles() {
		return profileIntegration.getProfiles().entrySet().stream()
		        .map(k -> {
		        	Profile profile = objectMapper.convertValue(k.getValue(), Profile.class);
		            return new ProfilesGet(profile.getName(),k.getKey());
		          }).collect(Collectors.toList());
	}

	@Override
	public Profile getProfile(String uniqueId) {
		return profileIntegration.getProfile(uniqueId);
	}

	@Override
	public String saveProfile(Profile profile, MultipartFile file) {
		if(file!=null && !file.isEmpty()) {
			String profileUrl = profileIntegration.saveProfilePic(file, profile.getName());
			profile.setProfileUrl(profileUrl);
		}
		profile.setCreatedDate(LocalDate.now().toString());		
		return profileIntegration.saveProfile(profile);
	}

	@Override
	public void updateProfile(UpdateProfile profile, MultipartFile file, String uniqueId) {
		if(file!=null && !file.isEmpty()) {
			String profileUrl = profileIntegration.saveProfilePic(file, profile.getName());
			profile.setProfileUrl(profileUrl);
		}
		profile.setUpdatedDate(LocalDate.now().toString());
		profileIntegration.updateProfile(profile, uniqueId);
	}

	@Override
	public void deleteProfile(String uniqueId) {
		profileIntegration.deleteProfile(uniqueId);
		
	}

}
