package com.bible.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.read.model.Participants;
import com.bible.read.service.DailyDataService;
import com.bible.read.service.ParticipantsService;

@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private ParticipantsService participantsService;

	@GetMapping(value="/participants/all")
	public List<Participants> getParticipants() {
		return participantsService.getParticipants();
	}
	
	@PostMapping(value="/participants/post", consumes = "application/json")
	public boolean postParticipants(@RequestBody Participants participants) {
		return participantsService.postParticipants(participants);
	}
	
	@DeleteMapping(value="/participants/{uniqueId}/delete")
	public boolean deleteParticipants(@PathVariable String uniqueId) {
		return participantsService.deleteParticipants(uniqueId);
	}
}
