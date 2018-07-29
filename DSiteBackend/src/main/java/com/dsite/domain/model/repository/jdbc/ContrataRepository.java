package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.ContrataDTO;

public interface ContrataRepository {

	List<ContrataDTO> findContrataByCriteria(ContrataDTO dto);

}
