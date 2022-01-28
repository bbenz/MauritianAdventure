package com.bjedrzejewski;

import java.io.Serializable;
import java.util.List;

public record Location(String locationCode, String description, String image,
		List<PlayerAction> availableActions) implements Serializable {
}