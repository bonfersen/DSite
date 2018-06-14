package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the presupuestoObra database table.
 * 
 */
@Entity
@Table(name = "presupuestoObra")
@NamedQuery(name="PresupuestoObra.findAll", query="SELECT p FROM PresupuestoObra p")
public class PresupuestoObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPresupuestoObra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvioActaCampo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvioActaFinal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvioPresupuestoLiquidacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvioPresupuestoOferta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaLiquidacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaOfertado;

	private BigDecimal importePresupuestoLiquidacion;

	private BigDecimal importePresupuestoOferta;

	private String observacionFinanzas;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to OfertaLiquidacionObra
	@OneToMany(mappedBy="presupuestoObra")
	private List<OfertaLiquidacionObra> ofertaLiquidacionObras;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="idObra")
	private Obra obra;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoMoneda")
	private TablaGeneral tablaGeneralTipoMoneda;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGActaCampo")
	private TablaGeneral tablaGeneralActaCampo;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGActaFinal")
	private TablaGeneral tablaGeneralActaFinal;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGEstadoFinanzas")
	private TablaGeneral tablaGeneralEstadoFinanzas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioEnvioPresupuestoOferta")
	private Usuario usuarioEnvioPresupuestoOferta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioEnvioPresupuestoLiquidacion")
	private Usuario usuarioEnvioPresupuestoLiquidacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioEnvioActaCampo")
	private Usuario usuarioEnvioActaCampo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioEnvioActaFinal")
	private Usuario usuarioEnvioActaFinal;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioOfertado")
	private Usuario usuarioOfertado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioLiquidacion")
	private Usuario usuarioLiquidacion;

	public PresupuestoObra() {
	}

	public int getIdPresupuestoObra() {
		return this.idPresupuestoObra;
	}

	public void setIdPresupuestoObra(int idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEnvioActaCampo() {
		return this.fechaEnvioActaCampo;
	}

	public void setFechaEnvioActaCampo(Date fechaEnvioActaCampo) {
		this.fechaEnvioActaCampo = fechaEnvioActaCampo;
	}

	public Date getFechaEnvioActaFinal() {
		return this.fechaEnvioActaFinal;
	}

	public void setFechaEnvioActaFinal(Date fechaEnvioActaFinal) {
		this.fechaEnvioActaFinal = fechaEnvioActaFinal;
	}

	public Date getFechaEnvioPresupuestoLiquidacion() {
		return this.fechaEnvioPresupuestoLiquidacion;
	}

	public void setFechaEnvioPresupuestoLiquidacion(Date fechaEnvioPresupuestoLiquidacion) {
		this.fechaEnvioPresupuestoLiquidacion = fechaEnvioPresupuestoLiquidacion;
	}

	public Date getFechaEnvioPresupuestoOferta() {
		return this.fechaEnvioPresupuestoOferta;
	}

	public void setFechaEnvioPresupuestoOferta(Date fechaEnvioPresupuestoOferta) {
		this.fechaEnvioPresupuestoOferta = fechaEnvioPresupuestoOferta;
	}

	public Date getFechaLiquidacion() {
		return this.fechaLiquidacion;
	}

	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaOfertado() {
		return this.fechaOfertado;
	}

	public void setFechaOfertado(Date fechaOfertado) {
		this.fechaOfertado = fechaOfertado;
	}

	public BigDecimal getImportePresupuestoLiquidacion() {
		return this.importePresupuestoLiquidacion;
	}

	public void setImportePresupuestoLiquidacion(BigDecimal importePresupuestoLiquidacion) {
		this.importePresupuestoLiquidacion = importePresupuestoLiquidacion;
	}

	public BigDecimal getImportePresupuestoOferta() {
		return this.importePresupuestoOferta;
	}

	public void setImportePresupuestoOferta(BigDecimal importePresupuestoOferta) {
		this.importePresupuestoOferta = importePresupuestoOferta;
	}

	public String getObservacionFinanzas() {
		return this.observacionFinanzas;
	}

	public void setObservacionFinanzas(String observacionFinanzas) {
		this.observacionFinanzas = observacionFinanzas;
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

	public List<OfertaLiquidacionObra> getOfertaLiquidacionObras() {
		return this.ofertaLiquidacionObras;
	}

	public void setOfertaLiquidacionObras(List<OfertaLiquidacionObra> ofertaLiquidacionObras) {
		this.ofertaLiquidacionObras = ofertaLiquidacionObras;
	}

	public OfertaLiquidacionObra addOfertaLiquidacionObra(OfertaLiquidacionObra ofertaLiquidacionObra) {
		getOfertaLiquidacionObras().add(ofertaLiquidacionObra);
		ofertaLiquidacionObra.setPresupuestoObra(this);

		return ofertaLiquidacionObra;
	}

	public OfertaLiquidacionObra removeOfertaLiquidacionObra(OfertaLiquidacionObra ofertaLiquidacionObra) {
		getOfertaLiquidacionObras().remove(ofertaLiquidacionObra);
		ofertaLiquidacionObra.setPresupuestoObra(null);

		return ofertaLiquidacionObra;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public TablaGeneral getTablaGeneralTipoMoneda() {
		return this.tablaGeneralTipoMoneda;
	}

	public void setTablaGeneralTipoMoneda(TablaGeneral tablaGeneralTipoMoneda) {
		this.tablaGeneralTipoMoneda = tablaGeneralTipoMoneda;
	}

	public TablaGeneral getTablaGeneralActaCampo() {
		return this.tablaGeneralActaCampo;
	}

	public void setTablaGeneralActaCampo(TablaGeneral tablaGeneralActaCampo) {
		this.tablaGeneralActaCampo = tablaGeneralActaCampo;
	}

	public TablaGeneral getTablaGeneralActaFinal() {
		return this.tablaGeneralActaFinal;
	}

	public void setTablaGeneralActaFinal(TablaGeneral tablaGeneralActaFinal) {
		this.tablaGeneralActaFinal = tablaGeneralActaFinal;
	}

	public TablaGeneral getTablaGeneralEstadoFinanzas() {
		return this.tablaGeneralEstadoFinanzas;
	}

	public void setTablaGeneralEstadoFinanzas(TablaGeneral tablaGeneralEstadoFinanzas) {
		this.tablaGeneralEstadoFinanzas = tablaGeneralEstadoFinanzas;
	}

	public Usuario getUsuarioEnvioPresupuestoOferta() {
		return this.usuarioEnvioPresupuestoOferta;
	}

	public void setUsuarioEnvioPresupuestoOferta(Usuario usuarioEnvioPresupuestoOferta) {
		this.usuarioEnvioPresupuestoOferta = usuarioEnvioPresupuestoOferta;
	}

	public Usuario getUsuarioEnvioPresupuestoLiquidacion() {
		return this.usuarioEnvioPresupuestoLiquidacion;
	}

	public void setUsuarioEnvioPresupuestoLiquidacion(Usuario usuarioEnvioPresupuestoLiquidacion) {
		this.usuarioEnvioPresupuestoLiquidacion = usuarioEnvioPresupuestoLiquidacion;
	}

	public Usuario getUsuarioEnvioActaCampo() {
		return this.usuarioEnvioActaCampo;
	}

	public void setUsuarioEnvioActaCampo(Usuario usuarioEnvioActaCampo) {
		this.usuarioEnvioActaCampo = usuarioEnvioActaCampo;
	}

	public Usuario getUsuarioEnvioActaFinal() {
		return this.usuarioEnvioActaFinal;
	}

	public void setUsuarioEnvioActaFinal(Usuario usuarioEnvioActaFinal) {
		this.usuarioEnvioActaFinal = usuarioEnvioActaFinal;
	}

	public Usuario getUsuarioOfertado() {
		return this.usuarioOfertado;
	}

	public void setUsuarioOfertado(Usuario usuarioOfertado) {
		this.usuarioOfertado = usuarioOfertado;
	}

	public Usuario getUsuarioLiquidacion() {
		return this.usuarioLiquidacion;
	}

	public void setUsuarioLiquidacion(Usuario usuarioLiquidacion) {
		this.usuarioLiquidacion = usuarioLiquidacion;
	}

}