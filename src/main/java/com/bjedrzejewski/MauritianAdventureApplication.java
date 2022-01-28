package com.bjedrzejewski;

import freemarker.ext.beans.DefaultMemberAccessPolicy;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Version;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.hint.TypeHint;

import static org.springframework.nativex.hint.TypeAccess.*;

@ResourceHint(patterns = { "/freemarker/ext/beans/DefaultMemberAccessPolicy-rules" })
@TypeHint(types = { PlayerAction.class, ScreamAction.class, RestAction.class, SleepAction.class,
		ExploreTheBeachAction.class, GoToTheForestAction.class, DefaultMemberAccessPolicy.class,
		DefaultObjectWrapper.class, Player.class, GameState.class, Location.class, DayTime.class, Version.class, },
		access = { DECLARED_CLASSES, DECLARED_CONSTRUCTORS, DECLARED_FIELDS, DECLARED_METHODS })
@SpringBootApplication
public class MauritianAdventureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MauritianAdventureApplication.class, args);
	}

}
