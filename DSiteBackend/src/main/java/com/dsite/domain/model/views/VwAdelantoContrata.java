package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwAdelantoContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idContratasObra;
    private BigDecimal porcentajeAdelanto;
    private BigDecimal importeAdelanto;
    private Date fechaRechazo;
    private Date fechaSolicitud;
    private Date fechaAprobacion;
    private Date fechaPago;
    private String idTGEstadoPagoContrata;
    private String estado;
    private BigDecimal importeTotalAdelanto;
    
	public Integer getIdContratasObra() {
		return idContratasObra;
	}
	public void setIdContratasObra(Integer idContratasObra) {
		this.idContratasObra = idContratasObra;
	}
	public BigDecimal getPorcentajeAdelanto() {
		return porcentajeAdelanto;
	}
	public void setPorcentajeAdelanto(BigDecimal porcentajeAdelanto) {
		this.porcentajeAdelanto = porcentajeAdelanto;
	}
	public BigDecimal getImporteAdelanto() {
		return importeAdelanto;
	}
	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}
	public Date getFechaRechazo() {
		return fechaRechazo;
	}
	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getIdTGEstadoPagoContrata() {
		return idTGEstadoPagoContrata;
	}
	public void setIdTGEstadoPagoContrata(String idTGEstadoPagoContrata) {
		this.idTGEstadoPagoContrata = idTGEstadoPagoContrata;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public BigDecimal getImporteTotalAdelanto() {
		return importeTotalAdelanto;
	}
	public void setImporteTotalAdelanto(BigDecimal importeTotalAdelanto) {
		this.importeTotalAdelanto = importeTotalAdelanto;
	}
}
