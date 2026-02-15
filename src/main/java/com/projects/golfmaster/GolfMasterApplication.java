package com.projects.golfmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GolfMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolfMasterApplication.class, args);
	}

}
