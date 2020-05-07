package com.bible.read.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Activity;

public interface ActivityService {
	
	public List<Activity> getActivities();
	
	public HashMap<String,Object> createActivity(Activity activity, List<MultipartFile> files);
	
	public List<String> updateActivity(String uniqueId, Activity activity, List<MultipartFile> files, List<String> deletedPicsUrl);
	
	public void deleteActivity(String uniqueId, List<String> picsUrl);

}
