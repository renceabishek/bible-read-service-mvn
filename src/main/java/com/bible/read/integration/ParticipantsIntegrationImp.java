package com.bible.read.integration;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bible.read.model.Participants;
import com.google.firebase.database.DatabaseReference;

@Service
public class ParticipantsIntegrationImp implements ParticipantsIntegration {
	
	  @Autowired
	  @Qualifier("main")
	  private DatabaseReference mainDatabaseReference;

	  @Value("${firebase.path.participants}")
	  private String path;

	  private RestTemplate restTemplate = new RestTemplate();

	@Override
	public HashMap<String, Participants> getParticipants() {
		// https://myfirstproject-fi.firebaseio.com/participants
		 return restTemplate.getForObject("https://myfirstproject-fi.firebaseio.com/participants.json",
		        HashMap.class);
	}

	@Override
	public void postParticipants(Participants participants) {
		DatabaseReference postsRef = mainDatabaseReference.child(path);
	    DatabaseReference newPostRef = postsRef.push();
	    newPostRef.setValueAsync(participants);
	}

	@Override
	public void deleteParticipants(String uniqueId) {
		restTemplate
        .delete("https://myfirstproject-fi.firebaseio.com/participants/" + uniqueId + ".json");
	}

}
