package com.dsite.domain.model.views;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the vwBandejaCustomerService database table.
 * 
 */
public class VwBandejaCustomerService implements Serializable {
	private static final long serialVersionUID = 1L;
	private String area;
	private String codigoDSite;
	private Date fechaRecibido;
	private String idTGArea;
	private String idTGTipoEnvio;
	private BigDecimal importeOfertaLiquidacion;
	private String nombreReal;
	private String tipoEnvio;

	public VwBandejaCustomerService() {
	}


	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public String getCodigoDSite() {
		return this.codigoDSite;
	}

	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechaRecibido() {
		return this.fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}


	public String getIdTGArea() {
		return this.idTGArea;
	}

	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}


	public String getIdTGTipoEnvio() {
		return this.idTGTipoEnvio;
	}

	public void setIdTGTipoEnvio(String idTGTipoEnvio) {
		this.idTGTipoEnvio = idTGTipoEnvio;
	}


	public BigDecimal getImporteOfertaLiquidacion() {
		return this.importeOfertaLiquidacion;
	}

	public void setImporteOfertaLiquidacion(BigDecimal importeOfertaLiquidacion) {
		this.importeOfertaLiquidacion = importeOfertaLiquidacion;
	}


	public String getNombreReal() {
		return this.nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}


	public String getTipoEnvio() {
		return this.tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

}