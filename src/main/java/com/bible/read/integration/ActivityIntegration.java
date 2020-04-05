package com.bible.read.integration;

import java.util.HashMap;

import com.bible.read.model.Activity;
import com.bible.read.model.DailyData;

public interface ActivityIntegration {

	HashMap<String, Activity> getActivities();

	void deleteActivity(String uniqueId);

	String createActivity(Activity activity);

	void updateActivity(String uniqueId, Activity activity);

}
