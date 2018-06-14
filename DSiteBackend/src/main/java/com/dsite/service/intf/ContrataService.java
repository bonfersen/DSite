package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ContrataDTO;

public interface ContrataService {

	ContrataDTO findById(int id);
	
	List<ContrataDTO> findAllContratas();

	void saveContrata(ContrataDTO ContrataDTO);

	void updateContrata(ContrataDTO ContrataDTO);

	void deleteContrataById(int id);
}
