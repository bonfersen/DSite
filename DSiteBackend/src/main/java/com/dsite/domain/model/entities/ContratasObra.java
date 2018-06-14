package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contratasObra database table.
 * 
 */
@Entity
@Table(name = "contratasObra")
@NamedQuery(name="ContratasObra.findAll", query="SELECT c FROM ContratasObra c")
public class ContratasObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContratasObra;

	private String comentarioCierreEconomico;

	private String comentarioDescuentoOperativo;

	private String comentarioImporteAdicional;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCECompletado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCEParcial;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCEPendiente;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private BigDecimal importeAdicional;

	private BigDecimal importeDescuentoOperativo;

	private BigDecimal importeFinal;

	private BigDecimal importeLiquidadacionObra;

	private BigDecimal importePendientePago;

	private BigDecimal importePresupuestoObra;

	private BigDecimal importeTipoCambio;

	private BigDecimal importeTotalAdelanto;

	private BigDecimal porcentajeActasAprobadas;

	private String tipoTrabajo;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy="contratasObra")
	private List<ActasContrata> actasContratas;

	//bi-directional many-to-one association to Contrata
	@ManyToOne
	@JoinColumn(name="idContrata")
	private Contrata contrata;

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
	@JoinColumn(name="idTGEstadoCierreEconomico")
	private TablaGeneral tablaGeneralEstadoCierreEconomico;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGEstadoLiquidacion")
	private TablaGeneral tablaGeneralEstadoLiquidacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioCEPendiente")
	private Usuario usuarioCEPendiente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioCEParcial")
	private Usuario usuarioCEParcial;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioCECompletado")
	private Usuario usuarioCECompletado;

	//bi-directional many-to-one association to PagosContrata
	@OneToMany(mappedBy="contratasObra")
	private List<PagosContrata> pagosContratas;

	public ContratasObra() {
	}

	public int getIdContratasObra() {
		return this.idContratasObra;
	}

	public void setIdContratasObra(int idContratasObra) {
		this.idContratasObra = idContratasObra;
	}

	public String getComentarioCierreEconomico() {
		return this.comentarioCierreEconomico;
	}

	public void setComentarioCierreEconomico(String comentarioCierreEconomico) {
		this.comentarioCierreEconomico = comentarioCierreEconomico;
	}

	public String getComentarioDescuentoOperativo() {
		return this.comentarioDescuentoOperativo;
	}

	public void setComentarioDescuentoOperativo(String comentarioDescuentoOperativo) {
		this.comentarioDescuentoOperativo = comentarioDescuentoOperativo;
	}

	public String getComentarioImporteAdicional() {
		return this.comentarioImporteAdicional;
	}

	public void setComentarioImporteAdicional(String comentarioImporteAdicional) {
		this.comentarioImporteAdicional = comentarioImporteAdicional;
	}

	public Date getFechaCECompletado() {
		return this.fechaCECompletado;
	}

	public void setFechaCECompletado(Date fechaCECompletado) {
		this.fechaCECompletado = fechaCECompletado;
	}

	public Date getFechaCEParcial() {
		return this.fechaCEParcial;
	}

	public void setFechaCEParcial(Date fechaCEParcial) {
		this.fechaCEParcial = fechaCEParcial;
	}

	public Date getFechaCEPendiente() {
		return this.fechaCEPendiente;
	}

	public void setFechaCEPendiente(Date fechaCEPendiente) {
		this.fechaCEPendiente = fechaCEPendiente;
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

	public BigDecimal getImporteAdicional() {
		return this.importeAdicional;
	}

	public void setImporteAdicional(BigDecimal importeAdicional) {
		this.importeAdicional = importeAdicional;
	}

	public BigDecimal getImporteDescuentoOperativo() {
		return this.importeDescuentoOperativo;
	}

	public void setImporteDescuentoOperativo(BigDecimal importeDescuentoOperativo) {
		this.importeDescuentoOperativo = importeDescuentoOperativo;
	}

	public BigDecimal getImporteFinal() {
		return this.importeFinal;
	}

	public void setImporteFinal(BigDecimal importeFinal) {
		this.importeFinal = importeFinal;
	}

	public BigDecimal getImporteLiquidadacionObra() {
		return this.importeLiquidadacionObra;
	}

	public void setImporteLiquidadacionObra(BigDecimal importeLiquidadacionObra) {
		this.importeLiquidadacionObra = importeLiquidadacionObra;
	}

	public BigDecimal getImportePendientePago() {
		return this.importePendientePago;
	}

	public void setImportePendientePago(BigDecimal importePendientePago) {
		this.importePendientePago = importePendientePago;
	}

	public BigDecimal getImportePresupuestoObra() {
		return this.importePresupuestoObra;
	}

	public void setImportePresupuestoObra(BigDecimal importePresupuestoObra) {
		this.importePresupuestoObra = importePresupuestoObra;
	}

	public BigDecimal getImporteTipoCambio() {
		return this.importeTipoCambio;
	}

	public void setImporteTipoCambio(BigDecimal importeTipoCambio) {
		this.importeTipoCambio = importeTipoCambio;
	}

	public BigDecimal getImporteTotalAdelanto() {
		return this.importeTotalAdelanto;
	}

	public void setImporteTotalAdelanto(BigDecimal importeTotalAdelanto) {
		this.importeTotalAdelanto = importeTotalAdelanto;
	}

	public BigDecimal getPorcentajeActasAprobadas() {
		return this.porcentajeActasAprobadas;
	}

	public void setPorcentajeActasAprobadas(BigDecimal porcentajeActasAprobadas) {
		this.porcentajeActasAprobadas = porcentajeActasAprobadas;
	}

	public String getTipoTrabajo() {
		return this.tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
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

	public List<ActasContrata> getActasContratas() {
		return this.actasContratas;
	}

	public void setActasContratas(List<ActasContrata> actasContratas) {
		this.actasContratas = actasContratas;
	}

	public ActasContrata addActasContrata(ActasContrata actasContrata) {
		getActasContratas().add(actasContrata);
		actasContrata.setContratasObra(this);

		return actasContrata;
	}

	public ActasContrata removeActasContrata(ActasContrata actasContrata) {
		getActasContratas().remove(actasContrata);
		actasContrata.setContratasObra(null);

		return actasContrata;
	}

	public Contrata getContrata() {
		return this.contrata;
	}

	public void setContrata(Contrata contrata) {
		this.contrata = contrata;
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

	public TablaGeneral getTablaGeneralEstadoCierreEconomico() {
		return this.tablaGeneralEstadoCierreEconomico;
	}

	public void setTablaGeneralEstadoCierreEconomico(TablaGeneral tablaGeneralEstadoCierreEconomico) {
		this.tablaGeneralEstadoCierreEconomico = tablaGeneralEstadoCierreEconomico;
	}

	public TablaGeneral getTablaGeneralEstadoLiquidacion() {
		return this.tablaGeneralEstadoLiquidacion;
	}

	public void setTablaGeneralEstadoLiquidacion(TablaGeneral tablaGeneralEstadoLiquidacion) {
		this.tablaGeneralEstadoLiquidacion = tablaGeneralEstadoLiquidacion;
	}

	public Usuario getUsuarioCEPendiente() {
		return this.usuarioCEPendiente;
	}

	public void setUsuarioCEPendiente(Usuario usuarioCEPendiente) {
		this.usuarioCEPendiente = usuarioCEPendiente;
	}

	public Usuario getUsuarioCEParcial() {
		return this.usuarioCEParcial;
	}

	public void setUsuarioCEParcial(Usuario usuarioCEParcial) {
		this.usuarioCEParcial = usuarioCEParcial;
	}

	public Usuario getUsuarioCECompletado() {
		return this.usuarioCECompletado;
	}

	public void setUsuarioCECompletado(Usuario usuarioCECompletado) {
		this.usuarioCECompletado = usuarioCECompletado;
	}

	public List<PagosContrata> getPagosContratas() {
		return this.pagosContratas;
	}

	public void setPagosContratas(List<PagosContrata> pagosContratas) {
		this.pagosContratas = pagosContratas;
	}

	public PagosContrata addPagosContrata(PagosContrata pagosContrata) {
		getPagosContratas().add(pagosContrata);
		pagosContrata.setContratasObra(this);

		return pagosContrata;
	}

	public PagosContrata removePagosContrata(PagosContrata pagosContrata) {
		getPagosContratas().remove(pagosContrata);
		pagosContrata.setContratasObra(null);

		return pagosContrata;
	}

}