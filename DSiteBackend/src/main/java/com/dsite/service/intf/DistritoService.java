package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.DistritoDTO;

public interface DistritoService {

	public List<DistritoDTO> obtenerDistritosPorProvincia(String idProvincia);
}
