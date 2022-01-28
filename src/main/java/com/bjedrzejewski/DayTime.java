package com.bjedrzejewski;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 */git
public enum DayTime {

	MORNING {
		@Override
		public List<PlayerAction> basicActions() {
			List<PlayerAction> basicPlayerActions = new ArrayList<>();
			basicPlayerActions.add(RestAction.getInstance());
			return basicPlayerActions;
		}

		@Override
		public String description() {
			return "It is Morning.";
		}

		@Override
		public int brightness() {
			return 100;
		}
	},
	AFTERNOON {
		@Override
		public List<PlayerAction> basicActions() {
			List<PlayerAction> basicPlayerActions = new ArrayList<>();
			basicPlayerActions.add(RestAction.getInstance());
			return basicPlayerActions;
		}

		@Override
		public String description() {
			return "It is Afternoon.";
		}

		@Override
		public int brightness() {
			return 90;
		}
	},
	EVENING {
		@Override
		public List<PlayerAction> basicActions() {
			List<PlayerAction> basicPlayerActions = new ArrayList<>();
			basicPlayerActions.add(RestAction.getInstance());
			return basicPlayerActions;
		}

		@Override
		public String description() {
			return "It is Evening.";
		}

		@Override
		public int brightness() {
			return 40;
		}
	},
	NIGHT {
		@Override
		public List<PlayerAction> basicActions() {
			List<PlayerAction> basicPlayerActions = new ArrayList<>();
			basicPlayerActions.add(SleepAction.getInstance());
			return basicPlayerActions;
		}

		@Override
		public String description() {
			return "It is Night.";
		}

		@Override
		public int brightness() {
			return 20;
		}
	};

	public abstract List<PlayerAction> basicActions();

	public abstract String description();

	public abstract int brightness();

}
