package com.dsite.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.EmpleadoAreaObra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.EmpleadoAreaObraJPARepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.dto.model.EmpleadoAreaObraDTO;
import com.dsite.service.intf.EmpleadoAreaObraService;
import com.dsite.util.ValidateUtil;

@Service
public class EmpleadoAreaObraServiceImpl implements EmpleadoAreaObraService {

	@Autowired
	EmpleadoAreaObraJPARepository empleadoAreaObraJPARepository;

	@Autowired
	EmpleadoJPARepository empleadoJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	Mapper mapper;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EmpleadoAreaObraDTO findById(int id) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void createEmpleadoAreaObra(EmpleadoAreaObraDTO empleadoAreaObraDTO) {
		EmpleadoAreaObra empleadoAreaObraEntity = new EmpleadoAreaObra();
		mapper.map(empleadoAreaObraDTO, empleadoAreaObraEntity);

		/*
		 * Ingresar datos a la entidad
		 */
		createUpdateEmpleadoAreaObra(empleadoAreaObraDTO, empleadoAreaObraEntity);
	}

	@Override
	public void updateEmpleadoAreaObra(EmpleadoAreaObraDTO empleadoAreaObraDTO) {
		EmpleadoAreaObra empleadoAreaObraEntity = new EmpleadoAreaObra();
		if (ValidateUtil.isNotEmpty(empleadoAreaObraDTO.getIdEmpleadoAreaObra())) {
			empleadoAreaObraEntity = empleadoAreaObraJPARepository.findOne(empleadoAreaObraDTO.getIdEmpleadoAreaObra());
		}
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(empleadoAreaObraDTO.getActivo()))
			empleadoAreaObraDTO.setActivo(empleadoAreaObraEntity.getActivo());

		// Ingresar datos a la entidad
		mapper.map(empleadoAreaObraDTO, empleadoAreaObraEntity);
		createUpdateEmpleadoAreaObra(empleadoAreaObraDTO, empleadoAreaObraEntity);
	}

	private void createUpdateEmpleadoAreaObra(EmpleadoAreaObraDTO empleadoAreaObraDTO, EmpleadoAreaObra empleadoAreaObraEntity) {
		if (ValidateUtil.isNotEmpty(empleadoAreaObraDTO.getIdTGEmpleadoAreaObra())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(empleadoAreaObraDTO.getIdTGEmpleadoAreaObra());
			empleadoAreaObraEntity.setTablaGeneralEmpleadoAreaObra(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(empleadoAreaObraDTO.getIdEmpleado())) {
			Empleado empleado = empleadoJPARepository.findOne(empleadoAreaObraDTO.getIdEmpleado());
			empleadoAreaObraEntity.setEmpleado(empleado);
		}
		empleadoAreaObraJPARepository.save(empleadoAreaObraEntity);
		empleadoAreaObraJPARepository.flush();
	}

	@Override
	public void deleteEmpleadoAreaObraByIdEmpleado(int id) {
		// Invocar procedure para generar el codigo de obra
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteEmpleadoAreaObraByIdEmpleado");
		query.registerStoredProcedureParameter("IdEmpleado", Integer.class, ParameterMode.IN);
		// set input parameter
		query.setParameter("IdEmpleado", id);
		// Execute query
		query.execute();
	}
}
