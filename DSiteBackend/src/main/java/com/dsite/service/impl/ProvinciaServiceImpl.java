package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Provincia;
import com.dsite.domain.model.repository.jpa.DepartamentoJPARepository;
import com.dsite.domain.model.repository.jpa.ProvinciaJPARepository;
import com.dsite.dto.model.ProvinciaDTO;
import com.dsite.service.intf.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	Mapper mapper;

	@Autowired
	DepartamentoJPARepository departamentoJpaRepository;

	@Autowired
	ProvinciaJPARepository provinciaJpaRepository;

	@Override
	public List<ProvinciaDTO> obtenerProvinciasPorDepartamento(String idDpto) {		
		List<Provincia> entities;
		List<ProvinciaDTO> itemsDTO;
		
		entities = provinciaJpaRepository.findByDepartamento(idDpto);
		
		itemsDTO = entities.stream().map(m -> mapper.map(m, ProvinciaDTO.class)).collect(toList());
		
		return itemsDTO;
	}
}
