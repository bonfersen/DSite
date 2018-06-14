package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;

public class CajaChicaObraDTO {

	private int idCajaChicaObra;

	private String detalle;

	private Date fechaAprobacion;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private Date fechaPago;

	private Date fechaRechazo;

	private Date fechaSolicitud;

	private BigDecimal importeCaja;

	private BigDecimal importeTotal;

	private BigDecimal importeViatico;

	private String motivoRechazo;

	private String rendirCaja;

	private String rendirViatico;

	private String usuarioCreacion;

	private int idUsuarioSolicitud;

	private int idUsuarioAprobacion;

	private int idUsuarioPago;

	private int idUsuarioRechazo;

	private int idEmpleadoSustentador;

	private int idEmpleadoBeneficiario;

	private int idObra;

	private String idTGTipoCaja;

	private String idTGEstadoCajaChica;

	private int idUsuarioModificacion;

	//private List<RendicionCajaChicaDTO> rendicionCajaChicas;
	
	public int getIdCajaChicaObra() {
		return idCajaChicaObra;
	}

	public void setIdCajaChicaObra(int idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	public BigDecimal getImporteCaja() {
		return importeCaja;
	}

	public void setImporteCaja(BigDecimal importeCaja) {
		this.importeCaja = importeCaja;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public BigDecimal getImporteViatico() {
		return importeViatico;
	}

	public void setImporteViatico(BigDecimal importeViatico) {
		this.importeViatico = importeViatico;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getRendirCaja() {
		return rendirCaja;
	}

	public void setRendirCaja(String rendirCaja) {
		this.rendirCaja = rendirCaja;
	}

	public String getRendirViatico() {
		return rendirViatico;
	}

	public void setRendirViatico(String rendirViatico) {
		this.rendirViatico = rendirViatico;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public int getIdUsuarioSolicitud() {
		return idUsuarioSolicitud;
	}

	public void setIdUsuarioSolicitud(int idUsuarioSolicitud) {
		this.idUsuarioSolicitud = idUsuarioSolicitud;
	}

	public int getIdUsuarioAprobacion() {
		return idUsuarioAprobacion;
	}

	public void setIdUsuarioAprobacion(int idUsuarioAprobacion) {
		this.idUsuarioAprobacion = idUsuarioAprobacion;
	}

	public int getIdUsuarioPago() {
		return idUsuarioPago;
	}

	public void setIdUsuarioPago(int idUsuarioPago) {
		this.idUsuarioPago = idUsuarioPago;
	}

	public int getIdUsuarioRechazo() {
		return idUsuarioRechazo;
	}

	public void setIdUsuarioRechazo(int idUsuarioRechazo) {
		this.idUsuarioRechazo = idUsuarioRechazo;
	}

	public int getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}

	public void setIdEmpleadoSustentador(int idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}

	public int getIdEmpleadoBeneficiario() {
		return idEmpleadoBeneficiario;
	}

	public void setIdEmpleadoBeneficiario(int idEmpleadoBeneficiario) {
		this.idEmpleadoBeneficiario = idEmpleadoBeneficiario;
	}

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getIdTGTipoCaja() {
		return idTGTipoCaja;
	}

	public void setIdTGTipoCaja(String idTGTipoCaja) {
		this.idTGTipoCaja = idTGTipoCaja;
	}

	public String getIdTGEstadoCajaChica() {
		return idTGEstadoCajaChica;
	}

	public void setIdTGEstadoCajaChica(String idTGEstadoCajaChica) {
		this.idTGEstadoCajaChica = idTGEstadoCajaChica;
	}

	public int getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(int idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}	
}
