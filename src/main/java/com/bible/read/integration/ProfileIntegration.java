package com.bible.read.integration;

import java.util.HashMap;

import com.bible.read.model.Profile;

public interface ProfileIntegration {
	
	HashMap<String, Profile> getProfiles();
	Profile getProfile(String uniqueId);
	String saveProfile(Profile profile);
	void updateProfile(Profile profile,String uniqueId);
	void deleteProfile(String uniqueId);
}
