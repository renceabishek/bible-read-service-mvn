package com.bible.bibleservice.service;

import java.time.LocalDate;
import java.util.List;

import com.bible.bibleservice.model.DailyData;
import com.bible.bibleservice.model.TotalCount;

public interface DailyDataService {

  List<DailyData> getDailyData();

  List<DailyData> getDailyDataByDate(String date);

  void deleteDailyDataById(String uniqueId);

  void createDailyData(DailyData dailyData);

  List<TotalCount> getTotalCountData();

}
