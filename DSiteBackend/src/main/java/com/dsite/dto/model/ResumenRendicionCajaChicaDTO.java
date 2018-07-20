package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ResumenRendicionCajaChicaDTO {

	private int idResumenRendicionCajaChica;

	private int idEmpleadoSustentador;

	private String codigoRendicion;

	private Date fechaCreacion;

	private Date fechaDescuento;

	private Date fechaImpresion;

	private Date fechaModificacion;

	private Date fechaReembolso;

	private BigDecimal importeAbonoCaja;

	private BigDecimal importeAbonoViatico;

	private BigDecimal importeDescuentoCaja;

	private BigDecimal importeDescuentoViatico;

	private BigDecimal importeReembolsoCaja;

	private BigDecimal importeRendidoCaja;

	private BigDecimal importeRendidoViatico;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<RendicionCajaChicaDTO> rendicionCajaChicas;

	private String idTGEstadoRendicion;

	private Integer idUsuarioImpresion;

	private Integer idUsuarioAprobacion;

	private Date fechaAprobacion;

	private Integer idUsuarioRechazo;

	private Date fechaRechazo;

	private String motivoRechazo;

	private String idTGEstado;

	public ResumenRendicionCajaChicaDTO() {
	}

	public int getIdResumenRendicionCajaChica() {
		return this.idResumenRendicionCajaChica;
	}

	public void setIdResumenRendicionCajaChica(int idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}

	public String getCodigoRendicion() {
		return this.codigoRendicion;
	}

	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaDescuento() {
		return this.fechaDescuento;
	}

	public void setFechaDescuento(Date fechaDescuento) {
		this.fechaDescuento = fechaDescuento;
	}

	public Date getFechaImpresion() {
		return this.fechaImpresion;
	}

	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaReembolso() {
		return this.fechaReembolso;
	}

	public void setFechaReembolso(Date fechaReembolso) {
		this.fechaReembolso = fechaReembolso;
	}

	public BigDecimal getImporteAbonoCaja() {
		return this.importeAbonoCaja;
	}

	public void setImporteAbonoCaja(BigDecimal importeAbonoCaja) {
		this.importeAbonoCaja = importeAbonoCaja;
	}

	public BigDecimal getImporteAbonoViatico() {
		return this.importeAbonoViatico;
	}

	public void setImporteAbonoViatico(BigDecimal importeAbonoViatico) {
		this.importeAbonoViatico = importeAbonoViatico;
	}

	public BigDecimal getImporteDescuentoCaja() {
		return this.importeDescuentoCaja;
	}

	public void setImporteDescuentoCaja(BigDecimal importeDescuentoCaja) {
		this.importeDescuentoCaja = importeDescuentoCaja;
	}

	public BigDecimal getImporteDescuentoViatico() {
		return this.importeDescuentoViatico;
	}

	public void setImporteDescuentoViatico(BigDecimal importeDescuentoViatico) {
		this.importeDescuentoViatico = importeDescuentoViatico;
	}

	public BigDecimal getImporteReembolsoCaja() {
		return this.importeReembolsoCaja;
	}

	public void setImporteReembolsoCaja(BigDecimal importeReembolsoCaja) {
		this.importeReembolsoCaja = importeReembolsoCaja;
	}

	public BigDecimal getImporteRendidoCaja() {
		return this.importeRendidoCaja;
	}

	public void setImporteRendidoCaja(BigDecimal importeRendidoCaja) {
		this.importeRendidoCaja = importeRendidoCaja;
	}

	public BigDecimal getImporteRendidoViatico() {
		return this.importeRendidoViatico;
	}

	public void setImporteRendidoViatico(BigDecimal importeRendidoViatico) {
		this.importeRendidoViatico = importeRendidoViatico;
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

	public List<RendicionCajaChicaDTO> getRendicionCajaChicas() {
		return this.rendicionCajaChicas;
	}

	public void setRendicionCajaChicas(List<RendicionCajaChicaDTO> rendicionCajaChicas) {
		this.rendicionCajaChicas = rendicionCajaChicas;
	}

	public String getIdTGEstadoRendicion() {
		return idTGEstadoRendicion;
	}

	public void setIdTGEstadoRendicion(String idTGEstadoRendicion) {
		this.idTGEstadoRendicion = idTGEstadoRendicion;
	}

	public Integer getIdUsuarioImpresion() {
		return idUsuarioImpresion;
	}

	public void setIdUsuarioImpresion(Integer idUsuarioImpresion) {
		this.idUsuarioImpresion = idUsuarioImpresion;
	}

	public int getIdEmpleadoSustentador() {
		return idEmpleadoSustentador;
	}

	public void setIdEmpleadoSustentador(int idEmpleadoSustentador) {
		this.idEmpleadoSustentador = idEmpleadoSustentador;
	}

	public Integer getIdUsuarioAprobacion() {
		return idUsuarioAprobacion;
	}

	public void setIdUsuarioAprobacion(Integer idUsuarioAprobacion) {
		this.idUsuarioAprobacion = idUsuarioAprobacion;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Integer getIdUsuarioRechazo() {
		return idUsuarioRechazo;
	}

	public void setIdUsuarioRechazo(Integer idUsuarioRechazo) {
		this.idUsuarioRechazo = idUsuarioRechazo;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getIdTGEstado() {
		return idTGEstado;
	}

	public void setIdTGEstado(String idTGEstado) {
		this.idTGEstado = idTGEstado;
	}
}