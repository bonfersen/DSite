package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.Obra;

@Repository
public interface ObraJPARepository extends CrudRepository<Obra, Integer>, JpaRepository<Obra, Integer> {

	@Query("SELECT o FROM Obra o WHERE o.codigoDSite = :codigoDSite")
	Obra findCodDSite(@Param("codigoDSite") String codigoDSite);

}
