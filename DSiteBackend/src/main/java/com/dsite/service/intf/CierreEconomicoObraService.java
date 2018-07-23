package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.CierreEconomicoObraDTO;
import com.dsite.dto.model.CierresAsignadasDTO;

public interface CierreEconomicoObraService {

	CierreEconomicoObraDTO findById(Integer id);
	
	void asignarCierreEconomico(CierresAsignadasDTO cierresAsignadasDTO);
	
	void createCierreEconomicoObra(CierreEconomicoObraDTO dto);
	
	void updateCierreEconomicoObra(CierreEconomicoObraDTO dto);
	
	void deleteCierreEconomicoObraById(Integer id);
	
	List<CierreEconomicoObraDTO> findByIdObra(Integer idObra);
}
