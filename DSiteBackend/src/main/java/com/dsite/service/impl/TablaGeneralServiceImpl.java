package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.TablaGeneralDTO;
import com.dsite.service.intf.TablaGeneralService;

@Service
public class TablaGeneralServiceImpl implements TablaGeneralService {

	@Autowired
	Mapper mapper;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Override
	public List<TablaGeneralDTO> findByCategoria(String categoria) {
		List<TablaGeneral> entities;
		List<TablaGeneralDTO> itemsDTO;
		
		entities = tablaGeneralJpaRepository.findByCategoria(categoria);		
		itemsDTO = entities.stream().map(m -> mapper.map(m, TablaGeneralDTO.class)).collect(toList());
		
		return itemsDTO;
	}

	@Override
	public TablaGeneralDTO findByCategoriaAndCodigo(String categoria, String idTablaGeneral) {
		TablaGeneral entities;
		TablaGeneralDTO itemDTO = null;
		
		entities = tablaGeneralJpaRepository.findByCategoriaAndCodigo(categoria, idTablaGeneral);		
		mapper.map(entities, itemDTO);
		
		return itemDTO;
	}
	
	@Override
	public List<TablaGeneralDTO> findByCategoriaAndCodigoPadre(String categoria, String idTablaGeneralPadre) {
		List<TablaGeneral> entities;
		List<TablaGeneralDTO> itemsDTO;
		
		entities = tablaGeneralJpaRepository.findByCategoriaAndCodigoPadre(categoria, idTablaGeneralPadre);		
		itemsDTO = entities.stream().map(m -> mapper.map(m, TablaGeneralDTO.class)).collect(toList());
		
		return itemsDTO;
	}
}
