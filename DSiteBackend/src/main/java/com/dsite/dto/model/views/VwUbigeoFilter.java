package com.dsite.dto.model.views;

/** 
 * The persistent class for the vwUbigeo database table.
 * 
 */
public class VwUbigeoFilter {

	private String departamento;
	private String distrito;
	private String idDepartamento;
	private String idDistrito;
	private String idProvincia;
	private String provincia;

	public VwUbigeoFilter() {
	}


	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public String getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public String getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}


	public String getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}


	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}