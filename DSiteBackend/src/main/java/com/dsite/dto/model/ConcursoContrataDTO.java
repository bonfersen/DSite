package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;

public class ConcursoContrataDTO {

	private int idConcursoContrata;

	private String codigoConcurso;

	private Date fechaCreacion;

	private Date fechaFinAbjudicacion;

	private Date fechaInicioAbjudicacion;

	private Date fechaModificacion;

	private BigDecimal importeAbjudicado;

	private BigDecimal porcentajeFondoGarantia;

	private short tiempoFondoGarantia;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private int idContrata;

	private String idTGArea;

	private Date fechaCreacionContrataObra;
	
	private String idTGAreaContrataObra;

	public ConcursoContrataDTO() {
	}

	public int getIdConcursoContrata() {
		return idConcursoContrata;
	}

	public void setIdConcursoContrata(int idConcursoContrata) {
		this.idConcursoContrata = idConcursoContrata;
	}

	public String getCodigoConcurso() {
		return codigoConcurso;
	}

	public void setCodigoConcurso(String codigoConcurso) {
		this.codigoConcurso = codigoConcurso;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinAbjudicacion() {
		return fechaFinAbjudicacion;
	}

	public void setFechaFinAbjudicacion(Date fechaFinAbjudicacion) {
		this.fechaFinAbjudicacion = fechaFinAbjudicacion;
	}

	public Date getFechaInicioAbjudicacion() {
		return fechaInicioAbjudicacion;
	}

	public void setFechaInicioAbjudicacion(Date fechaInicioAbjudicacion) {
		this.fechaInicioAbjudicacion = fechaInicioAbjudicacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getImporteAbjudicado() {
		return importeAbjudicado;
	}

	public void setImporteAbjudicado(BigDecimal importeAbjudicado) {
		this.importeAbjudicado = importeAbjudicado;
	}

	public BigDecimal getPorcentajeFondoGarantia() {
		return porcentajeFondoGarantia;
	}

	public void setPorcentajeFondoGarantia(BigDecimal porcentajeFondoGarantia) {
		this.porcentajeFondoGarantia = porcentajeFondoGarantia;
	}

	public short getTiempoFondoGarantia() {
		return tiempoFondoGarantia;
	}

	public void setTiempoFondoGarantia(short tiempoFondoGarantia) {
		this.tiempoFondoGarantia = tiempoFondoGarantia;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public int getIdContrata() {
		return idContrata;
	}

	public void setIdContrata(int idContrata) {
		this.idContrata = idContrata;
	}

	public String getIdTGArea() {
		return idTGArea;
	}

	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}

	public Date getFechaCreacionContrataObra() {
		return fechaCreacionContrataObra;
	}

	public void setFechaCreacionContrataObra(Date fechaCreacionContrataObra) {
		this.fechaCreacionContrataObra = fechaCreacionContrataObra;
	}

	public String getIdTGAreaContrataObra() {
		return idTGAreaContrataObra;
	}

	public void setIdTGAreaContrataObra(String idTGAreaContrataObra) {
		this.idTGAreaContrataObra = idTGAreaContrataObra;
	}
}