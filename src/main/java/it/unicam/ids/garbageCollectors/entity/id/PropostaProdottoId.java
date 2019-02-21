package it.unicam.ids.garbageCollectors.entity.id;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.unicam.ids.garbageCollectors.entity.AppUser;
import it.unicam.ids.garbageCollectors.entity.PropostaProdotto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class PropostaProdottoId implements Serializable {

	private static final long serialVersionUID = 1783104906543239249L;
	
	public PropostaProdottoId(String prodId, AppUser user) {
		this.prodId = prodId;
		this.user = user;
	}
	
	@Column(name = "prod_id")
	private String prodId;
	
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "appUser_name",
				insertable = false, updatable = false)
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
