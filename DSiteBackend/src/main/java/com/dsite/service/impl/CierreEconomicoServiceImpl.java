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
import com.dsite.domain.model.entities.CierreEconomico;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jdbc.CierreEconomicoJDBCRepository;
import com.dsite.domain.model.repository.jpa.CierreEconomicoJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.CierreEconomicoDTO;
import com.dsite.service.intf.CierreEconomicoService;
import com.dsite.util.ValidateUtil;

@Service
public class CierreEconomicoServiceImpl implements CierreEconomicoService {

	@Autowired
	CierreEconomicoJDBCRepository cierreEconomicoJDBCRepository;

	@Autowired
	CierreEconomicoJPARepository cierreEconomicoJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJPARepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	Mapper mapper;

	@Override
	public CierreEconomicoDTO findById(Integer id) {
		CierreEconomicoDTO dto = new CierreEconomicoDTO();
		dto.setIdCierreEconomico(id);
		List<CierreEconomicoDTO> lstDTO = cierreEconomicoJDBCRepository.findCierreEconomicoByCriteria(dto);
		if (lstDTO.size() > 0)
			return lstDTO.get(0);
		else
			return null;
	}

	@Transactional
	public CierreEconomico createCierreEconomico(CierreEconomicoDTO cierreEconomicoDTO) {
		CierreEconomico cierreEconomicoEntidad = new CierreEconomico();
		mapper.map(cierreEconomicoDTO, cierreEconomicoEntidad);

		// Invocar procedure para generar el codigo de obra
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getCodigoCierreEconomico");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
		// Execute query
		query.execute();
		// Get output parameters
		String codigoCierre = (String) query.getOutputParameterValue(1);
		// Establecer codigos
		cierreEconomicoEntidad.setCodigoCierre(codigoCierre);

		// Ingresar datos a la entidad
		cierreEconomicoEntidad.setFechaCreacion(new Date());
		cierreEconomicoEntidad.setFechaAsignacion(new Date());
		if (ValidateUtil.isEmpty(cierreEconomicoDTO.getUsuarioCreacion()))
			cierreEconomicoEntidad.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		if (ValidateUtil.isEmpty(cierreEconomicoDTO.getIdUsuarioAsignacion()))
			cierreEconomicoEntidad.setUsuarioAsignacion(usuario);
		TablaGeneral tablaGeneralEstadoCierreEconomico = tablaGeneralJPARepository.findOne(DSiteCoreConstants.ESTADO_CIERRE_ECONOMICO_PENDIENTE);
		cierreEconomicoEntidad.setTablaGeneralEstadoCierreEconomico(tablaGeneralEstadoCierreEconomico);
		
		createUpdateCierreEconomico(cierreEconomicoDTO, cierreEconomicoEntidad);
		
		return cierreEconomicoEntidad;
	}

	@Transactional
	public void updateCierreEconomico(CierreEconomicoDTO cierreEconomicoDTO) {
		CierreEconomico cierreEconomicoEntidad = new CierreEconomico();
		if (ValidateUtil.isNotEmpty(cierreEconomicoDTO.getIdCierreEconomico()))
			cierreEconomicoEntidad = cierreEconomicoJPARepository.findOne(cierreEconomicoDTO.getIdCierreEconomico());
		/*
		 * Validar DTO
		 */
		cierreEconomicoDTO.setFechaCreacion(cierreEconomicoEntidad.getFechaCreacion());
		cierreEconomicoDTO.setUsuarioCreacion(cierreEconomicoEntidad.getUsuarioCreacion());
		if (ValidateUtil.isEmpty(cierreEconomicoDTO.getCodigoCierre()))
			cierreEconomicoDTO.setCodigoCierre(cierreEconomicoEntidad.getCodigoCierre());
		if (ValidateUtil.isEmpty(cierreEconomicoDTO.getFechaAsignacion()))
			cierreEconomicoDTO.setFechaAsignacion(cierreEconomicoEntidad.getFechaAsignacion());

		// Ingresar datos a la entidad
		mapper.map(cierreEconomicoDTO, cierreEconomicoEntidad);

		createUpdateCierreEconomico(cierreEconomicoDTO, cierreEconomicoEntidad);
	}

	private void createUpdateCierreEconomico(CierreEconomicoDTO cierreEconomicoDTO, CierreEconomico cierreEconomicoEntidad) {

		if (ValidateUtil.isNotEmpty(cierreEconomicoDTO.getIdTGEstadoCierreEconomico())) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(cierreEconomicoDTO.getIdTGEstadoCierreEconomico());
			cierreEconomicoEntidad.setTablaGeneralEstadoCierreEconomico(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(cierreEconomicoDTO.getIdUsuarioAsignacion())) {
			Usuario usuario = usuarioJPARepository.findOne(cierreEconomicoDTO.getIdUsuarioAsignacion());
			cierreEconomicoEntidad.setUsuarioAsignacion(usuario);
		}
		cierreEconomicoJPARepository.save(cierreEconomicoEntidad);
		cierreEconomicoJPARepository.flush();
	}

	@Override
	public void deleteCierreEconomicoById(Integer id) {
		// XXX Auto-generated method stub

	}

}
