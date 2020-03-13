package com.bible.read.integration;

import com.bible.read.model.DailyData;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DailyDataIntegrationImp implements DailyDataIntegration {

  @Autowired
  @Qualifier("main")
  private DatabaseReference mainDatabaseReference;

  @Value("${firebase.path}")
  private String path;

  private RestTemplate restTemplate = new RestTemplate();

  @Override
  public HashMap<String, DailyData> getDailyData() {
    return restTemplate.getForObject("https://myfirstproject-fi.firebaseio.com/dailybible.json",
        HashMap.class);
  }

  @Override
  public HashMap<String, DailyData> getDailyDataByDate(String date) {

    String url =
        "https://myfirstproject-fi.firebaseio.com/dailybible.json?orderBy=\"date\"&equalTo=\""
            + date + "\"";
    return restTemplate.getForObject(url, HashMap.class);
  }

  @Override
  public void deleteDailyDataById(String uniqueId) {
    restTemplate
        .delete("https://myfirstproject-fi.firebaseio.com/dailybible/" + uniqueId + ".json");
  }
  

  @Override
  public String createDailyData(DailyData dailyData) {
    DatabaseReference postsRef = mainDatabaseReference.child(path);
    DatabaseReference newPostRef = postsRef.push();
    newPostRef.setValueAsync(dailyData);
    return newPostRef.getKey();
  }

@Override
public void updateDailyData(DailyData dailyData, String uniqueId) {
	 restTemplate.put("https://myfirstproject-fi.firebaseio.com/dailybible/" + uniqueId + ".json", dailyData);
	
}
}
