package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ContrataDTO {

	private int idContrata;

	private String activo;

	private String contacto;

	private String correo;

	private String direccion;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private BigDecimal importeTotalPendientePago;

	private String nombreCorto;

	private String razonSocial;

	private String ruc;

	private String telefono;

	private String usuarioCreacion;

	private String usuarioModificacion;

	// private List<ConcursoContrataDTO> concursoContratasDTO;

	private String idTGCategoria;

	private List<ContratasObraDTO> contratasObrasDTO;

	public ContrataDTO() {
	}

	public int getIdContrata() {
		return idContrata;
	}

	public void setIdContrata(int idContrata) {
		this.idContrata = idContrata;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public BigDecimal getImporteTotalPendientePago() {
		return importeTotalPendientePago;
	}

	public void setImporteTotalPendientePago(BigDecimal importeTotalPendientePago) {
		this.importeTotalPendientePago = importeTotalPendientePago;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getIdTGCategoria() {
		return idTGCategoria;
	}

	public void setIdTGCategoria(String idTGCategoria) {
		this.idTGCategoria = idTGCategoria;
	}

	public List<ContratasObraDTO> getContratasObrasDTO() {
		return contratasObrasDTO;
	}

	public void setContratasObrasDTO(List<ContratasObraDTO> contratasObrasDTO) {
		this.contratasObrasDTO = contratasObrasDTO;
	}
}