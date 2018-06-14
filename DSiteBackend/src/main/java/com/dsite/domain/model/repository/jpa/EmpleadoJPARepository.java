package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.Empleado;

@Repository
public interface EmpleadoJPARepository extends CrudRepository<Empleado, Integer>, JpaRepository<Empleado, Integer> {

	@Query("SELECT e FROM Empleado e WHERE e.usuario.idUsuario = :idUsuario ")
	Empleado findEmpleadoByUsuario(@Param("idUsuario") int idUsuario);
}