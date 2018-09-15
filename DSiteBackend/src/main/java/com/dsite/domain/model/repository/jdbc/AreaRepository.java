package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.AreaDTO;

public interface AreaRepository {

	List<AreaDTO> findAreaByCriteria(AreaDTO areaDTO);
}
