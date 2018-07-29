package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.repository.jdbc.ContrataJDBCRepository;
import com.dsite.dto.model.ContrataDTO;
import com.dsite.service.intf.ContrataService;

@Service
public class ContrataServiceImpl implements ContrataService {
	
	@Autowired
	ContrataJDBCRepository contrataJDBCRepository;
	
	@Autowired
	Mapper mapper;

	@Override
	public ContrataDTO findById(int id) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContrataDTO> findAllContratas() {
		List<ContrataDTO> lstDTO = contrataJDBCRepository.findContrataByCriteria(null);
		return lstDTO;
	}

	@Override
	public void saveContrata(ContrataDTO ContrataDTO) {
		// XXX Auto-generated method stub
		/*
		 * importeTotalPendientePago = 0 al crearse
		 */
	}

	@Override
	public void updateContrata(ContrataDTO ContrataDTO) {
		// XXX Auto-generated method stub

	}

	@Override
	public void deleteContrataById(int id) {
		// XXX Auto-generated method stub

	}

}
