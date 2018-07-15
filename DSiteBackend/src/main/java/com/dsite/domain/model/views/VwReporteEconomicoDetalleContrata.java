package com.dsite.domain.model.views;

import java.math.BigDecimal;

public class VwReporteEconomicoDetalleContrata {
	private String codigoDSite;
	private String nombreCorto; 
	private String tipoTrabajo; 
	private BigDecimal importePresupuestoObra; 
	private BigDecimal importeTotalAdelanto; 
	private BigDecimal porcentajeActasAprobadas;
	
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public BigDecimal getImportePresupuestoObra() {
		return importePresupuestoObra;
	}
	public void setImportePresupuestoObra(BigDecimal importePresupuestoObra) {
		this.importePresupuestoObra = importePresupuestoObra;
	}
	public BigDecimal getImporteTotalAdelanto() {
		return importeTotalAdelanto;
	}
	public void setImporteTotalAdelanto(BigDecimal importeTotalAdelanto) {
		this.importeTotalAdelanto = importeTotalAdelanto;
	}
	public BigDecimal getPorcentajeActasAprobadas() {
		return porcentajeActasAprobadas;
	}
	public void setPorcentajeActasAprobadas(BigDecimal porcentajeActasAprobadas) {
		this.porcentajeActasAprobadas = porcentajeActasAprobadas;
	}
}
