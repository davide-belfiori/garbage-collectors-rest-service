package it.unicam.ids.garbageCollectors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "categoria_smaltimento")
public class CategoriaSmaltimento {

	@Id
	@Column(name = "cat_id")
	@JsonIgnore
	private int catId;
	
	@Column(name = "categoria")
	private String categoria;
}
