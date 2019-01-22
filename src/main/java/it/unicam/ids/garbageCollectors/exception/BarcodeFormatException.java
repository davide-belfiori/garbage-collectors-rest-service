package it.unicam.ids.garbageCollectors.exception;

public class BarcodeFormatException extends Exception {

	private String prodId;

	public BarcodeFormatException(String prodId) {
		this.prodId = prodId;
	}

	@Override
	public String getMessage() {
		return "Codice a barre non riconosciuto: barcode = " + this.prodId;
	}
	
	

}
