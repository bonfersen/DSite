package com.dsite.dto.model.views;

public class VwLiquidacionContrataFilter {
// (filtrar por codigoDSite tipoTrabajo idContrata) OK
	private String codigoDSite;
	private Integer idContrata;
	private String tipoTrabajo;
	
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
}
