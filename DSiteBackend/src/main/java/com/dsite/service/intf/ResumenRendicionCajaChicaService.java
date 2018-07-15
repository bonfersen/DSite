package com.dsite.service.intf;

import com.dsite.domain.model.entities.ResumenRendicionCajaChica;
import com.dsite.dto.model.ResumenRendicionCajaChicaDTO;

public interface ResumenRendicionCajaChicaService {

	ResumenRendicionCajaChicaDTO findById(int id);
	
	ResumenRendicionCajaChica createResumenRendicionCajaChica(ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO);

	void updateResumenRendicionCajaChica(ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO);

}