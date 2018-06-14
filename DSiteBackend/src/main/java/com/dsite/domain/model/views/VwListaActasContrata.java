package com.dsite.domain.model.views;

import java.io.Serializable;
import javax.persistence.*;


/** 
 * The persistent class for the vwListaActasContrata database table.
 * 
 */
public class VwListaActasContrata implements Serializable {
	private static final long serialVersionUID = 1L;
	private String actasContrata;
	private int idContratasObra;

	public VwListaActasContrata() {
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