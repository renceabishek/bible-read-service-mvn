package com.bible.read.service;

import com.bible.read.integration.DailyDataIntegration;
import com.bible.read.model.DailyData;
import com.bible.read.model.TotalCount;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyDataServiceImp implements DailyDataService {

  @Autowired
  private DailyDataIntegration dailyDataIntegration;
  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public List<DailyData> getDailyData() {
    return dailyDataIntegration.getDailyData().entrySet().stream()
        .map(k -> {
          DailyData dailyData = objectMapper.convertValue(k.getValue(), DailyData.class);
          return new DailyData(k.getKey(), dailyData.getDate(), dailyData.getName(),
              dailyData.getPortion(), dailyData.getChapter(), dailyData.getFromVerses(),
              dailyData.getToVerses());
        }).collect(Collectors.toList());
  }

  @Override
  public List<DailyData> getDailyDataByDate(String date) {
    return dailyDataIntegration.getDailyDataByDate(date).entrySet().stream()
        .map(k -> {
          DailyData dailyData = objectMapper.convertValue(k.getValue(), DailyData.class);
          return new DailyData(k.getKey(), dailyData.getDate(), dailyData.getName(),
              dailyData.getPortion(), dailyData.getChapter(), dailyData.getFromVerses(),
              dailyData.getToVerses());
        }).collect(Collectors.toList());
  }

  @Override
  public void deleteDailyDataById(String uniqueId) {
    dailyDataIntegration.deleteDailyDataById(uniqueId);
  }

  @Override
  public void createDailyData(DailyData dailyData) {
    dailyDataIntegration.createDailyData(dailyData);
  }

  @Override
  public List<TotalCount> getTotalCountData() {
    HashMap<String,Integer> hm=new HashMap<>();
    List<TotalCount> totalCounts = new ArrayList<>();
    dailyDataIntegration.getDailyData().entrySet()
        .forEach(k -> {
          DailyData dailyData = objectMapper.convertValue(k.getValue(), DailyData.class);
          if(!hm.containsKey(dailyData.getName())) {
            hm.put(dailyData.getName(), 1);
          } else {
            hm.compute(dailyData.getName(), (key,value)->value+1);
          }
        });

    hm.entrySet().stream()
        .forEach(k->{
          TotalCount totalCount=new TotalCount();
          totalCount.setName(k.getKey());
          totalCount.setCount(k.getValue());
          totalCounts.add(totalCount);
        });
    return totalCounts;
  }
}
