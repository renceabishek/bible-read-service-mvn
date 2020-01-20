package com.bible.read.service;

import com.bible.read.model.DailyData;
import com.bible.read.model.TotalCount;
import java.time.LocalDate;
import java.util.List;

public interface DailyDataService {

  List<DailyData> getDailyData();

  List<DailyData> getDailyDataByDate(String date);

  void deleteDailyDataById(String uniqueId);

  void createDailyData(DailyData dailyData);

  List<TotalCount> getTotalCountData();

}
