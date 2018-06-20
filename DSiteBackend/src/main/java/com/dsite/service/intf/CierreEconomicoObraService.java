package com.dsite.service.intf;

import com.dsite.dto.model.CierreEconomicoObraDTO;

public interface CierreEconomicoObraService {

	CierreEconomicoObraDTO findById(Integer id);
	
	void createCierreEconomicoObra(CierreEconomicoObraDTO dto);
	
	void updateCierreEconomicoObra(CierreEconomicoObraDTO dto);
	
	void deleteCierreEconomicoObraById(Integer id);
}
