package it.unicam.ids.garbageCollectors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Table(name = "AppUser")
@Data
public class AppUser {

	@Id
	@Column(name = "appUser_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appUserId;
	
	@Column(name = "appUser_name")
	@NotNull
	private String username;
	
	@Column(name = "appUser_password")
	@NotNull
	@Length(max = 60)
	private String appUserPassword;
	
	@ManyToOne
	@JoinColumn(name = "app_user_area")
	private AreaGeografica area;
}
