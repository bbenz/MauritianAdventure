package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameState;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This interaface represents actions that the player of the game can take.
 */
public interface PlayerAction extends Serializable {

	/**
	 * Url required for invoking the particular action.
	 * @return
	 */
	String getActionUrl();

	/**
	 * Controller mapped to the action
	 * @return
	 */
	void invokeAction(HttpSession session, GameState gameState);

	/**
	 * Action label to be displayed int he UI
	 * @return
	 */
	String getActionLabel();

	/**
	 * Action description to be displayed upon invocation
	 * @return
	 */
	String getActionDescription();

}
