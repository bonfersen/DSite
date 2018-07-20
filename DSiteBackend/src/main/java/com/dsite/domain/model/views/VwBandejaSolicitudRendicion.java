package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwBandejaSolicitudRendicion implements Serializable {

	private static final long serialVersionUID = 4043326945886292279L;
	private Integer idResumenRendicionCajaChica;
	private String codigoRendicion;
	private Integer idEmpleadoSustentador;
	private String empleadoSustentador;
	private BigDecimal importeRendido;
	private Date fechaCreacion;

	public Integer getIdResumenRendicionCajaChica() {
		return idResumenRendicionCajaChica;
	}

	public void setIdResumenRendicionCajaChica(Integer idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}

	public String getCodigoRendicion() {
		return codigoRendicion;
	}

	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}

	public Integer getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}

	public void setIdEmpleadoSustentador(Integer idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}

	public String getEmpleadoSustentador() {
		return empleadoSustentador;
	}

	public void setEmpleadoSustentador(String empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
	}

	public BigDecimal getImporteRendido() {
		return importeRendido;
	}

	public void setImporteRendido(BigDecimal importeRendido) {
		this.importeRendido = importeRendido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
