package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.AreaDTO;

public interface AreaService {

	List<AreaDTO> findAreaByCriteria(AreaDTO dto);
}
