package com.mitocode.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//aca se crea la relacion para las llaves foraneas

@Data
@EqualsAndHashCode
@Embeddable
public class ConsultaExamenPK implements Serializable {



	@ManyToOne
	@JoinColumn(name="id_consulta", nullable=false)
	private Consulta consulta;
	
	@ManyToOne
	@JoinColumn(name="id_examen", nullable=false)
	private Examen examen;


}
