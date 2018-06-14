package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.repository.jdbc.EmpleadoJDBCRepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.service.intf.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
    EmpleadoJPARepository empleadoJPARepository;
	
	@Autowired
    EmpleadoJDBCRepository empleadoJDBCRepository;
	
	@Autowired
	Mapper mapper;
	
	public EmpleadoDTO findById(int id) {
		EmpleadoDTO empleadoDTO= new EmpleadoDTO();
        Empleado empleadoEntity = empleadoJPARepository.findOne(id);
        mapper.map(empleadoEntity, empleadoDTO);
		return empleadoDTO;
	}

	@Override
	public EmpleadoDTO findByName(String name) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmpleado(EmpleadoDTO empleado) {
		// XXX Auto-generated method stub

	}

	@Override
	public void updateEmpleado(EmpleadoDTO empleado) {
		// XXX Auto-generated method stub

	}

	@Override
	public void deleteEmpleadoById(long id) {
		// XXX Auto-generated method stub

	}

	public List<EmpleadoDTO> findAllEmpleados() {
		EmpleadoDTO dto = new EmpleadoDTO();
		List<EmpleadoDTO> lstDTO = empleadoJDBCRepository.findEmpleadoByCriteria(dto);		 
		return lstDTO ;
	}

	public List<EmpleadoDTO> findResponsableObra() {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.setResponsableObra("1");
		List<EmpleadoDTO> lstDTO = empleadoJDBCRepository.findEmpleadoByCriteria(dto);		 
		return lstDTO ;
	}
	
	@Override
	public boolean isEmpleadoExist(EmpleadoDTO empleado) {
		// XXX Auto-generated method stub
		return false;
	}

}
