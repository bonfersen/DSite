package com.dsite.service.impl;

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
import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.ResumenRendicionCajaChica;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.ResumenRendicionCajaChicaJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.ResumenRendicionCajaChicaDTO;
import com.dsite.service.intf.ResumenRendicionCajaChicaService;
import com.dsite.util.ValidateUtil;

@Service
public class ResumenRendicionCajaChicaServiceImpl implements ResumenRendicionCajaChicaService {

	@Autowired
	Mapper mapper;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ResumenRendicionCajaChicaJPARepository resumenRendicionCajaChicaJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;
	
	@Autowired
	EmpleadoJPARepository empleadoJPARepository;

	@Override
	public ResumenRendicionCajaChicaDTO findById(int id) {
		ResumenRendicionCajaChicaDTO dto = new ResumenRendicionCajaChicaDTO();
		ResumenRendicionCajaChica entity = resumenRendicionCajaChicaJPARepository.findOne(id);
		mapper.map(entity, dto);
		return dto;
	}

	@Transactional
	public ResumenRendicionCajaChica createResumenRendicionCajaChica(ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO) {
		ResumenRendicionCajaChica resumenRendicionCajaChicaEntity = new ResumenRendicionCajaChica();
		mapper.map(resumenRendicionCajaChicaDTO, resumenRendicionCajaChicaEntity);

		// Invocar procedure para generar el codigo de obra
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getCodigoRendicion");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
		// Execute query
		query.execute();
		// Get output parameters
		String codigoRendicion = (String) query.getOutputParameterValue(1);
		// Establecer codigos
		resumenRendicionCajaChicaEntity.setCodigoRendicion(codigoRendicion);

		// Ingresar datos a la entidad
		resumenRendicionCajaChicaEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getUsuarioCreacion()))
			resumenRendicionCajaChicaEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		TablaGeneral tablaGeneralEstadoRendicion = tablaGeneralJpaRepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_POR_RENDIR);
		resumenRendicionCajaChicaEntity.setTablaGeneralEstadoRendicion(tablaGeneralEstadoRendicion);

		createUpdateResumenRendicionCajaChica(resumenRendicionCajaChicaDTO, resumenRendicionCajaChicaEntity);
		
		return resumenRendicionCajaChicaEntity;
	}

	@Transactional
	public void updateResumenRendicionCajaChica(ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO) {
		ResumenRendicionCajaChica resumenRendicionCajaChicaEntity = new ResumenRendicionCajaChica();
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdResumenRendicionCajaChica()))
			resumenRendicionCajaChicaEntity = resumenRendicionCajaChicaJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdResumenRendicionCajaChica());
		resumenRendicionCajaChicaDTO.setFechaCreacion(resumenRendicionCajaChicaEntity.getFechaCreacion());
		resumenRendicionCajaChicaDTO.setUsuarioCreacion(resumenRendicionCajaChicaEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getCodigoRendicion()))
			resumenRendicionCajaChicaDTO.setCodigoRendicion(resumenRendicionCajaChicaEntity.getCodigoRendicion());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getFechaCreacion()))
			resumenRendicionCajaChicaDTO.setFechaCreacion(resumenRendicionCajaChicaEntity.getFechaCreacion());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getFechaDescuento()))
			resumenRendicionCajaChicaDTO.setFechaDescuento(resumenRendicionCajaChicaEntity.getFechaDescuento());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getFechaImpresion()))
			resumenRendicionCajaChicaDTO.setFechaImpresion(resumenRendicionCajaChicaEntity.getFechaImpresion());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getFechaReembolso()))
			resumenRendicionCajaChicaDTO.setFechaReembolso(resumenRendicionCajaChicaEntity.getFechaReembolso());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteAbonoCaja()))
			resumenRendicionCajaChicaDTO.setImporteAbonoCaja(resumenRendicionCajaChicaEntity.getImporteAbonoCaja());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteAbonoViatico()))
			resumenRendicionCajaChicaDTO.setImporteAbonoViatico(resumenRendicionCajaChicaEntity.getImporteAbonoViatico());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteDescuentoCaja()))
			resumenRendicionCajaChicaDTO.setImporteDescuentoCaja(resumenRendicionCajaChicaEntity.getImporteDescuentoCaja());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteDescuentoViatico()))
			resumenRendicionCajaChicaDTO.setImporteDescuentoViatico(resumenRendicionCajaChicaEntity.getImporteDescuentoViatico());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteReembolsoCaja()))
			resumenRendicionCajaChicaDTO.setImporteReembolsoCaja(resumenRendicionCajaChicaEntity.getImporteReembolsoCaja());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteRendidoCaja()))
			resumenRendicionCajaChicaDTO.setImporteRendidoCaja(resumenRendicionCajaChicaEntity.getImporteRendidoCaja());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getImporteRendidoViatico()))
			resumenRendicionCajaChicaDTO.setImporteRendidoViatico(resumenRendicionCajaChicaEntity.getImporteRendidoViatico());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getCodigoRendicion()))
			resumenRendicionCajaChicaDTO.setCodigoRendicion(resumenRendicionCajaChicaEntity.getCodigoRendicion());

		// Ingresar datos a la entidad
		mapper.map(resumenRendicionCajaChicaDTO, resumenRendicionCajaChicaEntity);
		resumenRendicionCajaChicaEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getUsuarioModificacion()))
			resumenRendicionCajaChicaEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateResumenRendicionCajaChica(resumenRendicionCajaChicaDTO, resumenRendicionCajaChicaEntity);
	}

	private void createUpdateResumenRendicionCajaChica(ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO, ResumenRendicionCajaChica resumenRendicionCajaChicaEntity) {
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdUsuarioImpresion())) {
			Usuario usuario = usuarioJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdUsuarioImpresion());
			resumenRendicionCajaChicaEntity.setUsuarioImpresion(usuario);
		}
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdTGEstadoRendicion())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(resumenRendicionCajaChicaDTO.getIdTGEstadoRendicion());
			resumenRendicionCajaChicaEntity.setTablaGeneralEstadoRendicion(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdEmpleadoSustentador())) {
			Empleado empleado = empleadoJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdEmpleadoSustentador());
			resumenRendicionCajaChicaEntity.setEmpleadoSustentador(empleado);
		}
		resumenRendicionCajaChicaJPARepository.save(resumenRendicionCajaChicaEntity);
		resumenRendicionCajaChicaJPARepository.flush();
	}

}
