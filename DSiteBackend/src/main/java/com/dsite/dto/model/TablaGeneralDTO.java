package com.dsite.dto.model;

import java.util.Date;

public class TablaGeneralDTO {

	private String idTablaGeneral;

	private String activo;
	
	private String idTGPadre;
	
	private String categoria;

	private String descripcion;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private String usuarioCreacion;

	private String usuarioModificacion;

	public String getIdTablaGeneral() {
		return idTablaGeneral;
	}

	public void setIdTablaGeneral(String idTablaGeneral) {
		this.idTablaGeneral = idTablaGeneral;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getIdTGPadre() {
		return idTGPadre;
	}

	public void setIdTGPadre(String idTGPadre) {
		this.idTGPadre = idTGPadre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
}
