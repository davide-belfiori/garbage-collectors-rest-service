package it.unicam.ids.garbageCollectors.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
	@Column(name = "prod_id")
	private String prodId;
	
	@Column(name = "nome_prodotto")
	@NotNull
	private String nomeProdotto;
	
	@OneToMany(cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	@JoinColumn(name = "prodotto_prod_id", referencedColumnName = "prod_id")
	@JsonManagedReference
	private List<Componente> componenti = new ArrayList<>();

}
