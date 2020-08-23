package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Paciente;
//una interface puede heredar otra interface 
//se referencian con sus genericos
public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
