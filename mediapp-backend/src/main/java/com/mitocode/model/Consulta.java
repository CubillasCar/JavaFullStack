package com.mitocode.model;

import java.time.LocalDateTime;

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
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;

	
	//Clase que representa llave foranea
	//toda FK es ManyToOne
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false, foreignKey= @ForeignKey(name="FK_consulta_paciente	"))//Fk_Consulta_Paciente
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="id_medico", nullable=false, foreignKey=@ForeignKey(name="FK_consulta_medico"))
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="id_especialidad", nullable=false, foreignKey=@ForeignKey(name="fk_consulta_especialidad"))
	private Especialidad especialidad;
	
	@ManyToOne
	@Column(name = "num_consultorio", length = 3, nullable = true)
	private String numConsultorio;

	@Column(name="fecha", nullable=false)
	private LocalDateTime fecha;
}
