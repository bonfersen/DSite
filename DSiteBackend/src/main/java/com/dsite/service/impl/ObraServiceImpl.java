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
import com.dsite.domain.model.entities.Distrito;
import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.Obra;
import com.dsite.domain.model.entities.PresupuestoObra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.DistritoJPARepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.ObraJPARepository;
import com.dsite.domain.model.repository.jpa.PresupuestoObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.JsonResult;
import com.dsite.dto.model.ObraDTO;
import com.dsite.service.intf.ObraService;
import com.dsite.util.ValidateUtil;

@Service
public class ObraServiceImpl implements ObraService {

	@Autowired
	ObraJPARepository obraJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	DistritoJPARepository distritoJpaRepository;

	@Autowired
	EmpleadoJPARepository empleadoJpaRepository;

	@Autowired
	PresupuestoObraJPARepository presupuestoObraJPARepository;

	@Autowired
	Mapper mapper;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ObraDTO findById(int id) {
		ObraDTO obraDTO = new ObraDTO();
		Obra obraEntity = obraJPARepository.findOne(id);
		mapper.map(obraEntity, obraDTO);
		return obraDTO;
	}

	@Override
	public ObraDTO findByCodigoDSite(String codDSite) {
		ObraDTO obraDTO = new ObraDTO();
		Obra obraEntity = obraJPARepository.findCodDSite(codDSite);
		mapper.map(obraEntity, obraDTO);

		// Ingresar datos al DTO
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralArea())) {
			obraDTO.setIdTGArea(obraEntity.getTablaGeneralArea().getIdTablaGeneral());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralAreaSoporte())) {
			obraDTO.setIdTGAreaSoporte(obraEntity.getTablaGeneralAreaSoporte().getIdTablaGeneral());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralProyecto())) {
			obraDTO.setIdTGProyecto(obraEntity.getTablaGeneralProyecto().getIdTablaGeneral());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralTipoGasto())) {
			obraDTO.setIdTGTipoGasto(obraEntity.getTablaGeneralTipoGasto().getIdTablaGeneral());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralEstadoObra())) {
			obraDTO.setIdTGEstadoObra(obraEntity.getTablaGeneralEstadoObra().getIdTablaGeneral());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralGerenteProyecto())) {
			obraDTO.setIdTGGerenteProyecto(obraEntity.getTablaGeneralGerenteProyecto().getIdTablaGeneral());
		}
		// Distrito
		if (ValidateUtil.isNotEmpty(obraEntity.getDistrito())) {
			obraDTO.setIdDistrito(obraEntity.getDistrito().getIdDistrito());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getTablaGeneralGestorProyecto())) {
			obraDTO.setIdTGGestorProyecto(obraEntity.getTablaGeneralGestorProyecto().getIdTablaGeneral());
		}
		if (ValidateUtil.isNotEmpty(obraEntity.getEmpleado())) {
			obraDTO.setIdEmpleadoResponsableObra(obraEntity.getEmpleado().getIdEmpleado());
		}

		return obraDTO;
	}

	@Transactional
	public JsonResult createObra(ObraDTO obraDTO) {
		Obra obraEntidad = new Obra();
		JsonResult jsonResult = new JsonResult();
		mapper.map(obraDTO, obraEntidad);
		
		// Invocar procedure para generar el codigo de obra
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getCodigoDSite");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
		// Execute query
		query.execute();
		// Get output parameters
		String codigoDSite = (String) query.getOutputParameterValue(1);
		String codigoCellusat = (String) query.getOutputParameterValue(2);
		// Establecer codigos
		obraEntidad.setCodigoDSite(codigoDSite);
		obraEntidad.setCodigoCellusat(codigoCellusat);

		// Ingresar datos a la entidad
		obraEntidad.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(obraDTO.getUsuarioCreacion()))
			obraEntidad.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateObra(obraDTO, obraEntidad);

		// Crear registro en presupuesto Obra
		PresupuestoObra presupuestoObra = new PresupuestoObra();
		presupuestoObra.setFechaCreacion(new Date());
		presupuestoObra.setObra(obraEntidad);
		TablaGeneral tablaGeneralEF = tablaGeneralJpaRepository.findOne(DSiteCoreConstants.ESTADO_FINANZA_PENDIENTE);
		presupuestoObra.setTablaGeneralEstadoFinanzas(tablaGeneralEF);
		presupuestoObra.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		
		presupuestoObraJPARepository.save(presupuestoObra);
		
		jsonResult.setCodigo(codigoDSite);
		return jsonResult;
	}

	@Transactional
	public JsonResult updateObra(ObraDTO obraDTO) {
		Obra obraEntidad = new Obra();
		JsonResult jsonResult = new JsonResult();
		if (ValidateUtil.isNotEmpty(obraDTO.getIdObra()))
			obraEntidad = obraJPARepository.findOne(obraDTO.getIdObra());
		obraDTO.setFechaCreacion(obraEntidad.getFechaCreacion());
		obraDTO.setCodigoDSite(obraEntidad.getCodigoDSite());
		obraDTO.setCodigoCellusat(obraEntidad.getCodigoCellusat());
				
		// Ingresar datos a la entidad
		mapper.map(obraDTO, obraEntidad);
		obraEntidad.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(obraDTO.getUsuarioModificacion()))
			obraEntidad.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateObra(obraDTO, obraEntidad);
		
		jsonResult.setCodigo(obraEntidad.getCodigoDSite());
		return jsonResult;
	}

	private void createUpdateObra(ObraDTO obraDTO, Obra obraEntidad) {
		
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGArea())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGArea());
			obraEntidad.setTablaGeneralArea(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGAreaSoporte())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGAreaSoporte());
			obraEntidad.setTablaGeneralAreaSoporte(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGProyecto())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGProyecto());
			obraEntidad.setTablaGeneralProyecto(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGGerenteProyecto())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGGerenteProyecto());
			obraEntidad.setTablaGeneralGerenteProyecto(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGGestorProyecto())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGGestorProyecto());
			obraEntidad.setTablaGeneralGestorProyecto(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGTipoGasto())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGTipoGasto());
			obraEntidad.setTablaGeneralTipoGasto(tablaGeneral);
		}
		// Distrito
		if (ValidateUtil.isNotEmpty(obraDTO.getIdDistrito())) {
			Distrito distrito = distritoJpaRepository.findOne(obraDTO.getIdDistrito());
			obraEntidad.setDistrito(distrito);
		}
		if (ValidateUtil.isNotEmpty(obraDTO.getIdTGEstadoObra())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(obraDTO.getIdTGEstadoObra());
			obraEntidad.setTablaGeneralEstadoObra(tablaGeneral);
		}
		// Responsable Obra
		if (ValidateUtil.isNotEmpty(obraDTO.getIdEmpleadoResponsableObra())) {
			Empleado empleado = empleadoJpaRepository.findOne(obraDTO.getIdEmpleadoResponsableObra());
			obraEntidad.setEmpleado(empleado);
		}
		obraJPARepository.save(obraEntidad);
		obraJPARepository.flush();		
	}

	@Override
	public void deleteObraById(long id) {

	}

	@Override
	public List<ObraDTO> findAllObras() {

		return null;
	}

	@Override
	public boolean isObraExist(ObraDTO Obra) {

		return false;
	}
}
