package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

//Se genera el service
//@Valid se coloca donde se quiera que se respeten los javax validation constraints
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	//definimos los primeros metodos
	//nivel de madures 0

	//listar todos
	@GetMapping
	public ResponseEntity< List<Paciente>> listar (){
		List<Paciente> lista= service.listar();
			return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK)	;
	}
	
	//listar por id
	@GetMapping ("/{id}")	//el valor ingresa	
	public ResponseEntity< Paciente> listarPorId(@PathVariable("id")Integer id) {
		Paciente obj= service.listarPorId(id);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	//insertar
	//RequestBody tranforma los json a objetos
	@PostMapping
	public ResponseEntity< Paciente> registrar(@Valid @RequestBody Paciente paciente) {
		Paciente obj= service.registrar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.CREATED);
	}
	
	//Modificar
	//RequestBody tranforma los json a objetos
	@PutMapping
	public ResponseEntity< Paciente> modificar(@Valid @RequestBody Paciente paciente) {
		Paciente obj= service.modificar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping ("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id")Integer id) {
		 service.eliminar(id);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
