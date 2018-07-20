package com.dsite.service.intf;

import com.dsite.domain.model.entities.CajaChicaObra;
import com.dsite.dto.model.CajaChicaObraDTO;

public interface CajaChicaObraService {

	CajaChicaObraDTO findById(int id);
	
	void createCajaChicaObra(CajaChicaObraDTO CajaChica);
	
	void updateCajaChicaObra(CajaChicaObraDTO CajaChica);
	
	void deleteCajaChicaObraById(int id);

	void updateCajaChicaObraEntity(CajaChicaObra cajaChicaObra);
}
