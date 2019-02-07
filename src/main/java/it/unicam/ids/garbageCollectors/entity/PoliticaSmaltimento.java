package it.unicam.ids.garbageCollectors.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import it.unicam.ids.garbageCollectors.entity.id.PoliticaSmaltimentoId;
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
		@JoinColumn(name = "pol_prod_id", referencedColumnName = "prodotto_prod_id"
					, insertable = false, updatable = false),
		@JoinColumn(name = "pol_comp_id", referencedColumnName = "comp_id"
					, insertable = false, updatable = false),
	})
	private Componente componente;
	
	@OneToOne
	@JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
	private CategoriaSmaltimento categoria;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	
}
