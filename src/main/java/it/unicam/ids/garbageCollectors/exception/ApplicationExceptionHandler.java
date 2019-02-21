package it.unicam.ids.garbageCollectors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(AreaNotFoundException.class)
	ResponseEntity<String> areaNotFoundHandler(AreaNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	ResponseEntity<String> productNotFoundHandler(ProductNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BindingException.class)
	ResponseEntity<?> bindingExceptionHandler() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({DuplicatedProductException.class, ProposalException.class})
	ResponseEntity<String> duplicatedProductHandler(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(BarcodeFormatException.class)
	ResponseEntity<String> barcodeFormatHandler(BarcodeFormatException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	ResponseEntity<?> barcodeFormatHandler(NumberFormatException ex) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnknowException.class)
	ResponseEntity<?> unknowErrorHandler(UnknowException ex) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}