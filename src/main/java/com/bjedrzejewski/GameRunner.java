package com.bjedrzejewski;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 06/08/2016. This is the utility class responsible for
 * running the game.
 */
class GameRunner {

	public static GameState checkGameState(HttpSession session) {
		if (session.getAttribute("game") == null) {
			session.setAttribute("game", new GameState());
		}
		return (GameState) session.getAttribute("game");
	}

}
