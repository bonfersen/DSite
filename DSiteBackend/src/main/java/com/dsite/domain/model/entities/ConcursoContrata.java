package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the concursoContrata database table.
 * 
 */
@Entity
@Table(name = "concursoContrata")
@NamedQuery(name="ConcursoContrata.findAll", query="SELECT c FROM ConcursoContrata c")
public class ConcursoContrata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idConcursoContrata;

	private String codigoConcurso;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinAbjudicacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioAbjudicacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private BigDecimal importeAbjudicado;

	private BigDecimal porcentajeFondoGarantia;

	private short tiempoFondoGarantia;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to Contrata
	@ManyToOne
	@JoinColumn(name="idContrata")
	private Contrata contrata;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGArea")
	private TablaGeneral tablaGeneralArea;

	public ConcursoContrata() {
	}

	public int getIdConcursoContrata() {
		return this.idConcursoContrata;
	}

	public void setIdConcursoContrata(int idConcursoContrata) {
		this.idConcursoContrata = idConcursoContrata;
	}

	public String getCodigoConcurso() {
		return this.codigoConcurso;
	}

	public void setCodigoConcurso(String codigoConcurso) {
		this.codigoConcurso = codigoConcurso;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinAbjudicacion() {
		return this.fechaFinAbjudicacion;
	}

	public void setFechaFinAbjudicacion(Date fechaFinAbjudicacion) {
		this.fechaFinAbjudicacion = fechaFinAbjudicacion;
	}

	public Date getFechaInicioAbjudicacion() {
		return this.fechaInicioAbjudicacion;
	}

	public void setFechaInicioAbjudicacion(Date fechaInicioAbjudicacion) {
		this.fechaInicioAbjudicacion = fechaInicioAbjudicacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getImporteAbjudicado() {
		return this.importeAbjudicado;
	}

	public void setImporteAbjudicado(BigDecimal importeAbjudicado) {
		this.importeAbjudicado = importeAbjudicado;
	}

	public BigDecimal getPorcentajeFondoGarantia() {
		return this.porcentajeFondoGarantia;
	}

	public void setPorcentajeFondoGarantia(BigDecimal porcentajeFondoGarantia) {
		this.porcentajeFondoGarantia = porcentajeFondoGarantia;
	}

	public short getTiempoFondoGarantia() {
		return this.tiempoFondoGarantia;
	}

	public void setTiempoFondoGarantia(short tiempoFondoGarantia) {
		this.tiempoFondoGarantia = tiempoFondoGarantia;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Contrata getContrata() {
		return this.contrata;
	}

	public void setContrata(Contrata contrata) {
		this.contrata = contrata;
	}

	public TablaGeneral getTablaGeneralArea() {
		return this.tablaGeneralArea;
	}

	public void setTablaGeneralArea(TablaGeneral tablaGeneralArea) {
		this.tablaGeneralArea = tablaGeneralArea;
	}

}