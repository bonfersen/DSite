package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Distrito;
import com.dsite.domain.model.repository.jpa.DistritoJPARepository;
import com.dsite.domain.model.repository.jpa.ProvinciaJPARepository;
import com.dsite.dto.model.DistritoDTO;
import com.dsite.service.intf.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

	@Autowired
    Mapper mapper;
	
	@Autowired
	ProvinciaJPARepository provinciaJpaRepository;

	@Autowired
	DistritoJPARepository distritoJpaRepository;

	@Override
	public List<DistritoDTO> obtenerDistritosPorProvincia(String idProvincia) {		
		List<Distrito> entities;
		List<DistritoDTO> itemsDTO;
		
		entities = distritoJpaRepository.findByProvincia(idProvincia);
		
		itemsDTO = entities.stream().map(m -> mapper.map(m, DistritoDTO.class)).collect(toList());
		
		return itemsDTO;
	}
}
