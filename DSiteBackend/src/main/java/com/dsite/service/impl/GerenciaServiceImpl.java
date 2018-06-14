package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Gerencia;
import com.dsite.domain.model.repository.jpa.GerenciaJPARepository;
import com.dsite.dto.model.GerenciaDTO;
import com.dsite.service.intf.GerenciaService;

@Service
public class GerenciaServiceImpl implements GerenciaService {

	@Autowired
    GerenciaJPARepository gerenciaJpaRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public GerenciaDTO findById(int id) {
		GerenciaDTO gerenciaDTO= new GerenciaDTO();
        Gerencia gerenciaEntity= gerenciaJpaRepository.findOne(id);
        mapper.map(gerenciaEntity, gerenciaDTO);
		return gerenciaDTO;
	}

	@Override
	public GerenciaDTO findByName(String name) {
		
		return null;
	}

	@Override
	public void saveGerencia(GerenciaDTO Gerencia) {
		

	}

	@Override
	public void updateGerencia(GerenciaDTO Gerencia) {
		

	}

	@Override
	public void deleteGerenciaById(long id) {
		

	}

	@Override
	public List<GerenciaDTO> findAllGerencias() {		
		List<Gerencia> lstGerenciasEntity = (List<Gerencia>) gerenciaJpaRepository.findAll();
		List<GerenciaDTO> lstDTO = new ArrayList<GerenciaDTO>();		
		if(lstGerenciasEntity != null)
			lstDTO = lstGerenciasEntity.stream().map(m -> mapper.map(m, GerenciaDTO.class)).collect(toList());
		return lstDTO ;
	}

	@Override
	public void deleteAllGerencias() {
		

	}

	@Override
	public boolean isGerenciaExist(GerenciaDTO Gerencia) {
		
		return false;
	}

}
