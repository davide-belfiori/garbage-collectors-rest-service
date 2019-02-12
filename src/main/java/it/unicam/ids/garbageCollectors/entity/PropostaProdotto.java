package it.unicam.ids.garbageCollectors.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	@NotNull
	private Date created = new Date();
}
