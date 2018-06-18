package com.dsite.dto.model.views;

import java.util.Date;

public class VwBandejaRechazoCajaChicaFilter {

	private Date fechaRechazoInicio;

	private Date fechaRechazoFin;

	public Date getFechaRechazoInicio() {
		return fechaRechazoInicio;
	}

	public void setFechaRechazoInicio(Date fechaRechazoInicio) {
		this.fechaRechazoInicio = fechaRechazoInicio;
	}

	public Date getFechaRechazoFin() {
		return fechaRechazoFin;
	}

	public void setFechaRechazoFin(Date fechaRechazoFin) {
		this.fechaRechazoFin = fechaRechazoFin;
	}
}
