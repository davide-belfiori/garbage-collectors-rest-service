package it.unicam.ids.garbageCollectors.exception;

public class AreaNotFoundException extends Exception {

	private int areaId;

	public AreaNotFoundException(int areaId) {
		this.areaId = areaId;
	}

	@Override
	public String getMessage() {
		return "Impossibile trovare l'area geografica con id = " + this.areaId;
	}
	
	

}
