package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the resumenRendicionCajaChica database table.
 * 
 */
@Entity
@Table(name = "resumenRendicionCajaChica")
@NamedQuery(name = "ResumenRendicionCajaChica.findAll", query = "SELECT r FROM ResumenRendicionCajaChica r")
public class ResumenRendicionCajaChica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResumenRendicionCajaChica;

	private String codigoRendicion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDescuento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaImpresion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReembolso;

	private BigDecimal importeAbonoCaja;

	private BigDecimal importeAbonoViatico;

	private BigDecimal importeDescuentoCaja;

	private BigDecimal importeDescuentoViatico;

	private BigDecimal importeReembolsoCaja;

	private BigDecimal importeRendidoCaja;

	private BigDecimal importeRendidoViatico;

	private String usuarioCreacion;

	private String usuarioModificacion;

	// bi-directional many-to-one association to RendicionCajaChica
	@OneToMany(mappedBy = "resumenRendicionCajaChica")
	private List<RendicionCajaChica> rendicionCajaChicas;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGEstadoRendicion")
	private TablaGeneral tablaGeneralEstadoRendicion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioImpresion")
	private Usuario usuarioImpresion;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "idEmpleadoSustentador")
	private Empleado empleadoSustentador;
	
	@ManyToOne
	@JoinColumn(name = "idUsuarioAprobacion")
	private Usuario usuarioAprobacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAprobacion;
	
	@ManyToOne
	@JoinColumn(name = "idUsuarioRechazo")
	private Usuario usuarioRechazo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRechazo;
	
	private String motivoRechazo;
	
	@ManyToOne
	@JoinColumn(name = "idTGEstado")
	private TablaGeneral tablaGeneralEstado;

	public ResumenRendicionCajaChica() {
	}

	public int getIdResumenRendicionCajaChica() {
		return this.idResumenRendicionCajaChica;
	}

	public void setIdResumenRendicionCajaChica(int idResumenRendicionCajaChica) {
		this.idResumenRendicionCajaChica = idResumenRendicionCajaChica;
	}

	public String getCodigoRendicion() {
		return this.codigoRendicion;
	}

	public void setCodigoRendicion(String codigoRendicion) {
		this.codigoRendicion = codigoRendicion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaDescuento() {
		return this.fechaDescuento;
	}

	public void setFechaDescuento(Date fechaDescuento) {
		this.fechaDescuento = fechaDescuento;
	}

	public Date getFechaImpresion() {
		return this.fechaImpresion;
	}

	public void setFechaImpresion(Date fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaReembolso() {
		return this.fechaReembolso;
	}

	public void setFechaReembolso(Date fechaReembolso) {
		this.fechaReembolso = fechaReembolso;
	}

	public BigDecimal getImporteAbonoCaja() {
		return this.importeAbonoCaja;
	}

	public void setImporteAbonoCaja(BigDecimal importeAbonoCaja) {
		this.importeAbonoCaja = importeAbonoCaja;
	}

	public BigDecimal getImporteAbonoViatico() {
		return this.importeAbonoViatico;
	}

	public void setImporteAbonoViatico(BigDecimal importeAbonoViatico) {
		this.importeAbonoViatico = importeAbonoViatico;
	}

	public BigDecimal getImporteDescuentoCaja() {
		return this.importeDescuentoCaja;
	}

	public void setImporteDescuentoCaja(BigDecimal importeDescuentoCaja) {
		this.importeDescuentoCaja = importeDescuentoCaja;
	}

	public BigDecimal getImporteDescuentoViatico() {
		return this.importeDescuentoViatico;
	}

	public void setImporteDescuentoViatico(BigDecimal importeDescuentoViatico) {
		this.importeDescuentoViatico = importeDescuentoViatico;
	}

	public BigDecimal getImporteReembolsoCaja() {
		return this.importeReembolsoCaja;
	}

	public void setImporteReembolsoCaja(BigDecimal importeReembolsoCaja) {
		this.importeReembolsoCaja = importeReembolsoCaja;
	}

	public BigDecimal getImporteRendidoCaja() {
		return this.importeRendidoCaja;
	}

	public void setImporteRendidoCaja(BigDecimal importeRendidoCaja) {
		this.importeRendidoCaja = importeRendidoCaja;
	}

	public BigDecimal getImporteRendidoViatico() {
		return this.importeRendidoViatico;
	}

	public void setImporteRendidoViatico(BigDecimal importeRendidoViatico) {
		this.importeRendidoViatico = importeRendidoViatico;
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

	public List<RendicionCajaChica> getRendicionCajaChicas() {
		return this.rendicionCajaChicas;
	}

	public void setRendicionCajaChicas(List<RendicionCajaChica> rendicionCajaChicas) {
		this.rendicionCajaChicas = rendicionCajaChicas;
	}

	public RendicionCajaChica addRendicionCajaChica(RendicionCajaChica rendicionCajaChica) {
		getRendicionCajaChicas().add(rendicionCajaChica);
		rendicionCajaChica.setResumenRendicionCajaChica(this);

		return rendicionCajaChica;
	}

	public RendicionCajaChica removeRendicionCajaChica(RendicionCajaChica rendicionCajaChica) {
		getRendicionCajaChicas().remove(rendicionCajaChica);
		rendicionCajaChica.setResumenRendicionCajaChica(null);

		return rendicionCajaChica;
	}

	public TablaGeneral getTablaGeneralEstadoRendicion() {
		return this.tablaGeneralEstadoRendicion;
	}

	public void setTablaGeneralEstadoRendicion(TablaGeneral tablaGeneralEstadoRendicion) {
		this.tablaGeneralEstadoRendicion = tablaGeneralEstadoRendicion;
	}

	public Usuario getUsuarioImpresion() {
		return this.usuarioImpresion;
	}

	public void setUsuarioImpresion(Usuario usuarioImpresion) {
		this.usuarioImpresion = usuarioImpresion;
	}

	public Empleado getEmpleadoSustentador() {
		return empleadoSustentador;
	}

	public void setEmpleadoSustentador(Empleado empleadoSustentador) {
		this.empleadoSustentador = empleadoSustentador;
	}

	public Usuario getUsuarioAprobacion() {
		return usuarioAprobacion;
	}

	public void setUsuarioAprobacion(Usuario usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Usuario getUsuarioRechazo() {
		return usuarioRechazo;
	}

	public void setUsuarioRechazo(Usuario usuarioRechazo) {
		this.usuarioRechazo = usuarioRechazo;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public TablaGeneral getTablaGeneralEstado() {
		return tablaGeneralEstado;
	}

	public void setTablaGeneralEstado(TablaGeneral tablaGeneralEstado) {
		this.tablaGeneralEstado = tablaGeneralEstado;
	}
}