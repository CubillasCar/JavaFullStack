package com.mitocode.repo;


//se referencian con sus genericos
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Paciente;
@Repository
public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {
	
}
