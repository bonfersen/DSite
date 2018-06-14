package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.ConcursoContrata;

@Repository
public interface ConcursoContrataJPARepository extends CrudRepository<ConcursoContrata, Integer>, JpaRepository<ConcursoContrata, Integer> {

}
