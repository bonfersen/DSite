package com.dsite.domain.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.Area;

@Repository
public interface AreaJPARepository extends CrudRepository<Area, Integer>, JpaRepository<Area, Integer> {
}
