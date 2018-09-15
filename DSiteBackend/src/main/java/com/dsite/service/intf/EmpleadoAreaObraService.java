package com.dsite.service.intf;

import com.dsite.dto.model.EmpleadoAreaObraDTO;

public interface EmpleadoAreaObraService {

	EmpleadoAreaObraDTO findById(int id);
	
	void createEmpleadoAreaObra(EmpleadoAreaObraDTO usuarioDTO);
	
	void updateEmpleadoAreaObra(EmpleadoAreaObraDTO usuarioDTO);
	
	void deleteEmpleadoAreaObraByIdEmpleado(int id);
}
