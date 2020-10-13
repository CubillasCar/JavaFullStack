package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//se declaran las llaves
//cuando existe una tabla  1 * TABLA * 1
//se tiene que declarar las relaciones en otra tabla

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "consulta_examen")
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

	// [idConsulta(FK) idExamen(FK)] PK

	@Id
	private Consulta consulta;

	@Id
	private Examen examen;

	
}
