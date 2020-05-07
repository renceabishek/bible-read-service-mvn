package com.bible.read.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.Activity;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.DatabaseReference;

@Service
public class ActivityIntegrationImp implements ActivityIntegration {
	
	  @Autowired
	  @Qualifier("main")
	  private DatabaseReference mainDatabaseReference;

	  @Value("${firebase.path.activity}")
	  private String path;
	  
	  @Value("${firebase.database-url}")
	  private String firebaseUrl;
	  
	  @Value("${firebase.project-Url}")
	  private String projectUrl;
	  
	  @Value("${firebase.storage-url}")
	  private String storageUrl;
	  
	  @Value("${firebase.storage.activityPic}")
	  private String storageFolderName;
	  
	  @Autowired
	  @Qualifier("storage-main")
	  private Storage storage;

	  private RestTemplate restTemplate = new RestTemplate();

	@Override
	public HashMap<String, Activity> getActivities() {
		return restTemplate.getForObject(firebaseUrl+"/"+path+".json",HashMap.class);
	}

	@Override
	public void deleteActivity(String uniqueId) {
		restTemplate.delete(firebaseUrl+"/"+path+"/"+ uniqueId + ".json");
		
	}
	
	@Override
	public List<String> saveActivityPics(List<MultipartFile> files, String date) {
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
	public String createActivity(Activity activity) {
		DatabaseReference postsRef = mainDatabaseReference.child(path);
	    DatabaseReference newPostRef = postsRef.push();
	    newPostRef.setValueAsync(activity);
	    return newPostRef.getKey();
	}

	@Override
	public void updateActivity(String uniqueId, Activity activity) {
		restTemplate.put(firebaseUrl+"/"+path+"/" + uniqueId + ".json", activity);
		
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
