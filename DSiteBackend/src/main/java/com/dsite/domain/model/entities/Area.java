package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name = "area")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArea;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String nombre;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to Gerencia
	@ManyToOne
	@JoinColumn(name="idGerencia")
	private Gerencia gerencia;

	//bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy="area")
	private List<Cargo> cargos;

	public Area() {
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
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

	public Gerencia getGerencia() {
		return this.gerencia;
	}

	public void setGerencia(Gerencia gerencia) {
		this.gerencia = gerencia;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Cargo addCargo(Cargo cargo) {
		getCargos().add(cargo);
		cargo.setArea(this);

		return cargo;
	}

	public Cargo removeCargo(Cargo cargo) {
		getCargos().remove(cargo);
		cargo.setArea(null);

		return cargo;
	}

}