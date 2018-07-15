package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.JsonResult;
import com.dsite.dto.model.RendicionCajaChicaDTO;
import com.dsite.dto.model.RendicionesAsignadasDTO;

public interface RendicionCajaChicaService {

	RendicionCajaChicaDTO findById(int id);
	
	void createRendicionCajaChica(RendicionCajaChicaDTO rendicionCajaChicaDTO);

	JsonResult asignarRendicion(RendicionesAsignadasDTO rendiciones);
}
