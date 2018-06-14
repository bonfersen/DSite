package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cajaChicaObra database table.
 * 
 */
@Entity
@Table(name = "cajaChicaObra")
@NamedQuery(name="CajaChicaObra.findAll", query="SELECT c FROM CajaChicaObra c")
public class CajaChicaObra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCajaChicaObra;

	private String detalle;

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

	private BigDecimal importeCaja;

	private BigDecimal importeTotal;

	private BigDecimal importeViatico;

	private String motivoRechazo;

	private String rendirCaja;

	private String rendirViatico;

	private String usuarioCreacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioSolicitud")
	private Usuario usuarioSolicitud;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioAprobacion")
	private Usuario usuarioAprobacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioPago")
	private Usuario usuarioPago;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioRechazo")
	private Usuario usuarioRechazo;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idEmpleadoSustentador")
	private Empleado empleadoSustentador;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idEmpleadoBeneficiario")
	private Empleado empleadoBeneficiario;

	//bi-directional many-to-one association to Obra
	@ManyToOne
	@JoinColumn(name="idObra")
	private Obra obra;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoCaja")
	private TablaGeneral tablaGeneralTipoCaja;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGEstadoCajaChica")
	private TablaGeneral tablaGeneralEstadoCajaChica;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuarioModificacion")
	private Usuario usuarioModificacion;

	//bi-directional many-to-one association to RendicionCajaChica
	@OneToMany(mappedBy="cajaChicaObra")
	private List<RendicionCajaChica> rendicionCajaChicas;

	public CajaChicaObra() {
	}

	public int getIdCajaChicaObra() {
		return this.idCajaChicaObra;
	}

	public void setIdCajaChicaObra(int idCajaChicaObra) {
		this.idCajaChicaObra = idCajaChicaObra;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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

	public BigDecimal getImporteCaja() {
		return this.importeCaja;
	}

	public void setImporteCaja(BigDecimal importeCaja) {
		this.importeCaja = importeCaja;
	}

	public BigDecimal getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public BigDecimal getImporteViatico() {
		return this.importeViatico;
	}

	public void setImporteViatico(BigDecimal importeViatico) {
		this.importeViatico = importeViatico;
	}

	public String getMotivoRechazo() {
		return this.motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public String getRendirCaja() {
		return this.rendirCaja;
	}

	public void setRendirCaja(String rendirCaja) {
		this.rendirCaja = rendirCaja;
	}

	public String getRendirViatico() {
		return this.rendirViatico;
	}

	public void setRendirViatico(String rendirViatico) {
		this.rendirViatico = rendirViatico;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Usuario getUsuarioSolicitud() {
		return this.usuarioSolicitud;
	}

	public void setUsuarioSolicitud(Usuario usuarioSolicitud) {
		this.usuarioSolicitud = usuarioSolicitud;
	}

	public Usuario getUsuarioAprobacion() {
		return this.usuarioAprobacion;
	}

	public void setUsuarioAprobacion(Usuario usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

	public Usuario getUsuarioPago() {
		return this.usuarioPago;
	}

	public void setUsuarioPago(Usuario usuarioPago) {
		this.usuarioPago = usuarioPago;
	}

	public Usuario getUsuarioRechazo() {
		return this.usuarioRechazo;
	}

	public void setUsuarioRechazo(Usuario usuarioRechazo) {
		this.usuarioRechazo = usuarioRechazo;
	}

	public Empleado getEmpleadoSustentador() {
		return this.empleadoSustentador;
	}

	public void setEmpleadoSustentador(Empleado empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
	}

	public Empleado getEmpleadoBeneficiario() {
		return this.empleadoBeneficiario;
	}

	public void setEmpleadoBeneficiario(Empleado empleadoBeneficiario) {
		this.empleadoBeneficiario = empleadoBeneficiario;
	}

	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public TablaGeneral getTablaGeneralTipoCaja() {
		return this.tablaGeneralTipoCaja;
	}

	public void setTablaGeneralTipoCaja(TablaGeneral tablaGeneralTipoCaja) {
		this.tablaGeneralTipoCaja = tablaGeneralTipoCaja;
	}

	public TablaGeneral getTablaGeneralEstadoCajaChica() {
		return this.tablaGeneralEstadoCajaChica;
	}

	public void setTablaGeneralEstadoCajaChica(TablaGeneral tablaGeneralEstadoCajaChica) {
		this.tablaGeneralEstadoCajaChica = tablaGeneralEstadoCajaChica;
	}

	public Usuario getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<RendicionCajaChica> getRendicionCajaChicas() {
		return this.rendicionCajaChicas;
	}

	public void setRendicionCajaChicas(List<RendicionCajaChica> rendicionCajaChicas) {
		this.rendicionCajaChicas = rendicionCajaChicas;
	}

	public RendicionCajaChica addRendicionCajaChica(RendicionCajaChica rendicionCajaChica) {
		getRendicionCajaChicas().add(rendicionCajaChica);
		rendicionCajaChica.setCajaChicaObra(this);

		return rendicionCajaChica;
	}

	public RendicionCajaChica removeRendicionCajaChica(RendicionCajaChica rendicionCajaChica) {
		getRendicionCajaChicas().remove(rendicionCajaChica);
		rendicionCajaChica.setCajaChicaObra(null);

		return rendicionCajaChica;
	}

}