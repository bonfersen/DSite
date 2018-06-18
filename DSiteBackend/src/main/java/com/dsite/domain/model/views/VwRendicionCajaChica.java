package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwRendicionCajaChica implements Serializable {

	private static final long serialVersionUID = 5946723282391653596L;
	private String codigoDSite;
	private BigDecimal importeCaja;
	private BigDecimal importeViatico;
    private Date fechaPago;
	private BigDecimal importeAbonoCaja;
	private BigDecimal importeRendidoCaja;
	private BigDecimal importeReembolsoCaja;
	private BigDecimal importeDescuentoCaja;
	private BigDecimal importeAbonoViatico;
	private BigDecimal importeRendidoViatico;
	private BigDecimal importeDescuentoViatico;
    private Integer idResumenRendicionCajaChica;
    private Integer idRendicionCajaChica;
    private String codigoRendicion;
    private Integer idCajaChicaObra;
    
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
	public BigDecimal getImporteCaja() {
		return importeCaja;
	}
	public void setImporteCaja(BigDecimal importeCaja) {
		this.importeCaja = importeCaja;
	}
	public BigDecimal getImporteViatico() {
		return importeViatico;
	}
	public void setImporteViatico(BigDecimal importeViatico) {
		this.importeViatico = importeViatico;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public BigDecimal getImporteAbonoCaja() {
		return importeAbonoCaja;
	}
	public void setImporteAbonoCaja(BigDecimal importeAbonoCaja) {
		this.importeAbonoCaja = importeAbonoCaja;
	}
	public BigDecimal getImporteRendidoCaja() {
		return importeRendidoCaja;
	}
	public void setImporteRendidoCaja(BigDecimal importeRendidoCaja) {
		this.importeRendidoCaja = importeRendidoCaja;
	}
	public BigDecimal getImporteReembolsoCaja() {
		return importeReembolsoCaja;
	}
	public void setImporteReembolsoCaja(BigDecimal importeReembolsoCaja) {
		this.importeReembolsoCaja = importeReembolsoCaja;
	}
	public BigDecimal getImporteDescuentoCaja() {
		return importeDescuentoCaja;
	}
	public void setImporteDescuentoCaja(BigDecimal importeDescuentoCaja) {
		this.importeDescuentoCaja = importeDescuentoCaja;
	}
	public BigDecimal getImporteAbonoViatico() {
		return importeAbonoViatico;
	}
	public void setImporteAbonoViatico(BigDecimal importeAbonoViatico) {
		this.importeAbonoViatico = importeAbonoViatico;
	}
	public BigDecimal getImporteRendidoViatico() {
		return importeRendidoViatico;
	}
	public void setImporteRendidoViatico(BigDecimal importeRendidoViatico) {
		this.importeRendidoViatico = importeRendidoViatico;
	}
	public BigDecimal getImporteDescuentoViatico() {
		return importeDescuentoViatico;
	}
	public void setImporteDescuentoViatico(BigDecimal importeDescuentoViatico) {
		this.importeDescuentoViatico = importeDescuentoViatico;
	}
	public Integer getIdResumenRendicionCajaChica() {
		return idResumenRendicionCajaChica;
	}
	public void setIdResumenRendicionCajaChica(Integer idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}
	public Integer getIdRendicionCajaChica() {
		return idRendicionCajaChica;
	}
	public void setIdRendicionCajaChica(Integer idRendicionCajaChica) {
		this.idRendicionCajaChica = idRendicionCajaChica;
	}
	public String getCodigoRendicion() {
		return codigoRendicion;
	}
	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}
	public Integer getIdCajaChicaObra() {
		return idCajaChicaObra;
	}
	public void setIdCajaChicaObra(Integer idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}
}
