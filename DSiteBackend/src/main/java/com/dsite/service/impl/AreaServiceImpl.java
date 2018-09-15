package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.repository.jdbc.AreaJDBCRepository;
import com.dsite.dto.model.AreaDTO;
import com.dsite.service.intf.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	AreaJDBCRepository areaJDBCRepository;
	
	@Autowired
	Mapper mapper;

	@Override
	public List<AreaDTO> findAreaByCriteria(AreaDTO dto) {
		List<AreaDTO> lstDTO = areaJDBCRepository.findAreaByCriteria(dto);		 
		return lstDTO ;
	}

}
