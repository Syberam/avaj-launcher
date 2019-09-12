package com.launcher.airport;

import java.util.ArrayList;
import java.util.List;
import com.launcher.aircrafts.Flyable;


class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (this.observers.contains(flyable))
			return;
		this.observers.add(flyable);
		System.out.println(
			String.format("Tower says: %s#%s(%d) registered to weather tower.",
					flyable.getType(),
					flyable.getName(),
					flyable.getId()
				)
		);
	}
	
	public void unregister(Flyable flyable) {
		if (this.observers.contains(flyable)) {
			this.observers.remove(flyable);
			System.out.println(
				String.format("Tower says: %s#%s(%d) unregistered from weather tower.",
						flyable.getType(),
						flyable.getName(),
						flyable.getId()
					)
			);
		}
	}

	protected void conditionsChanged() {
		List<Flyable> observers = new ArrayList<Flyable>();

		if (this.observers.size() > 0)
			this.observers.forEach(observer -> observers.add(observer));
		if (observers.size() > 0)
			observers.forEach(observer -> observer.updateConditions());
	}

	public int countObservers(){
		return this.observers.size();
	}
}