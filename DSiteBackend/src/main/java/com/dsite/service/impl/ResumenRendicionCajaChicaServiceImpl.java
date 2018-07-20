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
import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.ResumenRendicionCajaChica;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.ResumenRendicionCajaChicaJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.RendicionDTO;
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
	TablaGeneralJPARepository tablaGeneralJPARepository;

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
		TablaGeneral tablaGeneralEstadoRendicion = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_POR_RENDIR);
		resumenRendicionCajaChicaEntity.setTablaGeneralEstadoRendicion(tablaGeneralEstadoRendicion);
		TablaGeneral tablaGeneralEstadoRendicionAprobacion = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_APROBACION_PENDIENTE);
		resumenRendicionCajaChicaEntity.setTablaGeneralEstado(tablaGeneralEstadoRendicionAprobacion);

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
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getFechaAprobacion()))
			resumenRendicionCajaChicaDTO.setFechaAprobacion(resumenRendicionCajaChicaEntity.getFechaAprobacion());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getFechaRechazo()))
			resumenRendicionCajaChicaDTO.setFechaRechazo(resumenRendicionCajaChicaEntity.getFechaRechazo());
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO.getMotivoRechazo()))
			resumenRendicionCajaChicaDTO.setMotivoRechazo(resumenRendicionCajaChicaEntity.getMotivoRechazo());

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
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdTGEstadoRendicion());
			resumenRendicionCajaChicaEntity.setTablaGeneralEstadoRendicion(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdEmpleadoSustentador())) {
			Empleado empleado = empleadoJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdEmpleadoSustentador());
			resumenRendicionCajaChicaEntity.setEmpleadoSustentador(empleado);
		}
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdUsuarioAprobacion())) {
			Usuario usuario = usuarioJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdUsuarioAprobacion());
			resumenRendicionCajaChicaEntity.setUsuarioAprobacion(usuario);
		}
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdUsuarioRechazo())) {
			Usuario usuario = usuarioJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdUsuarioRechazo());
			resumenRendicionCajaChicaEntity.setUsuarioRechazo(usuario);
		}
		if (ValidateUtil.isNotEmpty(resumenRendicionCajaChicaDTO.getIdTGEstado())) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(resumenRendicionCajaChicaDTO.getIdTGEstado());
			resumenRendicionCajaChicaEntity.setTablaGeneralEstado(tablaGeneral);
		}
		resumenRendicionCajaChicaJPARepository.save(resumenRendicionCajaChicaEntity);
		resumenRendicionCajaChicaJPARepository.flush();
	}

	@Transactional
	public void updateImporteResumenRendicionCajaChica(RendicionDTO rendicionDTO, ResumenRendicionCajaChica resumenRendicionCajaChica) {
		BigDecimal importeReembolsoCaja = ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteReembolsoCaja()) ? resumenRendicionCajaChica.getImporteReembolsoCaja()
				: BigDecimal.ZERO;
		BigDecimal importeDescuentoCaja = ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteDescuentoCaja()) ? resumenRendicionCajaChica.getImporteDescuentoCaja()
				: BigDecimal.ZERO;
		BigDecimal importeDescuentoViatico = ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteDescuentoViatico())
				? resumenRendicionCajaChica.getImporteDescuentoViatico()
				: BigDecimal.ZERO;
		BigDecimal importeRendidoCaja = ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteRendidoCaja()) ? resumenRendicionCajaChica.getImporteRendidoCaja()
				: BigDecimal.ZERO;
		BigDecimal importeRendidoViatico = ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteRendidoViatico()) ? resumenRendicionCajaChica.getImporteRendidoViatico()
				: BigDecimal.ZERO;

		if (ValidateUtil.isNotEmpty(rendicionDTO.getIdTGTipoRendicion())) {
			if (rendicionDTO.getIdTGTipoRendicion().compareTo(DSiteCoreConstants.CLASIFICACION_CAJA_CHICA_CAJA) == 0) {
				importeRendidoCaja = importeRendidoCaja.add(rendicionDTO.getImporteRendidoCajaViatico());
				resumenRendicionCajaChica.setImporteRendidoCaja(importeRendidoCaja);

				if (ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteAbonoCaja())) {
					BigDecimal varCaja = resumenRendicionCajaChica.getImporteAbonoCaja().subtract(importeRendidoCaja);
					if (varCaja.compareTo(BigDecimal.ZERO) > 0)
						importeDescuentoCaja = varCaja;
					else {
						importeReembolsoCaja = varCaja.abs();
						importeDescuentoCaja = BigDecimal.ZERO;
					}
					resumenRendicionCajaChica.setImporteDescuentoCaja(importeDescuentoCaja);
					resumenRendicionCajaChica.setImporteReembolsoCaja(importeReembolsoCaja);
				}
			}
			else if (rendicionDTO.getIdTGTipoRendicion().compareTo(DSiteCoreConstants.CLASIFICACION_CAJA_CHICA_VIATICO) == 0) {
				importeRendidoViatico = importeRendidoViatico.add(rendicionDTO.getImporteRendidoCajaViatico());
				resumenRendicionCajaChica.setImporteRendidoViatico(importeRendidoViatico);

				if (ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteAbonoViatico())) {
					BigDecimal varViatico = resumenRendicionCajaChica.getImporteAbonoViatico().subtract(importeRendidoViatico);
					if (varViatico.compareTo(BigDecimal.ZERO) > 0)
						importeDescuentoViatico = varViatico;
					else
						importeDescuentoViatico = BigDecimal.ZERO;
					resumenRendicionCajaChica.setImporteDescuentoViatico(importeDescuentoViatico);
				}
			}
		}

		BigDecimal importeDescuentoVar = importeDescuentoCaja.add(importeDescuentoViatico);
		BigDecimal importeReembolsoVar = importeReembolsoCaja.subtract(importeDescuentoVar);
		if (importeReembolsoVar.compareTo(BigDecimal.ZERO) > 0) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_PENDIENTE_REEMBOLSO);
			resumenRendicionCajaChica.setTablaGeneralEstadoRendicion(tablaGeneral);
		}
		else if (importeReembolsoVar.compareTo(BigDecimal.ZERO) < 0) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_PENDIENTE_DESCUENTO);
			resumenRendicionCajaChica.setTablaGeneralEstadoRendicion(tablaGeneral);
		}
		else if (importeReembolsoVar.compareTo(BigDecimal.ZERO) == 0) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_COMPLETADO);
			resumenRendicionCajaChica.setTablaGeneralEstadoRendicion(tablaGeneral);
		}
		resumenRendicionCajaChicaJPARepository.save(resumenRendicionCajaChica);
		resumenRendicionCajaChicaJPARepository.flush();
	}

}
