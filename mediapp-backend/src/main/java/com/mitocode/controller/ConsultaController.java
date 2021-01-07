package com.mitocode.controller;


import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.exepcion.ModeloNotFoundException;
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;
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
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService service;

	//Listar
	@GetMapping
	public ResponseEntity< List<Consulta>> listar() throws Exception{
		List<Consulta>  lista=service.listar();
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}

	//Listar por Id
//HATEOAS NIVEL 3 RICHARDSON
	@GetMapping("/hateoas/{id}")
	public EntityModel<Consulta> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Consulta obj= service.listarPorId(id);
		if (obj==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		EntityModel<Consulta> recurso= EntityModel.of(obj);
		WebMvcLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarPorId(id));

		recurso.add(linkTo.withRel("consulta-recurso"));
		return recurso;
	}

	@GetMapping("/{id}")
	public ResponseEntity <Consulta> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Consulta obj = service.listarPorId(id);
		if (obj ==null){
				throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);
	}



	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody ConsultaListaExamenDTO dto) throws Exception{
		Consulta obj = service.registrarTransaccional(dto);

		//localhost:8080/pacientes/7
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();

		return ResponseEntity.created(location).build();
	}


	//Modificar
	@PutMapping
	public ResponseEntity<Consulta> modificar(@Valid @RequestBody Consulta consulta) throws Exception{
		Consulta obj= service.modificar(consulta);
		return new ResponseEntity<Consulta>(obj, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Consulta obj = service.listarPorId(id);
		if (obj==null){
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);

		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
