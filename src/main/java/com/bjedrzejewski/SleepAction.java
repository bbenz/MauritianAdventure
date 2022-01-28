package com.bjedrzejewski;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This action represents player sleeping. It is a singleton.
 */
@Component
@Slf4j
class SleepAction implements PlayerAction {

	private static final String restUrl = "sleep";

	private static final SleepAction INSTANCE = new SleepAction();

	private static final String actionDescription = "You sleep for the night.";

	public static SleepAction getInstance() {
		return INSTANCE;
	}

	@Override
	public String actionUrl() {
		return restUrl;
	}

	@Override
	public void invokeAction(HttpSession session, GameState gameState) {
		log.debug("Player is sleeping.");
	}

	@Override
	public String actionLabel() {
		return "Go to sleep";
	}

	@Override
	public String actionDescription() {
		return actionDescription;
	}

	public SleepAction clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot clone instance of this class");
	}

}
