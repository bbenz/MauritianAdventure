package com.bjedrzejewski.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * Created by bartoszjedrzejewski on 03/08/2016.
 */
@Controller
@Slf4j
public class GameController {

	@GetMapping("/game")
	public String mainGameController(HttpSession session, Map<String, Object> model) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);

		// First the game state for the session is retrieved or created
		GameState gameState = GameRunner.checkGameState(session);

		// Based on that player actions are presented
		model.put("actions", gameState.getAvailablePlayerActions().values());

		// Based on that player location is made available
		model.put("location", gameState.getPlayerLocation());

		// The rest of UI gets rendered
		String description = "";

		// Only show the general description during the first day.
		if (gameState.getDaysPassed() == 0) {
			description += """
					Welcome to the Mauritian Adventure. This is a game where you will try to survive and explore
					the magical island of Mauritius.
					<br/>
					""";
		}

		description += String.format("%s You have been on this adventure for %s days. <br/> %s",
				gameState.getCurrentDayTime().getDescription(), gameState.getDaysPassed(), gameState.getDescription());

		model.put("mainText", description);

		// Saving the gameState for session
		session.setAttribute("game", gameState);

		// Make the whole state available when needed
		model.put("gameState", gameState);

		return "game";
	}

}
