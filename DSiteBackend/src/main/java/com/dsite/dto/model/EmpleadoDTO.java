package com.dsite.dto.model;

import java.util.Date;
import java.util.List;

public class EmpleadoDTO {

	private int idEmpleado;

	private String activo;

	private String apellidoMaterno;

	private String apellidoPaterno;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private String nombre;

	private String numeroDocumento;

	private String responsableObra;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<CajaChicaObraDTO> cajaChicaObrasEmpleadoSustentador;

	private List<CajaChicaObraDTO> cajaChicaObrasEmpleadoBeneficiario;

	private Integer idCargo;

	private String idTGTipoDocumento;

	private int idUsuario;

	private String idTGNivelUsuario;

	private List<ObraDTO> obras;

	private List<EmpleadoAreaObraDTO> empleadoAreaObras;

	private List<AutorizacionesDTO> autorizaciones;

	private String cuentaUsuario;
	
	private String password;
	
	private String activoUsuario;

	private String idTGRol;
	
	private Integer idContrata;

	public EmpleadoDTO() {
	}

	public Integer getIdContrata() {
		return idContrata;
	}

	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
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

	public String getIdTGNivelUsuario() {
		return idTGNivelUsuario;
	}

	public void setIdTGNivelUsuario(String idTGNivelUsuario) {
		this.idTGNivelUsuario = idTGNivelUsuario;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
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

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getResponsableObra() {
		return responsableObra;
	}

	public void setResponsableObra(String responsableObra) {
		this.responsableObra = responsableObra;
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

	public List<CajaChicaObraDTO> getCajaChicaObrasEmpleadoSustentador() {
		return cajaChicaObrasEmpleadoSustentador;
	}

	public void setCajaChicaObrasEmpleadoSustentador(List<CajaChicaObraDTO> cajaChicaObrasEmpleadoSustentador) {
		this.cajaChicaObrasEmpleadoSustentador = cajaChicaObrasEmpleadoSustentador;
	}

	public List<CajaChicaObraDTO> getCajaChicaObrasEmpleadoBeneficiario() {
		return cajaChicaObrasEmpleadoBeneficiario;
	}

	public void setCajaChicaObrasEmpleadoBeneficiario(List<CajaChicaObraDTO> cajaChicaObrasEmpleadoBeneficiario) {
		this.cajaChicaObrasEmpleadoBeneficiario = cajaChicaObrasEmpleadoBeneficiario;
	}

	public String getIdTGTipoDocumento() {
		return idTGTipoDocumento;
	}

	public void setIdTGTipoDocumento(String idTGTipoDocumento) {
		this.idTGTipoDocumento = idTGTipoDocumento;
	}

	public List<ObraDTO> getObras() {
		return obras;
	}

	public void setObras(List<ObraDTO> obras) {
		this.obras = obras;
	}
	
	public List<EmpleadoAreaObraDTO> getEmpleadoAreaObras() {
		return empleadoAreaObras;
	}

	public void setEmpleadoAreaObras(List<EmpleadoAreaObraDTO> empleadoAreaObras) {
		this.empleadoAreaObras = empleadoAreaObras;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<AutorizacionesDTO> getAutorizaciones() {
		return autorizaciones;
	}

	public void setAutorizaciones(List<AutorizacionesDTO> autorizaciones) {
		this.autorizaciones = autorizaciones;
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}
}