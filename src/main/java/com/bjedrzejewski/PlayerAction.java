package com.bjedrzejewski;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This interaface represents actions that the player of the game can take.
 */
public interface PlayerAction extends Serializable {

	String actionUrl();

	String actionLabel();

	String actionDescription();

	void invokeAction(HttpSession session, GameState gameState);

}
