package com.bible.read.integration;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Profile;
import com.bible.read.model.UpdateProfile;

public interface ProfileIntegration {
	
	HashMap<String, Profile> getProfiles();
	Profile getProfile(String uniqueId);
	String saveProfilePic(MultipartFile file, String name);
	String saveProfile(Profile profile);
	void updateProfile(UpdateProfile profile,String uniqueId);
	void deleteProfile(String uniqueId);
}
