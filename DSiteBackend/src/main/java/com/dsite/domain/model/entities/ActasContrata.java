package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the actasContrata database table.
 * 
 */
@Entity
@Table(name = "actasContrata")
@NamedQuery(name="ActasContrata.findAll", query="SELECT a FROM ActasContrata a")
public class ActasContrata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActasContrata;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAdjunto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRechazo;

	private String usuarioCreacion;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGActas")
	private TablaGeneral tablaGeneralActas;

	//bi-directional many-to-one association to ContratasObra
	@ManyToOne
	@JoinColumn(name="idContratasObra")
	private ContratasObra contratasObra;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGEstadoActa")
	private TablaGeneral tablaGeneralEstadoActa;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGMotivoRechazo")
	private TablaGeneral tablaGeneralMotivoRechazo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioRechaza")
	private Usuario usuarioRechaza;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioAprueba")
	private Usuario usuarioAprueba;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioAdjunta")
	private Usuario usuarioAdjunta;

	public ActasContrata() {
	}

	public int getIdActasContrata() {
		return this.idActasContrata;
	}

	public void setIdActasContrata(int idActasContrata) {
		this.idActasContrata = idActasContrata;
	}

	public Date getFechaAdjunto() {
		return this.fechaAdjunto;
	}

	public void setFechaAdjunto(Date fechaAdjunto) {
		this.fechaAdjunto = fechaAdjunto;
	}

	public Date getFechaAprobacion() {
		return this.fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRechazo() {
		return this.fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public TablaGeneral getTablaGeneralActas() {
		return this.tablaGeneralActas;
	}

	public void setTablaGeneralActas(TablaGeneral tablaGeneralActas) {
		this.tablaGeneralActas = tablaGeneralActas;
	}

	public ContratasObra getContratasObra() {
		return this.contratasObra;
	}

	public void setContratasObra(ContratasObra contratasObra) {
		this.contratasObra = contratasObra;
	}

	public TablaGeneral getTablaGeneralEstadoActa() {
		return this.tablaGeneralEstadoActa;
	}

	public void setTablaGeneralEstadoActa(TablaGeneral tablaGeneralEstadoActa) {
		this.tablaGeneralEstadoActa = tablaGeneralEstadoActa;
	}

	public TablaGeneral getTablaGeneralMotivoRechazo() {
		return this.tablaGeneralMotivoRechazo;
	}

	public void setTablaGeneralMotivoRechazo(TablaGeneral tablaGeneralMotivoRechazo) {
		this.tablaGeneralMotivoRechazo = tablaGeneralMotivoRechazo;
	}

	public Usuario getUsuarioRechaza() {
		return this.usuarioRechaza;
	}

	public void setUsuarioRechaza(Usuario usuarioRechaza) {
		this.usuarioRechaza = usuarioRechaza;
	}

	public Usuario getUsuarioAprueba() {
		return this.usuarioAprueba;
	}

	public void setUsuarioAprueba(Usuario usuarioAprueba) {
		this.usuarioAprueba = usuarioAprueba;
	}

	public Usuario getUsuarioAdjunta() {
		return this.usuarioAdjunta;
	}

	public void setUsuarioAdjunta(Usuario usuarioAdjunta) {
		this.usuarioAdjunta = usuarioAdjunta;
	}

}