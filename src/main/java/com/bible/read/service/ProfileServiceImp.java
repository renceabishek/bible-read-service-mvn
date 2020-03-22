package com.bible.read.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.read.integration.ProfileIntegration;
import com.bible.read.model.DailyData;
import com.bible.read.model.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProfileServiceImp implements ProfileService {
	
	@Autowired
	ProfileIntegration profileIntegration;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public String[] getProfiles() {
		// TODO Auto-generated method stub
		return profileIntegration.getProfiles().entrySet().stream()
		        .map(k -> {
		        	Profile profile = objectMapper.convertValue(k.getValue(), Profile.class);
		            return profile.getName()+"~"+k.getKey();
		          }).toArray(String[]::new);
	}

	@Override
	public Profile getProfile(String uniqueId) {
		return profileIntegration.getProfile(uniqueId);
	}

	@Override
	public String saveProfile(Profile profile) {
		return profileIntegration.saveProfile(profile);
	}

	@Override
	public void updateProfile(Profile profile, String uniqueId) {
		profileIntegration.updateProfile(profile, uniqueId);
		
	}

	@Override
	public void deleteProfile(String uniqueId) {
		profileIntegration.deleteProfile(uniqueId);
		
	}

}
