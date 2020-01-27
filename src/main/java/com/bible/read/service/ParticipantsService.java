package com.bible.read.service;

import java.util.List;

import com.bible.read.model.Participants;

public interface ParticipantsService {
	
	List<Participants> getParticipants();
	boolean postParticipants(Participants participants);
	boolean deleteParticipants(String uniqueId);
}
