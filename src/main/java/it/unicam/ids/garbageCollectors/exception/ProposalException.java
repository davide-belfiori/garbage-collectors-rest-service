package it.unicam.ids.garbageCollectors.exception;

import javax.validation.constraints.NotBlank;

public class ProposalException extends Exception {

	private @NotBlank String nomeUtente;
	private @NotBlank String prodId;

	public ProposalException(@NotBlank String nomeUtente, @NotBlank String prodId) {
		this.nomeUtente = nomeUtente;
		this.prodId = prodId;
	}

	@Override
	public String getMessage() {
		return "L'utente " + nomeUtente + " ha già effettuato una proposta per il prodotto " + prodId;
	}

	
	
}
