package com.bible.read.integration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Meeting;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Bucket.BucketSourceOption;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.DatabaseReference;

@Service
public class MeetingIntegrationImp implements MeetingIntegration {
	
	  @Autowired
	  @Qualifier("main")
	  private DatabaseReference mainDatabaseReference;

	  @Value("${firebase.path.meeting}")
	  private String path;
	  
	  @Value("${firebase.database-url}")
	  private String firebaseUrl;
	  
	  @Value("${firebase.project-Url}")
	  private String projectUrl;
	  
	  @Value("${firebase.storage-url}")
	  private String storageUrl;
	  
	  @Value("${firebase.storage.meetingPic}")
	  private String storageFolderName;
	  
	  @Autowired
	  @Qualifier("storage-main")
	  private Storage storage;

	  private RestTemplate restTemplate = new RestTemplate();
	  
	@Override
	public HashMap<String, Meeting> getMeetings() {		 
		return restTemplate.getForObject(firebaseUrl+"/"+path+".json",HashMap.class);
	}

	@Override
	public void deleteMeeting(String uniqueId) {
		restTemplate.delete(firebaseUrl+"/"+path+"/"+ uniqueId + ".json");
		
	}

	@Override
	public String createMeeting(Meeting meeting) {
		DatabaseReference postsRef = mainDatabaseReference.child(path);
	    DatabaseReference newPostRef = postsRef.push();
	    newPostRef.setValueAsync(meeting);
	    return newPostRef.getKey();
	}

	@Override
	public List<String> saveMeetingPics(List<MultipartFile> files, String date) {
		Bucket bucket = StorageClient.getInstance().bucket();
		
		List<String> picUrl = new ArrayList<String>();
		files.stream().forEach(file -> {
			Blob blob = null;
			try {
				blob = bucket.create(storageFolderName+date+"/" + file.getOriginalFilename(), file.getInputStream(),
						Bucket.BlobWriteOption.userProject(projectUrl));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			blob.getStorage().createAcl(blob.getBlobId(), Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
			picUrl.add(blob.getMediaLink());
		});
		return picUrl;
	}

	@Override
	public void updateMeeting(String uniqueId, Meeting meeting) {
		restTemplate.put(firebaseUrl+"/"+path+"/" + uniqueId + ".json", meeting);
		
	}

	@Override
	public void deletePicsFromFirebaseStorage(List<String> picsUrl) {
		picsUrl.forEach(pic->{
			String folderName = pic.split("%2F")[1];
			String picName=pic.split("%2F")[2].split("\\?")[0].replace("%20", " ");
			System.out.println("checking "+storageFolderName+folderName+"/"+picName);
			storage.delete(storageUrl, storageFolderName+folderName+"/"+picName);
		});		
		
	}

}
