package com.bible.bibleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class DailyDataController {

	@GetMapping(value="/check/{value}")
	public String getValue(@PathVariable String value) {
		return value;
	}
}
