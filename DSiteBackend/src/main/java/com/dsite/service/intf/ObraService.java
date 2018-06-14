package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.JsonResult;
import com.dsite.dto.model.ObraDTO;

public interface ObraService {

	ObraDTO findById(int id);
	
	ObraDTO findByCodigoDSite(String codDSite);
	
	JsonResult createObra(ObraDTO Obra);
	
	JsonResult updateObra(ObraDTO Obra);
	
	void deleteObraById(long id);

	List<ObraDTO> findAllObras(); 
	
	public boolean isObraExist(ObraDTO Obra);
}
