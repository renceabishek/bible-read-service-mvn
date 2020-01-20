package com.bible.read.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtConfig {
	
	@Value("${pi.value}")
	private String path;

}
