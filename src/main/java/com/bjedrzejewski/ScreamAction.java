package com.bjedrzejewski;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by andrewbissette on 23/12/2016.
 * <p>
 * This action represents player screaming. It is a singleton. This action will be removed
 * and was added as a learning process.
 */
@Slf4j
class ScreamAction implements PlayerAction {

	private static final String screamUrl = "scream";

	private static final ScreamAction INSTANCE = new ScreamAction();

	private static final String actionDescription = "You scream into the horizon for some time.";

	public static ScreamAction getInstance() {
		return INSTANCE;
	}

	@Override
	public String actionUrl() {
		return screamUrl;
	}

	@Override
	public void invokeAction(HttpSession session, GameState gameState) {
		log.info("player is screaming");
	}

	@Override
	public String actionLabel() {
		return "Scream futilely into the ocean.";
	}

	public String actionDescription() {
		return actionDescription;
	}

	public ScreamAction clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot clone instance of this class");
	}

}
