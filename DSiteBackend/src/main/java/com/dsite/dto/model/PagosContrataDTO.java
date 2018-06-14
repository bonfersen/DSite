package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;

public class PagosContrataDTO {

	private int idPagosContrata;

	private Date fechaAprobacion;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private Date fechaPago;

	private Date fechaRechazo;

	private Date fechaSolicitud;

	private BigDecimal importeAdelanto;

	private BigDecimal importeAplicadoPendientePago;

	private String motivoRechazo;

	private String numeroFactura;

	private String ordenServicio;

	private BigDecimal porcentajeAdelanto;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private int idContratasObra;

	private String idTGTipoSolicitud;

	private String idTGEstadoPagoContrata;

	private int idUsuarioSolicitado;

	private int idUsuarioAprobado;

	private int idUsuarioRechazo;

	public PagosContrataDTO() {
	}

	public int getIdPagosContrata() {
		return idPagosContrata;
	}

	public void setIdPagosContrata(int idPagosContrata) {
		this.idPagosContrata = idPagosContrata;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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

	public BigDecimal getImporteAdelanto() {
		return importeAdelanto;
	}

	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}

	public BigDecimal getImporteAplicadoPendientePago() {
		return importeAplicadoPendientePago;
	}

	public void setImporteAplicadoPendientePago(BigDecimal importeAplicadoPendientePago) {
		this.importeAplicadoPendientePago = importeAplicadoPendientePago;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getOrdenServicio() {
		return ordenServicio;
	}

	public void setOrdenServicio(String ordenServicio) {
		this.ordenServicio = ordenServicio;
	}

	public BigDecimal getPorcentajeAdelanto() {
		return porcentajeAdelanto;
	}

	public void setPorcentajeAdelanto(BigDecimal porcentajeAdelanto) {
		this.porcentajeAdelanto = porcentajeAdelanto;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public int getIdContratasObra() {
		return idContratasObra;
	}

	public void setIdContratasObra(int idContratasObra) {
		this.idContratasObra = idContratasObra;
	}

	public String getIdTGTipoSolicitud() {
		return idTGTipoSolicitud;
	}

	public void setIdTGTipoSolicitud(String idTGTipoSolicitud) {
		this.idTGTipoSolicitud = idTGTipoSolicitud;
	}

	public String getIdTGEstadoPagoContrata() {
		return idTGEstadoPagoContrata;
	}

	public void setIdTGEstadoPagoContrata(String idTGEstadoPagoContrata) {
		this.idTGEstadoPagoContrata = idTGEstadoPagoContrata;
	}

	public int getIdUsuarioSolicitado() {
		return idUsuarioSolicitado;
	}

	public void setIdUsuarioSolicitado(int idUsuarioSolicitado) {
		this.idUsuarioSolicitado = idUsuarioSolicitado;
	}

	public int getIdUsuarioAprobado() {
		return idUsuarioAprobado;
	}

	public void setIdUsuarioAprobado(int idUsuarioAprobado) {
		this.idUsuarioAprobado = idUsuarioAprobado;
	}

	public int getIdUsuarioRechazo() {
		return idUsuarioRechazo;
	}

	public void setIdUsuarioRechazo(int idUsuarioRechazo) {
		this.idUsuarioRechazo = idUsuarioRechazo;
	}
}