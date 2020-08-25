package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_consulta")
public class DetalleConsulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdDetalle;
	
	@ManyToOne
	@JoinColumn(name="id_consulta", nullable=false, foreignKey=@ForeignKey(name="FK_consulta_detalle"))
	private Consulta consulta;
	
	@Column(name="diagnostico", nullable=false)
	private String diagnostico;
	
	private String tratamiento;
}
