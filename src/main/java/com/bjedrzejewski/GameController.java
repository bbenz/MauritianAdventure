package com.bjedrzejewski;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * Created by bartoszjedrzejewski on 03/08/2016.
 */
@Controller
class GameController {

	@GetMapping("/game")
	String mainGameController(HttpSession session, Map<String, Object> model) {
		var uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		var gameState = GameRunner.checkGameState(session);
		model.put("actions", gameState.getAvailablePlayerActions().values());
		model.put("location", gameState.playerLocation());
		var description = "";
		if (gameState.daysPassed() == 0) {
			description += """
					Welcome to the Mauritian Adventure. This is a game where you will try to survive and explore
					the magical island of Mauritius.
					<br/>
					""";
		}
		description += String.format("%s You have been on this adventure for %s days. <br/> %s",
				gameState.currentDayTime().description(), gameState.daysPassed(), gameState.description());
		model.put("mainText", description);
		// Saving the gameState for session
		session.setAttribute("game", gameState);
		// Make the whole state available when needed
		model.put("gameState", gameState);
		return "game";
	}

}
