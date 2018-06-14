package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.DepartamentoDTO;

public interface DepartamentoService {
	List<DepartamentoDTO> findAllDepartamentos(); 
}
