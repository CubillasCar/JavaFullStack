package com.mitocode.service.impl;



import com.mitocode.repo.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Paciente;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService{


	@Autowired
	private IPacienteRepo repo;

	@Autowired
	protected IGenericRepo<Paciente, Integer> getRepo(){
		return repo;
	}
}
