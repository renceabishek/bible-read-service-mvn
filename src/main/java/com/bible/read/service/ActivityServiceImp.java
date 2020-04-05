package com.bible.read.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.read.integration.ActivityIntegration;
import com.bible.read.integration.DailyDataIntegration;
import com.bible.read.model.Activity;
import com.bible.read.model.DailyData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ActivityServiceImp implements ActivityService {

	@Autowired
	private ActivityIntegration activityIntegration;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Activity> getActivities() {
		return activityIntegration.getActivities().entrySet().stream().map(k -> {
			Activity activity = objectMapper.convertValue(k.getValue(), Activity.class);
			activity.setUniqueId(k.getKey());
			if (activity.getHelpedBy() == null) {
				activity.setHelpedBy(new ArrayList());
			}
			return activity;
		}).collect(Collectors.toList());
	}

	@Override
	public String createActivity(Activity activity) {
		if (activity.getHelpedBy() == null || activity.getHelpedBy().isEmpty()) {
			activity.setHelpedBy(null);
		}
		return activityIntegration.createActivity(activity);
	}

	@Override
	public void updateActivity(String uniqueId, Activity activity) {
		activityIntegration.updateActivity(uniqueId, activity);

	}

	@Override
	public void deleteActivity(String uniqueId) {
		activityIntegration.deleteActivity(uniqueId);
	}

}
