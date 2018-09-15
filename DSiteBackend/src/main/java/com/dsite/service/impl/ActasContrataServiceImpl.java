package com.dsite.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.ActasContrata;
import com.dsite.domain.model.entities.ContratasObra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.ActasContrataJPARepository;
import com.dsite.domain.model.repository.jpa.ContratasObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.ActasContrataDTO;
import com.dsite.service.intf.ActasContrataService;
import com.dsite.util.ValidateUtil;

@Service
public class ActasContrataServiceImpl implements ActasContrataService {

	@Autowired
	ActasContrataJPARepository actasContrataJPARepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	ContratasObraJPARepository contratasObraJPARepository;

	@Autowired
	Mapper mapper;

	@Override
	public ActasContrataDTO findById(int id) {
		ActasContrataDTO actasContrataDTO = new ActasContrataDTO();
		ActasContrata actasContrataEntity = actasContrataJPARepository.findOne(id);
		mapper.map(actasContrataEntity, actasContrataDTO);
		return actasContrataDTO;
	}

	@Transactional
	public void createActasContrata(ActasContrataDTO actasContrataDTO) {
		ActasContrata actasContrataEntity = new ActasContrata();
		actasContrataDTO.setIdTGEstadoActa(DSiteCoreConstants.ESTADO_ACTA_CONTRATA_PENDIENTE);
		mapper.map(actasContrataDTO, actasContrataEntity);

		// Ingresar datos a la entidad
		actasContrataEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(actasContrataDTO.getUsuarioCreacion()))
			actasContrataEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateActasContrata(actasContrataDTO, actasContrataEntity);

	}

	@Transactional
	public void updateActasContrata(ActasContrataDTO actasContrataDTO) {
		ActasContrata actasContrataEntity = new ActasContrata();
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdActasContrata()))
			actasContrataEntity = actasContrataJPARepository.findOne(actasContrataDTO.getIdActasContrata());
		/*
		 * Validar DTO
		 */
		actasContrataDTO.setFechaCreacion(actasContrataEntity.getFechaCreacion());
		actasContrataDTO.setUsuarioCreacion(actasContrataEntity.getUsuarioCreacion());
		if (ValidateUtil.isEmpty(actasContrataDTO.getFechaAprobacion()))
			actasContrataEntity.setFechaAprobacion(new Date());
		if (ValidateUtil.isEmpty(actasContrataDTO.getFechaAdjunto()))
			actasContrataEntity.setFechaAdjunto(new Date());
		if (ValidateUtil.isEmpty(actasContrataDTO.getFechaRechazo()))
			actasContrataEntity.setFechaRechazo(new Date());

		// Ingresar datos a la entidad
		mapper.map(actasContrataDTO, actasContrataEntity);
		createUpdateActasContrata(actasContrataDTO, actasContrataEntity);
	}

	private void createUpdateActasContrata(ActasContrataDTO actasContrataDTO, ActasContrata actasContrataEntity) {
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdContratasObra())) {
			ContratasObra contratasObra = contratasObraJPARepository.findOne(actasContrataDTO.getIdContratasObra());
			actasContrataEntity.setContratasObra(contratasObra);
		}
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdTGActas())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(actasContrataDTO.getIdTGActas());
			actasContrataEntity.setTablaGeneralActas(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdTGEstadoActa())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(actasContrataDTO.getIdTGEstadoActa());
			switch (tablaGeneral.getIdTablaGeneral()) {
			case DSiteCoreConstants.ESTADO_ACTA_CONTRATA_APROBADO:
				int totalAprobadas = 1;
				List<ActasContrata> lstActasContratas = actasContrataJPARepository.findByContratasObra(actasContrataEntity.getContratasObra());
				if (lstActasContratas.size() > 0) {
					for (ActasContrata actasContrata : lstActasContratas) {
						if (actasContrata.getTablaGeneralEstadoActa().getIdTablaGeneral().compareTo(DSiteCoreConstants.ESTADO_ACTA_CONTRATA_APROBADO) == 0) {
							if (actasContrata.getIdActasContrata() != actasContrataDTO.getIdActasContrata())
								totalAprobadas++;
						}
					}
					BigDecimal porcentajeAprob = new BigDecimal(totalAprobadas).divide(new BigDecimal(lstActasContratas.size()));
					porcentajeAprob = porcentajeAprob.setScale(2, BigDecimal.ROUND_HALF_EVEN);
					/*
					 * Se actualiza el porcentaje en contratas obras
					 */
					ContratasObra contratasObra = contratasObraJPARepository.findOne(actasContrataEntity.getContratasObra().getIdContratasObra());
					contratasObra.setPorcentajeActasAprobadas(porcentajeAprob);
					contratasObraJPARepository.save(contratasObra);
					contratasObraJPARepository.flush();
				}
				break;
			default:
				break;
			}
			actasContrataEntity.setTablaGeneralEstadoActa(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdTGMotivoRechazo())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(actasContrataDTO.getIdTGMotivoRechazo());
			actasContrataEntity.setTablaGeneralMotivoRechazo(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdUsuarioRechaza())) {
			Usuario usuario = usuarioJPARepository.findOne(actasContrataDTO.getIdUsuarioRechaza());
			actasContrataEntity.setUsuarioRechaza(usuario);
		}
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdUsuarioAprueba())) {
			Usuario usuario = usuarioJPARepository.findOne(actasContrataDTO.getIdUsuarioAprueba());
			actasContrataEntity.setUsuarioAprueba(usuario);
		}
		if (ValidateUtil.isNotEmpty(actasContrataDTO.getIdUsuarioAdjunta())) {
			Usuario usuario = usuarioJPARepository.findOne(actasContrataDTO.getIdUsuarioAdjunta());
			actasContrataEntity.setUsuarioAdjunta(usuario);
		}
		actasContrataJPARepository.save(actasContrataEntity);
		actasContrataJPARepository.flush();
	}

	@Transactional
	public void deleteActasContrataById(int id) {
	}

	@Override
	public List<ActasContrataDTO> findAllActasContratas() {
		// XXX Auto-generated method stub
		return null;
	}

}
