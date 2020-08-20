package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.model.Paciente;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;

//ctrl + 1 para implementar metodos
//Definimos la logica que se encuentra en Repo
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo repo;
	
	
	@Override
	public Paciente registrar(Paciente pac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente modificar(Paciente pac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
