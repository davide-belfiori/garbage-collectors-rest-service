package it.unicam.ids.garbageCollectors.utils;

import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RichiestaProposta {
	@NotBlank
	public String prodId;
	@NotBlank
	public String nomeUtente;
	@NotBlank
	public String nomeProdotto;
}
