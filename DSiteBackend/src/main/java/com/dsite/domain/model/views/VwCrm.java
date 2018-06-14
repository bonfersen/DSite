package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwCrm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigoDSite;
	private Integer idObra;
	private Integer idPresupuestoObra;
	private String correlativoOfertaLiquidacion;
    private String idTGArea;
    private String area;
    private String idTGProyecto;
    private String proyecto;
    private String idTGGestorProyecto;
    private String gestorProyecto;
    private String idTGGerenteProyecto;
    private String gerenteProyecto;
    private String OTAutogenerada;
    private String departamento;
    private String idTGTipoGasto;
    private String tipoGasto;
    private Date fechaCreacion;
    private String nombreReal;
    private String numeroOrdenCompra;
    private String idTGEstadoFinanzas;
    private String estadoFinanzas;
    private Date fechaLiquidacion;
    private BigDecimal importePresupuestoOferta;
    private BigDecimal importePresupuestoLiquidacion;
    private Integer idEnvioOferta;
    private BigDecimal importeOferta;
    private Integer idEnvioLiquidacion;
    private BigDecimal importeLiquidacion;
    private BigDecimal importeVarMas;
    private BigDecimal importeVarMenos;
    private Integer idEnvioActaCampo;
    private String actaCampo;
    private Date fechaActaCampo;
    private Integer idEnvioActaFinal;
    private String actaFinal;
    private Date fechaActaFinal;
    private String estadoActaAdministracion;
    private BigDecimal importeOrdenCompra;
    private String cetificado;
    private String facturaDSite;
    private BigDecimal importeOrdenCompraComplementaria;
    private String numeroOrdenCompraComplementaria;
    private String cetificadoComplementaria;
    private String facturaDSiteComplementaria;
    private String notaCredito;
    private String idTGEstadoObra;
    private String estadoObra;
    private String estadoActaCampo;
    private String estadoActaFinal;
    
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public Integer getIdObra() {
		return idObra;
	}
	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}
	public Integer getIdPresupuestoObra() {
		return idPresupuestoObra;
	}
	public void setIdPresupuestoObra(Integer idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}
	public String getCorrelativoOfertaLiquidacion() {
		return correlativoOfertaLiquidacion;
	}
	public void setCorrelativoOfertaLiquidacion(String correlativoOfertaLiquidacion) {
		this.correlativoOfertaLiquidacion = correlativoOfertaLiquidacion;
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
	public String getIdTGGestorProyecto() {
		return idTGGestorProyecto;
	}
	public void setIdTGGestorProyecto(String idTGGestorProyecto) {
		this.idTGGestorProyecto = idTGGestorProyecto;
	}
	public String getGestorProyecto() {
		return gestorProyecto;
	}
	public void setGestorProyecto(String gestorProyecto) {
		this.gestorProyecto = gestorProyecto;
	}
	public String getIdTGGerenteProyecto() {
		return idTGGerenteProyecto;
	}
	public void setIdTGGerenteProyecto(String idTGGerenteProyecto) {
		this.idTGGerenteProyecto = idTGGerenteProyecto;
	}
	public String getGerenteProyecto() {
		return gerenteProyecto;
	}
	public void setGerenteProyecto(String gerenteProyecto) {
		this.gerenteProyecto = gerenteProyecto;
	}
	public String getOTAutogenerada() {
		return OTAutogenerada;
	}
	public void setOTAutogenerada(String oTAutogenerada) {
		OTAutogenerada = oTAutogenerada;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getIdTGTipoGasto() {
		return idTGTipoGasto;
	}
	public void setIdTGTipoGasto(String idTGTipoGasto) {
		this.idTGTipoGasto = idTGTipoGasto;
	}
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}
	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}
	public String getIdTGEstadoFinanzas() {
		return idTGEstadoFinanzas;
	}
	public void setIdTGEstadoFinanzas(String idTGEstadoFinanzas) {
		this.idTGEstadoFinanzas = idTGEstadoFinanzas;
	}
	public String getEstadoFinanzas() {
		return estadoFinanzas;
	}
	public void setEstadoFinanzas(String estadoFinanzas) {
		this.estadoFinanzas = estadoFinanzas;
	}
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}
	public BigDecimal getImportePresupuestoOferta() {
		return importePresupuestoOferta;
	}
	public void setImportePresupuestoOferta(BigDecimal importePresupuestoOferta) {
		this.importePresupuestoOferta = importePresupuestoOferta;
	}
	public BigDecimal getImportePresupuestoLiquidacion() {
		return importePresupuestoLiquidacion;
	}
	public void setImportePresupuestoLiquidacion(BigDecimal importePresupuestoLiquidacion) {
		this.importePresupuestoLiquidacion = importePresupuestoLiquidacion;
	}
	public Integer getIdEnvioOferta() {
		return idEnvioOferta;
	}
	public void setIdEnvioOferta(Integer idEnvioOferta) {
		this.idEnvioOferta = idEnvioOferta;
	}
	public BigDecimal getImporteOferta() {
		return importeOferta;
	}
	public void setImporteOferta(BigDecimal importeOferta) {
		this.importeOferta = importeOferta;
	}
	public Integer getIdEnvioLiquidacion() {
		return idEnvioLiquidacion;
	}
	public void setIdEnvioLiquidacion(Integer idEnvioLiquidacion) {
		this.idEnvioLiquidacion = idEnvioLiquidacion;
	}
	public BigDecimal getImporteLiquidacion() {
		return importeLiquidacion;
	}
	public void setImporteLiquidacion(BigDecimal importeLiquidacion) {
		this.importeLiquidacion = importeLiquidacion;
	}
	public BigDecimal getImporteVarMas() {
		return importeVarMas;
	}
	public void setImporteVarMas(BigDecimal importeVarMas) {
		this.importeVarMas = importeVarMas;
	}
	public BigDecimal getImporteVarMenos() {
		return importeVarMenos;
	}
	public void setImporteVarMenos(BigDecimal importeVarMenos) {
		this.importeVarMenos = importeVarMenos;
	}
	public Integer getIdEnvioActaCampo() {
		return idEnvioActaCampo;
	}
	public void setIdEnvioActaCampo(Integer idEnvioActaCampo) {
		this.idEnvioActaCampo = idEnvioActaCampo;
	}
	public String getActaCampo() {
		return actaCampo;
	}
	public void setActaCampo(String actaCampo) {
		this.actaCampo = actaCampo;
	}
	public Date getFechaActaCampo() {
		return fechaActaCampo;
	}
	public void setFechaActaCampo(Date fechaActaCampo) {
		this.fechaActaCampo = fechaActaCampo;
	}
	public Integer getIdEnvioActaFinal() {
		return idEnvioActaFinal;
	}
	public void setIdEnvioActaFinal(Integer idEnvioActaFinal) {
		this.idEnvioActaFinal = idEnvioActaFinal;
	}
	public String getActaFinal() {
		return actaFinal;
	}
	public void setActaFinal(String actaFinal) {
		this.actaFinal = actaFinal;
	}
	public Date getFechaActaFinal() {
		return fechaActaFinal;
	}
	public void setFechaActaFinal(Date fechaActaFinal) {
		this.fechaActaFinal = fechaActaFinal;
	}
	public String getEstadoActaAdministracion() {
		return estadoActaAdministracion;
	}
	public void setEstadoActaAdministracion(String estadoActaAdministracion) {
		this.estadoActaAdministracion = estadoActaAdministracion;
	}
	public BigDecimal getImporteOrdenCompra() {
		return importeOrdenCompra;
	}
	public void setImporteOrdenCompra(BigDecimal importeOrdenCompra) {
		this.importeOrdenCompra = importeOrdenCompra;
	}
	public String getCetificado() {
		return cetificado;
	}
	public void setCetificado(String cetificado) {
		this.cetificado = cetificado;
	}
	public String getFacturaDSite() {
		return facturaDSite;
	}
	public void setFacturaDSite(String facturaDSite) {
		this.facturaDSite = facturaDSite;
	}
	public BigDecimal getImporteOrdenCompraComplementaria() {
		return importeOrdenCompraComplementaria;
	}
	public void setImporteOrdenCompraComplementaria(BigDecimal importeOrdenCompraComplementaria) {
		this.importeOrdenCompraComplementaria = importeOrdenCompraComplementaria;
	}
	public String getNumeroOrdenCompraComplementaria() {
		return numeroOrdenCompraComplementaria;
	}
	public void setNumeroOrdenCompraComplementaria(String numeroOrdenCompraComplementaria) {
		this.numeroOrdenCompraComplementaria = numeroOrdenCompraComplementaria;
	}
	public String getCetificadoComplementaria() {
		return cetificadoComplementaria;
	}
	public void setCetificadoComplementaria(String cetificadoComplementaria) {
		this.cetificadoComplementaria = cetificadoComplementaria;
	}
	public String getFacturaDSiteComplementaria() {
		return facturaDSiteComplementaria;
	}
	public void setFacturaDSiteComplementaria(String facturaDSiteComplementaria) {
		this.facturaDSiteComplementaria = facturaDSiteComplementaria;
	}
	public String getNotaCredito() {
		return notaCredito;
	}
	public void setNotaCredito(String notaCredito) {
		this.notaCredito = notaCredito;
	}
	public String getIdTGEstadoObra() {
		return idTGEstadoObra;
	}
	public void setIdTGEstadoObra(String idTGEstadoObra) {
		this.idTGEstadoObra = idTGEstadoObra;
	}
	public String getEstadoObra() {
		return estadoObra;
	}
	public void setEstadoObra(String estadoObra) {
		this.estadoObra = estadoObra;
	}
	public String getEstadoActaCampo() {
		return estadoActaCampo;
	}
	public void setEstadoActaCampo(String estadoActaCampo) {
		this.estadoActaCampo = estadoActaCampo;
	}
	public String getEstadoActaFinal() {
		return estadoActaFinal;
	}
	public void setEstadoActaFinal(String estadoActaFinal) {
		this.estadoActaFinal = estadoActaFinal;
	}
}
