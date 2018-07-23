package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.ContratasObraDTO;

public interface ContratasObraRepository {

	List<ContratasObraDTO> findContratasObraByCriteria(ContratasObraDTO contratasObraDTO);
}
