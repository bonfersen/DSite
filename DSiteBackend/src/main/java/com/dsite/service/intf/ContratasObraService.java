package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.dto.model.NotificacionDTO;

public interface ContratasObraService {

	List<ContratasObraDTO> findByIdObra(int id);

	void createContratasObra(ContratasObraDTO ContratasObraDTO);

	void updateContratasObra(ContratasObraDTO ContratasObraDTO);

	NotificacionDTO deleteContratasObraById(int id);
}
