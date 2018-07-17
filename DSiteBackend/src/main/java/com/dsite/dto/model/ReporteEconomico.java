package com.dsite.dto.model;

import java.util.List;

import com.dsite.domain.model.views.VwReporteEconomico;
import com.dsite.domain.model.views.VwReporteEconomicoDetalleContrata;

public class ReporteEconomico {

	VwReporteEconomico reporteEconomico;

	List<VwReporteEconomicoDetalleContrata> detalleReporteEconomico;

	public VwReporteEconomico getReporteEconomico() {
		return reporteEconomico;
	}

	public void setReporteEconomico(VwReporteEconomico reporteEconomico) {
		this.reporteEconomico = reporteEconomico;
	}

	public List<VwReporteEconomicoDetalleContrata> getDetalleReporteEconomico() {
		return detalleReporteEconomico;
	}

	public void setDetalleReporteEconomico(List<VwReporteEconomicoDetalleContrata> detalleReporteEconomico) {
		this.detalleReporteEconomico = detalleReporteEconomico;
	}
}
