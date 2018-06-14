package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Contrata;
import com.dsite.domain.model.repository.jpa.ContrataJPARepository;
import com.dsite.dto.model.ContrataDTO;
import com.dsite.service.intf.ContrataService;

@Service
public class ContrataServiceImpl implements ContrataService {
	
	@Autowired
	ContrataJPARepository contrataJPARepository;
	
	@Autowired
	Mapper mapper;

	@Override
	public ContrataDTO findById(int id) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContrataDTO> findAllContratas() {
		List<Contrata> lstContrataEntity = (List<Contrata>) contrataJPARepository.findAll();
		List<ContrataDTO> lstDTO = new ArrayList<ContrataDTO>();		
		if(lstContrataEntity != null)
			lstDTO = lstContrataEntity.stream().map(m -> mapper.map(m, ContrataDTO.class)).collect(toList());
		return lstDTO ;
	}

	@Override
	public void saveContrata(ContrataDTO ContrataDTO) {
		// XXX Auto-generated method stub

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
