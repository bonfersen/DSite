package com.dsite.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.Provincia;

@Repository
public interface ProvinciaJPARepository extends CrudRepository<Provincia, String>, JpaRepository<Provincia, String> {
	
	@Query("SELECT p FROM Provincia p WHERE p.departamento.idDepartamento =:idDepartamento ORDER BY p.nombre")
    List<Provincia> findByDepartamento(@Param("idDepartamento") String idDepartamento);
	
	@Query("SELECT p FROM Provincia p WHERE p.idProvincia =:idProvincia")
	Provincia findByCodigo(@Param("idProvincia") String idProvincia);
	
}
