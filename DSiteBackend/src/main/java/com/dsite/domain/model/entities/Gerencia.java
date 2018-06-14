package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gerencia database table.
 * 
 */
@Entity
@Table(name = "gerencia")
@NamedQuery(name="Gerencia.findAll", query="SELECT g FROM Gerencia g")
public class Gerencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGerencia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String nombre;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="gerencia")
	private List<Area> areas;

	public Gerencia() {
	}

	public int getIdGerencia() {
		return this.idGerencia;
	}

	public void setIdGerencia(int idGerencia) {
		this.idGerencia = idGerencia;
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

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setGerencia(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setGerencia(null);

		return area;
	}

}