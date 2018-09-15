package com.dsite.service.impl;

import static java.util.stream.Collectors.toList;

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
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.TablaGeneralDTO;
import com.dsite.service.intf.TablaGeneralService;
import com.dsite.util.ValidateUtil;

@Service
public class TablaGeneralServiceImpl implements TablaGeneralService {

	@Autowired
	Mapper mapper;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJPARepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TablaGeneralDTO findById(String id) {
		TablaGeneralDTO tgDTO= new TablaGeneralDTO();
		TablaGeneral tgEntity = tablaGeneralJPARepository.findOne(id);
        mapper.map(tgEntity, tgDTO);
		return tgDTO;
	}

	@Override
	public List<TablaGeneralDTO> findByCategoria(String categoria) {
		List<TablaGeneral> entities;
		List<TablaGeneralDTO> itemsDTO;

		entities = tablaGeneralJPARepository.findByCategoria(categoria);
		itemsDTO = entities.stream().map(m -> mapper.map(m, TablaGeneralDTO.class)).collect(toList());

		return itemsDTO;
	}

	@Override
	public TablaGeneralDTO findByCategoriaAndCodigo(String categoria, String idTablaGeneral) {
		TablaGeneral entities;
		TablaGeneralDTO itemDTO = null;

		entities = tablaGeneralJPARepository.findByCategoriaAndCodigo(categoria, idTablaGeneral);
		mapper.map(entities, itemDTO);

		return itemDTO;
	}

	@Override
	public List<TablaGeneralDTO> findByCategoriaAndCodigoPadre(String categoria, String idTablaGeneralPadre) {
		List<TablaGeneral> entities;
		List<TablaGeneralDTO> itemsDTO;

		entities = tablaGeneralJPARepository.findByCategoriaAndCodigoPadre(categoria, idTablaGeneralPadre);
		itemsDTO = entities.stream().map(m -> mapper.map(m, TablaGeneralDTO.class)).collect(toList());

		return itemsDTO;
	}

	@Transactional
	public void createTablaGeneral(TablaGeneralDTO tablaGeneralDTO) {
		TablaGeneral tablaGeneralEntity = new TablaGeneral();
		mapper.map(tablaGeneralDTO, tablaGeneralEntity);

		// Invocar procedure para generar el codigo de tablaGeneral
		StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("getCodigoTG");
		sp.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
		// Execute query
		sp.setParameter(1, tablaGeneralDTO.getCategoria());
		sp.execute();
		// Get output parameters
		String idTablaGeneralOut = (String) sp.getOutputParameterValue(2);

		/*
		 * Ingresar datos a la entidad
		 */
		tablaGeneralEntity.setIdTablaGeneral(idTablaGeneralOut);
		tablaGeneralEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(tablaGeneralDTO.getUsuarioCreacion()))
			tablaGeneralEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
		createUpdatetablaGeneral(tablaGeneralDTO, tablaGeneralEntity);
	}

	@Transactional
	public void updateTablaGeneral(TablaGeneralDTO tablaGeneralDTO) {
		TablaGeneral tablaGeneralEntity = new TablaGeneral();
		if (ValidateUtil.isNotEmpty(tablaGeneralDTO.getIdTablaGeneral())) {
			tablaGeneralEntity = tablaGeneralJPARepository.findOne(tablaGeneralDTO.getIdTablaGeneral());
		}
		tablaGeneralDTO.setFechaCreacion(tablaGeneralEntity.getFechaCreacion());
		tablaGeneralDTO.setUsuarioCreacion(tablaGeneralEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(tablaGeneralDTO.getActivo()))
			tablaGeneralDTO.setActivo(tablaGeneralEntity.getActivo());
		if (ValidateUtil.isEmpty(tablaGeneralDTO.getCategoria()))
			tablaGeneralDTO.setCategoria(tablaGeneralEntity.getCategoria());
		if (ValidateUtil.isEmpty(tablaGeneralDTO.getDescripcion()))
			tablaGeneralDTO.setDescripcion(tablaGeneralEntity.getDescripcion());

		// Ingresar datos a la entidad
		mapper.map(tablaGeneralDTO, tablaGeneralEntity);
		tablaGeneralEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(tablaGeneralDTO.getUsuarioModificacion()))
			tablaGeneralEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdatetablaGeneral(tablaGeneralDTO, tablaGeneralEntity);
	}

	private void createUpdatetablaGeneral(TablaGeneralDTO tablaGeneralDTO, TablaGeneral tablaGeneralEntity) {
		// Categoria
		if (ValidateUtil.isNotEmpty(tablaGeneralDTO.getIdTGPadre())) {
			TablaGeneral tablaGeneral = tablaGeneralJPARepository.findOne(tablaGeneralDTO.getIdTGPadre());
			tablaGeneralEntity.setTablaGeneralPadre(tablaGeneral);
		}

		tablaGeneralJPARepository.save(tablaGeneralEntity);
		tablaGeneralJPARepository.flush();
	}
}
