package com.dsite.service.intf;

import com.dsite.dto.model.DocumentosAdjuntoDTO;

public interface DocumentosAdjuntoService {

	DocumentosAdjuntoDTO findById(Integer id);
	
	void createDocumentosAdjunto(DocumentosAdjuntoDTO dto);
	
	void updateDocumentosAdjunto(DocumentosAdjuntoDTO dto);
	
	void deleteDocumentosAdjuntoById(Integer id);
}