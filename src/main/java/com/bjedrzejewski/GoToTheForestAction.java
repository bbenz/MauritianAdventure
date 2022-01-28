package com.bjedrzejewski;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
class GoToTheForestAction implements PlayerAction {

	@Override
	public String actionUrl() {
		return "go-to-forest";
	}

	@Override
	public void invokeAction(HttpSession session, GameState gameState) {
		gameState.visitLocation(Locations.buildForestLocation());
	}

	@Override
	public String actionLabel() {
		return "Go to the forest";
	}

	@Override
	public String actionDescription() {
		return "go to the forest";
	}

}
