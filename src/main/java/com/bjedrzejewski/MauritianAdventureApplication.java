package com.bjedrzejewski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@EnableScheduling
@SpringBootApplication
public class MauritianAdventureApplication {

	@Bean
	ScheduledExecutorService scheduledExecutorService() {
		return Executors.newScheduledThreadPool(10);
	}

	public static void main(String[] args) {
		SpringApplication.run(MauritianAdventureApplication.class, args);
	}

}
