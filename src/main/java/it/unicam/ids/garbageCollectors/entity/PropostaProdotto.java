package it.unicam.ids.garbageCollectors.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;
import lombok.Data;

@Data
@Entity
@Table(name = "proposta_prodotto")
public class PropostaProdotto {
	
	@EmbeddedId
	private PropostaProdottoId propostaId;
	
	@MapsId("appUserId")
	@ManyToOne
	private AppUser user;
	
	@Column(name = "nome_prodotto")
	@NotNull
	private String nomeProdotto;
}
