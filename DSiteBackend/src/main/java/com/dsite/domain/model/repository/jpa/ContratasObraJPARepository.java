package com.dsite.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.ContratasObra;
import com.dsite.domain.model.entities.Obra;

@Repository
public interface ContratasObraJPARepository extends CrudRepository<ContratasObra, Integer>, JpaRepository<ContratasObra, Integer> {

	List<ContratasObra> findByObra(Obra obra);
}
