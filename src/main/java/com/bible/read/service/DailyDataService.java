package com.bible.read.service;

import com.bible.read.model.DailyData;
import com.bible.read.model.TotalCount;
import java.time.LocalDate;
import java.util.List;

public interface DailyDataService {

  List<DailyData> getDailyData();

  List<DailyData> getDailyDataByDate(String date);

  void deleteDailyDataById(String uniqueId);

  String createDailyData(DailyData dailyData);
  
  void updateDailyData(DailyData dailyData, String uniqueId);

  List<TotalCount> getTotalCountData();

}
