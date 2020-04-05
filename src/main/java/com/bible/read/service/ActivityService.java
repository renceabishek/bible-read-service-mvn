package com.bible.read.service;

import java.util.List;

import com.bible.read.model.Activity;

public interface ActivityService {
	
	public List<Activity> getActivities();
	
	public String createActivity(Activity activity);
	
	public void updateActivity(String uniqueId, Activity activity);
	
	public void deleteActivity(String uniqueId);

}
