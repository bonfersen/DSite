package com.dsite.dto.model;

import java.util.Date;
import java.util.List;

public class TipoDocumentoAdjuntoDTO {

	private int idTipoDocumentoAdjunto;

	private String activo;

	private String extensionPermitida;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private String nombre;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<DocumentosAdjuntoDTO> documentosAdjuntos;

	private String idTGGrupo;

	public TipoDocumentoAdjuntoDTO() {
	}

	public int getIdTipoDocumentoAdjunto() {
		return idTipoDocumentoAdjunto;
	}

	public void setIdTipoDocumentoAdjunto(int idTipoDocumentoAdjunto) {
		this.idTipoDocumentoAdjunto = idTipoDocumentoAdjunto;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getExtensionPermitida() {
		return extensionPermitida;
	}

	public void setExtensionPermitida(String extensionPermitida) {
		this.extensionPermitida = extensionPermitida;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<DocumentosAdjuntoDTO> getDocumentosAdjuntos() {
		return documentosAdjuntos;
	}

	public void setDocumentosAdjuntos(List<DocumentosAdjuntoDTO> documentosAdjuntos) {
		this.documentosAdjuntos = documentosAdjuntos;
	}

	public String getIdTGGrupo() {
		return idTGGrupo;
	}

	public void setIdTGGrupo(String idTGGrupo) {
		this.idTGGrupo = idTGGrupo;
	}	
}