package it.unicam.ids.garbageCollectors.entity.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.unicam.ids.garbageCollectors.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PropostaProdottoId implements Serializable {

	private static final long serialVersionUID = 1783104906543239249L;
	
	@Column(name = "prod_id")
	private String prodId;
	
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "appUser_name",
				insertable = false, updatable = false)
	@JsonIgnore
	private AppUser user;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PropostaProdottoId that = (PropostaProdottoId) o;
        return Objects.equals(prodId, that.prodId) &&
               Objects.equals(user.getUsername(), that.user.getUsername());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(prodId, user.getUsername());
    }
}
