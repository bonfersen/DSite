package com.dsite.dto.model;

import com.dsite.domain.model.views.VwReporteEconomico;
import com.dsite.domain.model.views.VwReporteEconomicoDetalleContrata;

public class ReporteEconomico {

	VwReporteEconomico reporteEconomico;

	VwReporteEconomicoDetalleContrata detalleReporteEconomico;

	public VwReporteEconomico getReporteEconomico() {
		return reporteEconomico;
	}

	public void setReporteEconomico(VwReporteEconomico reporteEconomico) {
		this.reporteEconomico = reporteEconomico;
	}

	public VwReporteEconomicoDetalleContrata getDetalleReporteEconomico() {
		return detalleReporteEconomico;
	}

	public void setDetalleReporteEconomico(VwReporteEconomicoDetalleContrata detalleReporteEconomico) {
		this.detalleReporteEconomico = detalleReporteEconomico;
	}
}
