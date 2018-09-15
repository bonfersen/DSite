package com.dsite.domain.model.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.entities.TablaGeneral;

@Repository
public interface TablaGeneralJPARepository extends CrudRepository<TablaGeneral, String>, JpaRepository<TablaGeneral, String> {

	@Query("SELECT t FROM TablaGeneral t WHERE t.categoria LIKE :categoria and t.activo = '1'")
    List<TablaGeneral> findByCategoria(@Param("categoria") String categoria);
	
	@Query("SELECT t FROM TablaGeneral t WHERE t.categoria = :categoria and  t.idTablaGeneral = :idTablaGeneral")
    TablaGeneral findByCategoriaAndCodigo(@Param("categoria") String categoria,  @Param("idTablaGeneral") String idTablaGeneral);
	
	@Query("SELECT t FROM TablaGeneral t WHERE t.activo = '1' and t.categoria = :categoria and  t.tablaGeneralPadre.idTablaGeneral = :idTablaGeneralPadre")
    List<TablaGeneral> findByCategoriaAndCodigoPadre(@Param("categoria") String categoria,  @Param("idTablaGeneralPadre") String idTablaGeneralPadre);
}
