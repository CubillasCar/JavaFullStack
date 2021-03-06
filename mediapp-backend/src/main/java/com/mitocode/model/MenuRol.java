package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="menu_rol")
@IdClass(MenuRolPK.class)
public class MenuRol {
	
	@Id
	private Menu menu;
	
	@Id
	private Rol rol;

	
}
