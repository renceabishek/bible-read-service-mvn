package com.bible.bibleservice.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bible.bibleservice.model.DailyData;
import com.bible.bibleservice.model.TotalCount;
import com.bible.bibleservice.service.DailyDataService;

@RequestMapping("/bible")
@RestController
@CrossOrigin
public class DailyDataController {

	@GetMapping(value="/check/{value}")
	public String getValue(@PathVariable String value) {
		return value;
	}
	
	@Autowired
	  private DailyDataService dailyDataService;

	  @GetMapping(value ="/")
	  public String get() {
	    return "Hello World";
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
	  public void createDailyData(@RequestBody DailyData dailyData) {
	     dailyDataService.createDailyData(dailyData);
	  }

	  @GetMapping(value="/totalCounts")
	  public List<TotalCount> getTotalCountData() {
	    return dailyDataService.getTotalCountData();
	  }
}
