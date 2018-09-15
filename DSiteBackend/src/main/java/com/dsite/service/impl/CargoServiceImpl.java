package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.repository.jdbc.CargoJDBCRepository;
import com.dsite.dto.model.CargoDTO;
import com.dsite.service.intf.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	CargoJDBCRepository cargoJDBCRepository;

	@Autowired
	Mapper mapper;

	@Override
	public List<CargoDTO> findCargoByCriteria(CargoDTO dto) {
		List<CargoDTO> lstDTO = cargoJDBCRepository.findCargoByCriteria(dto);
		return lstDTO;
	}
}
