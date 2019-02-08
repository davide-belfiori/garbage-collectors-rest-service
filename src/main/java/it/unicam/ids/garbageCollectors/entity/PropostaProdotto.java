package it.unicam.ids.garbageCollectors.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.unicam.ids.garbageCollectors.entity.id.PropostaProdottoId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "proposta_prodotto")
public class PropostaProdotto {
	
	public PropostaProdotto(PropostaProdottoId propostaProdottoId) {
		this.propostaId = propostaProdottoId;
	}

	@EmbeddedId
	private PropostaProdottoId propostaId;
	
	@Column(name = "nome_prodotto")
	@NotNull
	private String nomeProdotto;
}
