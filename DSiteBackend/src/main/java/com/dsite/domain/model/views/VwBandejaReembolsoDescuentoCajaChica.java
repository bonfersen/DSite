package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwBandejaReembolsoDescuentoCajaChica implements Serializable {

	private static final long serialVersionUID = 4709590239780552673L;
	private String codigoRendicion;
	private String idTGTipoRendicion;
	private String tipoRendicion;
	private String tipoOperacion;
	private String idTGEstadoRendicion;
	private String estadoRendicion;
    private BigDecimal importeReembolsoDescuento;
    private Date fechaReembolso;
    private Date fechaDescuento;
    private Integer idEmpleadoSustentador;
    private String empleadoSustentador;    
    private String idTGTipoCaja;
    private String tipoCaja;
    private Integer idRendicionCajaChica;
    private Integer idResumenRendicionCajaChica;
    private Integer idCajaChicaObra;
    private String codigoDSite;
    
	public String getCodigoRendicion() {
		return codigoRendicion;
	}
	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}
	public String getIdTGTipoRendicion() {
		return idTGTipoRendicion;
	}
	public void setIdTGTipoRendicion(String idTGTipoRendicion) {
		this.idTGTipoRendicion = idTGTipoRendicion;
	}
	public String getTipoRendicion() {
		return tipoRendicion;
	}
	public void setTipoRendicion(String tipoRendicion) {
		this.tipoRendicion = tipoRendicion;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getIdTGEstadoRendicion() {
		return idTGEstadoRendicion;
	}
	public void setIdTGEstadoRendicion(String idTGEstadoRendicion) {
		this.idTGEstadoRendicion = idTGEstadoRendicion;
	}
	public String getEstadoRendicion() {
		return estadoRendicion;
	}
	public void setEstadoRendicion(String estadoRendicion) {
		this.estadoRendicion = estadoRendicion;
	}
	public BigDecimal getImporteReembolsoDescuento() {
		return importeReembolsoDescuento;
	}
	public void setImporteReembolsoDescuento(BigDecimal importeReembolsoDescuento) {
		this.importeReembolsoDescuento = importeReembolsoDescuento;
	}
	public Date getFechaReembolso() {
		return fechaReembolso;
	}
	public void setFechaReembolso(Date fechaReembolso) {
		this.fechaReembolso = fechaReembolso;
	}
	public Date getFechaDescuento() {
		return fechaDescuento;
	}
	public void setFechaDescuento(Date fechaDescuento) {
		this.fechaDescuento = fechaDescuento;
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
	public Integer getIdRendicionCajaChica() {
		return idRendicionCajaChica;
	}
	public void setIdRendicionCajaChica(Integer idRendicionCajaChica) {
		this.idRendicionCajaChica = idRendicionCajaChica;
	}
	public Integer getIdResumenRendicionCajaChica() {
		return idResumenRendicionCajaChica;
	}
	public void setIdResumenRendicionCajaChica(Integer idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}
	public Integer getIdCajaChicaObra() {
		return idCajaChicaObra;
	}
	public void setIdCajaChicaObra(Integer idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public Integer getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}
	public void setIdEmpleadoSustentador(Integer idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}
}
