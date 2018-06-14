package com.dsite.service.impl;

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
import com.dsite.domain.model.entities.Contrata;
import com.dsite.domain.model.entities.ContratasObra;
import com.dsite.domain.model.entities.Obra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.ContrataJPARepository;
import com.dsite.domain.model.repository.jpa.ContratasObraJPARepository;
import com.dsite.domain.model.repository.jpa.ObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJpaRepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.ActasContrataDTO;
import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.service.intf.ActasContrataService;
import com.dsite.service.intf.ContratasObraService;
import com.dsite.util.ValidateUtil;

@Service
public class ContratasObraServiceImpl implements ContratasObraService {

	@Autowired
	ContratasObraJPARepository contratasObraJPARepository;

	@Autowired
	ActasContrataService actasContrataService;

	@Autowired
	ObraJPARepository obraJPARepository;

	@Autowired
	ContrataJPARepository contrataJPARepository;
	
	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	TablaGeneralJpaRepository tablaGeneralJpaRepository;

	@Autowired
	Mapper mapper;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ContratasObraDTO findById(int id) {
		// XXX Auto-generated method stub
		return null;
	}

	@Transactional
	public void createContratasObra(ContratasObraDTO contratasObraDTO) {
		ContratasObra contratasObraEntity = new ContratasObra();
		mapper.map(contratasObraDTO, contratasObraEntity);

		// Ingresar datos a la entidad
		contratasObraEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(contratasObraDTO.getUsuarioCreacion()))
			contratasObraEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		createUpdateContratasObra(contratasObraDTO, contratasObraEntity);

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
	}

	@Override
	public void deleteContratasObraById(int id) {
		// Invocar procedure para generar el codigo de obra
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteContratasObra");
		query.registerStoredProcedureParameter("idContratasObra", Integer.class, ParameterMode.IN);
		// set input parameter
		query.setParameter("idContratasObra", id);
		// Execute query
		query.execute();
	}

	@Override
	public List<ContratasObraDTO> findAllContratasObras() {
		// XXX Auto-generated method stub
		return null;
	}

}
