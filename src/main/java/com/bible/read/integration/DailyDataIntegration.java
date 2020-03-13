package com.bible.read.integration;

import com.bible.read.model.DailyData;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface DailyDataIntegration {

  HashMap<String,DailyData> getDailyData();

  HashMap<String,DailyData> getDailyDataByDate(String date);

  void deleteDailyDataById(String uniqueId);

  String createDailyData(DailyData dailyData);
  
  void updateDailyData(DailyData dailyData, String uniqueId);

}
