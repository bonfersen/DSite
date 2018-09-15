package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.CargoDTO;

public interface CargoRepository {
	
	List<CargoDTO> findCargoByCriteria(CargoDTO cargoDTO);
}
