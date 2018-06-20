package com.dsite.dto.model;

import java.util.Date;
import java.util.List;

public class CierreEconomicoDTO {
	
	private Integer idCierreEconomico;

	private String codigoCierre;

	private Date fechaAsignacion;

	private Date fechaCreacion;

	private String usuarioCreacion;

	private String idTGEstadoCierreEconomico;

	private Integer idUsuarioAsignacion;

	private List<CierreEconomicoObraDTO> cierreEconomicoObras;

	public Integer getIdCierreEconomico() {
		return idCierreEconomico;
	}

	public void setIdCierreEconomico(Integer idCierreEconomico) {
		this.idCierreEconomico = idCierreEconomico;
	}

	public String getCodigoCierre() {
		return codigoCierre;
	}

	public void setCodigoCierre(String codigoCierre) {
		this.codigoCierre = codigoCierre;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getIdTGEstadoCierreEconomico() {
		return idTGEstadoCierreEconomico;
	}

	public void setIdTGEstadoCierreEconomico(String idTGEstadoCierreEconomico) {
		this.idTGEstadoCierreEconomico = idTGEstadoCierreEconomico;
	}

	public Integer getIdUsuarioAsignacion() {
		return idUsuarioAsignacion;
	}

	public void setIdUsuarioAsignacion(Integer idUsuarioAsignacion) {
		this.idUsuarioAsignacion = idUsuarioAsignacion;
	}

	public List<CierreEconomicoObraDTO> getCierreEconomicoObras() {
		return cierreEconomicoObras;
	}

	public void setCierreEconomicoObras(List<CierreEconomicoObraDTO> cierreEconomicoObras) {
		this.cierreEconomicoObras = cierreEconomicoObras;
	}
}