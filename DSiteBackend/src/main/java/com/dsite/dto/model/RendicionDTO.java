package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;


public class RendicionDTO {

	private int idRendicion;

	private String descripcionCajaViatico;

	private Date fechaComprobanteCajaViatico;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private BigDecimal importeRendidoCajaViatico;

	private String numeroComprobanteCajaViatico;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private String idTGTipoRendicion;

	private String idTGTipoComprobante;

	private String idTGTipoGasto;

	private Integer idResumenRendicionCajaChica;

	public RendicionDTO() {
	}

	public int getIdRendicion() {
		return this.idRendicion;
	}

	public void setIdRendicion(int idRendicion) {
		this.idRendicion = idRendicion;
	}

	public String getDescripcionCajaViatico() {
		return this.descripcionCajaViatico;
	}

	public void setDescripcionCajaViatico(String descripcionCajaViatico) {
		this.descripcionCajaViatico = descripcionCajaViatico;
	}

	public Date getFechaComprobanteCajaViatico() {
		return this.fechaComprobanteCajaViatico;
	}

	public void setFechaComprobanteCajaViatico(Date fechaComprobanteCajaViatico) {
		this.fechaComprobanteCajaViatico = fechaComprobanteCajaViatico;
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

	public BigDecimal getImporteRendidoCajaViatico() {
		return this.importeRendidoCajaViatico;
	}

	public void setImporteRendidoCajaViatico(BigDecimal importeRendidoCajaViatico) {
		this.importeRendidoCajaViatico = importeRendidoCajaViatico;
	}

	public String getNumeroComprobanteCajaViatico() {
		return this.numeroComprobanteCajaViatico;
	}

	public void setNumeroComprobanteCajaViatico(String numeroComprobanteCajaViatico) {
		this.numeroComprobanteCajaViatico = numeroComprobanteCajaViatico;
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

	public String getIdTGTipoRendicion() {
		return idTGTipoRendicion;
	}

	public void setIdTGTipoRendicion(String idTGTipoRendicion) {
		this.idTGTipoRendicion = idTGTipoRendicion;
	}

	public String getIdTGTipoComprobante() {
		return idTGTipoComprobante;
	}

	public void setIdTGTipoComprobante(String idTGTipoComprobante) {
		this.idTGTipoComprobante = idTGTipoComprobante;
	}

	public String getIdTGTipoGasto() {
		return idTGTipoGasto;
	}

	public void setIdTGTipoGasto(String idTGTipoGasto) {
		this.idTGTipoGasto = idTGTipoGasto;
	}

	public Integer getIdResumenRendicionCajaChica() {
		return idResumenRendicionCajaChica;
	}

	public void setIdResumenRendicionCajaChica(Integer idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}
}