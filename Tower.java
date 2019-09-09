import java.util.ArrayList;
import java.util.List;

class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (observers.contains(flyable))
			return;
		observers.add(flyable);
		System.out.println(
			String.format("Tower says: %s#%s(%d) registered to weather tower.",
					flyable.getClass(),
					flyable.getName(),
					flyable.getId()
				)
		);
	}
	
	public void unregister(Flyable flyable) {
		if (observers.contains(flyable)) {
			observers.remove(flyable);
			System.out.println(
				String.format("Tower says: %s#%s(%d) unregistered to weather tower.",
						flyable.getClass(),
						flyable.getName(),
						flyable.getId()
					)
			);
		}
	}

	protected void conditionsChanged() {

	}
}