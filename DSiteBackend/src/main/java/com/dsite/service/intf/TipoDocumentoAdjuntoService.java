package com.dsite.service.intf;

import com.dsite.dto.model.TipoDocumentoAdjuntoDTO;

public interface TipoDocumentoAdjuntoService {

	TipoDocumentoAdjuntoDTO findById(Integer id);
	
	void createTipoDocumentoAdjunto(TipoDocumentoAdjuntoDTO dto);
	
	void updateTipoDocumentoAdjunto(TipoDocumentoAdjuntoDTO dto);
	
	void deleteTipoDocumentoAdjuntoById(Integer id);
}