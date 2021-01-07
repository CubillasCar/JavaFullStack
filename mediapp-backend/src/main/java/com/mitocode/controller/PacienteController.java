package com.mitocode.controller;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import com.mitocode.exepcion.ModeloNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;

	//Listar
	@GetMapping
	public ResponseEntity< List<Paciente>> listar() throws Exception{
		List<Paciente>  lista=service.listar();
		return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
	}

	//Listar por Id
//HATEOAS NIVEL 3 RICHARDSON
	@GetMapping("/hateoas/{id}")
	public EntityModel<Paciente> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Paciente obj= service.listarPorId(id);
		if (obj==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		//localhost:8080/pacientes/{id}
		EntityModel<Paciente> recurso= EntityModel.of(obj);
		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));

		recurso.add(linkTo.withRel("paciente-recurso"));
		return recurso;


	}

	//Listar
	@GetMapping("/{id}")
	public ResponseEntity <Paciente> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Paciente obj = service.listarPorId(id);
		if (obj ==null){
				throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);
	}


	//Registrar
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Paciente paciente) throws Exception{
		Paciente obj= service.registrar(paciente);

		//localhost:8080/pacientes/												7
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}

	//Modificar
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente) throws Exception{
		Paciente obj= service.modificar(paciente);
		return new ResponseEntity<Paciente>(obj, HttpStatus.OK);

	}

	//Borrar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Paciente obj = service.listarPorId(id);
		if (obj==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
