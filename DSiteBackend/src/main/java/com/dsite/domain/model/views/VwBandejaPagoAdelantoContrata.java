package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwBandejaPagoAdelantoContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObra;
	private String codigoDSite;
	private String area;
	private String ebc;
	private String contrata;
	private String tipoTrabajo;
	private BigDecimal importeAdelanto;
	private String ordenServicio;
	private String numeroFactura;
    private Date fechaPago;
    private BigDecimal importeTotalPendientePago;
    private BigDecimal importeAplicadoPendientePago;
    private BigDecimal solicitadoAcumulado;
    private Integer idContrata;
    private Integer idContratasObra;
    private Integer idPagosContrata;
    
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEbc() {
		return ebc;
	}
	public void setEbc(String ebc) {
		this.ebc = ebc;
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
	public BigDecimal getImporteAdelanto() {
		return importeAdelanto;
	}
	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}
	public String getOrdenServicio() {
		return ordenServicio;
	}
	public void setOrdenServicio(String ordenServicio) {
		this.ordenServicio = ordenServicio;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public BigDecimal getImporteTotalPendientePago() {
		return importeTotalPendientePago;
	}
	public void setImporteTotalPendientePago(BigDecimal importeTotalPendientePago) {
		this.importeTotalPendientePago = importeTotalPendientePago;
	}
	public BigDecimal getImporteAplicadoPendientePago() {
		return importeAplicadoPendientePago;
	}
	public void setImporteAplicadoPendientePago(BigDecimal importeAplicadoPendientePago) {
		this.importeAplicadoPendientePago = importeAplicadoPendientePago;
	}
	public BigDecimal getSolicitadoAcumulado() {
		return solicitadoAcumulado;
	}
	public void setSolicitadoAcumulado(BigDecimal solicitadoAcumulado) {
		this.solicitadoAcumulado = solicitadoAcumulado;
	}
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}
	public Integer getIdContratasObra() {
		return idContratasObra;
	}
	public void setIdContratasObra(Integer idContratasObra) {
		this.idContratasObra = idContratasObra;
	}
	public Integer getIdPagosContrata() {
		return idPagosContrata;
	}
	public void setIdPagosContrata(Integer idPagosContrata) {
		this.idPagosContrata = idPagosContrata;
	}
}
