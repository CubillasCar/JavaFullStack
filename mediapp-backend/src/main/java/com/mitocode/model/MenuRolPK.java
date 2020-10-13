package com.mitocode.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode
@Embeddable
public class MenuRolPK implements Serializable{

	@ManyToOne
	@JoinColumn(name="id_menu", nullable=false)
	private Menu menu;
	
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
	private Rol rol;

	
}
