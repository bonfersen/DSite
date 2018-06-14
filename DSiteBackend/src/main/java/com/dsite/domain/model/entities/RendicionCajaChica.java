package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rendicionCajaChica database table.
 * 
 */
@Entity
@Table(name = "rendicionCajaChica")
@NamedQuery(name="RendicionCajaChica.findAll", query="SELECT r FROM RendicionCajaChica r")
public class RendicionCajaChica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRendicionCajaChica;

	private String codigoDSite;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to CajaChicaObra
	@ManyToOne
	@JoinColumn(name="idCajaChicaObra")
	private CajaChicaObra cajaChicaObra;

	//bi-directional many-to-one association to ResumenRendicionCajaChica
	@ManyToOne
	@JoinColumn(name="idResumenRendicionCajaChica")
	private ResumenRendicionCajaChica resumenRendicionCajaChica;

	public RendicionCajaChica() {
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

	public CajaChicaObra getCajaChicaObra() {
		return this.cajaChicaObra;
	}

	public void setCajaChicaObra(CajaChicaObra cajaChicaObra) {
		this.cajaChicaObra = cajaChicaObra;
	}

	public ResumenRendicionCajaChica getResumenRendicionCajaChica() {
		return this.resumenRendicionCajaChica;
	}

	public void setResumenRendicionCajaChica(ResumenRendicionCajaChica resumenRendicionCajaChica) {
		this.resumenRendicionCajaChica = resumenRendicionCajaChica;
	}

}