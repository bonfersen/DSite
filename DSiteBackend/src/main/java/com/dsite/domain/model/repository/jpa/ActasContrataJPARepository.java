package com.dsite.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.ActasContrata;
import com.dsite.domain.model.entities.ContratasObra;

@Repository
public interface ActasContrataJPARepository extends CrudRepository<ActasContrata, Integer>, JpaRepository<ActasContrata, Integer> {

	List<ActasContrata> findByContratasObra(ContratasObra contratasObra);

}
