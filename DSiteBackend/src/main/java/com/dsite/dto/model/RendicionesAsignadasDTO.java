package com.dsite.dto.model;

import java.util.List;

public class RendicionesAsignadasDTO {

	Integer idEmpleadoSustentador;
	List<RendicionCajaChicaDTO> rendiciones;
	
	public Integer getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}
	public void setIdEmpleadoSustentador(Integer idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}
	public List<RendicionCajaChicaDTO> getRendiciones() {
		return rendiciones;
	}
	public void setRendiciones(List<RendicionCajaChicaDTO> rendiciones) {
		this.rendiciones = rendiciones;
	}
}
