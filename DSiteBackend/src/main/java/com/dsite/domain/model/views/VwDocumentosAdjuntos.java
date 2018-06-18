package com.dsite.domain.model.views;

import java.io.Serializable;
import java.util.Date;

public class VwDocumentosAdjuntos implements Serializable {

	private static final long serialVersionUID = -1227588245358329699L;

	private Integer idDocumentosAdjunto;
	private String directorio;
	private String nombreArchivo;
	private Integer idTabla;
	private String idTGNombreTabla;
	private Integer idTipoDocumentoAdjunto;
	private Date fechaCreacion;
	private String usuarioCreacion;
	private Date fechaModificacion;
	private String usuarioModificacion;

	public Integer getIdDocumentosAdjunto() {
		return idDocumentosAdjunto;
	}

	public void setIdDocumentosAdjunto(Integer idDocumentosAdjunto) {
		this.idDocumentosAdjunto = idDocumentosAdjunto;
	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Integer getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(Integer idTabla) {
		this.idTabla = idTabla;
	}

	public String getIdTGNombreTabla() {
		return idTGNombreTabla;
	}

	public void setIdTGNombreTabla(String idTGNombreTabla) {
		this.idTGNombreTabla = idTGNombreTabla;
	}

	public Integer getIdTipoDocumentoAdjunto() {
		return idTipoDocumentoAdjunto;
	}

	public void setIdTipoDocumentoAdjunto(Integer idTipoDocumentoAdjunto) {
		this.idTipoDocumentoAdjunto = idTipoDocumentoAdjunto;
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

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
}
