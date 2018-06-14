package com.dsite.dto.model;

public class EmpleadoAreaObraDTO {

	private int idEmpleadoAreaObra;

	private String activo;

	private String idTGEmpleadoAreaObra;
	
	private String idTGEmpleadoAreaObraDescripcion;

	private int idEmpleado;

	public EmpleadoAreaObraDTO() {
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

	public String getIdTGEmpleadoAreaObra() {
		return idTGEmpleadoAreaObra;
	}

	public void setIdTGEmpleadoAreaObra(String idTGEmpleadoAreaObra) {
		this.idTGEmpleadoAreaObra = idTGEmpleadoAreaObra;
	}	
	
	public String getIdTGEmpleadoAreaObraDescripcion() {
		return idTGEmpleadoAreaObraDescripcion;
	}

	public void setIdTGEmpleadoAreaObraDescripcion(String idTGEmpleadoAreaObraDescripcion) {
		this.idTGEmpleadoAreaObraDescripcion = idTGEmpleadoAreaObraDescripcion;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
}