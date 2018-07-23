package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwLiquidacionContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObra;
	private String codigoDSite;	
	private Integer idContratasObra;
	private Integer idContrata;
    private String contrata;
    private String tipoTrabajo;
    private BigDecimal importePresupuestoObra;
    private BigDecimal importeLiquidadacionObra;
    private BigDecimal importeAdicional;
    private String comentarioImporteAdicional;
    private BigDecimal importeDescuentoOperativo;
    private String comentarioDescuentoOperativo;
    private BigDecimal importeFinal;
    private BigDecimal importePendientePago;
    private String estadoPagoContrata;
    private BigDecimal importeTotalContratas;
    private BigDecimal importeObra;
    private BigDecimal porcentajeCostos;
    private BigDecimal importeTotalAdelanto;
    private BigDecimal porcentajePagado;
    private String idTGEstadoLiquidacion;
    
	public Integer getIdObra() {
		return idObra;
	}
	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public Integer getIdContratasObra() {
		return idContratasObra;
	}
	public void setIdContratasObra(Integer idContratasObra) {
		this.idContratasObra = idContratasObra;
	}
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}
	public String getContrata() {
		return contrata;
	}
	public void setContrata(String contrata) {
		this.contrata = contrata;
	}
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public BigDecimal getImportePresupuestoObra() {
		return importePresupuestoObra;
	}
	public void setImportePresupuestoObra(BigDecimal importePresupuestoObra) {
		this.importePresupuestoObra = importePresupuestoObra;
	}
	public BigDecimal getImporteLiquidadacionObra() {
		return importeLiquidadacionObra;
	}
	public void setImporteLiquidadacionObra(BigDecimal importeLiquidadacionObra) {
		this.importeLiquidadacionObra = importeLiquidadacionObra;
	}
	public BigDecimal getImporteAdicional() {
		return importeAdicional;
	}
	public void setImporteAdicional(BigDecimal importeAdicional) {
		this.importeAdicional = importeAdicional;
	}
	public String getComentarioImporteAdicional() {
		return comentarioImporteAdicional;
	}
	public void setComentarioImporteAdicional(String comentarioImporteAdicional) {
		this.comentarioImporteAdicional = comentarioImporteAdicional;
	}
	public BigDecimal getImporteDescuentoOperativo() {
		return importeDescuentoOperativo;
	}
	public void setImporteDescuentoOperativo(BigDecimal importeDescuentoOperativo) {
		this.importeDescuentoOperativo = importeDescuentoOperativo;
	}
	public String getComentarioDescuentoOperativo() {
		return comentarioDescuentoOperativo;
	}
	public void setComentarioDescuentoOperativo(String comentarioDescuentoOperativo) {
		this.comentarioDescuentoOperativo = comentarioDescuentoOperativo;
	}
	public BigDecimal getImporteFinal() {
		return importeFinal;
	}
	public void setImporteFinal(BigDecimal importeFinal) {
		this.importeFinal = importeFinal;
	}
	public BigDecimal getImportePendientePago() {
		return importePendientePago;
	}
	public void setImportePendientePago(BigDecimal importePendientePago) {
		this.importePendientePago = importePendientePago;
	}
	public String getEstadoPagoContrata() {
		return estadoPagoContrata;
	}
	public void setEstadoPagoContrata(String estadoPagoContrata) {
		this.estadoPagoContrata = estadoPagoContrata;
	}
	public BigDecimal getImporteTotalContratas() {
		return importeTotalContratas;
	}
	public void setImporteTotalContratas(BigDecimal importeTotalContratas) {
		this.importeTotalContratas = importeTotalContratas;
	}
	public BigDecimal getImporteObra() {
		return importeObra;
	}
	public void setImporteObra(BigDecimal importeObra) {
		this.importeObra = importeObra;
	}
	public BigDecimal getPorcentajeCostos() {
		return porcentajeCostos;
	}
	public void setPorcentajeCostos(BigDecimal porcentajeCostos) {
		this.porcentajeCostos = porcentajeCostos;
	}
	public BigDecimal getImporteTotalAdelanto() {
		return importeTotalAdelanto;
	}
	public void setImporteTotalAdelanto(BigDecimal importeTotalAdelanto) {
		this.importeTotalAdelanto = importeTotalAdelanto;
	}
	public BigDecimal getPorcentajePagado() {
		return porcentajePagado;
	}
	public void setPorcentajePagado(BigDecimal porcentajePagado) {
		this.porcentajePagado = porcentajePagado;
	}
	public String getIdTGEstadoLiquidacion() {
		return idTGEstadoLiquidacion;
	}
	public void setIdTGEstadoLiquidacion(String idTGEstadoLiquidacion) {
		this.idTGEstadoLiquidacion = idTGEstadoLiquidacion;
	}
}
