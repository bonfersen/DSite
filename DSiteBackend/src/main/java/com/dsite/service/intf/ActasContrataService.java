package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ActasContrataDTO;

public interface ActasContrataService {

	ActasContrataDTO findById(int id);

	void createActasContrata(ActasContrataDTO ActasContrataDTO);

	void updateActasContrata(ActasContrataDTO ActasContrataDTO);

	void deleteActasContrataById(int id);

	List<ActasContrataDTO> findAllActasContratas();
}
