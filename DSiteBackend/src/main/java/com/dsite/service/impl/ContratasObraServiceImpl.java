package com.dsite.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.CierreEconomico;
import com.dsite.domain.model.entities.Contrata;
import com.dsite.domain.model.entities.ContratasObra;
import com.dsite.domain.model.entities.Obra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jdbc.ContratasObraJDBCRepository;
import com.dsite.domain.model.repository.jpa.CierreEconomicoJPARepository;
import com.dsite.domain.model.repository.jpa.CierreEconomicoObraJPARepository;
import com.dsite.domain.model.repository.jpa.ContrataJPARepository;
import com.dsite.domain.model.repository.jpa.ContratasObraJPARepository;
import com.dsite.domain.model.repository.jpa.ObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.ActasContrataDTO;
import com.dsite.dto.model.CierreEconomicoObraDTO;
import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.ActasContrataService;
import com.dsite.service.intf.CierreEconomicoObraService;
import com.dsite.service.intf.ContratasObraService;
import com.dsite.util.ValidateUtil;

@Service
public class ContratasObraServiceImpl implements ContratasObraService {

	@Autowired
	ContratasObraJPARepository contratasObraJPARepository;

	@Autowired
	ContratasObraJDBCRepository contratasObraJDBCRepository;

	@Autowired
	ActasContrataService actasContrataService;

	@Autowired
	ObraJPARepository obraJPARepository;

	@Autowired
	ContrataJPARepository contrataJPARepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	CierreEconomicoObraJPARepository cierreEconomicoObraJPARepository;

	@Autowired
	CierreEconomicoJPARepository cierreEconomicoJPARepository;

	@Autowired
	CierreEconomicoObraService cierreEconomicoObraService;

	@Autowired
	Mapper mapper;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ContratasObraDTO> findByIdObra(int idObra) {
		ContratasObraDTO dto = new ContratasObraDTO();
		dto.setIdObra(idObra);
		List<ContratasObraDTO> lstDTO = contratasObraJDBCRepository.findContratasObraByCriteria(dto);
		return lstDTO;
	}

	@Transactional
	public void createContratasObra(ContratasObraDTO contratasObraDTO) {
		ContratasObra contratasObraEntity = new ContratasObra();
		mapper.map(contratasObraDTO, contratasObraEntity);

		// Ingresar datos a la entidad
		contratasObraEntity.setFechaCreacion(new Date());
		TablaGeneral tablaGeneralEstadoCierreEconomico = new TablaGeneral();
		tablaGeneralEstadoCierreEconomico.setIdTablaGeneral(DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_PENDIENTE);
		contratasObraEntity.setTablaGeneralEstadoCierreEconomico(tablaGeneralEstadoCierreEconomico);
		// Estado liquidacion de contrataObra en generado
		TablaGeneral tablaGeneralEstadoLiquidacion = new TablaGeneral();
		tablaGeneralEstadoLiquidacion.setIdTablaGeneral(DSiteCoreConstants.ESTADO_LIQUIDACION_CONTRATA_GENERADO);
		contratasObraEntity.setTablaGeneralEstadoLiquidacion(tablaGeneralEstadoLiquidacion);
		if (ValidateUtil.isEmpty(contratasObraDTO.getUsuarioCreacion()))
			contratasObraEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		createUpdateContratasObra(contratasObraDTO, contratasObraEntity);
		
		/*
		 * Actualizar la cantidad de contratas
		 */
		Obra obra = contratasObraEntity.getObra();
		ContratasObraDTO contratasObraDTOCC = new ContratasObraDTO();
		contratasObraDTOCC.setIdObra(contratasObraEntity.getObra().getIdObra());
		List<ContratasObraDTO> lstContratasObra = contratasObraJDBCRepository.findContratasObraByCriteria(contratasObraDTOCC);
		if (lstContratasObra.size() > 0) {
			obra.setCantidadContratasAsignadas(lstContratasObra.size());
			obraJPARepository.save(obra);
			obraJPARepository.flush();
		}
		
		/*
		 * Ingresar datos a la Acta Contrata
		 */
		for (ActasContrataDTO actasContrataDTO : contratasObraDTO.getActasContratasDTO()) {
			actasContrataDTO.setIdContratasObra(contratasObraEntity.getIdContratasObra());
			actasContrataDTO.setIdTGEstadoActa(DSiteCoreConstants.ESTADO_ACTA_CONTRATA_PENDIENTE);
			actasContrataService.createActasContrata(actasContrataDTO);
		}
	}

