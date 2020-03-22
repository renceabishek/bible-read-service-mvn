package com.bible.read.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.bible.read.model.Profile;

public interface ProfileService {
	
	String[] getProfiles();
	Profile getProfile(String uniqueId);
	String saveProfile(Profile participants);
	void updateProfile(Profile profile,String uniqueId);
	void deleteProfile(String uniqueId);
}
