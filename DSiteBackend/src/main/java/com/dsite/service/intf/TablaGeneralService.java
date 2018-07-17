package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.TablaGeneralDTO;

public interface TablaGeneralService {

	public List<TablaGeneralDTO> findByCategoria(String categoria);
	
	public TablaGeneralDTO findByCategoriaAndCodigo(String categoria,  String idTablaGeneral);

	public List<TablaGeneralDTO> findByCategoriaAndCodigoPadre(String categoria, String idTablaGeneralPadre);
}
