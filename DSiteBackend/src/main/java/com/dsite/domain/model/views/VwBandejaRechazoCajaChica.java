package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwBandejaRechazoCajaChica implements Serializable {

	private static final long serialVersionUID = 306628854746838731L;
	private String codigoDSite;
	private String idTGArea;
	private String area;
	private String idTGProyecto;
	private String proyecto;
	private String nombreReal;
	private Integer idEmpleadoSustentador;
    private String empleadoSustentador;
    private String idTGTipoCaja;
    private String tipoCaja;
    private Integer idEmpleadoBeneficiario;
    private String empleadoBeneficiario;
    private BigDecimal importeCaja;
    private BigDecimal importeViatico;
    private BigDecimal importeTotal;
    private String detalle;
    private Date fechaRechazo;
    private String motivoRechazo;
    private Integer idUsuarioRechazo;
    private String empleadoRechazo;
    private Integer idCajaChicaObra;
    private String idTGEstadoCajaChica;
    private String estadoCajaChica;
    private Integer idObra;
    
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public String getIdTGArea() {
		return idTGArea;
	}
	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getIdTGProyecto() {
		return idTGProyecto;
	}
	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public Integer getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}
	public void setIdEmpleadoSustentador(Integer idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}
	public String getEmpleadoSustentador() {
		return empleadoSustentador;
	}
	public void setEmpleadoSustentador(String empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
	}
	public String getIdTGTipoCaja() {
		return idTGTipoCaja;
	}
	public void setIdTGTipoCaja(String idTGTipoCaja) {
		this.idTGTipoCaja = idTGTipoCaja;
	}
	public String getTipoCaja() {
		return tipoCaja;
	}
	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}
	public Integer getIdEmpleadoBeneficiario() {
		return idEmpleadoBeneficiario;
	}
	public void setIdEmpleadoBeneficiario(Integer idEmpleadoBeneficiario) {
		this.idEmpleadoBeneficiario = idEmpleadoBeneficiario;
	}
	public String getEmpleadoBeneficiario() {
		return empleadoBeneficiario;
	}
	public void setEmpleadoBeneficiario(String empleadoBeneficiario) {
		this.empleadoBeneficiario = empleadoBeneficiario;
	}
	public BigDecimal getImporteCaja() {
		return importeCaja;
	}
	public void setImporteCaja(BigDecimal importeCaja) {
		this.importeCaja = importeCaja;
	}
	public BigDecimal getImporteViatico() {
		return importeViatico;
	}
	public void setImporteViatico(BigDecimal importeViatico) {
		this.importeViatico = importeViatico;
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
	public Date getFechaRechazo() {
		return fechaRechazo;
	}
	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}
	public String getMotivoRechazo() {
		return motivoRechazo;
	}
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	public Integer getIdUsuarioRechazo() {
		return idUsuarioRechazo;
	}
	public void setIdUsuarioRechazo(Integer idUsuarioRechazo) {
		this.idUsuarioRechazo = idUsuarioRechazo;
	}
	public String getEmpleadoRechazo() {
		return empleadoRechazo;
	}
	public void setEmpleadoRechazo(String empleadoRechazo) {
		this.empleadoRechazo = empleadoRechazo;
	}
	public Integer getIdCajaChicaObra() {
		return idCajaChicaObra;
	}
	public void setIdCajaChicaObra(Integer idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}
	public String getIdTGEstadoCajaChica() {
		return idTGEstadoCajaChica;
	}
	public void setIdTGEstadoCajaChica(String idTGEstadoCajaChica) {
		this.idTGEstadoCajaChica = idTGEstadoCajaChica;
	}
	public String getEstadoCajaChica() {
		return estadoCajaChica;
	}
	public void setEstadoCajaChica(String estadoCajaChica) {
		this.estadoCajaChica = estadoCajaChica;
	}
	public Integer getIdObra() {
		return idObra;
	}
	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}
}
