package com.mitocode.repo;


import com.mitocode.model.Consulta;
import com.mitocode.model.Examen;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaRepo extends IGenericRepo<Consulta, Integer> {


}
