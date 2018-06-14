package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cierreEconomico database table.
 * 
 */
@Entity
@Table(name = "cierreEconomico")
@NamedQuery(name="CierreEconomico.findAll", query="SELECT c FROM CierreEconomico c")
public class CierreEconomico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCierreEconomico;

	private String codigoCierre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAsignacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	private String usuarioCreacion;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGEstadoCierreEconomico")
	private TablaGeneral tablaGeneralEstadoCierreEconomico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioAsignacion")
	private Usuario usuarioAsignacion;

	//bi-directional many-to-one association to CierreEconomicoObra
	@OneToMany(mappedBy="cierreEconomico")
	private List<CierreEconomicoObra> cierreEconomicoObras;

	public CierreEconomico() {
	}

	public int getIdCierreEconomico() {
		return this.idCierreEconomico;
	}

	public void setIdCierreEconomico(int idCierreEconomico) {
		this.idCierreEconomico = idCierreEconomico;
	}

	public String getCodigoCierre() {
		return this.codigoCierre;
	}

	public void setCodigoCierre(String codigoCierre) {
		this.codigoCierre = codigoCierre;
	}

	public Date getFechaAsignacion() {
		return this.fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public TablaGeneral getTablaGeneralEstadoCierreEconomico() {
		return this.tablaGeneralEstadoCierreEconomico;
	}

	public void setTablaGeneralEstadoCierreEconomico(TablaGeneral tablaGeneralEstadoCierreEconomico) {
		this.tablaGeneralEstadoCierreEconomico = tablaGeneralEstadoCierreEconomico;
	}

	public Usuario getUsuarioAsignacion() {
		return this.usuarioAsignacion;
	}

	public void setUsuarioAsignacion(Usuario usuarioAsignacion) {
		this.usuarioAsignacion = usuarioAsignacion;
	}

	public List<CierreEconomicoObra> getCierreEconomicoObras() {
		return this.cierreEconomicoObras;
	}

	public void setCierreEconomicoObras(List<CierreEconomicoObra> cierreEconomicoObras) {
		this.cierreEconomicoObras = cierreEconomicoObras;
	}

	public CierreEconomicoObra addCierreEconomicoObra(CierreEconomicoObra cierreEconomicoObra) {
		getCierreEconomicoObras().add(cierreEconomicoObra);
		cierreEconomicoObra.setCierreEconomico(this);

		return cierreEconomicoObra;
	}

	public CierreEconomicoObra removeCierreEconomicoObra(CierreEconomicoObra cierreEconomicoObra) {
		getCierreEconomicoObras().remove(cierreEconomicoObra);
		cierreEconomicoObra.setCierreEconomico(null);

		return cierreEconomicoObra;
	}

}