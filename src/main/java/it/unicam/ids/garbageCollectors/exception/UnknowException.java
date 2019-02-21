package it.unicam.ids.garbageCollectors.exception;

public class UnknowException extends Exception {

	@Override
	public String getMessage() {
		return "Unexpected Error";
	}
	
}
