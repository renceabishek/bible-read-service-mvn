package com.bible.read.integration;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bible.read.model.DailyData;
import com.bible.read.model.Profile;
import com.google.firebase.database.DatabaseReference;

@Service
public class ProfileIntegrationImp implements ProfileIntegration {
	
	  @Autowired
	  @Qualifier("main")
	  private DatabaseReference mainDatabaseReference;

	  @Value("${firebase.path.profile}")
	  private String path;

	  private RestTemplate restTemplate = new RestTemplate();


	@Override
	public HashMap<String, Profile> getProfiles() {
		return restTemplate.getForObject("https://myfirstproject-fi.firebaseio.com/profile.json",
		        HashMap.class);
	}

	@Override
	public Profile getProfile(String uniqueId) {
		return restTemplate.getForObject("https://myfirstproject-fi.firebaseio.com/profile/"+ uniqueId + ".json",
		        Profile.class);
	}

	@Override
	public String saveProfile(Profile profile) {
		DatabaseReference postsRef = mainDatabaseReference.child(path);
	    DatabaseReference newPostRef = postsRef.push();
	    newPostRef.setValueAsync(profile);
	    return newPostRef.getKey();
	}

	@Override
	public void updateProfile(Profile profile, String uniqueId) {
		restTemplate.put("https://myfirstproject-fi.firebaseio.com/profile/" + uniqueId + ".json", profile);
		
	}

	@Override
	public void deleteProfile(String uniqueId) {
		restTemplate.delete("https://myfirstproject-fi.firebaseio.com/profile/" + uniqueId + ".json");
		
	}

}
