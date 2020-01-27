package com.bible.read.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.read.integration.ParticipantsIntegration;
import com.bible.read.model.DailyData;
import com.bible.read.model.Participants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ParticipantsServiceImp implements ParticipantsService {
	
	@Autowired
	ParticipantsIntegration participantsIntegration;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Participants> getParticipants() {
		// TODO Auto-generated method stub
		return participantsIntegration.getParticipants().entrySet().stream()
		        .map(k -> {
		        	Participants participiants = objectMapper.convertValue(k.getValue(), Participants.class);
		            return new Participants(k.getKey(), participiants.getName(), participiants.getFile());
		          }).collect(Collectors.toList());
	}

	@Override
	public boolean postParticipants(Participants participants) {
		// TODO Auto-generated method stub
		participantsIntegration.postParticipants(participants);
		return true;
	}

	@Override
	public boolean deleteParticipants(String uniqueId) {
		// TODO Auto-generated method stub
		participantsIntegration.deleteParticipants(uniqueId);
		return true;
	}

}
