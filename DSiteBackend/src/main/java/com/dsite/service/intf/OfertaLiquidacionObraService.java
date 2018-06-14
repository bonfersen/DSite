package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.OfertaLiquidacionObraDTO;

public interface OfertaLiquidacionObraService {

	OfertaLiquidacionObraDTO findById(int id);
	
	List<OfertaLiquidacionObraDTO> findAllOfertaLiquidacionObras();

	void createOfertaLiquidacionObra(OfertaLiquidacionObraDTO OfertaLiquidacionObraDTO);

	void updateOfertaLiquidacionObra(OfertaLiquidacionObraDTO OfertaLiquidacionObraDTO);

	void deleteOfertaLiquidacionObraById(int id);
}
