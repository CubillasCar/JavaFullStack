package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	private Integer idRol;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descriptcion;

	Integer getIdRol() {
		return idRol;
	}

	void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	String getDescriptcion() {
		return descriptcion;
	}

	void setDescriptcion(String descriptcion) {
		this.descriptcion = descriptcion;
	}

}