	@Transactional
	public void updateContratasObra(ContratasObraDTO contratasObraDTO) {
		ContratasObra contratasObraEntity = new ContratasObra();
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdContratasObra())) {
			contratasObraEntity = contratasObraJPARepository.findOne(contratasObraDTO.getIdContratasObra());
		}
		contratasObraDTO.setFechaCreacion(contratasObraEntity.getFechaCreacion());
		contratasObraDTO.setUsuarioCreacion(contratasObraEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(contratasObraDTO.getComentarioCierreEconomico()))
			contratasObraDTO.setComentarioCierreEconomico(contratasObraEntity.getComentarioCierreEconomico());
		if (ValidateUtil.isEmpty(contratasObraDTO.getComentarioDescuentoOperativo()))
			contratasObraDTO.setComentarioDescuentoOperativo(contratasObraEntity.getComentarioDescuentoOperativo());
		if (ValidateUtil.isEmpty(contratasObraDTO.getComentarioImporteAdicional()))
			contratasObraDTO.setComentarioImporteAdicional(contratasObraEntity.getComentarioImporteAdicional());
		if (ValidateUtil.isEmpty(contratasObraDTO.getFechaCECompletado()))
			contratasObraDTO.setFechaCECompletado(contratasObraEntity.getFechaCECompletado());
		if (ValidateUtil.isEmpty(contratasObraDTO.getFechaCEParcial()))
			contratasObraDTO.setFechaCEParcial(contratasObraEntity.getFechaCEParcial());
		if (ValidateUtil.isEmpty(contratasObraDTO.getFechaCEPendiente()))
			contratasObraDTO.setFechaCEPendiente(contratasObraEntity.getFechaCEPendiente());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteAdicional()))
			contratasObraDTO.setImporteAdicional(contratasObraEntity.getImporteAdicional());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteDescuentoOperativo()))
			contratasObraDTO.setImporteDescuentoOperativo(contratasObraEntity.getImporteDescuentoOperativo());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteFinal()))
			contratasObraDTO.setImporteFinal(contratasObraEntity.getImporteFinal());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteLiquidadacionObra()))
			contratasObraDTO.setImporteLiquidadacionObra(contratasObraEntity.getImporteLiquidadacionObra());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImportePendientePago()))
			contratasObraDTO.setImportePendientePago(contratasObraEntity.getImportePendientePago());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImportePresupuestoObra()))
			contratasObraDTO.setImportePresupuestoObra(contratasObraEntity.getImportePresupuestoObra());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteTipoCambio()))
			contratasObraDTO.setImporteTipoCambio(contratasObraEntity.getImporteTipoCambio());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteTotalAdelanto()))
			contratasObraDTO.setImporteTotalAdelanto(contratasObraEntity.getImporteTotalAdelanto());
		if (ValidateUtil.isEmpty(contratasObraDTO.getImporteTotalPagado()))
			contratasObraDTO.setImporteTotalPagado(contratasObraEntity.getImporteTotalPagado());
		if (ValidateUtil.isEmpty(contratasObraDTO.getPorcentajeActasAprobadas()))
			contratasObraDTO.setPorcentajeActasAprobadas(contratasObraEntity.getPorcentajeActasAprobadas());
		if (ValidateUtil.isEmpty(contratasObraDTO.getTipoTrabajo()))
			contratasObraDTO.setTipoTrabajo(contratasObraEntity.getTipoTrabajo());

		// Ingresar datos a la entidad
		mapper.map(contratasObraDTO, contratasObraEntity);
		contratasObraEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(contratasObraDTO.getUsuarioModificacion()))
			contratasObraEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateContratasObra(contratasObraDTO, contratasObraEntity);
	}

	private void createUpdateContratasObra(ContratasObraDTO contratasObraDTO, ContratasObra contratasObraEntity) {
		/*
		 * Ingresar datos a la Contrata Obra
		 */
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdObra())) {
			Obra obra = obraJPARepository.findOne(contratasObraDTO.getIdObra());
			contratasObraEntity.setObra(obra);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdContrata())) {
			Contrata contrata = contrataJPARepository.findOne(contratasObraDTO.getIdContrata());
			contratasObraEntity.setContrata(contrata);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdTGTipoMoneda())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(contratasObraDTO.getIdTGTipoMoneda());
			contratasObraEntity.setTablaGeneralTipoMoneda(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdTGEstadoCierreEconomico())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(contratasObraDTO.getIdTGEstadoCierreEconomico());
			List<CierreEconomicoObraDTO> lstCierreEconomicoObraDTO = null;

			switch (contratasObraDTO.getIdTGEstadoCierreEconomico()) {
			case DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_PARCIAL:
				lstCierreEconomicoObraDTO = cierreEconomicoObraService.findByIdObra(contratasObraEntity.getObra().getIdObra());
				// Una obra siempre esta asignado a un solo cierre
				if (lstCierreEconomicoObraDTO.size() > 0) {
					CierreEconomicoObraDTO cierreEconomicoObraDTO = lstCierreEconomicoObraDTO.get(0);
					CierreEconomico cierreEconomico = cierreEconomicoJPARepository.findOne(cierreEconomicoObraDTO.getIdCierreEconomico());
					TablaGeneral tablaGeneralEstadoCierreEconomico = new TablaGeneral();
					tablaGeneralEstadoCierreEconomico.setIdTablaGeneral(DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_PARCIAL);
					cierreEconomico.setTablaGeneralEstadoCierreEconomico(tablaGeneralEstadoCierreEconomico);

					cierreEconomicoJPARepository.save(cierreEconomico);
					cierreEconomicoJPARepository.flush();
				}
				break;
			case DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_FINALIZADO:
				boolean estado = true;

				List<CierreEconomicoObraDTO> lstCierreEconomicoObraDTOTemp = cierreEconomicoObraService.findByIdObra(contratasObraEntity.getObra().getIdObra());
				if (lstCierreEconomicoObraDTOTemp.size() > 0) {
					CierreEconomicoObraDTO cierreEconomicoObraDTO = lstCierreEconomicoObraDTOTemp.get(0);
					lstCierreEconomicoObraDTO = cierreEconomicoObraService.findByIdCierreEconomico(cierreEconomicoObraDTO.getIdCierreEconomico());
					// Verificar que cada contrata obra este finalizado para finalizar el cierre
					for (CierreEconomicoObraDTO cierreEconomicoObra : lstCierreEconomicoObraDTO) {
						List<ContratasObraDTO> lstContratasObraDTO = this.findByIdObra(cierreEconomicoObra.getIdObra());
						for (ContratasObraDTO bean : lstContratasObraDTO) {
							if (bean.getIdTGEstadoCierreEconomico().compareTo(DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_FINALIZADO) != 0) {
								estado = false;
								break;
							}
						}
					}
					// Si todas las contratas obras estan finalizadas se cierra la obra
					if (estado) {
						CierreEconomico cierreEconomico = cierreEconomicoJPARepository.findOne(cierreEconomicoObraDTO.getIdCierreEconomico());
						TablaGeneral tablaGeneralEstadoCierreEconomico = new TablaGeneral();
						tablaGeneralEstadoCierreEconomico.setIdTablaGeneral(DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_FINALIZADO);
						cierreEconomico.setTablaGeneralEstadoCierreEconomico(tablaGeneralEstadoCierreEconomico);

						cierreEconomicoJPARepository.save(cierreEconomico);
						cierreEconomicoJPARepository.flush();
					}
				}
				break;
			default:
				break;
			}
			contratasObraEntity.setTablaGeneralEstadoCierreEconomico(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdTGEstadoLiquidacion())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(contratasObraDTO.getIdTGEstadoLiquidacion());
			contratasObraEntity.setTablaGeneralEstadoLiquidacion(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdUsuarioCEPendiente())) {
			Usuario usuario = usuarioJPARepository.findOne(contratasObraDTO.getIdUsuarioCEPendiente());
			contratasObraEntity.setUsuarioCEPendiente(usuario);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdUsuarioCEParcial())) {
			Usuario usuario = usuarioJPARepository.findOne(contratasObraDTO.getIdUsuarioCEParcial());
			contratasObraEntity.setUsuarioCEParcial(usuario);
		}
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getIdUsuarioCECompletado())) {
			Usuario usuario = usuarioJPARepository.findOne(contratasObraDTO.getIdUsuarioCECompletado());
			contratasObraEntity.setUsuarioCECompletado(usuario);
		}

		contratasObraJPARepository.save(contratasObraEntity);
		contratasObraJPARepository.flush();

		/*
		 * Si la contrata se liquida se suman los importes finales de cada contrata obra
		 */
		if (ValidateUtil.isNotEmpty(contratasObraDTO.getImporteFinal())) {
			List<ContratasObraDTO> lstContratasObraDTO = this.findByIdObra(contratasObraEntity.getObra().getIdObra());
			BigDecimal importeTotalPresupuestadoContrata = BigDecimal.ZERO;

			for (ContratasObraDTO dto : lstContratasObraDTO) {
				if (ValidateUtil.isNotEmpty(dto.getImporteFinal()))
					importeTotalPresupuestadoContrata = importeTotalPresupuestadoContrata.add(dto.getImporteFinal());
			}
			Obra obra = obraJPARepository.findOne(contratasObraEntity.getObra().getIdObra());
			obra.setImporteTotalPresupuestadoContrata(importeTotalPresupuestadoContrata);
			obraJPARepository.save(obra);
			obraJPARepository.flush();
		}
	}

	public NotificacionDTO deleteContratasObraById(int id) {
		NotificacionDTO notificacionDTO = new NotificacionDTO();
		try {
			// Invocar procedure para generar el codigo de obra
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteContratasObra");
			query.registerStoredProcedureParameter("idContratasObra", Integer.class, ParameterMode.IN);
			// set input parameter
			query.setParameter("idContratasObra", id);
			// Execute query
			query.execute();

			notificacionDTO.setCodigo(null);
			notificacionDTO.setSeverity("success");
			notificacionDTO.setSummary("DSite success");
			notificacionDTO.setDetail("Se elimino la contrataObra: " + id);
		}
		catch (Exception e) {
			notificacionDTO.setCodigo(null);
			notificacionDTO.setSeverity("warning");
			notificacionDTO.setSummary("DSite warning");
			notificacionDTO.setDetail(e.getCause().getCause().getMessage());
		}
		return notificacionDTO;
	}
}
