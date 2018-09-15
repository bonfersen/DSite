package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ContrataDTO;
import com.dsite.dto.model.NotificacionDTO;

public interface ContrataService {

	ContrataDTO findById(int id);
	
	List<ContrataDTO> findAllContratas();
	
	void createContrata(ContrataDTO contrataDTO);
	
	void updateContrata(ContrataDTO contrataDTO);
	
	NotificacionDTO deleteContrataById(int id);
}
