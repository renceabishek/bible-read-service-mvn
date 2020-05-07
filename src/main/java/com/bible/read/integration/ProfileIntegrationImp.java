package com.bible.read.integration;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.bible.read.model.DailyData;
import com.bible.read.model.Profile;
import com.bible.read.model.UpdateProfile;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.DatabaseReference;

@Service
public class ProfileIntegrationImp implements ProfileIntegration {
	
	  @Autowired
	  @Qualifier("main")
	  private DatabaseReference mainDatabaseReference;
	  
	  @Value("${firebase.database-url}")
	  private String firebaseUrl;

	  @Value("${firebase.path.profile}")
	  private String path;
	  
	  @Value("${firebase.project-Url}")
	  private String projectUrl;
	  
	  @Value("${firebase.storage.profilePic}")
	  private String storageFolderName;

	  private RestTemplate restTemplate = new RestTemplate();


	@Override
	public HashMap<String, Profile> getProfiles() {
		return restTemplate.getForObject(firebaseUrl+"/"+path+".json", HashMap.class);
	}

	@Override
	public Profile getProfile(String uniqueId) {
		return restTemplate.getForObject(firebaseUrl+"/"+path+"/"+ uniqueId + ".json", Profile.class);
	}
	
	@Override
	public String saveProfilePic(MultipartFile file, String name) {
		Bucket bucket = StorageClient.getInstance().bucket();
		Blob blob=null;
		try {
			blob=bucket.create(storageFolderName+name, file.getInputStream(), Bucket.BlobWriteOption.userProject(projectUrl));
			blob.getStorage().createAcl(blob.getBlobId(), Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return blob.getMediaLink();
	}

	@Override
	public String saveProfile(Profile profile) {		
		DatabaseReference postsRef = mainDatabaseReference.child(path);
	    DatabaseReference newPostRef = postsRef.push();
	    newPostRef.setValueAsync(profile);
	    return newPostRef.getKey();
	}

	@Override
	public void updateProfile(UpdateProfile profile, String uniqueId) {
		
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "merge-patch+json");
		headers.setContentType(mediaType);

		HttpEntity<UpdateProfile> entity = new HttpEntity<>(profile, headers);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		restTemplate.exchange(firebaseUrl+"/"+path+"/" + uniqueId + ".json", 
				HttpMethod.PATCH, entity, Void.class);
		
	}

	@Override
	public void deleteProfile(String uniqueId) {
		restTemplate.delete(firebaseUrl+"/"+path+"/" + uniqueId + ".json");
		
	}

	

}
