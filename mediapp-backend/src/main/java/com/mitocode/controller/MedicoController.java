package com.mitocode.controller;

import com.mitocode.exepcion.ModeloNotFoundException;
import com.mitocode.model.Medico;
import com.mitocode.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private IMedicoService service;

	//Listar
	@GetMapping
	public ResponseEntity< List<Medico>> listar() throws Exception{
		List<Medico>  lista=service.listar();
		return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
	}

	//Listar por Id
//HATEOAS NIVEL 3 RICHARDSON
	@GetMapping("/hateoas/{id}")
	public EntityModel<Medico> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Medico obj= service.listarPorId(id);
		if (obj==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		//localhost:8080/Medicoss/{id}
		EntityModel<Medico> recurso= EntityModel.of(obj);
		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));

		recurso.add(linkTo.withRel("Medicos-recurso"));
		return recurso;


	}

	@GetMapping("/{id}")
	public ResponseEntity <Medico> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Medico obj = service.listarPorId(id);
		if (obj ==null){
				throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		return new ResponseEntity<Medico>(obj, HttpStatus.OK);
	}



	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Medico medico) throws Exception{
		Medico obj= service.registrar(medico);

		//localhost:8080/Medicoss/7
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}

	//Modificar
	@PutMapping
	public ResponseEntity<Medico> modificar(@Valid @RequestBody Medico medico) throws Exception{
		Medico obj= service.modificar(medico);
		return new ResponseEntity<Medico>(obj, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Medico obj = service.listarPorId(id);
		if (obj==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
