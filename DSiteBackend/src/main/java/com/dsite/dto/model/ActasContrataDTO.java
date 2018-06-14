package com.dsite.dto.model;

import java.util.Date;

public class ActasContrataDTO {

	private int idActasContrata;

	private Date fechaAdjunto;

	private Date fechaAprobacion;

	private Date fechaCreacion;

	private Date fechaRechazo;

	private String usuarioCreacion;

	private String idTGActas;

	private int idContratasObra;

	private String idTGEstadoActa;

	private String idTGMotivoRechazo;

	private int idUsuarioRechaza;

	private int idUsuarioAprueba;

	private int idUsuarioAdjunta;

	public ActasContrataDTO() {
	}

	public int getIdActasContrata() {
		return idActasContrata;
	}

	public void setIdActasContrata(int idActasContrata) {
		this.idActasContrata = idActasContrata;
	}

	public Date getFechaAdjunto() {
		return fechaAdjunto;
	}

	public void setFechaAdjunto(Date fechaAdjunto) {
		this.fechaAdjunto = fechaAdjunto;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getIdTGActas() {
		return idTGActas;
	}

	public void setIdTGActas(String idTGActas) {
		this.idTGActas = idTGActas;
	}

	public int getIdContratasObra() {
		return idContratasObra;
	}

	public void setIdContratasObra(int idContratasObra) {
		this.idContratasObra = idContratasObra;
	}

	public String getIdTGEstadoActa() {
		return idTGEstadoActa;
	}

	public void setIdTGEstadoActa(String idTGEstadoActa) {
		this.idTGEstadoActa = idTGEstadoActa;
	}

	public String getIdTGMotivoRechazo() {
		return idTGMotivoRechazo;
	}

	public void setIdTGMotivoRechazo(String idTGMotivoRechazo) {
		this.idTGMotivoRechazo = idTGMotivoRechazo;
	}

	public int getIdUsuarioRechaza() {
		return idUsuarioRechaza;
	}

	public void setIdUsuarioRechaza(int idUsuarioRechaza) {
		this.idUsuarioRechaza = idUsuarioRechaza;
	}

	public int getIdUsuarioAprueba() {
		return idUsuarioAprueba;
	}

	public void setIdUsuarioAprueba(int idUsuarioAprueba) {
		this.idUsuarioAprueba = idUsuarioAprueba;
	}

	public int getIdUsuarioAdjunta() {
		return idUsuarioAdjunta;
	}

	public void setIdUsuarioAdjunta(int idUsuarioAdjunta) {
		this.idUsuarioAdjunta = idUsuarioAdjunta;
	}
}