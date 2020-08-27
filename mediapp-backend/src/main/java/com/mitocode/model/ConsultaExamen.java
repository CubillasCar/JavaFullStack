package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//se declaran las llaves
//cuando existe una tabla  1 * TABLA * 1
//se tiene que declarar las relaciones en otra tabla


@Entity
@Table(name="consulta_examen")
public class ConsultaExamen {
	
	//[idConsulta(FK) idExamen(FK)] PK
	
	@Id
	private Consulta idConsulta;
	
	@Id
	private Examen IdExamen;

	
	
	public Consulta getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Consulta idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Examen getIdExamen() {
		return IdExamen;
	}

	public void setIdExamen(Examen idExamen) {
		IdExamen = idExamen;
	}

	
}
