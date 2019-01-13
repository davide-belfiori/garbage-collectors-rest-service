package it.unicam.ids.garbageCollectors.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "politica_smaltimento")
public class PoliticaSmaltimento {

	@EmbeddedId
	@JsonIgnore
	private PoliticaSmaltimentoId polId;
	
	@ManyToOne
	@MapsId("areaId")
	@JsonIgnore
	private AreaGeografica areaGeografica;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "pol_prod_id", referencedColumnName = "prod_id"
					, insertable = false, updatable = false),
		@JoinColumn(name = "pol_comp_id", referencedColumnName = "comp_id"
					, insertable = false, updatable = false),
	})
	private Componente componente;
	
	@Column(name = "descrizione")
	@NotNull
	private String descrizione;
	
	
}
