package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.AutorizacionesDTO;

public interface AutorizacionesRepository {

	List<AutorizacionesDTO> findAutorizacionesByCriteria(AutorizacionesDTO dto);
}
