package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import com.mitocode.exepcion.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	//Listar
	@GetMapping
	public ResponseEntity< List<Paciente>> listar(){
		List<Paciente>  lista=service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

	//Listar por Id
	@GetMapping("/{id}")
	public ResponseEntity <Paciente> listarPorId(@PathVariable("id") Integer id){
		Paciente obj = service.listarPorId(id);
		if (obj.getIdPaciente()==null){
				throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}

	//Ingresar
	@PostMapping
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente){
		Paciente obj= service.registrar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.CREATED);
	}

	//Modificar
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente){
		Paciente obj= service.modificar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id){
		Paciente obj = service.listarPorId(id);
		if (obj.getIdPaciente()==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
