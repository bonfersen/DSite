package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwDetalleRendicionCajaChica implements Serializable {

	private static final long serialVersionUID = 3164850110786128039L;
	private Date fechaComprobanteCajaViatico;
	private String idTGTipoComprobante;
	private String tipoComprobante;
	private String idTGTipoGasto;
	private String tipoGasto;
	private String numeroComprobanteCajaViatico;
    private String descripcionCajaViatico;
    private BigDecimal importeRendidoCaja;
    private BigDecimal importeRendidoViatico;
    private Integer idCajaChicaObra;
    private Integer idRendicionCajaChica;
    private Integer idResumenRendicionCajaChica;
    private Integer idRendicion;
    private String codigoRendicion;
    private String idTGTipoRendicion;
    
	public Date getFechaComprobanteCajaViatico() {
		return fechaComprobanteCajaViatico;
	}
	public void setFechaComprobanteCajaViatico(Date fechaComprobanteCajaViatico) {
		this.fechaComprobanteCajaViatico = fechaComprobanteCajaViatico;
	}
	public String getIdTGTipoComprobante() {
		return idTGTipoComprobante;
	}
	public void setIdTGTipoComprobante(String idTGTipoComprobante) {
		this.idTGTipoComprobante = idTGTipoComprobante;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getIdTGTipoGasto() {
		return idTGTipoGasto;
	}
	public void setIdTGTipoGasto(String idTGTipoGasto) {
		this.idTGTipoGasto = idTGTipoGasto;
	}
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public String getNumeroComprobanteCajaViatico() {
		return numeroComprobanteCajaViatico;
	}
	public void setNumeroComprobanteCajaViatico(String numeroComprobanteCajaViatico) {
		this.numeroComprobanteCajaViatico = numeroComprobanteCajaViatico;
	}
	public String getDescripcionCajaViatico() {
		return descripcionCajaViatico;
	}
	public void setDescripcionCajaViatico(String descripcionCajaViatico) {
		this.descripcionCajaViatico = descripcionCajaViatico;
	}
	public BigDecimal getImporteRendidoCaja() {
		return importeRendidoCaja;
	}
	public void setImporteRendidoCaja(BigDecimal importeRendidoCaja) {
		this.importeRendidoCaja = importeRendidoCaja;
	}
	public BigDecimal getImporteRendidoViatico() {
		return importeRendidoViatico;
	}
	public void setImporteRendidoViatico(BigDecimal importeRendidoViatico) {
		this.importeRendidoViatico = importeRendidoViatico;
	}
	public Integer getIdCajaChicaObra() {
		return idCajaChicaObra;
	}
	public void setIdCajaChicaObra(Integer idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}
	public Integer getIdRendicionCajaChica() {
		return idRendicionCajaChica;
	}
	public void setIdRendicionCajaChica(Integer idRendicionCajaChica) {
		this.idRendicionCajaChica = idRendicionCajaChica;
	}
	public Integer getIdResumenRendicionCajaChica() {
		return idResumenRendicionCajaChica;
	}
	public void setIdResumenRendicionCajaChica(Integer idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}
	public Integer getIdRendicion() {
		return idRendicion;
	}
	public void setIdRendicion(Integer idRendicion) {
		this.idRendicion = idRendicion;
	}
	public String getCodigoRendicion() {
		return codigoRendicion;
	}
	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}
	public String getIdTGTipoRendicion() {
		return idTGTipoRendicion;
	}
	public void setIdTGTipoRendicion(String idTGTipoRendicion) {
		this.idTGTipoRendicion = idTGTipoRendicion;
	}
}
