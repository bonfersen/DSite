package com.dsite.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.Distrito;

@Repository
public interface DistritoJPARepository extends CrudRepository<Distrito, String>,JpaRepository<Distrito, String> {
	
	@Query("SELECT d FROM Distrito d WHERE d.provincia.idProvincia =:idProvincia ORDER BY d.nombre")
    List<Distrito> findByProvincia(@Param("idProvincia") String idProvincia);
	
}
