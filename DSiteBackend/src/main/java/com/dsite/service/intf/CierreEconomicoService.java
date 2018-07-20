package com.dsite.service.intf;

import com.dsite.domain.model.entities.CierreEconomico;
import com.dsite.dto.model.CierreEconomicoDTO;

public interface CierreEconomicoService {

	CierreEconomicoDTO findById(Integer id);
	
	CierreEconomico createCierreEconomico(CierreEconomicoDTO dto);
	
	void updateCierreEconomico(CierreEconomicoDTO dto);
	
	void deleteCierreEconomicoById(Integer id);
}
