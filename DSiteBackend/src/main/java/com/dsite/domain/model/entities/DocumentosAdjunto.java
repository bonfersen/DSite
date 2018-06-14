package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the documentosAdjunto database table.
 * 
 */
@Entity
@Table(name = "documentosAdjunto")
@NamedQuery(name="DocumentosAdjunto.findAll", query="SELECT d FROM DocumentosAdjunto d")
public class DocumentosAdjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDocumentosAdjunto;

	private String directorio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private int idTabla;

	private String nombreArchivo;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGNombreTabla")
	private TablaGeneral tablaGeneralNombreTabla;

	//bi-directional many-to-one association to TipoDocumentoAdjunto
	@ManyToOne
	@JoinColumn(name="idTipoDocumentoAdjunto")
	private TipoDocumentoAdjunto tipoDocumentoAdjunto;

	public DocumentosAdjunto() {
	}

	public int getIdDocumentosAdjunto() {
		return this.idDocumentosAdjunto;
	}

	public void setIdDocumentosAdjunto(int idDocumentosAdjunto) {
		this.idDocumentosAdjunto = idDocumentosAdjunto;
	}

	public String getDirectorio() {
		return this.directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
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

	public int getIdTabla() {
		return this.idTabla;
	}

	public void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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

	public TablaGeneral getTablaGeneralNombreTabla() {
		return this.tablaGeneralNombreTabla;
	}

	public void setTablaGeneralNombreTabla(TablaGeneral tablaGeneralNombreTabla) {
		this.tablaGeneralNombreTabla = tablaGeneralNombreTabla;
	}

	public TipoDocumentoAdjunto getTipoDocumentoAdjunto() {
		return this.tipoDocumentoAdjunto;
	}

	public void setTipoDocumentoAdjunto(TipoDocumentoAdjunto tipoDocumentoAdjunto) {
		this.tipoDocumentoAdjunto = tipoDocumentoAdjunto;
	}

}