package com.bjedrzejewski;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 04/08/2016.
 */
public class GameState implements Serializable {

	private final Player player;

	// Days passed since the game started
	private int daysPassed = 0;

	// Game starts in the morning
	private DayTime currentDayTime = DayTime.MORNING;

	private final Map<String, Location> visitedLocations = new HashMap<>();

	// Game starts on the beach
	private Location playerLocation;

	// Description of the last action
	private String lastActionDescription = "";

	GameState() {
		player = new Player(100);
		visitLocation(Locations.buildBeachLocation());
	}

	public void visitLocation(Location location) {
		if (visitedLocations.containsKey(location.locationCode())) {
			playerLocation = visitedLocations.get(location.locationCode());
		}
		else {
			visitedLocations.put(location.locationCode(), location);
			playerLocation = location;
		}
	}

	/**
	 * This method returns currently available player actions
	 * @return
	 */
	public Map<String, PlayerAction> getAvailablePlayerActions() {
		Map<String, PlayerAction> availablePlayerActions = new HashMap<>();

		// Add the basic actions that are always available
		getBasicActions().forEach(d -> availablePlayerActions.put(d.actionUrl(), d));

		// Add actions that are location specific
		playerLocation.availableActions().forEach(d -> availablePlayerActions.put(d.actionUrl(), d));

		return availablePlayerActions;
	}

	public void advanceTime() {
		this.currentDayTime = switch (currentDayTime) {
		case MORNING -> DayTime.AFTERNOON;
		case AFTERNOON -> DayTime.EVENING;
		case EVENING -> DayTime.NIGHT;
		case NIGHT -> DayTime.MORNING;
		};
		if (this.currentDayTime.equals(DayTime.NIGHT))
			this.daysPassed += 1;
	}

	/**
	 * Provides the description of what the player sees and what is happening to him.
	 * @return the text description to be displayed
	 */
	public String description() {
		return String.format("%s <br/> %s", lastActionDescription(), playerLocation.description());
	}

	// gets the current GameState's lastActionDescription
	public String lastActionDescription() {
		return lastActionDescription;
	}

	public void lastActionDescription(String newDescription) {
		lastActionDescription = newDescription;
	}

	/**
	 * These are the actions that the player can always take.
	 * @return
	 */
	private List<PlayerAction> getBasicActions() {
		return List.copyOf(currentDayTime.basicActions());
	}

	public Player player() {
		return player;
	}

	public DayTime currentDayTime() {
		return currentDayTime;
	}

	public int daysPassed() {
		return daysPassed;
	}

	public Location playerLocation() {
		return playerLocation;
	}

}
