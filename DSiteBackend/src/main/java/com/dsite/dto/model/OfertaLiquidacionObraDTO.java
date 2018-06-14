package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;

public class OfertaLiquidacionObraDTO {

	private int idOfertaLiquidacionObra;

	private String actaCampoActaFinal;

	private String correlativoOfertaLiquidacion;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private Date fechaOfertaLiquidacionActaCampoActaFinal;

	private Date fechaRecibido;

	private BigDecimal importeOfertaLiquidacion;

	private BigDecimal importeVarMas;

	private BigDecimal importeVarMenos;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private int idPresupuestoObra;

	private String idTGTipoEnvio;

	public OfertaLiquidacionObraDTO() {
	}

	public int getIdOfertaLiquidacionObra() {
		return idOfertaLiquidacionObra;
	}

	public void setIdOfertaLiquidacionObra(int idOfertaLiquidacionObra) {
		this.idOfertaLiquidacionObra = idOfertaLiquidacionObra;
	}

	public String getActaCampoActaFinal() {
		return actaCampoActaFinal;
	}

	public void setActaCampoActaFinal(String actaCampoActaFinal) {
		this.actaCampoActaFinal = actaCampoActaFinal;
	}

	public String getCorrelativoOfertaLiquidacion() {
		return correlativoOfertaLiquidacion;
	}

	public void setCorrelativoOfertaLiquidacion(String correlativoOfertaLiquidacion) {
		this.correlativoOfertaLiquidacion = correlativoOfertaLiquidacion;
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

	public Date getFechaOfertaLiquidacionActaCampoActaFinal() {
		return fechaOfertaLiquidacionActaCampoActaFinal;
	}

	public void setFechaOfertaLiquidacionActaCampoActaFinal(Date fechaOfertaLiquidacionActaCampoActaFinal) {
		this.fechaOfertaLiquidacionActaCampoActaFinal = fechaOfertaLiquidacionActaCampoActaFinal;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public BigDecimal getImporteOfertaLiquidacion() {
		return importeOfertaLiquidacion;
	}

	public void setImporteOfertaLiquidacion(BigDecimal importeOfertaLiquidacion) {
		this.importeOfertaLiquidacion = importeOfertaLiquidacion;
	}

	public BigDecimal getImporteVarMas() {
		return importeVarMas;
	}

	public void setImporteVarMas(BigDecimal importeVarMas) {
		this.importeVarMas = importeVarMas;
	}

	public BigDecimal getImporteVarMenos() {
		return importeVarMenos;
	}

	public void setImporteVarMenos(BigDecimal importeVarMenos) {
		this.importeVarMenos = importeVarMenos;
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

	public int getIdPresupuestoObra() {
		return idPresupuestoObra;
	}

	public void setIdPresupuestoObra(int idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}

	public String getIdTGTipoEnvio() {
		return idTGTipoEnvio;
	}

	public void setIdTGTipoEnvio(String idTGTipoEnvio) {
		this.idTGTipoEnvio = idTGTipoEnvio;
	}
}