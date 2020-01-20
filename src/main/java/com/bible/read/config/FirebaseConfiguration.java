package com.bible.read.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfiguration {
	
	@Value("${pi.value}")
	private String path;

}
