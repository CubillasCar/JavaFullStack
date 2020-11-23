package com.mitocode.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Schema(description = "Informacion del Medico")
@Entity
@Table(name = "medico")
public class Medico {

	@Schema(description = "Id Identity")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;

	@Schema(description = "Nombre del Medico")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Schema(description = "Apellido del Medico")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Schema(description = "CMP del Medico")
	@Column(name = "CMP", nullable = false, length = 12)
	private String CMP;

	@Schema(description = "Foto del Medico")
	@Column(name = "foto_url", nullable = true)
	private String fotoUrl;

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCMP() {
		return CMP;
	}

	public void setCMP(String CMP) {
		this.CMP = CMP;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
}
