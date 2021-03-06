package com.dsite.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Rendicion;
import com.dsite.domain.model.entities.ResumenRendicionCajaChica;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.RendicionJPARepository;
import com.dsite.domain.model.repository.jpa.ResumenRendicionCajaChicaJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.RendicionDTO;
import com.dsite.service.intf.RendicionService;
import com.dsite.service.intf.ResumenRendicionCajaChicaService;
import com.dsite.util.ValidateUtil;

@Service
public class RendicionServiceImpl implements RendicionService {

	@Autowired
	Mapper mapper;

	@Autowired
	RendicionJPARepository rendicionJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJPARepository;

	@Autowired
	ResumenRendicionCajaChicaJPARepository resumenRendicionCajaChicaJPARepository;

	@Autowired
	ResumenRendicionCajaChicaService resumenRendicionCajaChicaService;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public RendicionDTO findById(int id) {
		RendicionDTO dto = new RendicionDTO();
		Rendicion entity = rendicionJPARepository.findOne(id);
		mapper.map(entity, dto);
		return dto;
	}

	@Override
	public void createRendicion(RendicionDTO rendicionDTO) {
		Rendicion rendicionEntity = new Rendicion();
		mapper.map(rendicionDTO, rendicionEntity);

		// Ingresar datos a la entidad
		rendicionEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(rendicionDTO.getUsuarioCreacion()))
			rendicionEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateRendicion(rendicionDTO, rendicionEntity);
	}

	@Override
	public void updateRendicion(RendicionDTO rendicionDTO) {
		Rendicion rendicionEntity = new Rendicion();
		if (ValidateUtil.isNotEmpty(rendicionDTO.getIdRendicion()))
			rendicionEntity = rendicionJPARepository.findOne(rendicionDTO.getIdRendicion());
		rendicionDTO.setFechaCreacion(rendicionEntity.getFechaCreacion());
		rendicionDTO.setUsuarioCreacion(rendicionEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(rendicionDTO.getDescripcionCajaViatico()))
			rendicionDTO.setDescripcionCajaViatico(rendicionEntity.getDescripcionCajaViatico());
		if (ValidateUtil.isEmpty(rendicionDTO.getFechaComprobanteCajaViatico()))
			rendicionDTO.setFechaComprobanteCajaViatico(rendicionEntity.getFechaComprobanteCajaViatico());
		if (ValidateUtil.isEmpty(rendicionDTO.getImporteRendidoCajaViatico()))
			rendicionDTO.setImporteRendidoCajaViatico(rendicionEntity.getImporteRendidoCajaViatico());
		if (ValidateUtil.isEmpty(rendicionDTO.getNumeroComprobanteCajaViatico()))
			rendicionDTO.setNumeroComprobanteCajaViatico(rendicionEntity.getNumeroComprobanteCajaViatico());

		// Ingresar datos a la entidad
		mapper.map(rendicionDTO, rendicionEntity);
		rendicionEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(rendicionDTO.getUsuarioModificacion()))
			rendicionEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateRendicion(rendicionDTO, rendicionEntity);
	}

	private void createUpdateRendicion(RendicionDTO rendicionDTO, Rendicion rendicionEntity) {
		if (ValidateUtil.isNotEmpty(rendicionDTO.getIdTGTipoRendicion())) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(rendicionDTO.getIdTGTipoRendicion());
			rendicionEntity.setTablaGeneralTipoRendicion(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(rendicionDTO.getIdTGTipoComprobante())) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(rendicionDTO.getIdTGTipoComprobante());
			rendicionEntity.setTablaGeneralTipoComprobante(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(rendicionDTO.getIdTGTipoGasto())) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(rendicionDTO.getIdTGTipoGasto());
			rendicionEntity.setTablaGeneralTipoGasto(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(rendicionDTO.getIdResumenRendicionCajaChica())) {
			ResumenRendicionCajaChica resumenRendicionCajaChica = resumenRendicionCajaChicaJPARepository.findOne(rendicionDTO.getIdResumenRendicionCajaChica());
			resumenRendicionCajaChicaService.updateImporteResumenRendicionCajaChica(rendicionDTO, resumenRendicionCajaChica);
			rendicionEntity.setResumenRendicionCajaChica(resumenRendicionCajaChica);
		}
		rendicionJPARepository.save(rendicionEntity);
		rendicionJPARepository.flush();
	}

	@Transactional
	public void deleteRendicionById(Integer id) {
		Rendicion rendicion = rendicionJPARepository.findOne(id);
		
		if (ValidateUtil.isNotEmpty(rendicion)) {
			ResumenRendicionCajaChica resumenRendicionCajaChica = rendicion.getResumenRendicionCajaChica();			
			RendicionDTO rendicionDTO = new RendicionDTO();
			BigDecimal importeRendidoCajaViatico = rendicion.getImporteRendidoCajaViatico().negate();
			
			rendicionDTO.setIdTGTipoRendicion(rendicion.getTablaGeneralTipoRendicion().getIdTablaGeneral());
			rendicionDTO.setImporteRendidoCajaViatico(importeRendidoCajaViatico);

			resumenRendicionCajaChicaService.updateImporteResumenRendicionCajaChica(rendicionDTO, resumenRendicionCajaChica);

			// Invocar procedure para generar el codigo de obra
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteRendicion");
			query.registerStoredProcedureParameter("idRendicion", Integer.class, ParameterMode.IN);
			// set input parameter
			query.setParameter("idRendicion", rendicion.getIdRendicion());
			// Execute query
			query.execute();
		}
	}
}
