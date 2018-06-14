package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.GerenciaDTO;

public interface GerenciaService {

	GerenciaDTO findById(int id);
	
	GerenciaDTO findByName(String name);
	
	void saveGerencia(GerenciaDTO Gerencia);
	
	void updateGerencia(GerenciaDTO Gerencia);
	
	void deleteGerenciaById(long id);

	List<GerenciaDTO> findAllGerencias(); 
	
	void deleteAllGerencias();
	
	public boolean isGerenciaExist(GerenciaDTO Gerencia);
}
