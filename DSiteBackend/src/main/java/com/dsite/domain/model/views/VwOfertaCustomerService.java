package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the vwOfertaCustomerService database table.
 * 
 */
public class VwOfertaCustomerService implements Serializable {

	private static final long serialVersionUID = 1L;
	private String area;
	private String codigoDSite;
	private String correlativoOferta;
	private String departamento;
	private String estadoFinanzas;
	private Date fechaCreacion;
	private Date fechaOferta;
	private String gestorProyecto;
	private String idTGArea;
	private String idTGProyecto;
	private BigDecimal importeOferta;
	private String moneda;
	private String nombreReal;
	private String observacionFinanzas;
	private String OTAutogenerada;
	private String proyecto;
	private int idOfertaLiquidacionObra;
	private int idPresupuestoObra;
	private String idTGEstadoObra;

	public VwOfertaCustomerService() {
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCodigoDSite() {
		return this.codigoDSite;
	}

	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}

	public String getCorrelativoOferta() {
		return this.correlativoOferta;
	}

	public void setCorrelativoOferta(String correlativoOferta) {
		this.correlativoOferta = correlativoOferta;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEstadoFinanzas() {
		return this.estadoFinanzas;
	}

	public void setEstadoFinanzas(String estadoFinanzas) {
		this.estadoFinanzas = estadoFinanzas;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaOferta() {
		return this.fechaOferta;
	}

	public void setFechaOferta(Date fechaOferta) {
		this.fechaOferta = fechaOferta;
	}

	public String getGestorProyecto() {
		return this.gestorProyecto;
	}

	public void setGestorProyecto(String gestorProyecto) {
		this.gestorProyecto = gestorProyecto;
	}

	public String getIdTGArea() {
		return this.idTGArea;
	}

	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}

	public String getIdTGProyecto() {
		return this.idTGProyecto;
	}

	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}

	public BigDecimal getImporteOferta() {
		return this.importeOferta;
	}

	public void setImporteOferta(BigDecimal importeOferta) {
		this.importeOferta = importeOferta;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getNombreReal() {
		return this.nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getObservacionFinanzas() {
		return this.observacionFinanzas;
	}

	public void setObservacionFinanzas(String observacionFinanzas) {
		this.observacionFinanzas = observacionFinanzas;
	}

	public String getOTAutogenerada() {
		return this.OTAutogenerada;
	}

	public void setOTAutogenerada(String OTAutogenerada) {
		this.OTAutogenerada = OTAutogenerada;
	}

	public String getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public int getIdOfertaLiquidacionObra() {
		return idOfertaLiquidacionObra;
	}

	public void setIdOfertaLiquidacionObra(int idOfertaLiquidacionObra) {
		this.idOfertaLiquidacionObra = idOfertaLiquidacionObra;
	}

	public int getIdPresupuestoObra() {
		return idPresupuestoObra;
	}

	public void setIdPresupuestoObra(int idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}

	public String getIdTGEstadoObra() {
		return idTGEstadoObra;
	}

	public void setIdTGEstadoObra(String idTGEstadoObra) {
		this.idTGEstadoObra = idTGEstadoObra;
	}
}