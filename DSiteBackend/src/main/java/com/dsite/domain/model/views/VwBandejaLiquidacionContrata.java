package com.dsite.domain.model.views;

import java.io.Serializable;

public class VwBandejaLiquidacionContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObra;
	private String codigoDSite;
	private String area;
	private String contrata;
	private Integer idContrata;
	private Integer idContratasObra;
	private String nombreReal;
	
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
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
}
