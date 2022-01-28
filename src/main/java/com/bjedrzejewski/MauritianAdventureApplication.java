package com.bjedrzejewski;

import freemarker.template.Version;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.nativex.hint.TypeAccess;
import org.springframework.nativex.hint.TypeHint;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@TypeHint(
		types = { freemarker.template.DefaultObjectWrapper.class, Player.class, GameState.class, Location.class,
				DayTime.class, PlayerAction.class, Version.class, },
		access = { TypeAccess.DECLARED_CLASSES, TypeAccess.DECLARED_CONSTRUCTORS, TypeAccess.DECLARED_FIELDS,
				TypeAccess.DECLARED_METHODS })

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
