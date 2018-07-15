package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwPanelContratas implements Serializable {

	private static final long serialVersionUID = 4513039430213296572L;
	private String categoria;
	private String nombreCorto; 
	private BigDecimal importeAbjudicado;
    private BigDecimal importeAvanceTotal;
    private BigDecimal porcentaje;
    private BigDecimal importeRestante;
    private BigDecimal importeLiquidado;
    private BigDecimal importeCancelado;
    private BigDecimal importePendiente;
    private BigDecimal importeProyectado;
    
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public BigDecimal getImporteAbjudicado() {
		return importeAbjudicado;
	}
	public void setImporteAbjudicado(BigDecimal importeAbjudicado) {
		this.importeAbjudicado = importeAbjudicado;
	}
	public BigDecimal getImporteAvanceTotal() {
		return importeAvanceTotal;
	}
	public void setImporteAvanceTotal(BigDecimal importeAvanceTotal) {
		this.importeAvanceTotal = importeAvanceTotal;
	}
	public BigDecimal getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}
	public BigDecimal getImporteRestante() {
		return importeRestante;
	}
	public void setImporteRestante(BigDecimal importeRestante) {
		this.importeRestante = importeRestante;
	}
	public BigDecimal getImporteLiquidado() {
		return importeLiquidado;
	}
	public void setImporteLiquidado(BigDecimal importeLiquidado) {
		this.importeLiquidado = importeLiquidado;
	}
	public BigDecimal getImporteCancelado() {
		return importeCancelado;
	}
	public void setImporteCancelado(BigDecimal importeCancelado) {
		this.importeCancelado = importeCancelado;
	}
	public BigDecimal getImportePendiente() {
		return importePendiente;
	}
	public void setImportePendiente(BigDecimal importePendiente) {
		this.importePendiente = importePendiente;
	}
	public BigDecimal getImporteProyectado() {
		return importeProyectado;
	}
	public void setImporteProyectado(BigDecimal importeProyectado) {
		this.importeProyectado = importeProyectado;
	}
}
