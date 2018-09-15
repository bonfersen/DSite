package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwReporteEconomicoExcel implements Serializable {

	private static final long serialVersionUID = -4525840360676450393L;
	private String codigoDSite;
	private String nombreReal;
	private String area;
	private String proyecto;
	private String gestor;
	private String departamento;
	private String asignacion;
	private BigDecimal importeIngreso;
	private BigDecimal importeIngresoOferta;
	private String facturado;
	private String actas;
	private BigDecimal importeGastos;
	private BigDecimal importeRentabilidad;
	private BigDecimal porcentajeRentabilidad;
	
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getGestor() {
		return gestor;
	}
	public void setGestor(String gestor) {
		this.gestor = gestor;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}
	public BigDecimal getImporteIngreso() {
		return importeIngreso;
	}
	public void setImporteIngreso(BigDecimal importeIngreso) {
		this.importeIngreso = importeIngreso;
	}
	public BigDecimal getImporteIngresoOferta() {
		return importeIngresoOferta;
	}
	public void setImporteIngresoOferta(BigDecimal importeIngresoOferta) {
		this.importeIngresoOferta = importeIngresoOferta;
	}
	public String getFacturado() {
		return facturado;
	}
	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}
	public String getActas() {
		return actas;
	}
	public void setActas(String actas) {
		this.actas = actas;
	}
	public BigDecimal getImporteGastos() {
		return importeGastos;
	}
	public void setImporteGastos(BigDecimal importeGastos) {
		this.importeGastos = importeGastos;
	}
	public BigDecimal getImporteRentabilidad() {
		return importeRentabilidad;
	}
	public void setImporteRentabilidad(BigDecimal importeRentabilidad) {
		this.importeRentabilidad = importeRentabilidad;
	}
	public BigDecimal getPorcentajeRentabilidad() {
		return porcentajeRentabilidad;
	}
	public void setPorcentajeRentabilidad(BigDecimal porcentajeRentabilidad) {
		this.porcentajeRentabilidad = porcentajeRentabilidad;
	}
}
