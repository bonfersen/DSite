package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ContratasObraDTO;

public interface ContratasObraService {

	ContratasObraDTO findById(int id);

	void createContratasObra(ContratasObraDTO ContratasObraDTO);

	void updateContratasObra(ContratasObraDTO ContratasObraDTO);

	void deleteContratasObraById(int id);

	List<ContratasObraDTO> findAllContratasObras();
}
