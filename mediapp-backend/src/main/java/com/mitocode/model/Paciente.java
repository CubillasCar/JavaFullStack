package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SQL @Entity / NOSQL @Collection vuelve a la clase una entidad
 * 
 * @Table: crea una tabla. Si no se pone nombre a la tabla toma como nombre por
 *         defecto al nombre de la clase en minisculas
 * @Id: asigna llave primaria
 * @GenerateValue: asigna llave autoincremental
 * @Column: agrega Integer: Acepta valores nulos Int: No acepta valores nulos
 *          importar de forma automatica= ctrl + shift + O
 */

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;

	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Column(name = "direccion", nullable = false, length = 70)
	private String direccion;

	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

	@Column(name = "email", nullable = false, length = 70)
	private String email;

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
