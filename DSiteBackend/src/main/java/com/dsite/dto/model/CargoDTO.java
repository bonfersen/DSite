package com.dsite.dto.model;

import java.util.Date;
import java.util.List;

public class CargoDTO {
	
	private int idCargo;

	private String activo;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private String nombre;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<EmpleadoDTO> empleados;
	
	private Integer idArea;
	
	private String idTGTipoTrabajador;

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getIdTGTipoTrabajador() {
		return idTGTipoTrabajador;
	}

	public void setIdTGTipoTrabajador(String idTGTipoTrabajador) {
		this.idTGTipoTrabajador = idTGTipoTrabajador;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<EmpleadoDTO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoDTO> empleados) {
		this.empleados = empleados;
	}
}
