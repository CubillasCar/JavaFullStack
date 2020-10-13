package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Paciente;


public interface IPacienteService {

	Paciente registrar (Paciente pac);
	Paciente modificar (Paciente pac);
	List<Paciente> listar();
	Paciente listarPorId(Integer id);
	void eliminar(Integer id);
}
