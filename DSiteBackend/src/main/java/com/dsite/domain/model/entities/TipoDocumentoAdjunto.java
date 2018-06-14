package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipoDocumentoAdjunto database table.
 * 
 */
@Entity
@Table(name = "tipoDocumentoAdjunto")
@NamedQuery(name="TipoDocumentoAdjunto.findAll", query="SELECT t FROM TipoDocumentoAdjunto t")
public class TipoDocumentoAdjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoDocumentoAdjunto;

	private String activo;

	private String extensionPermitida;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String nombre;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to DocumentosAdjunto
	@OneToMany(mappedBy="tipoDocumentoAdjunto")
	private List<DocumentosAdjunto> documentosAdjuntos;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGGrupo")
	private TablaGeneral tablaGeneralGrupo;

	public TipoDocumentoAdjunto() {
	}

	public int getIdTipoDocumentoAdjunto() {
		return this.idTipoDocumentoAdjunto;
	}

	public void setIdTipoDocumentoAdjunto(int idTipoDocumentoAdjunto) {
		this.idTipoDocumentoAdjunto = idTipoDocumentoAdjunto;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getExtensionPermitida() {
		return this.extensionPermitida;
	}

	public void setExtensionPermitida(String extensionPermitida) {
		this.extensionPermitida = extensionPermitida;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<DocumentosAdjunto> getDocumentosAdjuntos() {
		return this.documentosAdjuntos;
	}

	public void setDocumentosAdjuntos(List<DocumentosAdjunto> documentosAdjuntos) {
		this.documentosAdjuntos = documentosAdjuntos;
	}

	public DocumentosAdjunto addDocumentosAdjunto(DocumentosAdjunto documentosAdjunto) {
		getDocumentosAdjuntos().add(documentosAdjunto);
		documentosAdjunto.setTipoDocumentoAdjunto(this);

		return documentosAdjunto;
	}

	public DocumentosAdjunto removeDocumentosAdjunto(DocumentosAdjunto documentosAdjunto) {
		getDocumentosAdjuntos().remove(documentosAdjunto);
		documentosAdjunto.setTipoDocumentoAdjunto(null);

		return documentosAdjunto;
	}

	public TablaGeneral getTablaGeneralGrupo() {
		return this.tablaGeneralGrupo;
	}

	public void setTablaGeneralGrupo(TablaGeneral tablaGeneralGrupo) {
		this.tablaGeneralGrupo = tablaGeneralGrupo;
	}

}