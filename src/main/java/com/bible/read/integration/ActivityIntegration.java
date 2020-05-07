package com.bible.read.integration;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Activity;
import com.bible.read.model.DailyData;

public interface ActivityIntegration {

	HashMap<String, Activity> getActivities();

	void deleteActivity(String uniqueId);
	
	List<String> saveActivityPics(List<MultipartFile> files, String date);

	String createActivity(Activity activity);

	void updateActivity(String uniqueId, Activity activity);
	
	void deletePicsFromFirebaseStorage(List<String> picsUrl);

}
