package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pagosContrata database table.
 * 
 */
@Entity
@Table(name = "pagosContrata")
@NamedQuery(name="PagosContrata.findAll", query="SELECT p FROM PagosContrata p")
public class PagosContrata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPagosContrata;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPago;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRechazo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSolicitud;

	private BigDecimal importeAdelanto;

	private BigDecimal importeAplicadoPendientePago;

	private String motivoRechazo;

	private String numeroFactura;

	private String ordenServicio;

	private BigDecimal porcentajeAdelanto;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to ContratasObra
	@ManyToOne
	@JoinColumn(name="idContratasObra")
	private ContratasObra contratasObra;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoSolicitud")
	private TablaGeneral tablaGeneralTipoSolicitud;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGEstadoPagoContrata")
	private TablaGeneral tablaGeneralEstadoPagoContrata;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioSolicitado")
	private Usuario usuarioSolicitado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioAprobado")
	private Usuario usuarioAprobado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioRechazo")
	private Usuario usuarioRechazo;

	public PagosContrata() {
	}

	public int getIdPagosContrata() {
		return this.idPagosContrata;
	}

	public void setIdPagosContrata(int idPagosContrata) {
		this.idPagosContrata = idPagosContrata;
	}

	public Date getFechaAprobacion() {
		return this.fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
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

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaRechazo() {
		return this.fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public BigDecimal getImporteAdelanto() {
		return this.importeAdelanto;
	}

	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}

	public BigDecimal getImporteAplicadoPendientePago() {
		return this.importeAplicadoPendientePago;
	}

	public void setImporteAplicadoPendientePago(BigDecimal importeAplicadoPendientePago) {
		this.importeAplicadoPendientePago = importeAplicadoPendientePago;
	}

	public String getMotivoRechazo() {
		return this.motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getNumeroFactura() {
		return this.numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getOrdenServicio() {
		return this.ordenServicio;
	}

	public void setOrdenServicio(String ordenServicio) {
		this.ordenServicio = ordenServicio;
	}

	public BigDecimal getPorcentajeAdelanto() {
		return this.porcentajeAdelanto;
	}

	public void setPorcentajeAdelanto(BigDecimal porcentajeAdelanto) {
		this.porcentajeAdelanto = porcentajeAdelanto;
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

	public ContratasObra getContratasObra() {
		return this.contratasObra;
	}

	public void setContratasObra(ContratasObra contratasObra) {
		this.contratasObra = contratasObra;
	}

	public TablaGeneral getTablaGeneralTipoSolicitud() {
		return this.tablaGeneralTipoSolicitud;
	}

	public void setTablaGeneralTipoSolicitud(TablaGeneral tablaGeneralTipoSolicitud) {
		this.tablaGeneralTipoSolicitud = tablaGeneralTipoSolicitud;
	}

	public TablaGeneral getTablaGeneralEstadoPagoContrata() {
		return this.tablaGeneralEstadoPagoContrata;
	}

	public void setTablaGeneralEstadoPagoContrata(TablaGeneral tablaGeneralEstadoPagoContrata) {
		this.tablaGeneralEstadoPagoContrata = tablaGeneralEstadoPagoContrata;
	}

	public Usuario getUsuarioSolicitado() {
		return this.usuarioSolicitado;
	}

	public void setUsuarioSolicitado(Usuario usuarioSolicitado) {
		this.usuarioSolicitado = usuarioSolicitado;
	}

	public Usuario getUsuarioAprobado() {
		return this.usuarioAprobado;
	}

	public void setUsuarioAprobado(Usuario usuarioAprobado) {
		this.usuarioAprobado = usuarioAprobado;
	}

	public Usuario getUsuarioRechazo() {
		return this.usuarioRechazo;
	}

	public void setUsuarioRechazo(Usuario usuarioRechazo) {
		this.usuarioRechazo = usuarioRechazo;
	}

}