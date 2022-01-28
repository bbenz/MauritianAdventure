package com.bjedrzejewski.player;

import java.io.Serializable;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * <p>
 * This is the class representing the Player in the game.
 */
public class Player implements Serializable {

	private final int life;

	public Player(int life) {
		this.life = life;
	}

	public int getLife() {
		return life;
	}

	public String description() {
		return "You are healthy and well rested.";
	}

}
