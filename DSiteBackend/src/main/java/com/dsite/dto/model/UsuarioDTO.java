package com.dsite.dto.model;

public class UsuarioDTO {
	
	private int idUsuario;

	private String activo;

	private String cuentaUsuario;

	private String password;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
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
}