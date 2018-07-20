package com.dsite.service.intf;

import com.dsite.dto.model.RendicionDTO;

public interface RendicionService {

	RendicionDTO findById(int id);
	
	void createRendicion(RendicionDTO rendicionDTO);

	void updateRendicion(RendicionDTO rendicionDTO);

	void deleteRendicionById(Integer id);
}
