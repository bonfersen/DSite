package com.dsite.dto.model;

import java.util.Date;

public class DocumentosAdjuntoDTO {

	private int idDocumentosAdjunto;

	private String directorio;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private int idTabla;

	private String nombreArchivo;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private String idTGNombreTabla;

	private int idTipoDocumentoAdjunto;

	public DocumentosAdjuntoDTO() {
	}

	public int getIdDocumentosAdjunto() {
		return idDocumentosAdjunto;
	}

	public void setIdDocumentosAdjunto(int idDocumentosAdjunto) {
		this.idDocumentosAdjunto = idDocumentosAdjunto;
	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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

	public String getIdTGNombreTabla() {
		return idTGNombreTabla;
	}

	public void setIdTGNombreTabla(String idTGNombreTabla) {
		this.idTGNombreTabla = idTGNombreTabla;
	}

	public int getIdTipoDocumentoAdjunto() {
		return idTipoDocumentoAdjunto;
	}

	public void setIdTipoDocumentoAdjunto(int idTipoDocumentoAdjunto) {
		this.idTipoDocumentoAdjunto = idTipoDocumentoAdjunto;
	}
}