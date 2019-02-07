package it.unicam.ids.garbageCollectors.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PropostaProdottoId implements Serializable{
	
	private static final long serialVersionUID = 1783104906543239249L;
	
	@Column(name = "app_user_Id")
	private int appUserId;
	
	@Column(name = "area_id")
	private int areaId;
	
	@Column(name = "prod_id")
	private String prodId;
	
}
