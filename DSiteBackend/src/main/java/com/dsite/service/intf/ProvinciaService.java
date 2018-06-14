package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.ProvinciaDTO;

public interface ProvinciaService {

	public List<ProvinciaDTO> obtenerProvinciasPorDepartamento(String idDpto);
}
