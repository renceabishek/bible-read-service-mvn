package com.bible.read.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
				List<String> emptyList=new ArrayList<String>();
				activity.setHelpedBy(emptyList);
			}
			return activity;
		}).collect(Collectors.toList());
	}

	@Override
	public HashMap<String,Object> createActivity(Activity activity, List<MultipartFile> files) {
		if (activity.getHelpedBy() == null || activity.getHelpedBy().isEmpty()) {
			activity.setHelpedBy(null);
		}
		HashMap<String,Object> hm=new HashMap();
		List<String> picsUrl = new ArrayList();
		if (files != null && !files.isEmpty()) {
			picsUrl = activityIntegration.saveActivityPics(files, activity.getDate());
			activity.setPicsUrl(picsUrl);
		}
		String uniqueId = activityIntegration.createActivity(activity);
		hm.put("uniqueId", uniqueId);
		hm.put("picsUrl", picsUrl);
		return hm;
	}

	@Override
	public List<String> updateActivity(String uniqueId, Activity activity, List<MultipartFile> files, List<String> deletedPicsUrl) {
		List<String> picsUrl = null;
		if(deletedPicsUrl!=null && !deletedPicsUrl.isEmpty()) {
			activityIntegration.deletePicsFromFirebaseStorage(deletedPicsUrl);
		}
		
		if (files != null && !files.isEmpty()) {
			 picsUrl = activityIntegration.saveActivityPics(files, activity.getDate());
			if(activity.getPicsUrl()!=null ) {
				activity.getPicsUrl().addAll(picsUrl);
			} else {
				activity.setPicsUrl(picsUrl);
			}			
		}
		activityIntegration.updateActivity(uniqueId, activity);
		return picsUrl;
	}

	@Override
	public void deleteActivity(String uniqueId, List<String> picsUrl) {
		activityIntegration.deletePicsFromFirebaseStorage(picsUrl);
		activityIntegration.deleteActivity(uniqueId);
	}

}
