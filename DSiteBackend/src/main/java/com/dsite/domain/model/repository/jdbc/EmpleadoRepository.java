package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.EmpleadoDTO;

interface EmpleadoRepository {

	List<EmpleadoDTO> findEmpleadoByCriteria(EmpleadoDTO empleadoDTO);
}
