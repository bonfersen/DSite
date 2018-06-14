package com.dsite.dto.model.views;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class VwBudgetFilter {

	private String area;
	private String areaSoporte;
	private String codigoDSite;
	private String departamento;
	private String empleadoResponsableObra;
	private String estadoObra;
	private Date fechaCreacion;
	private Date fechaFinalizacionObra;
	private Date fechaInicioObra;
	private String gestorProyecto;
	private String idTGActaCampo;
	private String idTGActaFinal;
	private String idTGArea;
	private String idTGAreaSoporte;
	private String idTGEstadoObra;
	private String idTGProyecto;
	private BigDecimal importePresupuestoLiquidacion;
	private BigDecimal importePresupuestoOferta;
	private String moneda;
	private String nombreReal;
	private String numeroOrdenCompra;
	private String numeroOrdenCompraComplementaria;
	private String proyecto;
	private BigDecimal importeVarMas;

	public VwBudgetFilter() {
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaSoporte() {
		return this.areaSoporte;
	}

	public void setAreaSoporte(String areaSoporte) {
		this.areaSoporte = areaSoporte;
	}

	public String getCodigoDSite() {
		return this.codigoDSite;
	}

	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEstadoObra() {
		return this.estadoObra;
	}

	public void setEstadoObra(String estadoObra) {
		this.estadoObra = estadoObra;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaFinalizacionObra() {
		return this.fechaFinalizacionObra;
	}

	public void setFechaFinalizacionObra(Date fechaFinalizacionObra) {
		this.fechaFinalizacionObra = fechaFinalizacionObra;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaInicioObra() {
		return this.fechaInicioObra;
	}

	public void setFechaInicioObra(Date fechaInicioObra) {
		this.fechaInicioObra = fechaInicioObra;
	}

	public String getGestorProyecto() {
		return this.gestorProyecto;
	}

	public void setGestorProyecto(String gestorProyecto) {
		this.gestorProyecto = gestorProyecto;
	}

	public String getIdTGActaCampo() {
		return this.idTGActaCampo;
	}

	public void setIdTGActaCampo(String idTGActaCampo) {
		this.idTGActaCampo = idTGActaCampo;
	}

	public String getIdTGActaFinal() {
		return this.idTGActaFinal;
	}

	public void setIdTGActaFinal(String idTGActaFinal) {
		this.idTGActaFinal = idTGActaFinal;
	}

	public String getIdTGArea() {
		return this.idTGArea;
	}

	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}

	public String getIdTGAreaSoporte() {
		return this.idTGAreaSoporte;
	}

	public void setIdTGAreaSoporte(String idTGAreaSoporte) {
		this.idTGAreaSoporte = idTGAreaSoporte;
	}

	public String getIdTGEstadoObra() {
		return this.idTGEstadoObra;
	}

	public void setIdTGEstadoObra(String idTGEstadoObra) {
		this.idTGEstadoObra = idTGEstadoObra;
	}

	public String getIdTGProyecto() {
		return this.idTGProyecto;
	}

	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}

	public BigDecimal getImportePresupuestoLiquidacion() {
		return this.importePresupuestoLiquidacion;
	}

	public void setImportePresupuestoLiquidacion(BigDecimal importePresupuestoLiquidacion) {
		this.importePresupuestoLiquidacion = importePresupuestoLiquidacion;
	}

	public BigDecimal getImportePresupuestoOferta() {
		return this.importePresupuestoOferta;
	}

	public void setImportePresupuestoOferta(BigDecimal importePresupuestoOferta) {
		this.importePresupuestoOferta = importePresupuestoOferta;
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

	public String getNumeroOrdenCompra() {
		return this.numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public String getNumeroOrdenCompraComplementaria() {
		return this.numeroOrdenCompraComplementaria;
	}

	public void setNumeroOrdenCompraComplementaria(String numeroOrdenCompraComplementaria) {
		this.numeroOrdenCompraComplementaria = numeroOrdenCompraComplementaria;
	}

	public String getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public BigDecimal getImporteVarMas() {
		return importeVarMas;
	}

	public void setImporteVarMas(BigDecimal importeVarMas) {
		this.importeVarMas = importeVarMas;
	}

	public void setEmpleadoResponsableObra(String empleadoResponsableObra) {
		this.empleadoResponsableObra = empleadoResponsableObra;
	}

	public String getEmpleadoResponsableObra() {
		return empleadoResponsableObra;
	}

}