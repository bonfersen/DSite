package com.dsite.dto.model.views;

import java.util.Date;

public class VwBandejaDepositoCajaChicaFilter {

	private Date fechaPagoInicio;
	
	private Date fechaPagoFin;
	
	private String[] idTGEstadoCajaChica;

	public Date getFechaPagoInicio() {
		return fechaPagoInicio;
	}

	public void setFechaPagoInicio(Date fechaPagoInicio) {
		this.fechaPagoInicio = fechaPagoInicio;
	}

	public Date getFechaPagoFin() {
		return fechaPagoFin;
	}

	public void setFechaPagoFin(Date fechaPagoFin) {
		this.fechaPagoFin = fechaPagoFin;
	}

	public String[] getIdTGEstadoCajaChica() {
		return idTGEstadoCajaChica;
	}

	public void setIdTGEstadoCajaChica(String[] idTGEstadoCajaChica) {
		this.idTGEstadoCajaChica = idTGEstadoCajaChica;
	}
}
