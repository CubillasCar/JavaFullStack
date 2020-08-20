package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Paciente;
//Se define los metodos CRUD que seran implementados en ServiceImpl
public interface IPacienteService {

	Paciente registrar (Paciente pac);
	Paciente modificar (Paciente pac);
	List<Paciente> listar();
	Paciente listarPorId(Integer id);
	void eliminar(Integer id);
}
