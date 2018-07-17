package com.dsite.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Rendicion;
import com.dsite.domain.model.entities.ResumenRendicionCajaChica;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.RendicionJPARepository;
import com.dsite.domain.model.repository.jpa.ResumenRendicionCajaChicaJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.RendicionDTO;
import com.dsite.service.intf.RendicionService;
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
			BigDecimal importeRendidoCaja = BigDecimal.ZERO;
			BigDecimal importeRendidoViatico = BigDecimal.ZERO;
			BigDecimal importeReembolsoCaja = BigDecimal.ZERO;
			BigDecimal importeDescuentoCaja = BigDecimal.ZERO;
			BigDecimal importeDescuentoViatico = BigDecimal.ZERO;

			ResumenRendicionCajaChica resumenRendicionCajaChica = resumenRendicionCajaChicaJPARepository.findOne(rendicionDTO.getIdResumenRendicionCajaChica());

			if (ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteRendidoCaja()))
				importeRendidoCaja = importeRendidoCaja.add(resumenRendicionCajaChica.getImporteRendidoCaja());
			if (ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteRendidoViatico()))
				importeRendidoViatico = importeRendidoCaja.add(resumenRendicionCajaChica.getImporteRendidoViatico());
			if (ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteAbonoCaja())) {
				BigDecimal varCaja = resumenRendicionCajaChica.getImporteAbonoCaja().subtract(importeRendidoCaja);
				if (varCaja.compareTo(BigDecimal.ZERO) > 0)
					importeDescuentoCaja = varCaja;
				else
					importeReembolsoCaja = varCaja.abs();
				resumenRendicionCajaChica.setImporteDescuentoCaja(importeDescuentoCaja);
				resumenRendicionCajaChica.setImporteReembolsoCaja(importeReembolsoCaja);
			}
			if (ValidateUtil.isNotEmpty(resumenRendicionCajaChica.getImporteAbonoViatico())) {
				BigDecimal varViatico = resumenRendicionCajaChica.getImporteAbonoViatico().subtract(importeRendidoViatico);
				if (varViatico.compareTo(BigDecimal.ZERO) > 0)
					importeDescuentoViatico = varViatico;
				else
					importeDescuentoViatico = BigDecimal.ZERO;
				resumenRendicionCajaChica.setImporteDescuentoViatico(importeDescuentoViatico);
			}

			BigDecimal importeDescuentoVar = importeDescuentoCaja.add(importeDescuentoViatico);
			BigDecimal importeReembolsoVar = importeReembolsoCaja.subtract(importeDescuentoVar);
			if (importeReembolsoVar.compareTo(BigDecimal.ZERO) > 0) {
				TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_PENDIENTE_DESCUENTO);
				resumenRendicionCajaChica.setTablaGeneralEstadoRendicion(tablaGeneral);
			}
			else if (importeReembolsoVar.compareTo(BigDecimal.ZERO) < 0) {
				TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_PENDIENTE_REEMBOLSO);
				resumenRendicionCajaChica.setTablaGeneralEstadoRendicion(tablaGeneral);
			}
			else if (importeReembolsoVar.compareTo(BigDecimal.ZERO) == 0) {
				TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_RENDICION_COMPLETADO);
				resumenRendicionCajaChica.setTablaGeneralEstadoRendicion(tablaGeneral);
			}
			resumenRendicionCajaChicaJPARepository.save(resumenRendicionCajaChica);
			resumenRendicionCajaChicaJPARepository.flush();
			
			rendicionEntity.setResumenRendicionCajaChica(resumenRendicionCajaChica);
		}
		rendicionJPARepository.save(rendicionEntity);
		rendicionJPARepository.flush();
	}
}
