package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwBandejaRendicionCajaChica implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombreReal;
	private String idTGProyecto;
	private String idTGArea;
	private String codigoDSite;
	private String proyecto;
	private String area;
	private Integer idEmpleadoSustentador;
    private String idTGTipoCaja;
    private Integer idEmpleadoBeneficiario;
    private BigDecimal importeCaja;
    private String rendirCaja;
    private BigDecimal importeViatico;
    private String rendirViatico;
    private BigDecimal importeTotal;
    private String detalle;
    private String idTGEstadoCajaChica;
    private Date fechaAprobacion;
    private String motivoRechazo;
    private Date fechaPago;   
    private String empleadoSustentador;
    private String empleadoBeneficiario;
    private String tipoCaja;
    private String estadoCajaChica;
    
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getIdTGProyecto() {
		return idTGProyecto;
	}
	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}
	public String getIdTGArea() {
		return idTGArea;
	}
	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}
	public void setIdEmpleadoSustentador(Integer idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}
	public String getIdTGTipoCaja() {
		return idTGTipoCaja;
	}
	public void setIdTGTipoCaja(String idTGTipoCaja) {
		this.idTGTipoCaja = idTGTipoCaja;
	}
	public Integer getIdEmpleadoBeneficiario() {
		return idEmpleadoBeneficiario;
	}
	public void setIdEmpleadoBeneficiario(Integer idEmpleadoBeneficiario) {
		this.idEmpleadoBeneficiario = idEmpleadoBeneficiario;
	}
	public BigDecimal getImporteCaja() {
		return importeCaja;
	}
	public void setImporteCaja(BigDecimal importeCaja) {
		this.importeCaja = importeCaja;
	}
	public String getRendirCaja() {
		return rendirCaja;
	}
	public void setRendirCaja(String rendirCaja) {
		this.rendirCaja = rendirCaja;
	}
	public BigDecimal getImporteViatico() {
		return importeViatico;
	}
	public void setImporteViatico(BigDecimal importeViatico) {
		this.importeViatico = importeViatico;
	}
	public String getRendirViatico() {
		return rendirViatico;
	}
	public void setRendirViatico(String rendirViatico) {
		this.rendirViatico = rendirViatico;
	}
	public BigDecimal getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getIdTGEstadoCajaChica() {
		return idTGEstadoCajaChica;
	}
	public void setIdTGEstadoCajaChica(String idTGEstadoCajaChica) {
		this.idTGEstadoCajaChica = idTGEstadoCajaChica;
	}
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public String getMotivoRechazo() {
		return motivoRechazo;
	}
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getEmpleadoSustentador() {
		return empleadoSustentador;
	}
	public void setEmpleadoSustentador(String empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
	}
	public String getEmpleadoBeneficiario() {
		return empleadoBeneficiario;
	}
	public void setEmpleadoBeneficiario(String empleadoBeneficiario) {
		this.empleadoBeneficiario = empleadoBeneficiario;
	}
	public String getTipoCaja() {
		return tipoCaja;
	}
	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}
	public String getEstadoCajaChica() {
		return estadoCajaChica;
	}
	public void setEstadoCajaChica(String estadoCajaChica) {
		this.estadoCajaChica = estadoCajaChica;
	}
}
