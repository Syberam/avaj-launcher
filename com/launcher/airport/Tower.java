package com.launcher.airport;

import java.util.ArrayList;
import java.util.List;
import com.launcher.aircrafts.Flyable;
import java.io.IOException;



class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (this.observers.contains(flyable))
			return;
		this.observers.add(flyable);
		try {
			Simulator.printer(
				String.format("%s: %s registered from weather tower.",
					towerAnnonce(),
					flyable.annonce()
				)
			);
		}
		catch(IOException ex) { System.out.println(ex.getMessage());}
	}
	
	public void unregister(Flyable flyable) {
		if (this.observers.contains(flyable)) {
			this.observers.remove(flyable);
			try {
				Simulator.printer(
					String.format("%s: %s unregistered from weather tower.",
						towerAnnonce(),
						flyable.annonce()
					)
				);
			}
			catch(IOException ex) { System.out.println(ex.getMessage());}
		}
	}

	public int countObservers(){
		return this.observers.size();
	}

	protected void conditionsChanged() {
		List<Flyable> observers = new ArrayList<Flyable>();

		if (this.observers.size() > 0)
			this.observers.forEach(observer -> observers.add(observer));
		if (observers.size() > 0)
			observers.forEach(observer -> observer.updateConditions());
	}

	private String towerAnnonce(){
		return new String("Tower says");
	}

}