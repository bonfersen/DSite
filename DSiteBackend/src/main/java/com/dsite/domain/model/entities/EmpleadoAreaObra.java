package com.dsite.domain.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the empleadoareaobra database table.
 * 
 */
@Entity
@Table(name = "empleadoAreaObra")
@NamedQuery(name="EmpleadoAreaObra.findAll", query="SELECT e FROM EmpleadoAreaObra e")
public class EmpleadoAreaObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpleadoAreaObra;

	private String activo;

	@ManyToOne
	@JoinColumn(name = "idTGEmpleadoAreaObra")
	private TablaGeneral tablaGeneralEmpleadoAreaObra;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;

	public EmpleadoAreaObra() {
	}

	public int getIdEmpleadoAreaObra() {
		return idEmpleadoAreaObra;
	}

	public void setIdEmpleadoAreaObra(int idEmpleadoAreaObra) {
		this.idEmpleadoAreaObra = idEmpleadoAreaObra;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public TablaGeneral getTablaGeneralEmpleadoAreaObra() {
		return tablaGeneralEmpleadoAreaObra;
	}

	public void setTablaGeneralEmpleadoAreaObra(TablaGeneral tablaGeneralEmpleadoAreaObra) {
		this.tablaGeneralEmpleadoAreaObra = tablaGeneralEmpleadoAreaObra;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}