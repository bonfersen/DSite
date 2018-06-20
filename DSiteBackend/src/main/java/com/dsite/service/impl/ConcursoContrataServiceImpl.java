package com.dsite.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.ConcursoContrata;
import com.dsite.domain.model.entities.Contrata;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.ConcursoContrataJPARepository;
import com.dsite.domain.model.repository.jpa.ContrataJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.ConcursoContrataDTO;
import com.dsite.service.intf.ConcursoContrataService;
import com.dsite.util.ValidateUtil;

@Service
public class ConcursoContrataServiceImpl implements ConcursoContrataService {
	
	@Autowired
	ConcursoContrataJPARepository concursoContrataJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;
	
	@Autowired
	ContrataJPARepository contrataJPARepository;

	@Autowired
	Mapper mapper;
	
	@Override
	public ConcursoContrataDTO findById(int id) {
		ConcursoContrataDTO concursoContrataDTO = new ConcursoContrataDTO();
		ConcursoContrata concursoContrataEntity = concursoContrataJPARepository.findOne(id);
		mapper.map(concursoContrataEntity, concursoContrataDTO);
		return concursoContrataDTO;
	}

	@Override
	public List<ConcursoContrataDTO> findAllConcursoContratas() {
		return null;
	}

	@Override
	public void createConcursoContrata(ConcursoContrataDTO concursoContrataDTO) {
		ConcursoContrata concursoContrataEntity = new ConcursoContrata();
		mapper.map(concursoContrataDTO, concursoContrataEntity);

		// Ingresar datos a la entidad
		concursoContrataEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getUsuarioCreacion()))
			concursoContrataEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateConcursoContrata(concursoContrataDTO, concursoContrataEntity);
	}

	@Override
	public void updateConcursoContrata(ConcursoContrataDTO concursoContrataDTO) {
		ConcursoContrata concursoContrataEntity = new ConcursoContrata();
		if (ValidateUtil.isNotEmpty(concursoContrataDTO.getIdConcursoContrata()))
			concursoContrataEntity = concursoContrataJPARepository.findOne(concursoContrataDTO.getIdConcursoContrata());
		concursoContrataDTO.setFechaCreacion(concursoContrataEntity.getFechaCreacion());
		concursoContrataDTO.setUsuarioCreacion(concursoContrataEntity.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(concursoContrataDTO.getCodigoConcurso()))
			concursoContrataDTO.setCodigoConcurso(concursoContrataEntity.getCodigoConcurso());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getFechaFinAbjudicacion()))
			concursoContrataDTO.setFechaFinAbjudicacion(concursoContrataEntity.getFechaFinAbjudicacion());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getFechaInicioAbjudicacion()))
			concursoContrataDTO.setFechaInicioAbjudicacion(concursoContrataEntity.getFechaInicioAbjudicacion());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getImporteAbjudicado()))
			concursoContrataDTO.setImporteAbjudicado(concursoContrataEntity.getImporteAbjudicado());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getPorcentajeFondoGarantia()))
			concursoContrataDTO.setPorcentajeFondoGarantia(concursoContrataEntity.getPorcentajeFondoGarantia());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getTiempoFondoGarantia()))
			concursoContrataDTO.setTiempoFondoGarantia(concursoContrataEntity.getTiempoFondoGarantia());
		
		// Ingresar datos a la entidad
		mapper.map(concursoContrataDTO, concursoContrataEntity);
		concursoContrataEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(concursoContrataDTO.getUsuarioModificacion()))
			concursoContrataEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateConcursoContrata(concursoContrataDTO, concursoContrataEntity);
	}

	private void createUpdateConcursoContrata(ConcursoContrataDTO concursoContrataDTO, ConcursoContrata concursoContrataEntity) {
		if (ValidateUtil.isNotEmpty(concursoContrataDTO.getIdContrata())) {
			Contrata contrata = contrataJPARepository.findOne(concursoContrataDTO.getIdContrata());
			concursoContrataEntity.setContrata(contrata);
		}
		if (ValidateUtil.isNotEmpty(concursoContrataDTO.getIdTGArea())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(concursoContrataDTO.getIdTGArea());
			concursoContrataEntity.setTablaGeneralArea(tablaGeneral);
		}		
		concursoContrataJPARepository.save(concursoContrataEntity);
		concursoContrataJPARepository.flush();
	}

	@Override
	public void deleteConcursoContrataById(int id) {
		// XXX Auto-generated method stub

	}

}
