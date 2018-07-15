package com.dsite.domain.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the obra database table.
 * 
 */
@Entity
@Table(name = "obra")
@NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o")
public class Obra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObra;

	private int cantidadContratasAsignadas;

	private String cetificado;

	private String cetificadoComplementaria;

	private String codigoCellusat;

	private String codigoDSite;

	private String comentario;

	private BigDecimal coordenadaX;

	private BigDecimal coordenadaY;

	private String direccion;

	private String ebc;

	private String facturaDSite;

	private String facturaDSiteComplementaria;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAnulacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCierreObra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnEjecucion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinalizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinalizacionObra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicioObra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaParalizacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReactivacion;

	private BigDecimal importeOrdenCompra;

	private BigDecimal importeOrdenCompraComplementaria;

	private BigDecimal importeTotalContratas;

	private String nombreReal;

	private String notaCredito;

	private String numeroOrdenCompra;

	private String numeroOrdenCompraComplementaria;

	private String otAutogenerada;

	private BigDecimal porcentajeRentabilidad;

	private String tipoTrabajo;

	private String usuarioCreacion;

	private String usuarioModificacion;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "obra")
	private List<CajaChicaObra> cajaChicaObras;

	// bi-directional many-to-one association to CierreEconomicoObra
	@OneToMany(mappedBy = "obra")
	private List<CierreEconomicoObra> cierreEconomicoObras;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "obra")
	private List<ContratasObra> contratasObras;

	// bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name = "idDistrito")
	private Distrito distrito;

	// bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "idEmpleadoResponsableObra")
	private Empleado empleado;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGArea")
	private TablaGeneral tablaGeneralArea;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGAreaSoporte")
	private TablaGeneral tablaGeneralAreaSoporte;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGProyecto")
	private TablaGeneral tablaGeneralProyecto;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGTipoGasto")
	private TablaGeneral tablaGeneralTipoGasto;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGEstadoObra")
	private TablaGeneral tablaGeneralEstadoObra;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGGerenteProyecto")
	private TablaGeneral tablaGeneralGerenteProyecto;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGGestorProyecto")
	private TablaGeneral tablaGeneralGestorProyecto;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioCierreObra")
	private Usuario usuarioCierreObra;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioEnEjecucion")
	private Usuario usuarioEnEjecucion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioAnulacion")
	private Usuario usuarioAnulacion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioParalizacion")
	private Usuario usuarioParalizacion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioReactivacion")
	private Usuario usuarioReactivacion;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuarioFinalizacion")
	private Usuario usuarioFinalizacion;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "obra")
	private List<PresupuestoObra> presupuestoObras;
	
	private BigDecimal importeTotalPresupuestadoContrata;
	
	private BigDecimal importeTotalPagosContrata;

	public Obra() {
	}

	public int getIdObra() {
		return this.idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public int getCantidadContratasAsignadas() {
		return this.cantidadContratasAsignadas;
	}

	public void setCantidadContratasAsignadas(int cantidadContratasAsignadas) {
		this.cantidadContratasAsignadas = cantidadContratasAsignadas;
	}

	public String getCetificado() {
		return this.cetificado;
	}

	public void setCetificado(String cetificado) {
		this.cetificado = cetificado;
	}

	public String getCetificadoComplementaria() {
		return this.cetificadoComplementaria;
	}

	public void setCetificadoComplementaria(String cetificadoComplementaria) {
		this.cetificadoComplementaria = cetificadoComplementaria;
	}

	public String getCodigoCellusat() {
		return this.codigoCellusat;
	}

	public void setCodigoCellusat(String codigoCellusat) {
		this.codigoCellusat = codigoCellusat;
	}

	public String getCodigoDSite() {
		return this.codigoDSite;
	}

	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public BigDecimal getCoordenadaX() {
		return this.coordenadaX;
	}

	public void setCoordenadaX(BigDecimal coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public BigDecimal getCoordenadaY() {
		return this.coordenadaY;
	}

	public void setCoordenadaY(BigDecimal coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEbc() {
		return this.ebc;
	}

	public void setEbc(String ebc) {
		this.ebc = ebc;
	}

	public String getFacturaDSite() {
		return this.facturaDSite;
	}

	public void setFacturaDSite(String facturaDSite) {
		this.facturaDSite = facturaDSite;
	}

	public String getFacturaDSiteComplementaria() {
		return this.facturaDSiteComplementaria;
	}

	public void setFacturaDSiteComplementaria(String facturaDSiteComplementaria) {
		this.facturaDSiteComplementaria = facturaDSiteComplementaria;
	}

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Date getFechaCierreObra() {
		return this.fechaCierreObra;
	}

	public void setFechaCierreObra(Date fechaCierreObra) {
		this.fechaCierreObra = fechaCierreObra;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEnEjecucion() {
		return this.fechaEnEjecucion;
	}

	public void setFechaEnEjecucion(Date fechaEnEjecucion) {
		this.fechaEnEjecucion = fechaEnEjecucion;
	}

	public Date getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Date getFechaFinalizacionObra() {
		return this.fechaFinalizacionObra;
	}

	public void setFechaFinalizacionObra(Date fechaFinalizacionObra) {
		this.fechaFinalizacionObra = fechaFinalizacionObra;
	}

	public Date getFechaInicioObra() {
		return this.fechaInicioObra;
	}

	public void setFechaInicioObra(Date fechaInicioObra) {
		this.fechaInicioObra = fechaInicioObra;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaParalizacion() {
		return this.fechaParalizacion;
	}

	public void setFechaParalizacion(Date fechaParalizacion) {
		this.fechaParalizacion = fechaParalizacion;
	}

	public Date getFechaReactivacion() {
		return this.fechaReactivacion;
	}

	public void setFechaReactivacion(Date fechaReactivacion) {
		this.fechaReactivacion = fechaReactivacion;
	}

	public BigDecimal getImporteOrdenCompra() {
		return this.importeOrdenCompra;
	}

	public void setImporteOrdenCompra(BigDecimal importeOrdenCompra) {
		this.importeOrdenCompra = importeOrdenCompra;
	}

	public BigDecimal getImporteOrdenCompraComplementaria() {
		return this.importeOrdenCompraComplementaria;
	}

	public void setImporteOrdenCompraComplementaria(BigDecimal importeOrdenCompraComplementaria) {
		this.importeOrdenCompraComplementaria = importeOrdenCompraComplementaria;
	}

	public BigDecimal getImporteTotalContratas() {
		return this.importeTotalContratas;
	}

	public void setImporteTotalContratas(BigDecimal importeTotalContratas) {
		this.importeTotalContratas = importeTotalContratas;
	}

	public String getNombreReal() {
		return this.nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getNotaCredito() {
		return this.notaCredito;
	}

	public void setNotaCredito(String notaCredito) {
		this.notaCredito = notaCredito;
	}

	public String getNumeroOrdenCompra() {
		return this.numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public String getNumeroOrdenCompraComplementaria() {
		return this.numeroOrdenCompraComplementaria;
	}

	public void setNumeroOrdenCompraComplementaria(String numeroOrdenCompraComplementaria) {
		this.numeroOrdenCompraComplementaria = numeroOrdenCompraComplementaria;
	}

	public String getOtAutogenerada() {
		return otAutogenerada;
	}

	public void setOtAutogenerada(String otAutogenerada) {
		this.otAutogenerada = otAutogenerada;
	}

	public BigDecimal getPorcentajeRentabilidad() {
		return this.porcentajeRentabilidad;
	}

	public void setPorcentajeRentabilidad(BigDecimal porcentajeRentabilidad) {
		this.porcentajeRentabilidad = porcentajeRentabilidad;
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

	public List<CajaChicaObra> getCajaChicaObras() {
		return this.cajaChicaObras;
	}

	public void setCajaChicaObras(List<CajaChicaObra> cajaChicaObras) {
		this.cajaChicaObras = cajaChicaObras;
	}

	public CajaChicaObra addCajaChicaObra(CajaChicaObra cajaChicaObra) {
		getCajaChicaObras().add(cajaChicaObra);
		cajaChicaObra.setObra(this);

		return cajaChicaObra;
	}

	public CajaChicaObra removeCajaChicaObra(CajaChicaObra cajaChicaObra) {
		getCajaChicaObras().remove(cajaChicaObra);
		cajaChicaObra.setObra(null);

		return cajaChicaObra;
	}

	public List<CierreEconomicoObra> getCierreEconomicoObras() {
		return this.cierreEconomicoObras;
	}

	public void setCierreEconomicoObras(List<CierreEconomicoObra> cierreEconomicoObras) {
		this.cierreEconomicoObras = cierreEconomicoObras;
	}

	public CierreEconomicoObra addCierreEconomicoObra(CierreEconomicoObra cierreEconomicoObra) {
		getCierreEconomicoObras().add(cierreEconomicoObra);
		cierreEconomicoObra.setObra(this);

		return cierreEconomicoObra;
	}

	public CierreEconomicoObra removeCierreEconomicoObra(CierreEconomicoObra cierreEconomicoObra) {
		getCierreEconomicoObras().remove(cierreEconomicoObra);
		cierreEconomicoObra.setObra(null);

		return cierreEconomicoObra;
	}

	public List<ContratasObra> getContratasObras() {
		return this.contratasObras;
	}

	public void setContratasObras(List<ContratasObra> contratasObras) {
		this.contratasObras = contratasObras;
	}

	public ContratasObra addContratasObra(ContratasObra contratasObra) {
		getContratasObras().add(contratasObra);
		contratasObra.setObra(this);

		return contratasObra;
	}

	public ContratasObra removeContratasObra(ContratasObra contratasObra) {
		getContratasObras().remove(contratasObra);
		contratasObra.setObra(null);

		return contratasObra;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TablaGeneral getTablaGeneralArea() {
		return this.tablaGeneralArea;
	}

	public void setTablaGeneralArea(TablaGeneral tablaGeneralArea) {
		this.tablaGeneralArea = tablaGeneralArea;
	}

	public TablaGeneral getTablaGeneralAreaSoporte() {
		return this.tablaGeneralAreaSoporte;
	}

	public void setTablaGeneralAreaSoporte(TablaGeneral tablaGeneralAreaSoporte) {
		this.tablaGeneralAreaSoporte = tablaGeneralAreaSoporte;
	}

	public TablaGeneral getTablaGeneralProyecto() {
		return this.tablaGeneralProyecto;
	}

	public void setTablaGeneralProyecto(TablaGeneral tablaGeneralProyecto) {
		this.tablaGeneralProyecto = tablaGeneralProyecto;
	}

	public TablaGeneral getTablaGeneralTipoGasto() {
		return this.tablaGeneralTipoGasto;
	}

	public void setTablaGeneralTipoGasto(TablaGeneral tablaGeneralTipoGasto) {
		this.tablaGeneralTipoGasto = tablaGeneralTipoGasto;
	}

	public TablaGeneral getTablaGeneralEstadoObra() {
		return this.tablaGeneralEstadoObra;
	}

	public void setTablaGeneralEstadoObra(TablaGeneral tablaGeneralEstadoObra) {
		this.tablaGeneralEstadoObra = tablaGeneralEstadoObra;
	}

	public TablaGeneral getTablaGeneralGerenteProyecto() {
		return this.tablaGeneralGerenteProyecto;
	}

	public void setTablaGeneralGerenteProyecto(TablaGeneral tablaGeneralGerenteProyecto) {
		this.tablaGeneralGerenteProyecto = tablaGeneralGerenteProyecto;
	}

	public TablaGeneral getTablaGeneralGestorProyecto() {
		return this.tablaGeneralGestorProyecto;
	}

	public void setTablaGeneralGestorProyecto(TablaGeneral tablaGeneralGestorProyecto) {
		this.tablaGeneralGestorProyecto = tablaGeneralGestorProyecto;
	}

	public Usuario getUsuarioCierreObra() {
		return this.usuarioCierreObra;
	}

	public void setUsuarioCierreObra(Usuario usuarioCierreObra) {
		this.usuarioCierreObra = usuarioCierreObra;
	}

	public Usuario getUsuarioEnEjecucion() {
		return this.usuarioEnEjecucion;
	}

	public void setUsuarioEnEjecucion(Usuario usuarioEnEjecucion) {
		this.usuarioEnEjecucion = usuarioEnEjecucion;
	}

	public Usuario getUsuarioAnulacion() {
		return this.usuarioAnulacion;
	}

	public void setUsuarioAnulacion(Usuario usuarioAnulacion) {
		this.usuarioAnulacion = usuarioAnulacion;
	}

	public Usuario getUsuarioParalizacion() {
		return this.usuarioParalizacion;
	}

	public void setUsuarioParalizacion(Usuario usuarioParalizacion) {
		this.usuarioParalizacion = usuarioParalizacion;
	}

	public Usuario getUsuarioReactivacion() {
		return this.usuarioReactivacion;
	}

	public void setUsuarioReactivacion(Usuario usuarioReactivacion) {
		this.usuarioReactivacion = usuarioReactivacion;
	}

	public Usuario getUsuarioFinalizacion() {
		return this.usuarioFinalizacion;
	}

	public void setUsuarioFinalizacion(Usuario usuarioFinalizacion) {
		this.usuarioFinalizacion = usuarioFinalizacion;
	}

	public List<PresupuestoObra> getPresupuestoObras() {
		return this.presupuestoObras;
	}

	public void setPresupuestoObras(List<PresupuestoObra> presupuestoObras) {
		this.presupuestoObras = presupuestoObras;
	}

	public PresupuestoObra addPresupuestoObra(PresupuestoObra presupuestoObra) {
		getPresupuestoObras().add(presupuestoObra);
		presupuestoObra.setObra(this);

		return presupuestoObra;
	}

	public PresupuestoObra removePresupuestoObra(PresupuestoObra presupuestoObra) {
		getPresupuestoObras().remove(presupuestoObra);
		presupuestoObra.setObra(null);

		return presupuestoObra;
	}

	public BigDecimal getImporteTotalPresupuestadoContrata() {
		return importeTotalPresupuestadoContrata;
	}

	public void setImporteTotalPresupuestadoContrata(BigDecimal importeTotalPresupuestadoContrata) {
		this.importeTotalPresupuestadoContrata = importeTotalPresupuestadoContrata;
	}

	public BigDecimal getImporteTotalPagosContrata() {
		return importeTotalPagosContrata;
	}

	public void setImporteTotalPagosContrata(BigDecimal importeTotalPagosContrata) {
		this.importeTotalPagosContrata = importeTotalPagosContrata;
	}
}