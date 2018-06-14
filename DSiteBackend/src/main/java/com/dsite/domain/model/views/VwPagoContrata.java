package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwPagoContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idContrata;
	private Integer idObra;
	private String codigoDSite;
	private String contrata;
    private BigDecimal importeFinal;
    private String tipoTrabajo;
    
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}
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
	public String getContrata() {
		return contrata;
	}
	public void setContrata(String contrata) {
		this.contrata = contrata;
	}
	public BigDecimal getImporteFinal() {
		return importeFinal;
	}
	public void setImporteFinal(BigDecimal importeFinal) {
		this.importeFinal = importeFinal;
	}
	public String getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
}