package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the vwListaContratasAsignadas database table.
 * 
 */
public class VwListaContratasAsignada implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String actasContrata;
	private int idContratasObra;
	private int idObra;
	private BigDecimal importePresupuestoObra;
	private BigDecimal importeTipoCambio;
	private String moneda;
	private String nombreCorto;
	private String tipoTrabajo;

	public VwListaContratasAsignada() {
	}

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


	public int getIdObra() {
		return this.idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}


	public BigDecimal getImportePresupuestoObra() {
		return this.importePresupuestoObra;
	}

	public void setImportePresupuestoObra(BigDecimal importePresupuestoObra) {
		this.importePresupuestoObra = importePresupuestoObra;
	}


	public BigDecimal getImporteTipoCambio() {
		return this.importeTipoCambio;
	}

	public void setImporteTipoCambio(BigDecimal importeTipoCambio) {
		this.importeTipoCambio = importeTipoCambio;
	}


	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}


	public String getTipoTrabajo() {
		return this.tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

}