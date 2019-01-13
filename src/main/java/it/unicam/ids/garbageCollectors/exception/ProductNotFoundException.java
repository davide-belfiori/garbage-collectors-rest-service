package it.unicam.ids.garbageCollectors.exception;

public class ProductNotFoundException extends Exception {

	//TODO: da completare
	
	private String prodId;

	public ProductNotFoundException(String prodId) {
		this.prodId = prodId;
	}

	@Override
	public String getMessage() {
		return "Prodotto non trovato con id = " + prodId;
	}
	
	

}
