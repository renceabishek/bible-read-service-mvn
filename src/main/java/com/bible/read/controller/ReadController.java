package com.bible.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.read.model.DailyData;
import com.bible.read.service.DailyDataService;

@RequestMapping("/bible")
@RestController
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
}
