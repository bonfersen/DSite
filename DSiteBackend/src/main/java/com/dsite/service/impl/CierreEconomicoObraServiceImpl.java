package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsite.domain.model.entities.CierreEconomico;
import com.dsite.domain.model.entities.CierreEconomicoObra;
import com.dsite.domain.model.entities.Obra;
import com.dsite.domain.model.repository.jdbc.CierreEconomicoObraJDBCRepository;
import com.dsite.domain.model.repository.jpa.CierreEconomicoJPARepository;
import com.dsite.domain.model.repository.jpa.CierreEconomicoObraJPARepository;
import com.dsite.domain.model.repository.jpa.ObraJPARepository;
import com.dsite.dto.model.CierreEconomicoDTO;
import com.dsite.dto.model.CierreEconomicoObraDTO;
import com.dsite.dto.model.CierresAsignadasDTO;
import com.dsite.service.intf.CierreEconomicoObraService;
import com.dsite.service.intf.CierreEconomicoService;
import com.dsite.util.ValidateUtil;

@Service
public class CierreEconomicoObraServiceImpl implements CierreEconomicoObraService {

	@Autowired
	CierreEconomicoObraJDBCRepository cierreEconomicoObraJDBCRepository;
	
	@Autowired
	CierreEconomicoObraJPARepository cierreEconomicoObraJPARepository;
	
	@Autowired
	CierreEconomicoJPARepository cierreEconomicoJPARepository;

	@Autowired
	ObraJPARepository obraJPARepository;
	
	@Autowired
	CierreEconomicoService cierreEconomicoService;

	@Autowired
	Mapper mapper;

	@Override
	public CierreEconomicoObraDTO findById(Integer id) {
		CierreEconomicoObraDTO dto = new CierreEconomicoObraDTO();
		dto.setIdCierreEconomicoObra(id);
		List<CierreEconomicoObraDTO> lstDTO = cierreEconomicoObraJDBCRepository.findCierreEconomicoObraByCriteria(dto);
		if (lstDTO.size() > 0)
			return lstDTO.get(0);
		else
			return null;
	}
	
	public List<CierreEconomicoObraDTO> findByIdObra(Integer idObra) {
		CierreEconomicoObraDTO dto = new CierreEconomicoObraDTO();
		dto.setIdObra(idObra);
		List<CierreEconomicoObraDTO> lstDTO = cierreEconomicoObraJDBCRepository.findCierreEconomicoObraByCriteria(dto);
		return lstDTO;
	}

	@Transactional
	public void asignarCierreEconomico(CierresAsignadasDTO cierresAsignadasDTO) {
		List<CierreEconomicoObraDTO> obras = cierresAsignadasDTO.getObras();
		
		CierreEconomicoDTO cierreEconomicoDTO = new CierreEconomicoDTO(); 
		CierreEconomico cierreEconomico = cierreEconomicoService.createCierreEconomico(cierreEconomicoDTO);
		
		for (CierreEconomicoObraDTO cierreEconomicoObraDTO : obras) {			
			cierreEconomicoObraDTO.setIdCierreEconomico(cierreEconomico.getIdCierreEconomico());
			this.createCierreEconomicoObra(cierreEconomicoObraDTO);
		}
	}

	@Transactional
	public void createCierreEconomicoObra(CierreEconomicoObraDTO cierreEconomicoObraDTO) {
		CierreEconomicoObra cierreEconomicoObraEntidad = new CierreEconomicoObra();
		mapper.map(cierreEconomicoObraDTO, cierreEconomicoObraEntidad);

		createUpdateCierreEconomico(cierreEconomicoObraDTO, cierreEconomicoObraEntidad);
	}

	@Transactional
	public void updateCierreEconomicoObra(CierreEconomicoObraDTO cierreEconomicoObraDTO) {
		CierreEconomicoObra cierreEconomicoObraEntidad = new CierreEconomicoObra();
		if (ValidateUtil.isNotEmpty(cierreEconomicoObraDTO.getIdCierreEconomico()))
			cierreEconomicoObraEntidad = cierreEconomicoObraJPARepository.findOne(cierreEconomicoObraDTO.getIdCierreEconomico());

		// Ingresar datos a la entidad
		mapper.map(cierreEconomicoObraDTO, cierreEconomicoObraEntidad);

		createUpdateCierreEconomico(cierreEconomicoObraDTO, cierreEconomicoObraEntidad);
	}

	private void createUpdateCierreEconomico(CierreEconomicoObraDTO cierreEconomicoObraDTO, CierreEconomicoObra cierreEconomicoObraEntidad) {
		if (ValidateUtil.isNotEmpty(cierreEconomicoObraDTO.getIdCierreEconomico())) {
			CierreEconomico cierreEconomico = cierreEconomicoJPARepository.findOne(cierreEconomicoObraDTO.getIdCierreEconomico());
			cierreEconomicoObraEntidad.setCierreEconomico(cierreEconomico);
		}
		if (ValidateUtil.isNotEmpty(cierreEconomicoObraDTO.getIdObra())) {
			Obra obra = obraJPARepository.findOne(cierreEconomicoObraDTO.getIdObra());
			cierreEconomicoObraEntidad.setObra(obra);
		}
		cierreEconomicoObraJPARepository.save(cierreEconomicoObraEntidad);
		cierreEconomicoObraJPARepository.flush();
	}

	@Override
	public void deleteCierreEconomicoObraById(Integer id) {
		// XXX Auto-generated method stub

	}
}
