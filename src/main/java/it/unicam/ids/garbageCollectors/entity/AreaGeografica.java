package it.unicam.ids.garbageCollectors.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "area_geografica")
public class AreaGeografica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "area_id")
	@JsonIgnore
	private int areaId;
	
	@Column(name = "nome")
	@NotNull
	private String nome;

	@OneToMany(mappedBy = "areaGeografica",
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	@JsonIgnore
	private List<PoliticaSmaltimento> listaPolitiche = new ArrayList<>();

	public List<PoliticaSmaltimento> getListaPolitiche(String prodId) {
		
		List<PoliticaSmaltimento> toReturn = new ArrayList<>();
		for (PoliticaSmaltimento politica : this.listaPolitiche) {
			if(politica.getPolId().getProdId().equals(prodId))
				toReturn.add(politica);
		}
		
		return toReturn;
	}

}
