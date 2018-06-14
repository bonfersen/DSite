package com.dsite.domain.model.views;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/** 
 * The persistent class for the vwListaCajaChica database table.
 * 
 */
public class VwListaCajaChica implements Serializable {
	private static final long serialVersionUID = 1L;
	private String detalle;
	private String empleadoBeneficiario;
	private String empleadoSustentador;
	private Date fechaAprobacion;
	private Date fechaPago;
	private Date fechaRechazo;
	private Date fechaSolicitud;
	private int idCajaChicaObra;
	private String idTGEstadoCajaChica;
	private BigDecimal importeCaja;
	private BigDecimal importeTotal;
	private BigDecimal importeViatico;
	private String motivoRechazo;
	private String tipoCaja;

	public VwListaCajaChica() {
	}


	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEmpleadoBeneficiario() {
		return empleadoBeneficiario;
	}


	public void setEmpleadoBeneficiario(String empleadoBeneficiario) {
		this.empleadoBeneficiario = empleadoBeneficiario;
	}


	public String getEmpleadoSustentador() {
		return empleadoSustentador;
	}


	public void setEmpleadoSustentador(String empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
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
	public Date getFechaRechazo() {
		return this.fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public int getIdCajaChicaObra() {
		return this.idCajaChicaObra;
	}

	public void setIdCajaChicaObra(int idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}


	public String getIdTGEstadoCajaChica() {
		return this.idTGEstadoCajaChica;
	}

	public void setIdTGEstadoCajaChica(String idTGEstadoCajaChica) {
		this.idTGEstadoCajaChica = idTGEstadoCajaChica;
	}


	public BigDecimal getImporteCaja() {
		return this.importeCaja;
	}

	public void setImporteCaja(BigDecimal importeCaja) {
		this.importeCaja = importeCaja;
	}


	public BigDecimal getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}


	public BigDecimal getImporteViatico() {
		return this.importeViatico;
	}

	public void setImporteViatico(BigDecimal importeViatico) {
		this.importeViatico = importeViatico;
	}


	public String getMotivoRechazo() {
		return this.motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}


	public String getTipoCaja() {
		return this.tipoCaja;
	}

	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}

}