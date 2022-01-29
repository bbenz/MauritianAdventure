package com.bjedrzejewski;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This action represents player resting. It s a singleton.
 */
@Slf4j
class RestAction implements PlayerAction {

	private static final String restUrl = "rest";

	private static final RestAction INSTANCE = new RestAction();

	private static final String actionDescription = "You rest for a while.";

	public static RestAction getInstance() {
		return INSTANCE;
	}

	@Override
	public String actionUrl() {
		return restUrl;
	}

	@Override
	public void invokeAction(HttpSession session, GameState gameState) {
		log.debug("Player is resting.");
	}

	@Override
	public String actionLabel() {
		return "Take a rest";
	}

	@Override
	public String actionDescription() {
		return actionDescription;
	}

	public RestAction clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot clone instance of this class");
	}

}
