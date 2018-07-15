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
import com.dsite.domain.model.entities.CajaChicaObra;
import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.Obra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.CajaChicaObraJPARepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.ObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.CajaChicaObraDTO;
import com.dsite.service.intf.CajaChicaObraService;
import com.dsite.util.ValidateUtil;

@Service
public class CajaChicaObraServiceImpl implements CajaChicaObraService {

	@Autowired
	CajaChicaObraJPARepository cajaChicaObraJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	EmpleadoJPARepository empleadoJpaRepository;

	@Autowired
	UsuarioJPARepository usuarioJpaRepository;

	@Autowired
	ObraJPARepository obraJPARepository;

	@Autowired
	Mapper mapper;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CajaChicaObraDTO findById(int id) {
		CajaChicaObraDTO cajaChicaObraDTO = new CajaChicaObraDTO();
		CajaChicaObra cajaChicaObraEntity = cajaChicaObraJPARepository.findOne(id);
		mapper.map(cajaChicaObraEntity, cajaChicaObraDTO);
		return cajaChicaObraDTO;
	}

	@Transactional
	public void createCajaChicaObra(CajaChicaObraDTO cajaChicaObraDTO) {
		CajaChicaObra cajaChicaObraEntity = new CajaChicaObra();
		mapper.map(cajaChicaObraDTO, cajaChicaObraEntity);

		/*
		 * Ingresar datos a la entidad
		 */
		cajaChicaObraEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getUsuarioCreacion()))
			cajaChicaObraEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		// Estado de Caja
		TablaGeneral tablaGeneralEstadoCajaChica = new TablaGeneral();
		tablaGeneralEstadoCajaChica.setIdTablaGeneral(DSiteCoreConstants.ESTADO_CAJA_CHICA_SOLICITADO);
		cajaChicaObraEntity.setTablaGeneralEstadoCajaChica(tablaGeneralEstadoCajaChica);
		cajaChicaObraEntity.setFechaSolicitud(new Date());

		createUpdateCajaChicaObra(cajaChicaObraDTO, cajaChicaObraEntity);
	}

	@Transactional
	public void updateCajaChicaObra(CajaChicaObraDTO cajaChicaObraDTO) {
		CajaChicaObra cajaChicaObraEntity = new CajaChicaObra();
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdCajaChicaObra())) {
			cajaChicaObraEntity = cajaChicaObraJPARepository.findOne(cajaChicaObraDTO.getIdCajaChicaObra());
		}
		cajaChicaObraDTO.setFechaCreacion(cajaChicaObraEntity.getFechaCreacion());
		cajaChicaObraDTO.setUsuarioCreacion(cajaChicaObraEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getDetalle()))
			cajaChicaObraDTO.setDetalle(cajaChicaObraEntity.getDetalle());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getFechaAprobacion()))
			cajaChicaObraDTO.setFechaAprobacion(cajaChicaObraEntity.getFechaAprobacion());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getFechaModificacion()))
			cajaChicaObraDTO.setFechaModificacion(cajaChicaObraEntity.getFechaModificacion());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getFechaPago()))
			cajaChicaObraDTO.setFechaPago(cajaChicaObraEntity.getFechaPago());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getFechaRechazo()))
			cajaChicaObraDTO.setFechaRechazo(cajaChicaObraEntity.getFechaRechazo());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getFechaSolicitud()))
			cajaChicaObraDTO.setFechaSolicitud(cajaChicaObraEntity.getFechaSolicitud());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getImporteCaja()))
			cajaChicaObraDTO.setImporteCaja(cajaChicaObraEntity.getImporteCaja());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getImporteTotal()))
			cajaChicaObraDTO.setImporteTotal(cajaChicaObraEntity.getImporteTotal());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getImporteViatico()))
			cajaChicaObraDTO.setImporteViatico(cajaChicaObraEntity.getImporteViatico());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getMotivoRechazo()))
			cajaChicaObraDTO.setMotivoRechazo(cajaChicaObraEntity.getMotivoRechazo());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getRendirCaja()))
			cajaChicaObraDTO.setRendirCaja(cajaChicaObraEntity.getRendirCaja());
		if (ValidateUtil.isEmpty(cajaChicaObraDTO.getRendirViatico()))
			cajaChicaObraDTO.setRendirViatico(cajaChicaObraEntity.getRendirViatico());

		// Ingresar datos a la entidad
		mapper.map(cajaChicaObraDTO, cajaChicaObraEntity);
		cajaChicaObraEntity.setFechaModificacion(new Date());

		createUpdateCajaChicaObra(cajaChicaObraDTO, cajaChicaObraEntity);
	}

	private void createUpdateCajaChicaObra(CajaChicaObraDTO cajaChicaObraDTO, CajaChicaObra cajaChicaObraEntity) {
		/*
		 * Ingresar datos a Caja Chica Obra
		 */
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdObra())) {
			Obra obra = obraJPARepository.findOne(cajaChicaObraDTO.getIdObra());
			cajaChicaObraEntity.setObra(obra);
		}
		// Sustentador
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdEmpleadoSustentador())) {
			Empleado empleadoSustentador = empleadoJpaRepository.findOne(cajaChicaObraDTO.getIdEmpleadoSustentador());
			cajaChicaObraEntity.setEmpleadoSustentador(empleadoSustentador);
		}
		// Depositar a
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdEmpleadoBeneficiario())) {
			Empleado empleadoBeneficiario = empleadoJpaRepository.findOne(cajaChicaObraDTO.getIdEmpleadoBeneficiario());
			cajaChicaObraEntity.setEmpleadoBeneficiario(empleadoBeneficiario);
		}
		// Tipo de Caja
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdTGTipoCaja())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(cajaChicaObraDTO.getIdTGTipoCaja());
			cajaChicaObraEntity.setTablaGeneralTipoCaja(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdTGEstadoCajaChica())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(cajaChicaObraDTO.getIdTGEstadoCajaChica());
			cajaChicaObraEntity.setTablaGeneralEstadoCajaChica(tablaGeneral);
			
			switch (tablaGeneral.getIdTablaGeneral()) {
			case DSiteCoreConstants.ESTADO_CAJA_CHICA_APROBADO:
				
				cajaChicaObraDTO.setFechaAprobacion(cajaChicaObraEntity.getFechaAprobacion());
				break;
			case DSiteCoreConstants.ESTADO_CAJA_CHICA_RECHAZADO:
				
				cajaChicaObraDTO.setFechaRechazo(cajaChicaObraEntity.getFechaRechazo());
				break;
			case DSiteCoreConstants.ESTADO_CAJA_CHICA_DEPOSITADO://getIdUsuarioPago
				break;
			case DSiteCoreConstants.ESTADO_CAJA_CHICA_ASIGNADO:
				break;
			default:
				break;
			}
		}
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdUsuarioSolicitud())) {
			Usuario usuario = usuarioJpaRepository.findOne(cajaChicaObraDTO.getIdUsuarioSolicitud());
			cajaChicaObraEntity.setUsuarioSolicitud(usuario);
		}
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdUsuarioAprobacion())) {
			Usuario usuario = usuarioJpaRepository.findOne(cajaChicaObraDTO.getIdUsuarioAprobacion());
			cajaChicaObraEntity.setUsuarioAprobacion(usuario);
		}
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdUsuarioPago())) {
			Usuario usuario = usuarioJpaRepository.findOne(cajaChicaObraDTO.getIdUsuarioPago());
			cajaChicaObraEntity.setUsuarioPago(usuario);
		}
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdUsuarioRechazo())) {
			Usuario usuario = usuarioJpaRepository.findOne(cajaChicaObraDTO.getIdUsuarioRechazo());
			cajaChicaObraEntity.setUsuarioRechazo(usuario);
		}
		if (ValidateUtil.isNotEmpty(cajaChicaObraDTO.getIdUsuarioModificacion())) {
			Usuario usuario = usuarioJpaRepository.findOne(cajaChicaObraDTO.getIdUsuarioModificacion());
			cajaChicaObraEntity.setUsuarioModificacion(usuario);
		}
		cajaChicaObraJPARepository.save(cajaChicaObraEntity);
		cajaChicaObraJPARepository.flush();
	}

	@Transactional
	public void deleteCajaChicaObraById(int id) {
		// Invocar procedure para generar el codigo de obra
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteCajaChicaObra");
		query.registerStoredProcedureParameter("idCajaChicaObra", Integer.class, ParameterMode.IN);
		// set input parameter
		query.setParameter("idCajaChicaObra", id);
		// Execute query
		query.execute();
	}

	@Override
	public List<CajaChicaObraDTO> findAllCajaChicaObra() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCajaChicaObraExist(CajaChicaObraDTO CajaChicaDTO) {
		// XXX Auto-generated method stub
		return false;
	}

}
