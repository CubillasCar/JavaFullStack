package com.mitocode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	//--------------------------------------
	// --------------------------------------
	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false, foreignKey= @ForeignKey(name="FK_consulta_paciente	"))//Fk_Consulta_Paciente
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name="id_medico", nullable=false, foreignKey=@ForeignKey(name="FK_consulta_medico"))
	private Medico medico;


	//--------------------------------------------------------------------------

	@ManyToOne
	@JoinColumn(name="id_especialidad", nullable=false, foreignKey=@ForeignKey(name="fk_consulta_especialidad"))
	private Especialidad especialidad;

	@Column(name = "num_consultorio", length = 3, nullable = true)
	private String numConsultorio;

	@Column(name="fecha", nullable=false)
	private LocalDateTime fecha;


	//--------------------------------------------------------------------------

	//Detalle Consulta
	//OneToMany a nivel logico. Se usa en temas de maestro detalle.
	//lo que le pase a la tabla padre tambien le afecta a la tabla detalle.
	//orphan sirve para eliminar algun elemento del detalle
	
	@OneToMany(mappedBy="consulta",cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<DetalleConsulta> detalleConsulta;


}
