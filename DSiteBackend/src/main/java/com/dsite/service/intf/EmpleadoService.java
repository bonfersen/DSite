package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.EmpleadoDTO;

public interface EmpleadoService {

	EmpleadoDTO findById(int id);
	
	EmpleadoDTO findByName(String name);
	
	void saveEmpleado(EmpleadoDTO empleado);
	
	void updateEmpleado(EmpleadoDTO empleado);
	
	void deleteEmpleadoById(long id);

	List<EmpleadoDTO> findAllEmpleados();
	
	List<EmpleadoDTO> findResponsableObra();
	
	public boolean isEmpleadoExist(EmpleadoDTO empleado);
}
