package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwResumenRendicionCajaChica implements Serializable {

	private static final long serialVersionUID = 8800926887659708125L;

	private BigDecimal importeAbonoCaja;
	private BigDecimal importeRendidoCaja;
	private BigDecimal importeReembolsoCaja;
	private BigDecimal importeDescuentoCaja;
	private BigDecimal importeAbonoViatico;
	private BigDecimal importeRendidoViatico;
	private BigDecimal importeDescuentoViatico;
    private Integer idResumenRendicionCajaChica;
    private String codigoRendicion;
    private String idTGEstado;
    private String idTGEstadoRendicion;
    private String empleadoSustentador;
    
	public String getEmpleadoSustentador() {
		return empleadoSustentador;
	}
	public void setEmpleadoSustentador(String empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
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
	public String getCodigoRendicion() {
		return codigoRendicion;
	}
	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}
	public String getIdTGEstado() {
		return idTGEstado;
	}
	public void setIdTGEstado(String idTGEstado) {
		this.idTGEstado = idTGEstado;
	}
	public String getIdTGEstadoRendicion() {
		return idTGEstadoRendicion;
	}
	public void setIdTGEstadoRendicion(String idTGEstadoRendicion) {
		this.idTGEstadoRendicion = idTGEstadoRendicion;
	}
}
