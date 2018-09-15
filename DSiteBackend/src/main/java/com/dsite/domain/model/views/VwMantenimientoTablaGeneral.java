package com.dsite.domain.model.views;

import java.io.Serializable;

public class VwMantenimientoTablaGeneral implements Serializable {
	
	private static final long serialVersionUID = 531643535946161169L;
	
	private String idTablaGeneral;
	private String descripcion;
	private String categoria;
	private String activo;
	private String idTGPadre;
	private String descripcionPadre;	

	public String getIdTablaGeneral() {
		return idTablaGeneral;
	}
	public void setIdTablaGeneral(String idTablaGeneral) {
		this.idTablaGeneral = idTablaGeneral;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public String getDescripcionPadre() {
		return descripcionPadre;
	}
	public void setDescripcionPadre(String descripcionPadre) {
		this.descripcionPadre = descripcionPadre;
	}
}
