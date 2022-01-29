package com.bjedrzejewski;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
@Slf4j
class ExploreTheBeachAction implements PlayerAction {

	private static final String actionDescription = "You explore the beach for a while.";

	public int exploredTimes = 0;

	private Location beach;

	public ExploreTheBeachAction(Location beach) {
		this.beach = beach;
	}

	@Override
	public String actionUrl() {
		return "explore-the-beach";
	}

	@Override
	public void invokeAction(HttpSession session, GameState gameState) {
		exploredTimes++;
		log.debug("Player explored the beach: " + exploredTimes + " times");
		if (exploredTimes == 2) {
			beach.availableActions().add(new GoToTheForestAction());
		}
	}

	@Override
	public String actionLabel() {
		return "Explore the Beach";
	}

	@Override
	public String actionDescription() {
		return actionDescription;
	}

}
