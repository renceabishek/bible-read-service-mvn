package com.bible.read.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bible")
@RestController
public class ReadController {

	@GetMapping(value="/value/{value}")
	public String getValue(@PathVariable String value) {
		return value;
	}
}
