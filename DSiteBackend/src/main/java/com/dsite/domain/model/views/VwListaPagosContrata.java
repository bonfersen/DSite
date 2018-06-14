package com.dsite.domain.model.views;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the vwListaPagosContrata database table.
 * 
 */
public class VwListaPagosContrata implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String estadoPagoContrata;
	private Date fechaAprobacion;
	private Date fechaPago;
	private Date fechaSolicitud;
	private int idContratasObra;
	private BigDecimal importeAdelanto;
	private BigDecimal porcentajeAdelanto;

	public VwListaPagosContrata() {
	}


	public String getEstadoPagoContrata() {
		return this.estadoPagoContrata;
	}

	public void setEstadoPagoContrata(String estadoPagoContrata) {
		this.estadoPagoContrata = estadoPagoContrata;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaAprobacion() {
		return this.fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public int getIdContratasObra() {
		return this.idContratasObra;
	}

	public void setIdContratasObra(int idContratasObra) {
		this.idContratasObra = idContratasObra;
	}


	public BigDecimal getImporteAdelanto() {
		return this.importeAdelanto;
	}

	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}


	public BigDecimal getPorcentajeAdelanto() {
		return this.porcentajeAdelanto;
	}

	public void setPorcentajeAdelanto(BigDecimal porcentajeAdelanto) {
		this.porcentajeAdelanto = porcentajeAdelanto;
	}

}