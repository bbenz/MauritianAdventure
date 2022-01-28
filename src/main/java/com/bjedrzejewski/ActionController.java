package com.bjedrzejewski;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * This controller is responsible for resolving player actions.
 */
@Slf4j
@RequiredArgsConstructor
@Controller
class ActionController {

	private final GameController gameController;

	@GetMapping("/action/{type}")
	String invokeAction(HttpSession session, Map<String, Object> model, @PathVariable String type) {
		var gameState = GameRunner.checkGameState(session);
		var availableActions = gameState.getAvailablePlayerActions();
		var action = availableActions.getOrDefault(type, null);
		if (null == action) {
			log.warn("Unknown or unavailable action requested: " + type);
			return "error";
		}
		action.invokeAction(session, gameState);
		gameState.lastActionDescription(action.actionDescription());
		gameState = GameRunner.checkGameState(session);
		gameState.advanceTime();
		return this.gameController.mainGameController(session, model);
	}

}
