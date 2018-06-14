package com.dsite.dto.model.views;

import javax.persistence.Lob;


public class VwListaActasContrataFilter {

	private String actasContrata;
	private int idContratasObra;

	public VwListaActasContrataFilter() {
	}


	@Lob
	public String getActasContrata() {
		return this.actasContrata;
	}

	public void setActasContrata(String actasContrata) {
		this.actasContrata = actasContrata;
	}


	public int getIdContratasObra() {
		return this.idContratasObra;
	}

	public void setIdContratasObra(int idContratasObra) {
		this.idContratasObra = idContratasObra;
	}

}