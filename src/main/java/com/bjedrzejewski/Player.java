package com.bjedrzejewski;

import java.io.Serializable;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This is the class representing the Player in the game.
 */
public record Player(int life) implements Serializable {

	public String description() {
		return "You are healthy and well rested.";
	}

}
