package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

//Se genera el service
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	//definimos los primeros metodos
	//nivel de madures 0
	
	//listar todos
	@GetMapping
	public List<Paciente> listar (){
		return service.listar();
	}
	
	//listar por id
	@GetMapping ("/{id}")	//el valor ingresa	
	public Paciente listarPorId(@PathVariable("id")Integer id) {
		return service.listarPorId(id);
	}
	
	//insertar
	@PostMapping
	public Paciente registrar(Paciente paciente) {
		return service.registrar(paciente);
	}
	
	//Modificar
	@PutMapping
	public Paciente modificar(Paciente paciente) {
		return service.registrar(paciente);
	}
	
	//Delete
	@DeleteMapping
	public void eliminar(@PathVariable("id")Integer id) {
		 service.eliminar(id);
	}
	
}
