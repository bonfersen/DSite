package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.CargoDTO;

public interface CargoService {

	List<CargoDTO> findCargoByCriteria(CargoDTO dto);
}
