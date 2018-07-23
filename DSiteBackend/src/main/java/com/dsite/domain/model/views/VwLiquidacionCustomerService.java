package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the vwLiquidacionCustomerService database table.
 * 
 */
public class VwLiquidacionCustomerService implements Serializable {
	private static final long serialVersionUID = 1L;
	private String actaFinal;
	private String actaCampo;
	private String area;
	private String codigoDSite;
	private String correlativoLiquidacion;
	private String correlativoOferta;
	private String departamento;
	private String estadoFinanzas;
	private String estadoObra;
	private Date fechaActaCampo;
	private Date fechaActaFinal;
	private Date fechaCreacion;
	private Date fechaLiquidacion;
	private Date fechaOferta;
	private String gestorProyecto;
	private String idTGArea;
	private String idTGEstadoObra;
	private String idTGProyecto;
	private BigDecimal importeLiquidacion;
	private BigDecimal importeOferta;
	private BigDecimal importeVarMas;
	private BigDecimal importeVarMenos;
	private String moneda;
	private String nombreReal;
	private String numeroOrdenCompra;
	private String observacionFinanzas;
	private String OTAutogenerada;
	private String proyecto;
	private Integer idEnvioOferta;
	private Integer idEnvioLiquidacion;
	private Integer idEnvioActaCampo;
	private Integer idEnvioActaFinal;
	private Integer idPresupuestoObra;

	public VwLiquidacionCustomerService() {
	}

	public String getActaFinal() {
		return this.actaFinal;
	}

	public void setActaFinal(String actaFinal) {
		this.actaFinal = actaFinal;
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

	public String getCorrelativoLiquidacion() {
		return this.correlativoLiquidacion;
	}

	public void setCorrelativoLiquidacion(String correlativoLiquidacion) {
		this.correlativoLiquidacion = correlativoLiquidacion;
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

	public String getEstadoObra() {
		return this.estadoObra;
	}

	public void setEstadoObra(String estadoObra) {
		this.estadoObra = estadoObra;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaActaCampo() {
		return this.fechaActaCampo;
	}

	public void setFechaActaCampo(Date fechaActaCampo) {
		this.fechaActaCampo = fechaActaCampo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaActaFinal() {
		return this.fechaActaFinal;
	}

	public void setFechaActaFinal(Date fechaActaFinal) {
		this.fechaActaFinal = fechaActaFinal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaLiquidacion() {
		return this.fechaLiquidacion;
	}

	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
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

	public BigDecimal getImporteLiquidacion() {
		return this.importeLiquidacion;
	}

	public void setImporteLiquidacion(BigDecimal importeLiquidacion) {
		this.importeLiquidacion = importeLiquidacion;
	}

	public BigDecimal getImporteOferta() {
		return this.importeOferta;
	}

	public void setImporteOferta(BigDecimal importeOferta) {
		this.importeOferta = importeOferta;
	}

	public BigDecimal getImporteVarMas() {
		return this.importeVarMas;
	}

	public void setImporteVarMas(BigDecimal importeVarMas) {
		this.importeVarMas = importeVarMas;
	}

	public BigDecimal getImporteVarMenos() {
		return this.importeVarMenos;
	}

	public void setImporteVarMenos(BigDecimal importeVarMenos) {
		this.importeVarMenos = importeVarMenos;
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

	public Integer getIdEnvioOferta() {
		return idEnvioOferta;
	}

	public void setIdEnvioOferta(Integer idEnvioOferta) {
		this.idEnvioOferta = idEnvioOferta;
	}

	public Integer getIdEnvioLiquidacion() {
		return idEnvioLiquidacion;
	}

	public void setIdEnvioLiquidacion(Integer idEnvioLiquidacion) {
		this.idEnvioLiquidacion = idEnvioLiquidacion;
	}

	public Integer getIdEnvioActaCampo() {
		return idEnvioActaCampo;
	}

	public void setIdEnvioActaCampo(Integer idEnvioActaCampo) {
		this.idEnvioActaCampo = idEnvioActaCampo;
	}

	public Integer getIdEnvioActaFinal() {
		return idEnvioActaFinal;
	}

	public void setIdEnvioActaFinal(Integer idEnvioActaFinal) {
		this.idEnvioActaFinal = idEnvioActaFinal;
	}

	public String getActaCampo() {
		return actaCampo;
	}

	public void setActaCampo(String actaCampo) {
		this.actaCampo = actaCampo;
	}

	public Integer getIdPresupuestoObra() {
		return idPresupuestoObra;
	}

	public void setIdPresupuestoObra(Integer idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}
}