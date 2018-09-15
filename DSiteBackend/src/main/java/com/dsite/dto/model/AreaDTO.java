package com.dsite.dto.model;

import java.util.Date;
import java.util.List;


public class AreaDTO {
	
	private int idArea;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private String nombre;
	
	private Integer idGerencia;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<CargoDTO> cargos;

	public AreaDTO() {
	}

	public Integer getIdGerencia() {
		return idGerencia;
	}

	public void setIdGerencia(Integer idGerencia) {
		this.idGerencia = idGerencia;
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<CargoDTO> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<CargoDTO> cargos) {
		this.cargos = cargos;
	}
}