package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.Usuario;

@Repository
public interface UsuarioJPARepository extends CrudRepository<Usuario, Integer>, JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.cuentaUsuario = :cuentaUsuario and u.password = :password ")
	Usuario loginUsuario(@Param("cuentaUsuario") String cuentaUsuario, @Param("password") String password);
}
