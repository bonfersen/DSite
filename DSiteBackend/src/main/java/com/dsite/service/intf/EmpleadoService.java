package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.NotificacionDTO;

public interface EmpleadoService {

	EmpleadoDTO findById(int id);

	List<EmpleadoDTO> findAllEmpleados();
	
	List<EmpleadoDTO> findResponsableObra();
	
	NotificacionDTO createEmpleado(EmpleadoDTO empleadoDTO);
	
	NotificacionDTO updateEmpleado(EmpleadoDTO empleadoDTO);
}
