package it.unicam.ids.garbageCollectors.entity.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Embeddable
public class ComponenteId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "comp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int compId;
	
	@Column(name = "prod_id")
	private String prodId;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        ComponenteId that = (ComponenteId) o;
        return Objects.equals(prodId, that.prodId) &&
               Objects.equals(compId, that.compId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(prodId, compId);
    }
}
