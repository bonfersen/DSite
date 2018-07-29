package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwReporteEconomico implements Serializable {

	private static final long serialVersionUID = -4525840360676450393L;
	private String codigoDSite;
	private String nombreReal;
	private String area;
	private String proyecto;
	private String gestor;
	private String departamento;
	private String asignacion;
	private BigDecimal importeIngreso;
	private BigDecimal importePresupuestoOferta;
	private BigDecimal importeIngresoOferta;
	private String ordenCompra;
	private String facturado;
	private BigDecimal importeLiquidacionOferta;
	private BigDecimal importeIngresoLiquidacion;
	private String actas;
	private Date fechaLiquidacion;
	private String estatusGep;
	private BigDecimal variacionMas;
	private String numeroOrdenCompraComplementaria;
	private BigDecimal variacionMenos;
	private String notaCredito;
	private BigDecimal importeGastos;
	private BigDecimal importeRentabilidad;
	private BigDecimal porcentajeRentabilidad;
	private BigDecimal importeTotalPresupuestadoContrata;
	private BigDecimal importeTotalPagosContrata;
	private BigDecimal importeCajas;
	private BigDecimal importeViaticos;
	private BigDecimal importeTotalCajas;
	
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
	public BigDecimal getImportePresupuestoOferta() {
		return importePresupuestoOferta;
	}
	public void setImportePresupuestoOferta(BigDecimal importePresupuestoOferta) {
		this.importePresupuestoOferta = importePresupuestoOferta;
	}
	public BigDecimal getImporteIngresoOferta() {
		return importeIngresoOferta;
	}
	public void setImporteIngresoOferta(BigDecimal importeIngresoOferta) {
		this.importeIngresoOferta = importeIngresoOferta;
	}
	public String getOrdenCompra() {
		return ordenCompra;
	}
	public void setOrdenCompra(String ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	public String getFacturado() {
		return facturado;
	}
	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}
	public BigDecimal getImporteLiquidacionOferta() {
		return importeLiquidacionOferta;
	}
	public void setImporteLiquidacionOferta(BigDecimal importeLiquidacionOferta) {
		this.importeLiquidacionOferta = importeLiquidacionOferta;
	}
	public BigDecimal getImporteIngresoLiquidacion() {
		return importeIngresoLiquidacion;
	}
	public void setImporteIngresoLiquidacion(BigDecimal importeIngresoLiquidacion) {
		this.importeIngresoLiquidacion = importeIngresoLiquidacion;
	}
	public String getActas() {
		return actas;
	}
	public void setActas(String actas) {
		this.actas = actas;
	}
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}
	public String getEstatusGep() {
		return estatusGep;
	}
	public void setEstatusGep(String estatusGep) {
		this.estatusGep = estatusGep;
	}
	public BigDecimal getVariacionMas() {
		return variacionMas;
	}
	public void setVariacionMas(BigDecimal variacionMas) {
		this.variacionMas = variacionMas;
	}
	public String getNumeroOrdenCompraComplementaria() {
		return numeroOrdenCompraComplementaria;
	}
	public void setNumeroOrdenCompraComplementaria(String numeroOrdenCompraComplementaria) {
		this.numeroOrdenCompraComplementaria = numeroOrdenCompraComplementaria;
	}
	public BigDecimal getVariacionMenos() {
		return variacionMenos;
	}
	public void setVariacionMenos(BigDecimal variacionMenos) {
		this.variacionMenos = variacionMenos;
	}
	public String getNotaCredito() {
		return notaCredito;
	}
	public void setNotaCredito(String notaCredito) {
		this.notaCredito = notaCredito;
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
	public BigDecimal getImporteTotalPresupuestadoContrata() {
		return importeTotalPresupuestadoContrata;
	}
	public void setImporteTotalPresupuestadoContrata(BigDecimal importeTotalPresupuestadoContrata) {
		this.importeTotalPresupuestadoContrata = importeTotalPresupuestadoContrata;
	}
	public BigDecimal getImporteTotalPagosContrata() {
		return importeTotalPagosContrata;
	}
	public void setImporteTotalPagosContrata(BigDecimal importeTotalPagosContrata) {
		this.importeTotalPagosContrata = importeTotalPagosContrata;
	}
	public BigDecimal getImporteCajas() {
		return importeCajas;
	}
	public void setImporteCajas(BigDecimal importeCajas) {
		this.importeCajas = importeCajas;
	}
	public BigDecimal getImporteViaticos() {
		return importeViaticos;
	}
	public void setImporteViaticos(BigDecimal importeViaticos) {
		this.importeViaticos = importeViaticos;
	}
	public BigDecimal getImporteTotalCajas() {
		return importeTotalCajas;
	}
	public void setImporteTotalCajas(BigDecimal importeTotalCajas) {
		this.importeTotalCajas = importeTotalCajas;
	}
}
