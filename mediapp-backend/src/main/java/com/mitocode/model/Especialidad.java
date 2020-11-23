package com.mitocode.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "especialidad")

@Schema(description = "Informacion de Especialidad")

public class Especialidad {

	@Schema(description = "Id Identity")

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;

	@Schema(description = "Nombre de Especialidad")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Schema(description = "Descripcion de Especialidad")
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
