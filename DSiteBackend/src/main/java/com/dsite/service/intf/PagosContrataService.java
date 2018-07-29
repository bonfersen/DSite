package com.dsite.service.intf;

import com.dsite.dto.model.NotificacionDTO;
import com.dsite.dto.model.PagosContrataDTO;

public interface PagosContrataService {

	PagosContrataDTO findById(int id);
	
	NotificacionDTO createPagosContrata(PagosContrataDTO pagosContrataDTO);

	NotificacionDTO updatePagosContrata(PagosContrataDTO pagosContrataDTO);
}
