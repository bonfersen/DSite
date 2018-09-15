package com.dsite.domain.model.views;

import java.io.Serializable;

public class VwMantenimientoUsuario implements Serializable {
	
	private static final long serialVersionUID = -1672213657444367755L;
	
	private Integer idEmpleado;
	private String idTGTipoDocumento;
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer idCargo;
	private String cargo;
	private Integer idArea;
	private String area;
	private Integer idGerencia;
	private String gerencia;
	private String responsableObra;
	private String activo;
	private Integer idUsuario;
	private String cuentaUsuario;
	private String password;
	private String activoUsuario;
	private String idTGRol;
	private String rol;
	private Integer idContrata;
	private String nombreCorto;
	private String idEmpleadoAreaObra;
	private String empleadoAreaObra;
	
	public String getIdEmpleadoAreaObra() {
		return idEmpleadoAreaObra;
	}
	public void setIdEmpleadoAreaObra(String idEmpleadoAreaObra) {
		this.idEmpleadoAreaObra = idEmpleadoAreaObra;
	}
	public String getEmpleadoAreaObra() {
		return empleadoAreaObra;
	}
	public void setEmpleadoAreaObra(String empleadoAreaObra) {
		this.empleadoAreaObra = empleadoAreaObra;
	}
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getCuentaUsuario() {
		return cuentaUsuario;
	}
	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActivoUsuario() {
		return activoUsuario;
	}
	public void setActivoUsuario(String activoUsuario) {
		this.activoUsuario = activoUsuario;
	}
	public String getIdTGRol() {
		return idTGRol;
	}
	public void setIdTGRol(String idTGRol) {
		this.idTGRol = idTGRol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getIdTGTipoDocumento() {
		return idTGTipoDocumento;
	}
	public void setIdTGTipoDocumento(String idTGTipoDocumento) {
		this.idTGTipoDocumento = idTGTipoDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public Integer getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getIdGerencia() {
		return idGerencia;
	}
	public void setIdGerencia(Integer idGerencia) {
		this.idGerencia = idGerencia;
	}
	public String getGerencia() {
		return gerencia;
	}
	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}
	public String getResponsableObra() {
		return responsableObra;
	}
	public void setResponsableObra(String responsableObra) {
		this.responsableObra = responsableObra;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
