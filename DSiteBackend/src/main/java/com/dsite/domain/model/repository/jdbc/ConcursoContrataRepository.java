package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.ConcursoContrataDTO;

public interface ConcursoContrataRepository {

	List<ConcursoContrataDTO> findConcursoContrataByCriteria(ConcursoContrataDTO dto);
}