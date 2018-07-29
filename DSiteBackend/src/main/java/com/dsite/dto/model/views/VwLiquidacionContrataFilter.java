package com.dsite.dto.model.views;

import java.lang.reflect.Field;

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
	
	public boolean checkNull() throws IllegalAccessException {
	    for (Field f : getClass().getDeclaredFields())
	        if (f.get(this) != null)
	            return false;
	    return true;            
	}
}
