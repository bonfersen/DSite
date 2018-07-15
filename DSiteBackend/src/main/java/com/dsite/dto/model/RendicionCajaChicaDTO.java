package com.dsite.dto.model;

import java.util.Date;

public class RendicionCajaChicaDTO {

	private int idRendicionCajaChica;

	private String codigoDSite;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private Integer idCajaChicaObra;

	private Integer idResumenRendicionCajaChica;
	
	private String rendirCaja;
	
	private String rendirViatico;

	public RendicionCajaChicaDTO() {
	}

	public int getIdRendicionCajaChica() {
		return this.idRendicionCajaChica;
	}

	public void setIdRendicionCajaChica(int idRendicionCajaChica) {
		this.idRendicionCajaChica = idRendicionCajaChica;
	}

	public String getCodigoDSite() {
		return this.codigoDSite;
	}

	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	
	public Integer getIdCajaChicaObra() {
		return idCajaChicaObra;
	}

	public void setIdCajaChicaObra(Integer idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}

	public Integer getIdResumenRendicionCajaChica() {
		return idResumenRendicionCajaChica;
	}

	public void setIdResumenRendicionCajaChica(Integer idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}

	public String getRendirCaja() {
		return rendirCaja;
	}

	public void setRendirCaja(String rendirCaja) {
		this.rendirCaja = rendirCaja;
	}

	public String getRendirViatico() {
		return rendirViatico;
	}

	public void setRendirViatico(String rendirViatico) {
		this.rendirViatico = rendirViatico;
	}
}