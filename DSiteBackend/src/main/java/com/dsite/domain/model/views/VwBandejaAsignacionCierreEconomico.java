package com.dsite.domain.model.views;

import java.io.Serializable;
import java.util.Date;

public class VwBandejaAsignacionCierreEconomico implements Serializable {

	private static final long serialVersionUID = 5245599355178019629L;

	private String codigoDSite;
	private String idTGArea;
	private String area;
	private String nombreReal;
	private String tipoTrabajo;
	private Integer cantidadContratasAsignadas;
	private Integer idObra;
	private Date fechaFinalizacion;
	
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public String getIdTGArea() {
		return idTGArea;
	}
	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public Integer getCantidadContratasAsignadas() {
		return cantidadContratasAsignadas;
	}
	public void setCantidadContratasAsignadas(Integer cantidadContratasAsignadas) {
		this.cantidadContratasAsignadas = cantidadContratasAsignadas;
	}
	public Integer getIdObra() {
		return idObra;
	}
	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
}
