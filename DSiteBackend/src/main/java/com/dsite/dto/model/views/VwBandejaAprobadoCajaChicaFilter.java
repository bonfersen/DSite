package com.dsite.dto.model.views;

import java.util.Date;

public class VwBandejaAprobadoCajaChicaFilter {

	private Date fechaAprobacionInicio;

	private Date fechaAprobacionFin;

	public Date getFechaAprobacionInicio() {
		return fechaAprobacionInicio;
	}

	public void setFechaAprobacionInicio(Date fechaAprobacionInicio) {
		this.fechaAprobacionInicio = fechaAprobacionInicio;
	}

	public Date getFechaAprobacionFin() {
		return fechaAprobacionFin;
	}

	public void setFechaAprobacionFin(Date fechaAprobacionFin) {
		this.fechaAprobacionFin = fechaAprobacionFin;
	}
}
