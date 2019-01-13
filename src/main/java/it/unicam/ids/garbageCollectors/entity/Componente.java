package it.unicam.ids.garbageCollectors.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "componente")
public class Componente implements Serializable {
	
	@Id
	@Column(name = "comp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int compId;
	
	@Id
	@OneToOne
	@JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
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