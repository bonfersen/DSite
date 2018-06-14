package com.dsite.domain.model.views;

import java.io.Serializable;

public class VwBandejaCrm implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigoDSite;
	private String idTGArea;
	private String idTGProyecto;
	private String idTGEstadoFinanzas;
	private String nombreReal;
	private Integer idObra;
    private Integer idPresupuestoObra;
    private String proyecto;
    private String area;
    private String estadoFinanzas;
    
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public String getIdTGArea() {
		return idTGArea;
	}
	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}
	public String getIdTGProyecto() {
		return idTGProyecto;
	}
	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}
	public String getIdTGEstadoFinanzas() {
		return idTGEstadoFinanzas;
	}
	public void setIdTGEstadoFinanzas(String idTGEstadoFinanzas) {
		this.idTGEstadoFinanzas = idTGEstadoFinanzas;
	}
	public String getNombreReal() {
		return nombreReal;
	}
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	public Integer getIdObra() {
		return idObra;
	}
	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}
	public Integer getIdPresupuestoObra() {
		return idPresupuestoObra;
	}
	public void setIdPresupuestoObra(Integer idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEstadoFinanzas() {
		return estadoFinanzas;
	}
	public void setEstadoFinanzas(String estadoFinanzas) {
		this.estadoFinanzas = estadoFinanzas;
	}
}
