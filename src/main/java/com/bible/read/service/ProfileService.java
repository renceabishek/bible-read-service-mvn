package com.bible.read.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Profile;
import com.bible.read.model.ProfilesGet;
import com.bible.read.model.UpdateProfile;

public interface ProfileService {
	
	List<ProfilesGet> getProfiles();
	Profile getProfile(String uniqueId);
	String saveProfile(Profile participants, MultipartFile file);
	void updateProfile(UpdateProfile profile, MultipartFile file, String uniqueId);
	void deleteProfile(String uniqueId);
}
