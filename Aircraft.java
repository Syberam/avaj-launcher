class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private long idCounter;

	protected void Aircraft(String name, Coordinates coordinates){
		if !name.isEmpty() {
			this.name = name
			self.coordinates = coordinates;
		}
	//private nextId() : long
}