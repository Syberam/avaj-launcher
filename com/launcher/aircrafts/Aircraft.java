package com.launcher.aircrafts;

import com.launcher.conditions.Coordinates;


abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private	static long idCounter = 0;

	Aircraft(String name, Coordinates coordinates){
		if (!name.isEmpty()) {
			this.name = name; 
			this.coordinates = coordinates;
			this.id = nextId();
		}
	}

	private long nextId() {
		return ++Aircraft.idCounter;
	}

	public String getName() {
		return this.name;
	}

	public long getId() {
		return this.id;
	}

	public String annonce() {
		return String.format("%s#%s(%d): ",
				this.getClass().getSimpleName(),
				this.name,
				this.id
			);
	}
}