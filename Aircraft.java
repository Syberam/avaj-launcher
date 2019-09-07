abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private	static long idCounter = 0;

	Aircraft(String name, Coordinates coordinates){
		if (!name.isEmpty()) {
			this.name = name; 
			this.coordinates = coordinates;
			Aircraft.idCounter = nextId();
		}
	}
	private long nextId() {
		return Aircraft.idCounter + 1;
	}
}