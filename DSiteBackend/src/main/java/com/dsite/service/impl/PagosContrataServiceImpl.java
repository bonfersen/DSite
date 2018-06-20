package com.dsite.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.ContratasObra;
import com.dsite.domain.model.entities.PagosContrata;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.ContratasObraJPARepository;
import com.dsite.domain.model.repository.jpa.PagosContrataJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.PagosContrataDTO;
import com.dsite.service.intf.PagosContrataService;
import com.dsite.util.ValidateUtil;

@Service
public class PagosContrataServiceImpl implements PagosContrataService {

	@Autowired
	PagosContrataJPARepository pagosContrataJPARepository;
	
	@Autowired
	ContratasObraJPARepository contratasObraJPARepository;
	
	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	Mapper mapper;
	
	@Override
	public PagosContrataDTO findById(int id) {
		PagosContrataDTO pagosContrataDTO = new PagosContrataDTO();
		PagosContrata pagosContrataEntity = pagosContrataJPARepository.findOne(id);
		mapper.map(pagosContrataEntity, pagosContrataDTO);
		return pagosContrataDTO;
	}

	@Override
	public List<PagosContrataDTO> findAllPagosContratas() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void createPagosContrata(PagosContrataDTO pagosContrataDTO) {
		PagosContrata pagosContrataEntity = new PagosContrata();
		pagosContrataDTO.setIdTGEstadoPagoContrata(DSiteCoreConstants.ESTADO_PAGO_CONTRATA_SOLICITADO);
		mapper.map(pagosContrataDTO, pagosContrataEntity);

		// Ingresar datos a la entidad
		pagosContrataEntity.setFechaCreacion(new Date());
		pagosContrataEntity.setFechaSolicitud(new Date());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getUsuarioCreacion()))
			pagosContrataEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
				
		/*
		 *  Grabar porcentajes de adelantos
		 */
		BigDecimal porcentajeAdelanto = BigDecimal.ZERO;
		BigDecimal importePresupuestoObra = BigDecimal.ZERO;
		BigDecimal importeAdelanto = BigDecimal.ZERO;	
		
		ContratasObra contratasObra = contratasObraJPARepository.findOne(pagosContrataDTO.getIdContratasObra());
		if (ValidateUtil.isNotEmpty(contratasObra.getImportePresupuestoObra())) {
			importePresupuestoObra = contratasObra.getImportePresupuestoObra();
			porcentajeAdelanto = pagosContrataEntity.getPorcentajeAdelanto();			
			//importeAdelanto = (importePresupuestoObra.multiply(porcentajeAdelanto)).divide(new BigDecimal(DSiteCoreConstants.CIEN_CADENA));
			importeAdelanto = importePresupuestoObra.multiply(porcentajeAdelanto);
			pagosContrataEntity.setImporteAdelanto(importeAdelanto);
			pagosContrataEntity.setPorcentajeAdelanto(porcentajeAdelanto);
		}
		//.setScale(4, RoundingMode.HALF_UP)
		createUpdatePagosContrata(pagosContrataDTO, pagosContrataEntity);
	}

	@Override
	public void updatePagosContrata(PagosContrataDTO pagosContrataDTO) {
		PagosContrata pagosContrataEntity = new PagosContrata();
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdPagosContrata()))
			pagosContrataEntity = pagosContrataJPARepository.findOne(pagosContrataDTO.getIdPagosContrata());
		/*
		 * Validar DTO
		 */
		pagosContrataDTO.setFechaCreacion(pagosContrataEntity.getFechaCreacion());
		pagosContrataDTO.setUsuarioCreacion(pagosContrataEntity.getUsuarioCreacion());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getFechaAprobacion()))
			pagosContrataEntity.setFechaAprobacion(new Date());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getFechaPago()))
			pagosContrataDTO.setFechaPago(pagosContrataEntity.getFechaPago());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getFechaRechazo()))
			pagosContrataDTO.setFechaRechazo(pagosContrataEntity.getFechaRechazo());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getFechaSolicitud()))
			pagosContrataDTO.setFechaSolicitud(pagosContrataEntity.getFechaSolicitud());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getImporteAdelanto()))
			pagosContrataDTO.setImporteAdelanto(pagosContrataEntity.getImporteAdelanto());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getImporteAplicadoPendientePago()))
			pagosContrataDTO.setImporteAplicadoPendientePago(pagosContrataEntity.getImporteAplicadoPendientePago());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getMotivoRechazo()))
			pagosContrataDTO.setMotivoRechazo(pagosContrataEntity.getMotivoRechazo());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getNumeroFactura()))
			pagosContrataDTO.setNumeroFactura(pagosContrataEntity.getNumeroFactura());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getOrdenServicio()))
			pagosContrataDTO.setOrdenServicio(pagosContrataEntity.getOrdenServicio());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getPorcentajeAdelanto()))
			pagosContrataDTO.setPorcentajeAdelanto(pagosContrataEntity.getPorcentajeAdelanto());
		
		// Ingresar datos a la entidad
		mapper.map(pagosContrataDTO, pagosContrataEntity);
		pagosContrataEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(pagosContrataDTO.getUsuarioModificacion()))
			pagosContrataEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdatePagosContrata(pagosContrataDTO, pagosContrataEntity);
	}
	
	private void createUpdatePagosContrata(PagosContrataDTO pagosContrataDTO, PagosContrata pagosContrataEntity) {
		ContratasObra contratasObra = null;
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdContratasObra())) {
			contratasObra = contratasObraJPARepository.findOne(pagosContrataDTO.getIdContratasObra());
			pagosContrataEntity.setContratasObra(contratasObra);
		}
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdTGTipoSolicitud())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(pagosContrataDTO.getIdTGTipoSolicitud());
			pagosContrataEntity.setTablaGeneralTipoSolicitud(tablaGeneral);
		}	
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdTGEstadoPagoContrata())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(pagosContrataDTO.getIdTGEstadoPagoContrata());
			pagosContrataEntity.setTablaGeneralEstadoPagoContrata(tablaGeneral);

			switch (tablaGeneral.getIdTablaGeneral()) {
			case DSiteCoreConstants.ESTADO_PAGO_CONTRATA_APROBADO:
				BigDecimal importeTotalAdelantoObra = BigDecimal.ZERO;
				BigDecimal importeAdelanto = BigDecimal.ZERO;
				//se suma los adelanto al total si estas se aprueban
				if(ValidateUtil.isNotEmpty(contratasObra.getImporteTotalAdelanto()))
					importeTotalAdelantoObra = contratasObra.getImporteTotalAdelanto();
				importeAdelanto = pagosContrataEntity.getImporteAdelanto();
				importeTotalAdelantoObra = importeTotalAdelantoObra.add(importeAdelanto);
				contratasObra.setImporteTotalAdelanto(importeTotalAdelantoObra);
				contratasObraJPARepository.save(contratasObra);
				contratasObraJPARepository.flush();
				
				pagosContrataEntity.setFechaAprobacion(new Date());
				break;
			case DSiteCoreConstants.ESTADO_PAGO_CONTRATA_RECHAZADO:
				pagosContrataEntity.setFechaRechazo(new Date());
				break;
			case DSiteCoreConstants.ESTADO_PAGO_CONTRATA_PAGADO:
				pagosContrataEntity.setFechaPago(new Date());
				break;	
			default:
				break;
			}
		}
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdUsuarioSolicitado())) {
			Usuario usuarioSolicitado = usuarioJPARepository.findOne(pagosContrataDTO.getIdUsuarioSolicitado());
			pagosContrataEntity.setUsuarioSolicitado(usuarioSolicitado);
		}
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdUsuarioAprobado())) {
			Usuario usuarioAprobado = usuarioJPARepository.findOne(pagosContrataDTO.getIdUsuarioAprobado());
			pagosContrataEntity.setUsuarioAprobado(usuarioAprobado);
		}
		if (ValidateUtil.isNotEmpty(pagosContrataDTO.getIdUsuarioRechazo())) {
			Usuario usuarioRechazo = usuarioJPARepository.findOne(pagosContrataDTO.getIdUsuarioRechazo());
			pagosContrataEntity.setUsuarioRechazo(usuarioRechazo);
		}
		pagosContrataJPARepository.save(pagosContrataEntity);
		pagosContrataJPARepository.flush();
	}

	@Override
	public void deletePagosContrataById(int id) {
		// XXX Auto-generated method stub

	}

}
