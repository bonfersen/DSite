package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ConcursoContrataDTO;

public interface ConcursoContrataService {

	ConcursoContrataDTO findById(int id);
	
	List<ConcursoContrataDTO> findAllConcursoContratas();

	void createConcursoContrata(ConcursoContrataDTO concursoContrataDTO);

	void updateConcursoContrata(ConcursoContrataDTO concursoContrataDTO);

	void deleteConcursoContrataById(int id);
}
