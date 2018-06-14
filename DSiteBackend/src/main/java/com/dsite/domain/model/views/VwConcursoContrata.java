package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwConcursoContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private String categoria;	
	private String nombreCorto;    
	private BigDecimal importeAbjudicado;    
	private String codigoConcurso;	
	private BigDecimal porcentajeFondoGarantia;    
	private Integer tiempoFondoGarantia;    
	private Integer idConcursoContrata;
	private Integer idContrata;
	private String idTGCategoria;
	private String idTGArea;
	private Date fechaInicioAbjudicacion;
	private Date fechaFinAbjudicacion;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public BigDecimal getImporteAbjudicado() {
		return importeAbjudicado;
	}
	public void setImporteAbjudicado(BigDecimal importeAbjudicado) {
		this.importeAbjudicado = importeAbjudicado;
	}
	public String getCodigoConcurso() {
		return codigoConcurso;
	}
	public void setCodigoConcurso(String codigoConcurso) {
		this.codigoConcurso = codigoConcurso;
	}
	public BigDecimal getPorcentajeFondoGarantia() {
		return porcentajeFondoGarantia;
	}
	public void setPorcentajeFondoGarantia(BigDecimal porcentajeFondoGarantia) {
		this.porcentajeFondoGarantia = porcentajeFondoGarantia;
	}
	public Integer getTiempoFondoGarantia() {
		return tiempoFondoGarantia;
	}
	public void setTiempoFondoGarantia(Integer tiempoFondoGarantia) {
		this.tiempoFondoGarantia = tiempoFondoGarantia;
	}
	public Integer getIdConcursoContrata() {
		return idConcursoContrata;
	}
	public void setIdConcursoContrata(Integer idConcursoContrata) {
		this.idConcursoContrata = idConcursoContrata;
	}
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}
	public String getIdTGCategoria() {
		return idTGCategoria;
	}
	public void setIdTGCategoria(String idTGCategoria) {
		this.idTGCategoria = idTGCategoria;
	}
	public String getIdTGArea() {
		return idTGArea;
	}
	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}
	public Date getFechaInicioAbjudicacion() {
		return fechaInicioAbjudicacion;
	}
	public void setFechaInicioAbjudicacion(Date fechaInicioAbjudicacion) {
		this.fechaInicioAbjudicacion = fechaInicioAbjudicacion;
	}
	public Date getFechaFinAbjudicacion() {
		return fechaFinAbjudicacion;
	}
	public void setFechaFinAbjudicacion(Date fechaFinAbjudicacion) {
		this.fechaFinAbjudicacion = fechaFinAbjudicacion;
	}
}
