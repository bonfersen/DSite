package com.dsite.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.CajaChicaObra;
import com.dsite.domain.model.entities.RendicionCajaChica;
import com.dsite.domain.model.entities.ResumenRendicionCajaChica;
import com.dsite.domain.model.repository.jpa.CajaChicaObraJPARepository;
import com.dsite.domain.model.repository.jpa.RendicionCajaChicaRepository;
import com.dsite.domain.model.repository.jpa.ResumenRendicionCajaChicaJPARepository;
import com.dsite.dto.model.CajaChicaObraDTO;
import com.dsite.dto.model.JsonResult;
import com.dsite.dto.model.RendicionCajaChicaDTO;
import com.dsite.dto.model.RendicionesAsignadasDTO;
import com.dsite.dto.model.ResumenRendicionCajaChicaDTO;
import com.dsite.service.intf.CajaChicaObraService;
import com.dsite.service.intf.RendicionCajaChicaService;
import com.dsite.service.intf.ResumenRendicionCajaChicaService;
import com.dsite.util.ValidateUtil;

@Service
public class RendicionCajaChicaServiceImpl implements RendicionCajaChicaService {

	@Autowired
	Mapper mapper;

	@Autowired
	RendicionCajaChicaRepository rendicionCajaChicaRepository;
	
	@Autowired
	CajaChicaObraJPARepository cajaChicaObraJPARepository;
	
	@Autowired
	ResumenRendicionCajaChicaJPARepository resumenRendicionCajaChicaJPARepository;
	
	@Autowired
	ResumenRendicionCajaChicaService resumenRendicionCajaChicaService;
	
	@Autowired
	CajaChicaObraService cajaChicaObraService;

	@Override
	public RendicionCajaChicaDTO findById(int id) {
		RendicionCajaChicaDTO dto = new RendicionCajaChicaDTO();
		RendicionCajaChica entity = rendicionCajaChicaRepository.findOne(id);
		mapper.map(entity, dto);
		return dto;
	}
	
	public JsonResult asignarRendicion(RendicionesAsignadasDTO rendicionesAsignadasDTO) {
		JsonResult jsonResult = new JsonResult();
		List<RendicionCajaChicaDTO> lstRendicionCajaChicaDTO = rendicionesAsignadasDTO.getRendiciones();
		
		ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO = new ResumenRendicionCajaChicaDTO();
		resumenRendicionCajaChicaDTO.setIdEmpleadoSustentador(rendicionesAsignadasDTO.getIdEmpleadoSustentador());
		ResumenRendicionCajaChica resumenRendicionCajaChica = resumenRendicionCajaChicaService.createResumenRendicionCajaChica(resumenRendicionCajaChicaDTO);
		
		for (RendicionCajaChicaDTO rendicionCajaChicaDTO : lstRendicionCajaChicaDTO) {
			CajaChicaObraDTO cajaChicaObraDTO = cajaChicaObraService.findById(rendicionCajaChicaDTO.getIdCajaChicaObra());
			if (ValidateUtil.isNotEmpty(rendicionCajaChicaDTO.getRendirCaja()) && rendicionCajaChicaDTO.getRendirCaja().compareTo(DSiteCoreConstants.UNO) == 0)
				cajaChicaObraDTO.setRendirCaja(rendicionCajaChicaDTO.getRendirCaja());
			if (ValidateUtil.isNotEmpty(rendicionCajaChicaDTO.getRendirViatico()) && rendicionCajaChicaDTO.getRendirViatico().compareTo(DSiteCoreConstants.UNO) == 0)
				cajaChicaObraDTO.setRendirViatico(rendicionCajaChicaDTO.getRendirViatico());
			cajaChicaObraService.updateCajaChicaObra(cajaChicaObraDTO);
			
			rendicionCajaChicaDTO.setIdResumenRendicionCajaChica(resumenRendicionCajaChica.getIdResumenRendicionCajaChica());
			createRendicionCajaChica(rendicionCajaChicaDTO);
		}
		
		jsonResult.setCodigo(resumenRendicionCajaChica.getCodigoRendicion());
		return jsonResult;
	}

	@Transactional
	public void createRendicionCajaChica(RendicionCajaChicaDTO rendicionCajaChicaDTO) {
		RendicionCajaChica rendicionCajaChicaEntity = new RendicionCajaChica();
		mapper.map(rendicionCajaChicaDTO, rendicionCajaChicaEntity);

		// Ingresar datos a la entidad
		rendicionCajaChicaEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(rendicionCajaChicaDTO.getUsuarioCreacion()))
			rendicionCajaChicaEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateRendicionCajaChica(rendicionCajaChicaDTO, rendicionCajaChicaEntity);
	}

	@Transactional
	public void updateRendicionCajaChica(RendicionCajaChicaDTO rendicionCajaChicaDTO) {
		RendicionCajaChica rendicionCajaChicaEntity = new RendicionCajaChica();
		if (ValidateUtil.isNotEmpty(rendicionCajaChicaDTO.getIdRendicionCajaChica()))
			rendicionCajaChicaEntity = rendicionCajaChicaRepository.findOne(rendicionCajaChicaDTO.getIdRendicionCajaChica());
		rendicionCajaChicaDTO.setFechaCreacion(rendicionCajaChicaEntity.getFechaCreacion());
		rendicionCajaChicaDTO.setUsuarioCreacion(rendicionCajaChicaEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(rendicionCajaChicaDTO.getCodigoDSite()))
			rendicionCajaChicaDTO.setCodigoDSite(rendicionCajaChicaEntity.getCodigoDSite());
		if (ValidateUtil.isEmpty(rendicionCajaChicaDTO.getRendirCaja()))
			rendicionCajaChicaDTO.setRendirCaja(rendicionCajaChicaEntity.getRendirCaja());
		if (ValidateUtil.isEmpty(rendicionCajaChicaDTO.getRendirViatico()))
			rendicionCajaChicaDTO.setRendirViatico(rendicionCajaChicaEntity.getRendirViatico());
		
		// Ingresar datos a la entidad
		mapper.map(rendicionCajaChicaDTO, rendicionCajaChicaEntity);
		rendicionCajaChicaEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(rendicionCajaChicaDTO.getUsuarioModificacion()))
			rendicionCajaChicaEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateRendicionCajaChica(rendicionCajaChicaDTO, rendicionCajaChicaEntity);
	}

	private void createUpdateRendicionCajaChica(RendicionCajaChicaDTO rendicionCajaChicaDTO, RendicionCajaChica rendicionCajaChicaEntity) {
		if (ValidateUtil.isNotEmpty(rendicionCajaChicaDTO.getIdCajaChicaObra())) {
			CajaChicaObra cajaChicaObra = cajaChicaObraJPARepository.findOne(rendicionCajaChicaDTO.getIdCajaChicaObra());
			rendicionCajaChicaEntity.setCajaChicaObra(cajaChicaObra);
		}
		if (ValidateUtil.isNotEmpty(rendicionCajaChicaDTO.getIdResumenRendicionCajaChica())) {
			ResumenRendicionCajaChica resumenRendicionCajaChica = resumenRendicionCajaChicaJPARepository.findOne(rendicionCajaChicaDTO.getIdResumenRendicionCajaChica());
			rendicionCajaChicaEntity.setResumenRendicionCajaChica(resumenRendicionCajaChica);
		}
		rendicionCajaChicaRepository.save(rendicionCajaChicaEntity);
		rendicionCajaChicaRepository.flush();
	}
}
