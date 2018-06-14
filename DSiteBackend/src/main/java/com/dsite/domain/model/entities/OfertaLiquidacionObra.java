package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ofertaLiquidacionObra database table.
 * 
 */
@Entity
@Table(name = "ofertaLiquidacionObra")
@NamedQuery(name="OfertaLiquidacionObra.findAll", query="SELECT o FROM OfertaLiquidacionObra o")
public class OfertaLiquidacionObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idOfertaLiquidacionObra")
	private int idOfertaLiquidacionObra;

	@Column(name = "actaCampoActaFinal")
	private String actaCampoActaFinal;

	@Column(name = "correlativoOfertaLiquidacion")
	private String correlativoOfertaLiquidacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaCreacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaModificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaOfertaLiquidacionActaCampoActaFinal")
	private Date fechaOfertaLiquidacionActaCampoActaFinal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRecibido")
	private Date fechaRecibido;

	@Column(name = "importeOfertaLiquidacion")
	private BigDecimal importeOfertaLiquidacion;

	@Column(name = "importeVarMas")
	private BigDecimal importeVarMas;

	@Column(name = "importeVarMenos")
	private BigDecimal importeVarMenos;

	@Column(name = "usuarioCreacion")
	private String usuarioCreacion;

	@Column(name = "usuarioModificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to PresupuestoObra
	@ManyToOne
	@JoinColumn(name="idPresupuestoObra")
	private PresupuestoObra presupuestoObra;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoEnvio")
	private TablaGeneral tablaGeneralTipoEnvio;

	public OfertaLiquidacionObra() {
	}

	public int getIdOfertaLiquidacionObra() {
		return this.idOfertaLiquidacionObra;
	}

	public void setIdOfertaLiquidacionObra(int idOfertaLiquidacionObra) {
		this.idOfertaLiquidacionObra = idOfertaLiquidacionObra;
	}

	public String getActaCampoActaFinal() {
		return this.actaCampoActaFinal;
	}

	public void setActaCampoActaFinal(String actaCampoActaFinal) {
		this.actaCampoActaFinal = actaCampoActaFinal;
	}

	public String getCorrelativoOfertaLiquidacion() {
		return this.correlativoOfertaLiquidacion;
	}

	public void setCorrelativoOfertaLiquidacion(String correlativoOfertaLiquidacion) {
		this.correlativoOfertaLiquidacion = correlativoOfertaLiquidacion;
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

	public Date getFechaOfertaLiquidacionActaCampoActaFinal() {
		return this.fechaOfertaLiquidacionActaCampoActaFinal;
	}

	public void setFechaOfertaLiquidacionActaCampoActaFinal(Date fechaOfertaLiquidacionActaCampoActaFinal) {
		this.fechaOfertaLiquidacionActaCampoActaFinal = fechaOfertaLiquidacionActaCampoActaFinal;
	}

	public Date getFechaRecibido() {
		return this.fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public BigDecimal getImporteOfertaLiquidacion() {
		return this.importeOfertaLiquidacion;
	}

	public void setImporteOfertaLiquidacion(BigDecimal importeOfertaLiquidacion) {
		this.importeOfertaLiquidacion = importeOfertaLiquidacion;
	}

	public BigDecimal getImporteVarMas() {
		return this.importeVarMas;
	}

	public void setImporteVarMas(BigDecimal importeVarMas) {
		this.importeVarMas = importeVarMas;
	}

	public BigDecimal getImporteVarMenos() {
		return this.importeVarMenos;
	}

	public void setImporteVarMenos(BigDecimal importeVarMenos) {
		this.importeVarMenos = importeVarMenos;
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

	public PresupuestoObra getPresupuestoObra() {
		return this.presupuestoObra;
	}

	public void setPresupuestoObra(PresupuestoObra presupuestoObra) {
		this.presupuestoObra = presupuestoObra;
	}

	public TablaGeneral getTablaGeneralTipoEnvio() {
		return this.tablaGeneralTipoEnvio;
	}

	public void setTablaGeneralTipoEnvio(TablaGeneral tablaGeneralTipoEnvio) {
		this.tablaGeneralTipoEnvio = tablaGeneralTipoEnvio;
	}

}