package com.bible.read.integration;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bible.read.model.Activity;
import com.google.firebase.database.DatabaseReference;

@Service
public class ActivityIntegrationImp implements ActivityIntegration {
	
	@Autowired
	  @Qualifier("main")
	  private DatabaseReference mainDatabaseReference;

	  @Value("${firebase.path.activity}")
	  private String path;
	  
	  @Value("${firebase.database-url}")
	  private String firebaseUrl;

	  private RestTemplate restTemplate = new RestTemplate();

	@Override
	public HashMap<String, Activity> getActivities() {
		return restTemplate.getForObject(firebaseUrl+"/"+path+".json",HashMap.class);
	}

	@Override
	public void deleteActivity(String uniqueId) {
		restTemplate.delete(firebaseUrl+"/"+path+"/"+ uniqueId + ".json");
		
	}

	@Override
	public String createActivity(Activity activity) {
		DatabaseReference postsRef = mainDatabaseReference.child(path);
	    DatabaseReference newPostRef = postsRef.push();
	    newPostRef.setValueAsync(activity);
	    return newPostRef.getKey();
	}

	@Override
	public void updateActivity(String uniqueId, Activity activity) {
		restTemplate.put(firebaseUrl+"/"+path+"/" + uniqueId + ".json", activity);
		
	}

}
