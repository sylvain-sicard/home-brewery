package fr.mssd.homebrewery.model;

public enum VintageType {
	
	BEER("Beer"),
	GENERIC("Generic");
	
	public static final String BEER_STR = "Beer";
	public static final String GENERIC_STR = "Generic";
	
	VintageType(String value) {
		this.value=value;
	}

	private String value;
	
	public String toString() {
		return value;
	}
}
