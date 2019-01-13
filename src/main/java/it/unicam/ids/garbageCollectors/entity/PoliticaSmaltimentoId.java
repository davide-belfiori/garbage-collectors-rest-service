package it.unicam.ids.garbageCollectors.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PoliticaSmaltimentoId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "pol_prod_id")
	private String prodId;
	
	@Column(name = "pol_comp_id")
	private int compId;
	
	@Column(name = "pol_area_id")
	private int areaId;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PoliticaSmaltimentoId that = (PoliticaSmaltimentoId) o;
        return Objects.equals(prodId, that.prodId) &&
               Objects.equals(compId, that.compId) &&
               Objects.equals(areaId, that.areaId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(prodId, compId, areaId);
    }
	
}
