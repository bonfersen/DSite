package com.dsite.domain.model.views;

import java.io.Serializable;

/**
 * The persistent class for the vwBandejaBudget database table.
 * 
 */
public class VwBandejaBudget implements Serializable {
	private static final long serialVersionUID = 1L;
	private String area;
	private String codigoDSite;
	private String departamento;
	private String estadoObra;
	private String idTGArea;
	private String idTGEstadoObra;
	private String idTGProyecto;
	private String nombreReal;
	private String proyecto;

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

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getEstadoObra() {
		return this.estadoObra;
	}

	public void setEstadoObra(String estadoObra) {
		this.estadoObra = estadoObra;
	}

	public String getIdTGArea() {
		return this.idTGArea;
	}

	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}

	public String getIdTGEstadoObra() {
		return this.idTGEstadoObra;
	}

	public void setIdTGEstadoObra(String idTGEstadoObra) {
		this.idTGEstadoObra = idTGEstadoObra;
	}

	public String getIdTGProyecto() {
		return this.idTGProyecto;
	}

	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}

	public String getNombreReal() {
		return this.nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

}