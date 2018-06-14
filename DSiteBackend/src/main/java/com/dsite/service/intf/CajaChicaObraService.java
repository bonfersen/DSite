package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.CajaChicaObraDTO;

public interface CajaChicaObraService {

	CajaChicaObraDTO findById(int id);
	
	void createCajaChicaObra(CajaChicaObraDTO CajaChica);
	
	void updateCajaChicaObra(CajaChicaObraDTO CajaChica);
	
	void deleteCajaChicaObraById(int id);

	List<CajaChicaObraDTO> findAllCajaChicaObra(); 
	
	public boolean isCajaChicaObraExist(CajaChicaObraDTO CajaChica);
}
