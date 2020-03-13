package com.bible.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.read.model.DailyData;
import com.bible.read.model.TotalCount;
import com.bible.read.service.DailyDataService;

@RequestMapping("/bible")
@RestController
@CrossOrigin
public class ReadController {
	
	@Autowired
	private DailyDataService dailyDataService;

	@GetMapping(value="/value/{value}")
	public String getValue(@PathVariable String value) {
		return value;
	}
	
	@GetMapping(value = "/all")
	  public List<DailyData> getDailyData() {
	    return dailyDataService.getDailyData();
	  }
	
	@GetMapping(value = "/date/{date}")
	  public List<DailyData> getDailyDataByDate(@PathVariable String date) {
	    return dailyDataService.getDailyDataByDate(date);
	  }

	  @DeleteMapping(value = "/date/{uniqueId}")
	  public void deleteDailyDataById(@PathVariable String uniqueId) {
	     dailyDataService.deleteDailyDataById(uniqueId);
	  }

	  @PostMapping(value = "/all", consumes = "application/json")
	  public String createDailyData(@RequestBody DailyData dailyData) {
	    return dailyDataService.createDailyData(dailyData);
	  }
	  
	  @PutMapping(value = "/all/{uniqueId}", consumes = "application/json")
	  public void updateDailyData(@RequestBody DailyData dailyData, @PathVariable String uniqueId) {
	     dailyDataService.updateDailyData(dailyData,uniqueId);
	  }

	  @GetMapping(value="/totalCounts")
	  public List<TotalCount> getTotalCountData() {
	    return dailyDataService.getTotalCountData();
	  }
}
