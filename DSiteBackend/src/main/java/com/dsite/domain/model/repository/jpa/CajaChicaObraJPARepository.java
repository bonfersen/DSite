package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.CajaChicaObra;

@Repository
public interface CajaChicaObraJPARepository extends CrudRepository<CajaChicaObra, Integer>, JpaRepository<CajaChicaObra, Integer> {

}
