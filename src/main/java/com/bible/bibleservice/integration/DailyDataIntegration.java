package com.bible.bibleservice.integration;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.bible.bibleservice.model.DailyData;

public interface DailyDataIntegration {

  HashMap<String,DailyData> getDailyData();

  HashMap<String,DailyData> getDailyDataByDate(String date);

  void deleteDailyDataById(String uniqueId);

  void createDailyData(DailyData dailyData);

}
