package com.bible.read.integration;

import java.util.HashMap;

import com.bible.read.model.Participants;

public interface ParticipantsIntegration {
	
	HashMap<String, Participants> getParticipants();
	void postParticipants(Participants participants);
	void deleteParticipants(String uniqueId);
}
