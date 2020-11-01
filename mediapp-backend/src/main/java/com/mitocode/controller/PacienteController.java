package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

//Se genera el service
//@Valid se coloca donde se quiera que se respeten los javax validation constraints

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;

	@GetMapping
	public List<Paciente> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Paciente listarPorId(@PathVariable("id") Integer id){
		return service.listarPorId(id);

	}

	@PostMapping
	public Paciente registrar(@Valid @RequestBody Paciente paciente){
		return service.registrar(paciente);
	}

	@PutMapping
	public Paciente modificar(@Valid @RequestBody Paciente paciente){
		return service.modificar(paciente);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
	}
	
}
