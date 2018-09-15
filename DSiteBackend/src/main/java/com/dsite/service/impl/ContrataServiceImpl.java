package com.dsite.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Contrata;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jdbc.ContrataJDBCRepository;
import com.dsite.domain.model.repository.jpa.ContrataJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.ContrataDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.ContrataService;
import com.dsite.util.ValidateUtil;

@Service
public class ContrataServiceImpl implements ContrataService {

	@Autowired
	ContrataJPARepository contrataJPARepository;

	@Autowired
	ContrataJDBCRepository contrataJDBCRepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;
	
	@Autowired
	Mapper mapper;

	@Override
	public ContrataDTO findById(int id) {
		ContrataDTO dto = new ContrataDTO();
		dto.setIdContrata(id);
		List<ContrataDTO> lstDTO = contrataJDBCRepository.findContrataByCriteria(dto);
		return (lstDTO.size() > 0) ? lstDTO.get(0) : null;
	}

	@Override
	public List<ContrataDTO> findAllContratas() {
		ContrataDTO dto = new ContrataDTO();
		List<ContrataDTO> lstDTO = contrataJDBCRepository.findContrataByCriteria(dto);
		return lstDTO;
	}

	@Override
	public void createContrata(ContrataDTO contrataDTO) {
		Contrata contrataEntity = new Contrata();
		mapper.map(contrataDTO, contrataEntity);

		/*
		 * Ingresar datos a la entidad
		 */
		contrataEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(contrataDTO.getUsuarioCreacion()))
			contrataEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		createUpdateContrata(contrataDTO, contrataEntity);
	}

	@Override
	public void updateContrata(ContrataDTO contrataDTO) {
		Contrata contrataEntity = new Contrata();
		if (ValidateUtil.isNotEmpty(contrataDTO.getIdContrata())) {
			contrataEntity = contrataJPARepository.findOne(contrataDTO.getIdContrata());
		}
		contrataDTO.setFechaCreacion(contrataEntity.getFechaCreacion());
		contrataDTO.setUsuarioCreacion(contrataEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(contrataDTO.getNombreCorto()))
			contrataDTO.setNombreCorto(contrataEntity.getNombreCorto());
		if (ValidateUtil.isEmpty(contrataDTO.getRazonSocial()))
			contrataDTO.setRazonSocial(contrataEntity.getRazonSocial());
		if (ValidateUtil.isEmpty(contrataDTO.getRuc()))
			contrataDTO.setRuc(contrataEntity.getRuc());
		if (ValidateUtil.isEmpty(contrataDTO.getDireccion()))
			contrataDTO.setDireccion(contrataEntity.getDireccion());		
		if (ValidateUtil.isEmpty(contrataDTO.getActivo()))
			contrataDTO.setActivo(contrataEntity.getActivo());
		if (ValidateUtil.isEmpty(contrataDTO.getImporteTotalPendientePago()))
			contrataDTO.setImporteTotalPendientePago(contrataEntity.getImporteTotalPendientePago());

		// Ingresar datos a la entidad
		mapper.map(contrataDTO, contrataEntity);
		contrataEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(contrataDTO.getUsuarioModificacion()))
			contrataEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateContrata(contrataDTO, contrataEntity);
	}
	
	private void createUpdateContrata(ContrataDTO contrataDTO, Contrata contrataEntity) {
		// Categoria
		if (ValidateUtil.isNotEmpty(contrataDTO.getIdTGCategoria())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(contrataDTO.getIdTGCategoria());
			contrataEntity.setTablaGeneralCategoria(tablaGeneral);
		}

		contrataJPARepository.save(contrataEntity);
		contrataJPARepository.flush();
	}

	@Override
	public NotificacionDTO deleteContrataById(int id) {
		return null;
	}

}
