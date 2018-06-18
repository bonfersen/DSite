package com.dsite.domain.model.views;

import java.io.Serializable;
import java.util.Date;

public class VwBandejaCierreEconomico implements Serializable {

	private static final long serialVersionUID = 2850471938844267363L;

	private String idTGEstadoCierreEconomico;
	private String estadoCierreEconomico;
	private String codigoCierre;
	private String ebc;
	private Date fechaAsignacion;

	public String getIdTGEstadoCierreEconomico() {
		return idTGEstadoCierreEconomico;
	}

	public void setIdTGEstadoCierreEconomico(String idTGEstadoCierreEconomico) {
		this.idTGEstadoCierreEconomico = idTGEstadoCierreEconomico;
	}

	public String getEstadoCierreEconomico() {
		return estadoCierreEconomico;
	}

	public void setEstadoCierreEconomico(String estadoCierreEconomico) {
		this.estadoCierreEconomico = estadoCierreEconomico;
	}

	public String getCodigoCierre() {
		return codigoCierre;
	}

	public void setCodigoCierre(String codigoCierre) {
		this.codigoCierre = codigoCierre;
	}

	public String getEbc() {
		return ebc;
	}

	public void setEbc(String ebc) {
		this.ebc = ebc;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
}
