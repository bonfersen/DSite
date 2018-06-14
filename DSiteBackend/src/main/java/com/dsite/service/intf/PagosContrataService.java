package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.PagosContrataDTO;

public interface PagosContrataService {

	PagosContrataDTO findById(int id);
	
	List<PagosContrataDTO> findAllPagosContratas();

	void createPagosContrata(PagosContrataDTO pagosContrataDTO);

	void updatePagosContrata(PagosContrataDTO pagosContrataDTO);

	void deletePagosContrataById(int id);
}
