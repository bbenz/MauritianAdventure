package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This action represents player resting. It s a singleton.
 */
@Controller
@Slf4j
public final class RestAction implements PlayerAction {

	private static final String restUrl = "rest";

	private static final RestAction INSTANCE = new RestAction();

	private static final String actionDescription = "You rest for a while.";


	public static RestAction getInstance() {
		return INSTANCE;
	}

	@Override
	public String getActionUrl() {
		return restUrl;
	}

	@Override
	public void invokeAction(HttpSession session, GameState gameState) {
		log.debug("Player is resting.");
	}

	@Override
	public String getActionLabel() {
		return "Take a rest";
	}

	@Override
	public String getActionDescription() {
		return actionDescription;
	}

	public RestAction clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot clone instance of this class");
	}

}
