package com.bjedrzejewski;

import java.util.ArrayList;

/**
 * Created by bartoszjedrzejewski on 07/08/2016.
 * <p>
 * This is a concept of a game location.
 */

abstract class Locations {

	static Location buildBeachLocation() {

		var location = new Location("beach",
				"You are on a beautiful beach. The water is clear blue and you can see forest and some mountains in the distance. ",
				"beach.jpg", new ArrayList<>());
		location.availableActions().add(new ExploreTheBeachAction(location));
		location.availableActions().add(ScreamAction.getInstance());
		return location;
	}

	static Location buildForestLocation() {
		return new Location("forest", "You are in a deep tropical forest. You can see many plants and small animals",
				"forest.jpg", new ArrayList<>());
	}

}
