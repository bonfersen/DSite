package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@Table(name = "departamento")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idDepartamento;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="departamento")
	private List<Provincia> provincias;

	public Departamento() {
	}

	public String getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Provincia addProvincia(Provincia provincia) {
		getProvincias().add(provincia);
		provincia.setDepartamento(this);

		return provincia;
	}

	public Provincia removeProvincia(Provincia provincia) {
		getProvincias().remove(provincia);
		provincia.setDepartamento(null);

		return provincia;
	}

}