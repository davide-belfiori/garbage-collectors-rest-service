package it.unicam.ids.garbageCollectors.exception;

public class AreaNotFoundException extends Exception {

	private String message = "Impossibile trovare l'area geografica richiesta";
	private int areaId = -1;
	private String nomeArea;
	
	public AreaNotFoundException(int areaId) {
		this.areaId = areaId;
	}

	public AreaNotFoundException(String name) {
		this.nomeArea = name.toUpperCase();
	}

	@Override
	public String getMessage() {
		String toReturn = message + "\n";
		if(this.areaId > 0)
			toReturn = toReturn + "id = " + this.areaId + "\n";
		if(this.nomeArea != null)
			toReturn = toReturn + "nome = " + this.nomeArea + "\n";
		return toReturn;
	}
	
	

}
