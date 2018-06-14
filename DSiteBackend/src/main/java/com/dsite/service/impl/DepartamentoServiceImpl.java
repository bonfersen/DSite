package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Departamento;
import com.dsite.domain.model.repository.jpa.DepartamentoJPARepository;
import com.dsite.dto.model.DepartamentoDTO;
import com.dsite.service.intf.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoJPARepository departamentoJPARepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<DepartamentoDTO> findAllDepartamentos() {
		List<Departamento> lstDepartamentoEntity = (List<Departamento>) departamentoJPARepository.findAll();
		List<DepartamentoDTO> lstDTO = new ArrayList<DepartamentoDTO>();		
		if(lstDepartamentoEntity != null)
			lstDTO = lstDepartamentoEntity.stream().map(m -> mapper.map(m, DepartamentoDTO.class)).collect(toList());
		return lstDTO ;
	}

}
