package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.EmpleadoAreaObraDTO;

public interface EmpleadoAreaObraRepository {

	List<EmpleadoAreaObraDTO> findEmpleadoAreaObraByCriteria(EmpleadoAreaObraDTO dto);
}
