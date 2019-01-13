package it.unicam.ids.garbageCollectors.exception;

public class DuplicatedProductException extends Exception {

	private String prodId;

	public DuplicatedProductException(String prodId) {
		this.prodId = prodId;
	}

	@Override
	public String getMessage() {
		return "Il prodotto con Id = " + this.prodId +" già esiste";
	}

	
}
