package com.dsite.service.intf;

import java.util.List;

import com.dsite.dto.model.PresupuestoObraDTO;

public interface PresupuestoObraService {

	PresupuestoObraDTO findById(int id);
	
	List<PresupuestoObraDTO> findAllPresupuestos();

	void createPresupuestoObra(PresupuestoObraDTO PresupuestoObraDTO);

	void updatePresupuestoObra(PresupuestoObraDTO PresupuestoObraDTO);

	void deletePresupuestoObraById(int id);
}
