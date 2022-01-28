package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameController;
import com.bjedrzejewski.game.GameRunner;
import com.bjedrzejewski.game.GameState;
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
@Controller
public class ActionController {

	private final GameController gameController;

	ActionController(GameController gameController) {
		this.gameController = gameController;
	}

	@GetMapping("/action/{type}")
	public String invokeAction(HttpSession session, Map<String, Object> model, @PathVariable String type) {
		PlayerAction action = null;
		GameState gameState = GameRunner.checkGameState(session);
		Map<String, PlayerAction> availableActions = gameState.getAvailablePlayerActions();
		if (availableActions.containsKey(type)) {
			action = availableActions.get(type);
		}
		else {
			log.warn("Unknown or unavailable action requested: " + type);
			return "error";
		}

		action.invokeAction(session, gameState);
		gameState.setLastActionDescription(action.getActionDescription());
		gameState = GameRunner.checkGameState(session);
		gameState.advanceTime();

		return this.gameController.mainGameController(session, model);
	}

}
