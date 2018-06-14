package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwBandejaAdelantoRechazadoContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObra;
	private String codigoDSite;
	private String area;
	private String contrata;
	private String tipoTrabajo;
	private BigDecimal importePresupuestoObra;
	private BigDecimal importeTotalAdelanto;
	private BigDecimal importeAdelanto;
	private BigDecimal solicitadoAcumulado;
	private String motivoRechazo;
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
	public BigDecimal getImporteTotalAdelanto() {
		return importeTotalAdelanto;
	}
	public void setImporteTotalAdelanto(BigDecimal importeTotalAdelanto) {
		this.importeTotalAdelanto = importeTotalAdelanto;
	}
	public BigDecimal getImporteAdelanto() {
		return importeAdelanto;
	}
	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}
	public BigDecimal getSolicitadoAcumulado() {
		return solicitadoAcumulado;
	}
	public void setSolicitadoAcumulado(BigDecimal solicitadoAcumulado) {
		this.solicitadoAcumulado = solicitadoAcumulado;
	}
	public String getMotivoRechazo() {
		return motivoRechazo;
	}
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
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
