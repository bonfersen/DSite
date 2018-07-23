package com.dsite.service.intf;

import com.dsite.domain.model.entities.CajaChicaObra;
import com.dsite.dto.model.CajaChicaObraDTO;
import com.dsite.dto.model.NotificacionDTO;

public interface CajaChicaObraService {

	CajaChicaObraDTO findById(int id);
	
	void createCajaChicaObra(CajaChicaObraDTO CajaChica);
	
	void updateCajaChicaObra(CajaChicaObraDTO CajaChica);
	
	NotificacionDTO deleteCajaChicaObraById(int id);

	void updateCajaChicaObraEntity(CajaChicaObra cajaChicaObra);
}
