package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.CierreEconomico;

@Repository
public interface CierreEconomicoJPARepository extends CrudRepository<CierreEconomico, Integer>, JpaRepository<CierreEconomico, Integer> {

}