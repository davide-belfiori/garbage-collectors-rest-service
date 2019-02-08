package it.unicam.ids.garbageCollectors.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import it.unicam.ids.garbageCollectors.entity.id.ComponenteId;
import lombok.Data;

@Data
@Entity
@Table(name = "componente")
public class Componente implements Serializable {
	
	@EmbeddedId
	private ComponenteId compId;
	
	@ManyToOne
	@MapsId("prodId")
	@JsonBackReference
	private Prodotto prodotto;
	
	@Column(name = "nome_componente")
	@NotNull
	private String nomeComponente;
	
	@OneToMany(mappedBy = "componente",
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	@JsonIgnore
	private List<PoliticaSmaltimento> listaPolitiche = new ArrayList<>();
}