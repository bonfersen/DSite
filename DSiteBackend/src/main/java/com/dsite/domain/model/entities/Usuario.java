package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	private String activo;

	private String cuentaUsuario;

	private String password;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGRol")
	private TablaGeneral tablaGeneralRol;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "usuarioRechaza")
	private List<ActasContrata> actasContratasUsuarioRechaza;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "usuarioAprueba")
	private List<ActasContrata> actasContratasUsuarioAprueba;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "usuarioAdjunta")
	private List<ActasContrata> actasContratasUsuarioAdjunta;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "usuarioSolicitud")
	private List<CajaChicaObra> cajaChicaObrasUsuarioSolicitud;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "usuarioAprobacion")
	private List<CajaChicaObra> cajaChicaObrasUsuarioAprobacion;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "usuarioPago")
	private List<CajaChicaObra> cajaChicaObrasUsuarioPago;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "usuarioRechazo")
	private List<CajaChicaObra> cajaChicaObrasUsuarioRechazo;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "usuarioModificacion")
	private List<CajaChicaObra> cajaChicaObrasUsuarioModificacion;

	// bi-directional many-to-one association to CierreEconomico
	@OneToMany(mappedBy = "usuarioAsignacion")
	private List<CierreEconomico> cierreEconomicosUsuarioAsignacion;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "usuarioCEPendiente")
	private List<ContratasObra> contratasObrasUsuarioCEPendiente;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "usuarioCEParcial")
	private List<ContratasObra> contratasObrasUsuarioCEParcial;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "usuarioCECompletado")
	private List<ContratasObra> contratasObrasUsuarioCECompletado;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "usuarioCierreObra")
	private List<Obra> obrasUsuarioCierreObra;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "usuarioEnEjecucion")
	private List<Obra> obrasUsuarioEnEjecucion;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "usuarioAnulacion")
	private List<Obra> obrasUsuarioAnulacion;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "usuarioParalizacion")
	private List<Obra> obrasUsuarioParalizacion;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "usuarioReactivacion")
	private List<Obra> obrasUsuarioReactivacion;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "usuarioFinalizacion")
	private List<Obra> obrasUsuarioFinalizacion;

	// bi-directional many-to-one association to PagosContrata
	@OneToMany(mappedBy = "usuarioSolicitado")
	private List<PagosContrata> pagosContratasUsuarioSolicitado;

	// bi-directional many-to-one association to PagosContrata
	@OneToMany(mappedBy = "usuarioAprobado")
	private List<PagosContrata> pagosContratasUsuarioAprobado;

	// bi-directional many-to-one association to PagosContrata
	@OneToMany(mappedBy = "usuarioRechazo")
	private List<PagosContrata> pagosContratasUsuarioRechazo;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "usuarioEnvioPresupuestoOferta")
	private List<PresupuestoObra> presupuestoObrasUsuarioEnvioPresupuestoOferta;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "usuarioEnvioPresupuestoLiquidacion")
	private List<PresupuestoObra> presupuestoObrasUsuarioEnvioPresupuestoLiquidacion;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "usuarioEnvioActaCampo")
	private List<PresupuestoObra> presupuestoObrasUsuarioEnvioActaCampo;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "usuarioEnvioActaFinal")
	private List<PresupuestoObra> presupuestoObrasUsuarioEnvioActaFinal;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "usuarioOfertado")
	private List<PresupuestoObra> presupuestoObrasUsuarioOfertado;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "usuarioLiquidacion")
	private List<PresupuestoObra> presupuestoObrasUsuarioLiquidacion;

	// bi-directional many-to-one association to ResumenRendicionCajaChica
	@OneToMany(mappedBy = "usuarioImpresion")
	private List<ResumenRendicionCajaChica> resumenRendicionCajaChicasUsuarioImpresion;

	// bi-directional many-to-one association to ResumenRendicionCajaChica
	@OneToMany(mappedBy = "usuarioRechazo")
	private List<ResumenRendicionCajaChica> resumenRendicionCajaChicasUsuarioRechazo;

	@OneToMany(mappedBy = "usuarioAprobacion")
	private List<ResumenRendicionCajaChica> resumenRendicionCajaChicasUsuarioAprobacion;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCuentaUsuario() {
		return this.cuentaUsuario;
	}

	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TablaGeneral getTablaGeneralRol() {
		return tablaGeneralRol;
	}

	public void setTablaGeneralRol(TablaGeneral tablaGeneralRol) {
		this.tablaGeneralRol = tablaGeneralRol;
	}

	public List<ActasContrata> getActasContratasUsuarioRechaza() {
		return this.actasContratasUsuarioRechaza;
	}

	public void setActasContratasUsuarioRechaza(List<ActasContrata> actasContratasUsuarioRechaza) {
		this.actasContratasUsuarioRechaza = actasContratasUsuarioRechaza;
	}

	public ActasContrata addActasContratasUsuarioRechaza(ActasContrata actasContratasUsuarioRechaza) {
		getActasContratasUsuarioRechaza().add(actasContratasUsuarioRechaza);
		actasContratasUsuarioRechaza.setUsuarioRechaza(this);

		return actasContratasUsuarioRechaza;
	}

	public ActasContrata removeActasContratasUsuarioRechaza(ActasContrata actasContratasUsuarioRechaza) {
		getActasContratasUsuarioRechaza().remove(actasContratasUsuarioRechaza);
		actasContratasUsuarioRechaza.setUsuarioRechaza(null);

		return actasContratasUsuarioRechaza;
	}

	public List<ActasContrata> getActasContratasUsuarioAprueba() {
		return this.actasContratasUsuarioAprueba;
	}

	public void setActasContratasUsuarioAprueba(List<ActasContrata> actasContratasUsuarioAprueba) {
		this.actasContratasUsuarioAprueba = actasContratasUsuarioAprueba;
	}

	public ActasContrata addActasContratasUsuarioAprueba(ActasContrata actasContratasUsuarioAprueba) {
		getActasContratasUsuarioAprueba().add(actasContratasUsuarioAprueba);
		actasContratasUsuarioAprueba.setUsuarioAprueba(this);

		return actasContratasUsuarioAprueba;
	}

	public ActasContrata removeActasContratasUsuarioAprueba(ActasContrata actasContratasUsuarioAprueba) {
		getActasContratasUsuarioAprueba().remove(actasContratasUsuarioAprueba);
		actasContratasUsuarioAprueba.setUsuarioAprueba(null);

		return actasContratasUsuarioAprueba;
	}

	public List<ActasContrata> getActasContratasUsuarioAdjunta() {
		return this.actasContratasUsuarioAdjunta;
	}

	public void setActasContratasUsuarioAdjunta(List<ActasContrata> actasContratasUsuarioAdjunta) {
		this.actasContratasUsuarioAdjunta = actasContratasUsuarioAdjunta;
	}

	public ActasContrata addActasContratasUsuarioAdjunta(ActasContrata actasContratasUsuarioAdjunta) {
		getActasContratasUsuarioAdjunta().add(actasContratasUsuarioAdjunta);
		actasContratasUsuarioAdjunta.setUsuarioAdjunta(this);

		return actasContratasUsuarioAdjunta;
	}

	public ActasContrata removeActasContratasUsuarioAdjunta(ActasContrata actasContratasUsuarioAdjunta) {
		getActasContratasUsuarioAdjunta().remove(actasContratasUsuarioAdjunta);
		actasContratasUsuarioAdjunta.setUsuarioAdjunta(null);

		return actasContratasUsuarioAdjunta;
	}

	public List<CajaChicaObra> getCajaChicaObrasUsuarioSolicitud() {
		return this.cajaChicaObrasUsuarioSolicitud;
	}

	public void setCajaChicaObrasUsuarioSolicitud(List<CajaChicaObra> cajaChicaObrasUsuarioSolicitud) {
		this.cajaChicaObrasUsuarioSolicitud = cajaChicaObrasUsuarioSolicitud;
	}

	public CajaChicaObra addCajaChicaObrasUsuarioSolicitud(CajaChicaObra cajaChicaObrasUsuarioSolicitud) {
		getCajaChicaObrasUsuarioSolicitud().add(cajaChicaObrasUsuarioSolicitud);
		cajaChicaObrasUsuarioSolicitud.setUsuarioSolicitud(this);

		return cajaChicaObrasUsuarioSolicitud;
	}

	public CajaChicaObra removeCajaChicaObrasUsuarioSolicitud(CajaChicaObra cajaChicaObrasUsuarioSolicitud) {
		getCajaChicaObrasUsuarioSolicitud().remove(cajaChicaObrasUsuarioSolicitud);
		cajaChicaObrasUsuarioSolicitud.setUsuarioSolicitud(null);

		return cajaChicaObrasUsuarioSolicitud;
	}

	public List<CajaChicaObra> getCajaChicaObrasUsuarioAprobacion() {
		return this.cajaChicaObrasUsuarioAprobacion;
	}

	public void setCajaChicaObrasUsuarioAprobacion(List<CajaChicaObra> cajaChicaObrasUsuarioAprobacion) {
		this.cajaChicaObrasUsuarioAprobacion = cajaChicaObrasUsuarioAprobacion;
	}

	public CajaChicaObra addCajaChicaObrasUsuarioAprobacion(CajaChicaObra cajaChicaObrasUsuarioAprobacion) {
		getCajaChicaObrasUsuarioAprobacion().add(cajaChicaObrasUsuarioAprobacion);
		cajaChicaObrasUsuarioAprobacion.setUsuarioAprobacion(this);

		return cajaChicaObrasUsuarioAprobacion;
	}

	public CajaChicaObra removeCajaChicaObrasUsuarioAprobacion(CajaChicaObra cajaChicaObrasUsuarioAprobacion) {
		getCajaChicaObrasUsuarioAprobacion().remove(cajaChicaObrasUsuarioAprobacion);
		cajaChicaObrasUsuarioAprobacion.setUsuarioAprobacion(null);

		return cajaChicaObrasUsuarioAprobacion;
	}

	public List<CajaChicaObra> getCajaChicaObrasUsuarioPago() {
		return this.cajaChicaObrasUsuarioPago;
	}

	public void setCajaChicaObrasUsuarioPago(List<CajaChicaObra> cajaChicaObrasUsuarioPago) {
		this.cajaChicaObrasUsuarioPago = cajaChicaObrasUsuarioPago;
	}

	public CajaChicaObra addCajaChicaObrasUsuarioPago(CajaChicaObra cajaChicaObrasUsuarioPago) {
		getCajaChicaObrasUsuarioPago().add(cajaChicaObrasUsuarioPago);
		cajaChicaObrasUsuarioPago.setUsuarioPago(this);

		return cajaChicaObrasUsuarioPago;
	}

	public CajaChicaObra removeCajaChicaObrasUsuarioPago(CajaChicaObra cajaChicaObrasUsuarioPago) {
		getCajaChicaObrasUsuarioPago().remove(cajaChicaObrasUsuarioPago);
		cajaChicaObrasUsuarioPago.setUsuarioPago(null);

		return cajaChicaObrasUsuarioPago;
	}

	public List<CajaChicaObra> getCajaChicaObrasUsuarioRechazo() {
		return this.cajaChicaObrasUsuarioRechazo;
	}

	public void setCajaChicaObrasUsuarioRechazo(List<CajaChicaObra> cajaChicaObrasUsuarioRechazo) {
		this.cajaChicaObrasUsuarioRechazo = cajaChicaObrasUsuarioRechazo;
	}

	public CajaChicaObra addCajaChicaObrasUsuarioRechazo(CajaChicaObra cajaChicaObrasUsuarioRechazo) {
		getCajaChicaObrasUsuarioRechazo().add(cajaChicaObrasUsuarioRechazo);
		cajaChicaObrasUsuarioRechazo.setUsuarioRechazo(this);

		return cajaChicaObrasUsuarioRechazo;
	}

	public CajaChicaObra removeCajaChicaObrasUsuarioRechazo(CajaChicaObra cajaChicaObrasUsuarioRechazo) {
		getCajaChicaObrasUsuarioRechazo().remove(cajaChicaObrasUsuarioRechazo);
		cajaChicaObrasUsuarioRechazo.setUsuarioRechazo(null);

		return cajaChicaObrasUsuarioRechazo;
	}

	public List<CajaChicaObra> getCajaChicaObrasUsuarioModificacion() {
		return this.cajaChicaObrasUsuarioModificacion;
	}

	public void setCajaChicaObrasUsuarioModificacion(List<CajaChicaObra> cajaChicaObrasUsuarioModificacion) {
		this.cajaChicaObrasUsuarioModificacion = cajaChicaObrasUsuarioModificacion;
	}

	public CajaChicaObra addCajaChicaObrasUsuarioModificacion(CajaChicaObra cajaChicaObrasUsuarioModificacion) {
		getCajaChicaObrasUsuarioModificacion().add(cajaChicaObrasUsuarioModificacion);
		cajaChicaObrasUsuarioModificacion.setUsuarioModificacion(this);

		return cajaChicaObrasUsuarioModificacion;
	}

	public CajaChicaObra removeCajaChicaObrasUsuarioModificacion(CajaChicaObra cajaChicaObrasUsuarioModificacion) {
		getCajaChicaObrasUsuarioModificacion().remove(cajaChicaObrasUsuarioModificacion);
		cajaChicaObrasUsuarioModificacion.setUsuarioModificacion(null);

		return cajaChicaObrasUsuarioModificacion;
	}

	public List<CierreEconomico> getCierreEconomicosUsuarioAsignacion() {
		return this.cierreEconomicosUsuarioAsignacion;
	}

	public void setCierreEconomicosUsuarioAsignacion(List<CierreEconomico> cierreEconomicosUsuarioAsignacion) {
		this.cierreEconomicosUsuarioAsignacion = cierreEconomicosUsuarioAsignacion;
	}

	public CierreEconomico addCierreEconomicosUsuarioAsignacion(CierreEconomico cierreEconomicosUsuarioAsignacion) {
		getCierreEconomicosUsuarioAsignacion().add(cierreEconomicosUsuarioAsignacion);
		cierreEconomicosUsuarioAsignacion.setUsuarioAsignacion(this);

		return cierreEconomicosUsuarioAsignacion;
	}

	public CierreEconomico removeCierreEconomicosUsuarioAsignacion(CierreEconomico cierreEconomicosUsuarioAsignacion) {
		getCierreEconomicosUsuarioAsignacion().remove(cierreEconomicosUsuarioAsignacion);
		cierreEconomicosUsuarioAsignacion.setUsuarioAsignacion(null);

		return cierreEconomicosUsuarioAsignacion;
	}

	public List<ContratasObra> getContratasObrasUsuarioCEPendiente() {
		return this.contratasObrasUsuarioCEPendiente;
	}

	public void setContratasObrasUsuarioCEPendiente(List<ContratasObra> contratasObrasUsuarioCEPendiente) {
		this.contratasObrasUsuarioCEPendiente = contratasObrasUsuarioCEPendiente;
	}

	public ContratasObra addContratasObrasUsuarioCEPendiente(ContratasObra contratasObrasUsuarioCEPendiente) {
		getContratasObrasUsuarioCEPendiente().add(contratasObrasUsuarioCEPendiente);
		contratasObrasUsuarioCEPendiente.setUsuarioCEPendiente(this);

		return contratasObrasUsuarioCEPendiente;
	}

	public ContratasObra removeContratasObrasUsuarioCEPendiente(ContratasObra contratasObrasUsuarioCEPendiente) {
		getContratasObrasUsuarioCEPendiente().remove(contratasObrasUsuarioCEPendiente);
		contratasObrasUsuarioCEPendiente.setUsuarioCEPendiente(null);

		return contratasObrasUsuarioCEPendiente;
	}

	public List<ContratasObra> getContratasObrasUsuarioCEParcial() {
		return this.contratasObrasUsuarioCEParcial;
	}

	public void setContratasObrasUsuarioCEParcial(List<ContratasObra> contratasObrasUsuarioCEParcial) {
		this.contratasObrasUsuarioCEParcial = contratasObrasUsuarioCEParcial;
	}

	public ContratasObra addContratasObrasUsuarioCEParcial(ContratasObra contratasObrasUsuarioCEParcial) {
		getContratasObrasUsuarioCEParcial().add(contratasObrasUsuarioCEParcial);
		contratasObrasUsuarioCEParcial.setUsuarioCEParcial(this);

		return contratasObrasUsuarioCEParcial;
	}

	public ContratasObra removeContratasObrasUsuarioCEParcial(ContratasObra contratasObrasUsuarioCEParcial) {
		getContratasObrasUsuarioCEParcial().remove(contratasObrasUsuarioCEParcial);
		contratasObrasUsuarioCEParcial.setUsuarioCEParcial(null);

		return contratasObrasUsuarioCEParcial;
	}

	public List<ContratasObra> getContratasObrasUsuarioCECompletado() {
		return this.contratasObrasUsuarioCECompletado;
	}

	public void setContratasObrasUsuarioCECompletado(List<ContratasObra> contratasObrasUsuarioCECompletado) {
		this.contratasObrasUsuarioCECompletado = contratasObrasUsuarioCECompletado;
	}

	public ContratasObra addContratasObrasUsuarioCECompletado(ContratasObra contratasObrasUsuarioCECompletado) {
		getContratasObrasUsuarioCECompletado().add(contratasObrasUsuarioCECompletado);
		contratasObrasUsuarioCECompletado.setUsuarioCECompletado(this);

		return contratasObrasUsuarioCECompletado;
	}

	public ContratasObra removeContratasObrasUsuarioCECompletado(ContratasObra contratasObrasUsuarioCECompletado) {
		getContratasObrasUsuarioCECompletado().remove(contratasObrasUsuarioCECompletado);
		contratasObrasUsuarioCECompletado.setUsuarioCECompletado(null);

		return contratasObrasUsuarioCECompletado;
	}

	public List<Obra> getObrasUsuarioCierreObra() {
		return this.obrasUsuarioCierreObra;
	}

	public void setObrasUsuarioCierreObra(List<Obra> obrasUsuarioCierreObra) {
		this.obrasUsuarioCierreObra = obrasUsuarioCierreObra;
	}

	public Obra addObrasUsuarioCierreObra(Obra obrasUsuarioCierreObra) {
		getObrasUsuarioCierreObra().add(obrasUsuarioCierreObra);
		obrasUsuarioCierreObra.setUsuarioCierreObra(this);

		return obrasUsuarioCierreObra;
	}

	public Obra removeObrasUsuarioCierreObra(Obra obrasUsuarioCierreObra) {
		getObrasUsuarioCierreObra().remove(obrasUsuarioCierreObra);
		obrasUsuarioCierreObra.setUsuarioCierreObra(null);

		return obrasUsuarioCierreObra;
	}

	public List<Obra> getObrasUsuarioEnEjecucion() {
		return this.obrasUsuarioEnEjecucion;
	}

	public void setObrasUsuarioEnEjecucion(List<Obra> obrasUsuarioEnEjecucion) {
		this.obrasUsuarioEnEjecucion = obrasUsuarioEnEjecucion;
	}

	public Obra addObrasUsuarioEnEjecucion(Obra obrasUsuarioEnEjecucion) {
		getObrasUsuarioEnEjecucion().add(obrasUsuarioEnEjecucion);
		obrasUsuarioEnEjecucion.setUsuarioEnEjecucion(this);

		return obrasUsuarioEnEjecucion;
	}

	public Obra removeObrasUsuarioEnEjecucion(Obra obrasUsuarioEnEjecucion) {
		getObrasUsuarioEnEjecucion().remove(obrasUsuarioEnEjecucion);
		obrasUsuarioEnEjecucion.setUsuarioEnEjecucion(null);

		return obrasUsuarioEnEjecucion;
	}

	public List<Obra> getObrasUsuarioAnulacion() {
		return this.obrasUsuarioAnulacion;
	}

	public void setObrasUsuarioAnulacion(List<Obra> obrasUsuarioAnulacion) {
		this.obrasUsuarioAnulacion = obrasUsuarioAnulacion;
	}

	public Obra addObrasUsuarioAnulacion(Obra obrasUsuarioAnulacion) {
		getObrasUsuarioAnulacion().add(obrasUsuarioAnulacion);
		obrasUsuarioAnulacion.setUsuarioAnulacion(this);

		return obrasUsuarioAnulacion;
	}

	public Obra removeObrasUsuarioAnulacion(Obra obrasUsuarioAnulacion) {
		getObrasUsuarioAnulacion().remove(obrasUsuarioAnulacion);
		obrasUsuarioAnulacion.setUsuarioAnulacion(null);

		return obrasUsuarioAnulacion;
	}

	public List<Obra> getObrasUsuarioParalizacion() {
		return this.obrasUsuarioParalizacion;
	}

	public void setObrasUsuarioParalizacion(List<Obra> obrasUsuarioParalizacion) {
		this.obrasUsuarioParalizacion = obrasUsuarioParalizacion;
	}

	public Obra addObrasUsuarioParalizacion(Obra obrasUsuarioParalizacion) {
		getObrasUsuarioParalizacion().add(obrasUsuarioParalizacion);
		obrasUsuarioParalizacion.setUsuarioParalizacion(this);

		return obrasUsuarioParalizacion;
	}

	public Obra removeObrasUsuarioParalizacion(Obra obrasUsuarioParalizacion) {
		getObrasUsuarioParalizacion().remove(obrasUsuarioParalizacion);
		obrasUsuarioParalizacion.setUsuarioParalizacion(null);

		return obrasUsuarioParalizacion;
	}

	public List<Obra> getObrasUsuarioReactivacion() {
		return this.obrasUsuarioReactivacion;
	}

	public void setObrasUsuarioReactivacion(List<Obra> obrasUsuarioReactivacion) {
		this.obrasUsuarioReactivacion = obrasUsuarioReactivacion;
	}

	public Obra addObrasUsuarioReactivacion(Obra obrasUsuarioReactivacion) {
		getObrasUsuarioReactivacion().add(obrasUsuarioReactivacion);
		obrasUsuarioReactivacion.setUsuarioReactivacion(this);

		return obrasUsuarioReactivacion;
	}

	public Obra removeObrasUsuarioReactivacion(Obra obrasUsuarioReactivacion) {
		getObrasUsuarioReactivacion().remove(obrasUsuarioReactivacion);
		obrasUsuarioReactivacion.setUsuarioReactivacion(null);

		return obrasUsuarioReactivacion;
	}

	public List<Obra> getObrasUsuarioFinalizacion() {
		return this.obrasUsuarioFinalizacion;
	}

	public void setObrasUsuarioFinalizacion(List<Obra> obrasUsuarioFinalizacion) {
		this.obrasUsuarioFinalizacion = obrasUsuarioFinalizacion;
	}

	public Obra addObrasUsuarioFinalizacion(Obra obrasUsuarioFinalizacion) {
		getObrasUsuarioFinalizacion().add(obrasUsuarioFinalizacion);
		obrasUsuarioFinalizacion.setUsuarioFinalizacion(this);

		return obrasUsuarioFinalizacion;
	}

	public Obra removeObrasUsuarioFinalizacion(Obra obrasUsuarioFinalizacion) {
		getObrasUsuarioFinalizacion().remove(obrasUsuarioFinalizacion);
		obrasUsuarioFinalizacion.setUsuarioFinalizacion(null);

		return obrasUsuarioFinalizacion;
	}

	public List<PagosContrata> getPagosContratasUsuarioSolicitado() {
		return this.pagosContratasUsuarioSolicitado;
	}

	public void setPagosContratasUsuarioSolicitado(List<PagosContrata> pagosContratasUsuarioSolicitado) {
		this.pagosContratasUsuarioSolicitado = pagosContratasUsuarioSolicitado;
	}

	public PagosContrata addPagosContratasUsuarioSolicitado(PagosContrata pagosContratasUsuarioSolicitado) {
		getPagosContratasUsuarioSolicitado().add(pagosContratasUsuarioSolicitado);
		pagosContratasUsuarioSolicitado.setUsuarioSolicitado(this);

		return pagosContratasUsuarioSolicitado;
	}

	public PagosContrata removePagosContratasUsuarioSolicitado(PagosContrata pagosContratasUsuarioSolicitado) {
		getPagosContratasUsuarioSolicitado().remove(pagosContratasUsuarioSolicitado);
		pagosContratasUsuarioSolicitado.setUsuarioSolicitado(null);

		return pagosContratasUsuarioSolicitado;
	}

	public List<PagosContrata> getPagosContratasUsuarioAprobado() {
		return this.pagosContratasUsuarioAprobado;
	}

	public void setPagosContratasUsuarioAprobado(List<PagosContrata> pagosContratasUsuarioAprobado) {
		this.pagosContratasUsuarioAprobado = pagosContratasUsuarioAprobado;
	}

	public PagosContrata addPagosContratasUsuarioAprobado(PagosContrata pagosContratasUsuarioAprobado) {
		getPagosContratasUsuarioAprobado().add(pagosContratasUsuarioAprobado);
		pagosContratasUsuarioAprobado.setUsuarioAprobado(this);

		return pagosContratasUsuarioAprobado;
	}

	public PagosContrata removePagosContratasUsuarioAprobado(PagosContrata pagosContratasUsuarioAprobado) {
		getPagosContratasUsuarioAprobado().remove(pagosContratasUsuarioAprobado);
		pagosContratasUsuarioAprobado.setUsuarioAprobado(null);

		return pagosContratasUsuarioAprobado;
	}

	public List<PagosContrata> getPagosContratasUsuarioRechazo() {
		return this.pagosContratasUsuarioRechazo;
	}

	public void setPagosContratasUsuarioRechazo(List<PagosContrata> pagosContratasUsuarioRechazo) {
		this.pagosContratasUsuarioRechazo = pagosContratasUsuarioRechazo;
	}

	public PagosContrata addPagosContratasUsuarioRechazo(PagosContrata pagosContratasUsuarioRechazo) {
		getPagosContratasUsuarioRechazo().add(pagosContratasUsuarioRechazo);
		pagosContratasUsuarioRechazo.setUsuarioRechazo(this);

		return pagosContratasUsuarioRechazo;
	}

	public PagosContrata removePagosContratasUsuarioRechazo(PagosContrata pagosContratasUsuarioRechazo) {
		getPagosContratasUsuarioRechazo().remove(pagosContratasUsuarioRechazo);
		pagosContratasUsuarioRechazo.setUsuarioRechazo(null);

		return pagosContratasUsuarioRechazo;
	}

	public List<PresupuestoObra> getPresupuestoObrasUsuarioEnvioPresupuestoOferta() {
		return this.presupuestoObrasUsuarioEnvioPresupuestoOferta;
	}

	public void setPresupuestoObrasUsuarioEnvioPresupuestoOferta(List<PresupuestoObra> presupuestoObrasUsuarioEnvioPresupuestoOferta) {
		this.presupuestoObrasUsuarioEnvioPresupuestoOferta = presupuestoObrasUsuarioEnvioPresupuestoOferta;
	}

	public PresupuestoObra addPresupuestoObrasUsuarioEnvioPresupuestoOferta(PresupuestoObra presupuestoObrasUsuarioEnvioPresupuestoOferta) {
		getPresupuestoObrasUsuarioEnvioPresupuestoOferta().add(presupuestoObrasUsuarioEnvioPresupuestoOferta);
		presupuestoObrasUsuarioEnvioPresupuestoOferta.setUsuarioEnvioPresupuestoOferta(this);

		return presupuestoObrasUsuarioEnvioPresupuestoOferta;
	}

	public PresupuestoObra removePresupuestoObrasUsuarioEnvioPresupuestoOferta(PresupuestoObra presupuestoObrasUsuarioEnvioPresupuestoOferta) {
		getPresupuestoObrasUsuarioEnvioPresupuestoOferta().remove(presupuestoObrasUsuarioEnvioPresupuestoOferta);
		presupuestoObrasUsuarioEnvioPresupuestoOferta.setUsuarioEnvioPresupuestoOferta(null);

		return presupuestoObrasUsuarioEnvioPresupuestoOferta;
	}

	public List<PresupuestoObra> getPresupuestoObrasUsuarioEnvioPresupuestoLiquidacion() {
		return this.presupuestoObrasUsuarioEnvioPresupuestoLiquidacion;
	}

	public void setPresupuestoObrasUsuarioEnvioPresupuestoLiquidacion(List<PresupuestoObra> presupuestoObrasUsuarioEnvioPresupuestoLiquidacion) {
		this.presupuestoObrasUsuarioEnvioPresupuestoLiquidacion = presupuestoObrasUsuarioEnvioPresupuestoLiquidacion;
	}

	public PresupuestoObra addPresupuestoObrasUsuarioEnvioPresupuestoLiquidacion(PresupuestoObra presupuestoObrasUsuarioEnvioPresupuestoLiquidacion) {
		getPresupuestoObrasUsuarioEnvioPresupuestoLiquidacion().add(presupuestoObrasUsuarioEnvioPresupuestoLiquidacion);
		presupuestoObrasUsuarioEnvioPresupuestoLiquidacion.setUsuarioEnvioPresupuestoLiquidacion(this);

		return presupuestoObrasUsuarioEnvioPresupuestoLiquidacion;
	}

	public PresupuestoObra removePresupuestoObrasUsuarioEnvioPresupuestoLiquidacion(PresupuestoObra presupuestoObrasUsuarioEnvioPresupuestoLiquidacion) {
		getPresupuestoObrasUsuarioEnvioPresupuestoLiquidacion().remove(presupuestoObrasUsuarioEnvioPresupuestoLiquidacion);
		presupuestoObrasUsuarioEnvioPresupuestoLiquidacion.setUsuarioEnvioPresupuestoLiquidacion(null);

		return presupuestoObrasUsuarioEnvioPresupuestoLiquidacion;
	}

	public List<PresupuestoObra> getPresupuestoObrasUsuarioEnvioActaCampo() {
		return this.presupuestoObrasUsuarioEnvioActaCampo;
	}

	public void setPresupuestoObrasUsuarioEnvioActaCampo(List<PresupuestoObra> presupuestoObrasUsuarioEnvioActaCampo) {
		this.presupuestoObrasUsuarioEnvioActaCampo = presupuestoObrasUsuarioEnvioActaCampo;
	}

	public PresupuestoObra addPresupuestoObrasUsuarioEnvioActaCampo(PresupuestoObra presupuestoObrasUsuarioEnvioActaCampo) {
		getPresupuestoObrasUsuarioEnvioActaCampo().add(presupuestoObrasUsuarioEnvioActaCampo);
		presupuestoObrasUsuarioEnvioActaCampo.setUsuarioEnvioActaCampo(this);

		return presupuestoObrasUsuarioEnvioActaCampo;
	}

	public PresupuestoObra removePresupuestoObrasUsuarioEnvioActaCampo(PresupuestoObra presupuestoObrasUsuarioEnvioActaCampo) {
		getPresupuestoObrasUsuarioEnvioActaCampo().remove(presupuestoObrasUsuarioEnvioActaCampo);
		presupuestoObrasUsuarioEnvioActaCampo.setUsuarioEnvioActaCampo(null);

		return presupuestoObrasUsuarioEnvioActaCampo;
	}

	public List<PresupuestoObra> getPresupuestoObrasUsuarioEnvioActaFinal() {
		return this.presupuestoObrasUsuarioEnvioActaFinal;
	}

	public void setPresupuestoObrasUsuarioEnvioActaFinal(List<PresupuestoObra> presupuestoObrasUsuarioEnvioActaFinal) {
		this.presupuestoObrasUsuarioEnvioActaFinal = presupuestoObrasUsuarioEnvioActaFinal;
	}

	public PresupuestoObra addPresupuestoObrasUsuarioEnvioActaFinal(PresupuestoObra presupuestoObrasUsuarioEnvioActaFinal) {
		getPresupuestoObrasUsuarioEnvioActaFinal().add(presupuestoObrasUsuarioEnvioActaFinal);
		presupuestoObrasUsuarioEnvioActaFinal.setUsuarioEnvioActaFinal(this);

		return presupuestoObrasUsuarioEnvioActaFinal;
	}

	public PresupuestoObra removePresupuestoObrasUsuarioEnvioActaFinal(PresupuestoObra presupuestoObrasUsuarioEnvioActaFinal) {
		getPresupuestoObrasUsuarioEnvioActaFinal().remove(presupuestoObrasUsuarioEnvioActaFinal);
		presupuestoObrasUsuarioEnvioActaFinal.setUsuarioEnvioActaFinal(null);

		return presupuestoObrasUsuarioEnvioActaFinal;
	}

	public List<PresupuestoObra> getPresupuestoObrasUsuarioOfertado() {
		return this.presupuestoObrasUsuarioOfertado;
	}

	public void setPresupuestoObrasUsuarioOfertado(List<PresupuestoObra> presupuestoObrasUsuarioOfertado) {
		this.presupuestoObrasUsuarioOfertado = presupuestoObrasUsuarioOfertado;
	}

	public PresupuestoObra addPresupuestoObrasUsuarioOfertado(PresupuestoObra presupuestoObrasUsuarioOfertado) {
		getPresupuestoObrasUsuarioOfertado().add(presupuestoObrasUsuarioOfertado);
		presupuestoObrasUsuarioOfertado.setUsuarioOfertado(this);

		return presupuestoObrasUsuarioOfertado;
	}

	public PresupuestoObra removePresupuestoObrasUsuarioOfertado(PresupuestoObra presupuestoObrasUsuarioOfertado) {
		getPresupuestoObrasUsuarioOfertado().remove(presupuestoObrasUsuarioOfertado);
		presupuestoObrasUsuarioOfertado.setUsuarioOfertado(null);

		return presupuestoObrasUsuarioOfertado;
	}

	public List<PresupuestoObra> getPresupuestoObrasUsuarioLiquidacion() {
		return this.presupuestoObrasUsuarioLiquidacion;
	}

	public void setPresupuestoObrasUsuarioLiquidacion(List<PresupuestoObra> presupuestoObrasUsuarioLiquidacion) {
		this.presupuestoObrasUsuarioLiquidacion = presupuestoObrasUsuarioLiquidacion;
	}

	public PresupuestoObra addPresupuestoObrasUsuarioLiquidacion(PresupuestoObra presupuestoObrasUsuarioLiquidacion) {
		getPresupuestoObrasUsuarioLiquidacion().add(presupuestoObrasUsuarioLiquidacion);
		presupuestoObrasUsuarioLiquidacion.setUsuarioLiquidacion(this);

		return presupuestoObrasUsuarioLiquidacion;
	}

	public PresupuestoObra removePresupuestoObrasUsuarioLiquidacion(PresupuestoObra presupuestoObrasUsuarioLiquidacion) {
		getPresupuestoObrasUsuarioLiquidacion().remove(presupuestoObrasUsuarioLiquidacion);
		presupuestoObrasUsuarioLiquidacion.setUsuarioLiquidacion(null);

		return presupuestoObrasUsuarioLiquidacion;
	}

	public List<ResumenRendicionCajaChica> getResumenRendicionCajaChicasUsuarioImpresion() {
		return this.resumenRendicionCajaChicasUsuarioImpresion;
	}

	public void setResumenRendicionCajaChicasUsuarioImpresion(List<ResumenRendicionCajaChica> resumenRendicionCajaChicasUsuarioImpresion) {
		this.resumenRendicionCajaChicasUsuarioImpresion = resumenRendicionCajaChicasUsuarioImpresion;
	}

	public ResumenRendicionCajaChica addResumenRendicionCajaChicasUsuarioImpresion(ResumenRendicionCajaChica resumenRendicionCajaChicasUsuarioImpresion) {
		getResumenRendicionCajaChicasUsuarioImpresion().add(resumenRendicionCajaChicasUsuarioImpresion);
		resumenRendicionCajaChicasUsuarioImpresion.setUsuarioImpresion(this);

		return resumenRendicionCajaChicasUsuarioImpresion;
	}

	public ResumenRendicionCajaChica removeResumenRendicionCajaChicasUsuarioImpresion(ResumenRendicionCajaChica resumenRendicionCajaChicasUsuarioImpresion) {
		getResumenRendicionCajaChicasUsuarioImpresion().remove(resumenRendicionCajaChicasUsuarioImpresion);
		resumenRendicionCajaChicasUsuarioImpresion.setUsuarioImpresion(null);

		return resumenRendicionCajaChicasUsuarioImpresion;
	}

	public List<ResumenRendicionCajaChica> getResumenRendicionCajaChicasUsuarioRechazo() {
		return resumenRendicionCajaChicasUsuarioRechazo;
	}

	public void setResumenRendicionCajaChicasUsuarioRechazo(List<ResumenRendicionCajaChica> resumenRendicionCajaChicasUsuarioRechazo) {
		this.resumenRendicionCajaChicasUsuarioRechazo = resumenRendicionCajaChicasUsuarioRechazo;
	}

	public List<ResumenRendicionCajaChica> getResumenRendicionCajaChicasUsuarioAprobacion() {
		return resumenRendicionCajaChicasUsuarioAprobacion;
	}

	public void setResumenRendicionCajaChicasUsuarioAprobacion(List<ResumenRendicionCajaChica> resumenRendicionCajaChicasUsuarioAprobacion) {
		this.resumenRendicionCajaChicasUsuarioAprobacion = resumenRendicionCajaChicasUsuarioAprobacion;
	}
}