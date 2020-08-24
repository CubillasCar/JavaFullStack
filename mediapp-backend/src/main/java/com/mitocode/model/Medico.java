package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medico")

public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;

	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Column(name = "CMP", nullable = false, length = 12)
	private String CMP;

	@Column(name = "fotourl", nullable = true)
	private String fotoUrl;

	Integer getIdMedico() {
		return idMedico;
	}

	void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	String getNombres() {
		return nombres;
	}

	void setNombres(String nombres) {
		this.nombres = nombres;
	}

	String getApellidos() {
		return apellidos;
	}

	void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	String getCMP() {
		return CMP;
	}

	void setCMP(String cMP) {
		CMP = cMP;
	}

	String getFotoUrl() {
		return fotoUrl;
	}

	void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

}
