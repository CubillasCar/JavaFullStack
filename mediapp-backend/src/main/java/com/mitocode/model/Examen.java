package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="examen")
public class Examen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idExamen;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	
	@Column(name="descripcion", nullable=false, length=50)
	private String descripcion;

	Integer getIdExamen() {
		return idExamen;
	}

	void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	String getDescripcion() {
		return descripcion;
	}

	void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
