package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.dto.model.NotificacionDTO;

public interface ContratasObraService {

	List<ContratasObraDTO> findByIdObra(int id);

	NotificacionDTO createContratasObra(ContratasObraDTO ContratasObraDTO);

	NotificacionDTO updateContratasObra(ContratasObraDTO ContratasObraDTO);

	NotificacionDTO deleteContratasObraById(int id);
}
