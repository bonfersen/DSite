package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@Table(name = "cargo")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCargo;

	private String activo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String nombre;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idArea")
	private Area area;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoTrabajador")
	private TablaGeneral tablaGeneralTipoTrabajador;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="cargo")
	private List<Empleado> empleados;

	public Cargo() {
	}

	public int getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
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

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public TablaGeneral getTablaGeneralTipoTrabajador() {
		return this.tablaGeneralTipoTrabajador;
	}

	public void setTablaGeneralTipoTrabajador(TablaGeneral tablaGeneralTipoTrabajador) {
		this.tablaGeneralTipoTrabajador = tablaGeneralTipoTrabajador;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setCargo(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setCargo(null);

		return empleado;
	}

}