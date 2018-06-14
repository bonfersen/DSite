package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
@Table(name = "distrito")
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idDistrito;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;

	//bi-directional many-to-one association to Obra
	@OneToMany(mappedBy="distrito")
	private List<Obra> obras;

	public Distrito() {
	}

	public String getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Obra> getObras() {
		return this.obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

	public Obra addObra(Obra obra) {
		getObras().add(obra);
		obra.setDistrito(this);

		return obra;
	}

	public Obra removeObra(Obra obra) {
		getObras().remove(obra);
		obra.setDistrito(null);

		return obra;
	}

}