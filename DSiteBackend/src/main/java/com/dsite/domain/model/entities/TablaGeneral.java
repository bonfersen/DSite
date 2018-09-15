package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tablaGeneral database table.
 * 
 */
@Entity
@Table(name = "tablaGeneral")
@NamedQuery(name = "TablaGeneral.findAll", query = "SELECT t FROM TablaGeneral t")
public class TablaGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idTablaGeneral;

	private String activo;

	private String categoria;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String usuarioCreacion;

	private String usuarioModificacion;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "tablaGeneralNivelUsuario")
	private List<Empleado> empleadosTGNivelUsuario;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "tablaGeneralActas")
	private List<ActasContrata> actasContratas;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "tablaGeneralEstadoActa")
	private List<ActasContrata> actasContratasTGEstadoActa;

	// bi-directional many-to-one association to ActasContrata
	@OneToMany(mappedBy = "tablaGeneralMotivoRechazo")
	private List<ActasContrata> actasContratasTGMotivoRechazo;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "tablaGeneralTipoCaja")
	private List<CajaChicaObra> cajaChicaObrasTGTipoCaja;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "tablaGeneralEstadoCajaChica")
	private List<CajaChicaObra> cajaChicaObrasTGEstadoCajaChica;

	// bi-directional many-to-one association to Cargo
	@OneToMany(mappedBy = "tablaGeneralTipoTrabajador")
	private List<Cargo> cargosTGTipoTrabajador;

	// bi-directional many-to-one association to CierreEconomico
	@OneToMany(mappedBy = "tablaGeneralEstadoCierreEconomico")
	private List<CierreEconomico> cierreEconomicosTGEstadoCierreEconomico;

	// bi-directional many-to-one association to ConcursoContrata
	@OneToMany(mappedBy = "tablaGeneralArea")
	private List<ConcursoContrata> concursoContratasTGArea;

	// bi-directional many-to-one association to Contrata
	@OneToMany(mappedBy = "tablaGeneralCategoria")
	private List<Contrata> contratasTGCategoria;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "tablaGeneralTipoMoneda")
	private List<ContratasObra> contratasObrasTGTipoMoneda;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "tablaGeneralEstadoCierreEconomico")
	private List<ContratasObra> contratasObrasTGEstadoCierreEconomico;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "tablaGeneralEstadoLiquidacion")
	private List<ContratasObra> contratasObrasTGEstadoLiquidacion;

	// bi-directional many-to-one association to DocumentosAdjunto
	@OneToMany(mappedBy = "tablaGeneralNombreTabla")
	private List<DocumentosAdjunto> documentosAdjuntosTGNombreTabla;

	// bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy = "tablaGeneralTipoDocumento")
	private List<Empleado> empleadosTGTipoDocumento;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralArea")
	private List<Obra> obrasTGArea;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralAreaSoporte")
	private List<Obra> obrasTGAreaSoporte;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralProyecto")
	private List<Obra> obrasTGProyecto;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralTipoGasto")
	private List<Obra> obrasTGTipoGasto;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralEstadoObra")
	private List<Obra> obrasTGEstadoObra;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralGerenteProyecto")
	private List<Obra> obrasTGGerenteProyecto;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "tablaGeneralGestorProyecto")
	private List<Obra> obrasTGGestorProyecto;

	// bi-directional many-to-one association to OfertaLiquidacionObra
	@OneToMany(mappedBy = "tablaGeneralTipoEnvio")
	private List<OfertaLiquidacionObra> ofertaLiquidacionObrasTGTipoEnvio;

	// bi-directional many-to-one association to PagosContrata
	@OneToMany(mappedBy = "tablaGeneralTipoSolicitud")
	private List<PagosContrata> pagosContratasTGTipoSolicitud;

	// bi-directional many-to-one association to PagosContrata
	@OneToMany(mappedBy = "tablaGeneralEstadoPagoContrata")
	private List<PagosContrata> pagosContratasTGEstadoPagoContrata;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "tablaGeneralTipoMoneda")
	private List<PresupuestoObra> presupuestoObrasTGTipoMoneda;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "tablaGeneralActaCampo")
	private List<PresupuestoObra> presupuestoObrasTGActaCampo;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "tablaGeneralActaFinal")
	private List<PresupuestoObra> presupuestoObrasTGActaFinal;

	// bi-directional many-to-one association to PresupuestoObra
	@OneToMany(mappedBy = "tablaGeneralEstadoFinanzas")
	private List<PresupuestoObra> presupuestoObrasTGEstadoFinanzas;

	// bi-directional many-to-one association to Rendicion
	@OneToMany(mappedBy = "tablaGeneralTipoRendicion")
	private List<Rendicion> rendicionesTGTipoRendicion;

	// bi-directional many-to-one association to Rendicion
	@OneToMany(mappedBy = "tablaGeneralTipoComprobante")
	private List<Rendicion> rendicionesTGTipoComprobante;

	// bi-directional many-to-one association to Rendicion
	@OneToMany(mappedBy = "tablaGeneralTipoGasto")
	private List<Rendicion> rendicionesTGTipoGasto;

	// bi-directional many-to-one association to ResumenRendicionCajaChica
	@OneToMany(mappedBy = "tablaGeneralEstadoRendicion")
	private List<ResumenRendicionCajaChica> resumenRendicionCajaChicasTGEstadoRendicion;

	@OneToMany(mappedBy = "tablaGeneralEstado")
	private List<ResumenRendicionCajaChica> resumenRendicionCajaChicasTGEstado;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGPadre")
	private TablaGeneral tablaGeneralPadre;

	// bi-directional many-to-one association to TablaGeneral
	@OneToMany(mappedBy = "tablaGeneralPadre")
	private List<TablaGeneral> tablaGeneralTGPadre;

	// bi-directional many-to-one association to TipoDocumentoAdjunto
	@OneToMany(mappedBy = "tablaGeneralGrupo")
	private List<TipoDocumentoAdjunto> tipoDocumentoAdjuntosTGGrupo;

	// bi-directional many-to-one association to TablaGeneral
	@OneToMany(mappedBy = "tablaGeneralRol")
	private List<TablaGeneral> tablaGeneralRol;

	public TablaGeneral() {
	}

	public List<Empleado> getEmpleadosTGNivelUsuario() {
		return empleadosTGNivelUsuario;
	}

	public void setEmpleadosTGNivelUsuario(List<Empleado> empleadosTGNivelUsuario) {
		this.empleadosTGNivelUsuario = empleadosTGNivelUsuario;
	}

	public String getIdTablaGeneral() {
		return this.idTablaGeneral;
	}

	public void setIdTablaGeneral(String idTablaGeneral) {
		this.idTablaGeneral = idTablaGeneral;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		actasContrata.setTablaGeneralActas(this);

		return actasContrata;
	}

	public ActasContrata removeActasContrata(ActasContrata actasContrata) {
		getActasContratas().remove(actasContrata);
		actasContrata.setTablaGeneralActas(null);

		return actasContrata;
	}

	public List<ActasContrata> getActasContratasTGEstadoActa() {
		return this.actasContratasTGEstadoActa;
	}

	public void setActasContratasTGEstadoActa(List<ActasContrata> actasContratasTGEstadoActa) {
		this.actasContratasTGEstadoActa = actasContratasTGEstadoActa;
	}

	public ActasContrata addActasContratasTGEstadoActa(ActasContrata actasContratasTGEstadoActa) {
		getActasContratasTGEstadoActa().add(actasContratasTGEstadoActa);
		actasContratasTGEstadoActa.setTablaGeneralEstadoActa(this);

		return actasContratasTGEstadoActa;
	}

	public ActasContrata removeActasContratasTGEstadoActa(ActasContrata actasContratasTGEstadoActa) {
		getActasContratasTGEstadoActa().remove(actasContratasTGEstadoActa);
		actasContratasTGEstadoActa.setTablaGeneralEstadoActa(null);

		return actasContratasTGEstadoActa;
	}

	public List<ActasContrata> getActasContratasTGMotivoRechazo() {
		return this.actasContratasTGMotivoRechazo;
	}

	public void setActasContratasTGMotivoRechazo(List<ActasContrata> actasContratasTGMotivoRechazo) {
		this.actasContratasTGMotivoRechazo = actasContratasTGMotivoRechazo;
	}

	public ActasContrata addActasContratasTGMotivoRechazo(ActasContrata actasContratasTGMotivoRechazo) {
		getActasContratasTGMotivoRechazo().add(actasContratasTGMotivoRechazo);
		actasContratasTGMotivoRechazo.setTablaGeneralMotivoRechazo(this);

		return actasContratasTGMotivoRechazo;
	}

	public ActasContrata removeActasContratasTGMotivoRechazo(ActasContrata actasContratasTGMotivoRechazo) {
		getActasContratasTGMotivoRechazo().remove(actasContratasTGMotivoRechazo);
		actasContratasTGMotivoRechazo.setTablaGeneralMotivoRechazo(null);

		return actasContratasTGMotivoRechazo;
	}

	public List<CajaChicaObra> getCajaChicaObrasTGTipoCaja() {
		return this.cajaChicaObrasTGTipoCaja;
	}

	public void setCajaChicaObrasTGTipoCaja(List<CajaChicaObra> cajaChicaObrasTGTipoCaja) {
		this.cajaChicaObrasTGTipoCaja = cajaChicaObrasTGTipoCaja;
	}

	public CajaChicaObra addCajaChicaObrasTGTipoCaja(CajaChicaObra cajaChicaObrasTGTipoCaja) {
		getCajaChicaObrasTGTipoCaja().add(cajaChicaObrasTGTipoCaja);
		cajaChicaObrasTGTipoCaja.setTablaGeneralTipoCaja(this);

		return cajaChicaObrasTGTipoCaja;
	}

	public CajaChicaObra removeCajaChicaObrasTGTipoCaja(CajaChicaObra cajaChicaObrasTGTipoCaja) {
		getCajaChicaObrasTGTipoCaja().remove(cajaChicaObrasTGTipoCaja);
		cajaChicaObrasTGTipoCaja.setTablaGeneralTipoCaja(null);

		return cajaChicaObrasTGTipoCaja;
	}

	public List<CajaChicaObra> getCajaChicaObrasTGEstadoCajaChica() {
		return this.cajaChicaObrasTGEstadoCajaChica;
	}

	public void setCajaChicaObrasTGEstadoCajaChica(List<CajaChicaObra> cajaChicaObrasTGEstadoCajaChica) {
		this.cajaChicaObrasTGEstadoCajaChica = cajaChicaObrasTGEstadoCajaChica;
	}

	public CajaChicaObra addCajaChicaObrasTGEstadoCajaChica(CajaChicaObra cajaChicaObrasTGEstadoCajaChica) {
		getCajaChicaObrasTGEstadoCajaChica().add(cajaChicaObrasTGEstadoCajaChica);
		cajaChicaObrasTGEstadoCajaChica.setTablaGeneralEstadoCajaChica(this);

		return cajaChicaObrasTGEstadoCajaChica;
	}

	public CajaChicaObra removeCajaChicaObrasTGEstadoCajaChica(CajaChicaObra cajaChicaObrasTGEstadoCajaChica) {
		getCajaChicaObrasTGEstadoCajaChica().remove(cajaChicaObrasTGEstadoCajaChica);
		cajaChicaObrasTGEstadoCajaChica.setTablaGeneralEstadoCajaChica(null);

		return cajaChicaObrasTGEstadoCajaChica;
	}

	public List<Cargo> getCargosTGTipoTrabajador() {
		return this.cargosTGTipoTrabajador;
	}

	public void setCargosTGTipoTrabajador(List<Cargo> cargosTGTipoTrabajador) {
		this.cargosTGTipoTrabajador = cargosTGTipoTrabajador;
	}

	public Cargo addCargosTGTipoTrabajador(Cargo cargosTGTipoTrabajador) {
		getCargosTGTipoTrabajador().add(cargosTGTipoTrabajador);
		cargosTGTipoTrabajador.setTablaGeneralTipoTrabajador(this);

		return cargosTGTipoTrabajador;
	}

	public Cargo removeCargosTGTipoTrabajador(Cargo cargosTGTipoTrabajador) {
		getCargosTGTipoTrabajador().remove(cargosTGTipoTrabajador);
		cargosTGTipoTrabajador.setTablaGeneralTipoTrabajador(null);

		return cargosTGTipoTrabajador;
	}

	public List<CierreEconomico> getCierreEconomicosTGEstadoCierreEconomico() {
		return this.cierreEconomicosTGEstadoCierreEconomico;
	}

	public void setCierreEconomicosTGEstadoCierreEconomico(List<CierreEconomico> cierreEconomicosTGEstadoCierreEconomico) {
		this.cierreEconomicosTGEstadoCierreEconomico = cierreEconomicosTGEstadoCierreEconomico;
	}

	public CierreEconomico addCierreEconomicosTGEstadoCierreEconomico(CierreEconomico cierreEconomicosTGEstadoCierreEconomico) {
		getCierreEconomicosTGEstadoCierreEconomico().add(cierreEconomicosTGEstadoCierreEconomico);
		cierreEconomicosTGEstadoCierreEconomico.setTablaGeneralEstadoCierreEconomico(this);

		return cierreEconomicosTGEstadoCierreEconomico;
	}

	public CierreEconomico removeCierreEconomicosTGEstadoCierreEconomico(CierreEconomico cierreEconomicosTGEstadoCierreEconomico) {
		getCierreEconomicosTGEstadoCierreEconomico().remove(cierreEconomicosTGEstadoCierreEconomico);
		cierreEconomicosTGEstadoCierreEconomico.setTablaGeneralEstadoCierreEconomico(null);

		return cierreEconomicosTGEstadoCierreEconomico;
	}

	public List<ConcursoContrata> getConcursoContratasTGArea() {
		return this.concursoContratasTGArea;
	}

	public void setConcursoContratasTGArea(List<ConcursoContrata> concursoContratasTGArea) {
		this.concursoContratasTGArea = concursoContratasTGArea;
	}

	public ConcursoContrata addConcursoContratasTGArea(ConcursoContrata concursoContratasTGArea) {
		getConcursoContratasTGArea().add(concursoContratasTGArea);
		concursoContratasTGArea.setTablaGeneralArea(this);

		return concursoContratasTGArea;
	}

	public ConcursoContrata removeConcursoContratasTGArea(ConcursoContrata concursoContratasTGArea) {
		getConcursoContratasTGArea().remove(concursoContratasTGArea);
		concursoContratasTGArea.setTablaGeneralArea(null);

		return concursoContratasTGArea;
	}

	public List<Contrata> getContratasTGCategoria() {
		return this.contratasTGCategoria;
	}

	public void setContratasTGCategoria(List<Contrata> contratasTGCategoria) {
		this.contratasTGCategoria = contratasTGCategoria;
	}

	public Contrata addContratasTGCategoria(Contrata contratasTGCategoria) {
		getContratasTGCategoria().add(contratasTGCategoria);
		contratasTGCategoria.setTablaGeneralCategoria(this);

		return contratasTGCategoria;
	}

	public Contrata removeContratasTGCategoria(Contrata contratasTGCategoria) {
		getContratasTGCategoria().remove(contratasTGCategoria);
		contratasTGCategoria.setTablaGeneralCategoria(null);

		return contratasTGCategoria;
	}

	public List<ContratasObra> getContratasObrasTGTipoMoneda() {
		return this.contratasObrasTGTipoMoneda;
	}

	public void setContratasObrasTGTipoMoneda(List<ContratasObra> contratasObrasTGTipoMoneda) {
		this.contratasObrasTGTipoMoneda = contratasObrasTGTipoMoneda;
	}

	public ContratasObra addContratasObrasTGTipoMoneda(ContratasObra contratasObrasTGTipoMoneda) {
		getContratasObrasTGTipoMoneda().add(contratasObrasTGTipoMoneda);
		contratasObrasTGTipoMoneda.setTablaGeneralTipoMoneda(this);

		return contratasObrasTGTipoMoneda;
	}

	public ContratasObra removeContratasObrasTGTipoMoneda(ContratasObra contratasObrasTGTipoMoneda) {
		getContratasObrasTGTipoMoneda().remove(contratasObrasTGTipoMoneda);
		contratasObrasTGTipoMoneda.setTablaGeneralTipoMoneda(null);

		return contratasObrasTGTipoMoneda;
	}

	public List<ContratasObra> getContratasObrasTGEstadoCierreEconomico() {
		return this.contratasObrasTGEstadoCierreEconomico;
	}

	public void setContratasObrasTGEstadoCierreEconomico(List<ContratasObra> contratasObrasTGEstadoCierreEconomico) {
		this.contratasObrasTGEstadoCierreEconomico = contratasObrasTGEstadoCierreEconomico;
	}

	public ContratasObra addContratasObrasTGEstadoCierreEconomico(ContratasObra contratasObrasTGEstadoCierreEconomico) {
		getContratasObrasTGEstadoCierreEconomico().add(contratasObrasTGEstadoCierreEconomico);
		contratasObrasTGEstadoCierreEconomico.setTablaGeneralEstadoCierreEconomico(this);

		return contratasObrasTGEstadoCierreEconomico;
	}

	public ContratasObra removeContratasObrasTGEstadoCierreEconomico(ContratasObra contratasObrasTGEstadoCierreEconomico) {
		getContratasObrasTGEstadoCierreEconomico().remove(contratasObrasTGEstadoCierreEconomico);
		contratasObrasTGEstadoCierreEconomico.setTablaGeneralEstadoCierreEconomico(null);

		return contratasObrasTGEstadoCierreEconomico;
	}

	public List<ContratasObra> getContratasObrasTGEstadoLiquidacion() {
		return this.contratasObrasTGEstadoLiquidacion;
	}

	public void setContratasObrasTGEstadoLiquidacion(List<ContratasObra> contratasObrasTGEstadoLiquidacion) {
		this.contratasObrasTGEstadoLiquidacion = contratasObrasTGEstadoLiquidacion;
	}

	public ContratasObra addContratasObrasTGEstadoLiquidacion(ContratasObra contratasObrasTGEstadoLiquidacion) {
		getContratasObrasTGEstadoLiquidacion().add(contratasObrasTGEstadoLiquidacion);
		contratasObrasTGEstadoLiquidacion.setTablaGeneralEstadoLiquidacion(this);

		return contratasObrasTGEstadoLiquidacion;
	}

	public ContratasObra removeContratasObrasTGEstadoLiquidacion(ContratasObra contratasObrasTGEstadoLiquidacion) {
		getContratasObrasTGEstadoLiquidacion().remove(contratasObrasTGEstadoLiquidacion);
		contratasObrasTGEstadoLiquidacion.setTablaGeneralEstadoLiquidacion(null);

		return contratasObrasTGEstadoLiquidacion;
	}

	public List<DocumentosAdjunto> getDocumentosAdjuntosTGNombreTabla() {
		return this.documentosAdjuntosTGNombreTabla;
	}

	public void setDocumentosAdjuntosTGNombreTabla(List<DocumentosAdjunto> documentosAdjuntosTGNombreTabla) {
		this.documentosAdjuntosTGNombreTabla = documentosAdjuntosTGNombreTabla;
	}

	public DocumentosAdjunto addDocumentosAdjuntosTGNombreTabla(DocumentosAdjunto documentosAdjuntosTGNombreTabla) {
		getDocumentosAdjuntosTGNombreTabla().add(documentosAdjuntosTGNombreTabla);
		documentosAdjuntosTGNombreTabla.setTablaGeneralNombreTabla(this);

		return documentosAdjuntosTGNombreTabla;
	}

	public DocumentosAdjunto removeDocumentosAdjuntosTGNombreTabla(DocumentosAdjunto documentosAdjuntosTGNombreTabla) {
		getDocumentosAdjuntosTGNombreTabla().remove(documentosAdjuntosTGNombreTabla);
		documentosAdjuntosTGNombreTabla.setTablaGeneralNombreTabla(null);

		return documentosAdjuntosTGNombreTabla;
	}

	public List<Empleado> getEmpleadosTGTipoDocumento() {
		return this.empleadosTGTipoDocumento;
	}

	public void setEmpleadosTGTipoDocumento(List<Empleado> empleadosTGTipoDocumento) {
		this.empleadosTGTipoDocumento = empleadosTGTipoDocumento;
	}

	public Empleado addEmpleadosTGTipoDocumento(Empleado empleadosTGTipoDocumento) {
		getEmpleadosTGTipoDocumento().add(empleadosTGTipoDocumento);
		empleadosTGTipoDocumento.setTablaGeneralTipoDocumento(this);

		return empleadosTGTipoDocumento;
	}

	public Empleado removeEmpleadosTGTipoDocumento(Empleado empleadosTGTipoDocumento) {
		getEmpleadosTGTipoDocumento().remove(empleadosTGTipoDocumento);
		empleadosTGTipoDocumento.setTablaGeneralTipoDocumento(null);

		return empleadosTGTipoDocumento;
	}

	public List<Obra> getObrasTGArea() {
		return this.obrasTGArea;
	}

	public void setObrasTGArea(List<Obra> obrasTGArea) {
		this.obrasTGArea = obrasTGArea;
	}

	public Obra addObrasTGArea(Obra obrasTGArea) {
		getObrasTGArea().add(obrasTGArea);
		obrasTGArea.setTablaGeneralArea(this);

		return obrasTGArea;
	}

	public Obra removeObrasTGArea(Obra obrasTGArea) {
		getObrasTGArea().remove(obrasTGArea);
		obrasTGArea.setTablaGeneralArea(null);

		return obrasTGArea;
	}

	public List<Obra> getObrasTGAreaSoporte() {
		return this.obrasTGAreaSoporte;
	}

	public void setObrasTGAreaSoporte(List<Obra> obrasTGAreaSoporte) {
		this.obrasTGAreaSoporte = obrasTGAreaSoporte;
	}

	public Obra addObrasTGAreaSoporte(Obra obrasTGAreaSoporte) {
		getObrasTGAreaSoporte().add(obrasTGAreaSoporte);
		obrasTGAreaSoporte.setTablaGeneralAreaSoporte(this);

		return obrasTGAreaSoporte;
	}

	public Obra removeObrasTGAreaSoporte(Obra obrasTGAreaSoporte) {
		getObrasTGAreaSoporte().remove(obrasTGAreaSoporte);
		obrasTGAreaSoporte.setTablaGeneralAreaSoporte(null);

		return obrasTGAreaSoporte;
	}

	public List<Obra> getObrasTGProyecto() {
		return this.obrasTGProyecto;
	}

	public void setObrasTGProyecto(List<Obra> obrasTGProyecto) {
		this.obrasTGProyecto = obrasTGProyecto;
	}

	public Obra addObrasTGProyecto(Obra obrasTGProyecto) {
		getObrasTGProyecto().add(obrasTGProyecto);
		obrasTGProyecto.setTablaGeneralProyecto(this);

		return obrasTGProyecto;
	}

	public Obra removeObrasTGProyecto(Obra obrasTGProyecto) {
		getObrasTGProyecto().remove(obrasTGProyecto);
		obrasTGProyecto.setTablaGeneralProyecto(null);

		return obrasTGProyecto;
	}

	public List<Obra> getObrasTGTipoGasto() {
		return this.obrasTGTipoGasto;
	}

	public void setObrasTGTipoGasto(List<Obra> obrasTGTipoGasto) {
		this.obrasTGTipoGasto = obrasTGTipoGasto;
	}

	public Obra addObrasTGTipoGasto(Obra obrasTGTipoGasto) {
		getObrasTGTipoGasto().add(obrasTGTipoGasto);
		obrasTGTipoGasto.setTablaGeneralTipoGasto(this);

		return obrasTGTipoGasto;
	}

	public Obra removeObrasTGTipoGasto(Obra obrasTGTipoGasto) {
		getObrasTGTipoGasto().remove(obrasTGTipoGasto);
		obrasTGTipoGasto.setTablaGeneralTipoGasto(null);

		return obrasTGTipoGasto;
	}

	public List<Obra> getObrasTGEstadoObra() {
		return this.obrasTGEstadoObra;
	}

	public void setObrasTGEstadoObra(List<Obra> obrasTGEstadoObra) {
		this.obrasTGEstadoObra = obrasTGEstadoObra;
	}

	public Obra addObrasTGEstadoObra(Obra obrasTGEstadoObra) {
		getObrasTGEstadoObra().add(obrasTGEstadoObra);
		obrasTGEstadoObra.setTablaGeneralEstadoObra(this);

		return obrasTGEstadoObra;
	}

	public Obra removeObrasTGEstadoObra(Obra obrasTGEstadoObra) {
		getObrasTGEstadoObra().remove(obrasTGEstadoObra);
		obrasTGEstadoObra.setTablaGeneralEstadoObra(null);

		return obrasTGEstadoObra;
	}

	public List<Obra> getObrasTGGerenteProyecto() {
		return this.obrasTGGerenteProyecto;
	}

	public void setObrasTGGerenteProyecto(List<Obra> obrasTGGerenteProyecto) {
		this.obrasTGGerenteProyecto = obrasTGGerenteProyecto;
	}

	public Obra addObrasTGGerenteProyecto(Obra obrasTGGerenteProyecto) {
		getObrasTGGerenteProyecto().add(obrasTGGerenteProyecto);
		obrasTGGerenteProyecto.setTablaGeneralGerenteProyecto(this);

		return obrasTGGerenteProyecto;
	}

	public Obra removeObrasTGGerenteProyecto(Obra obrasTGGerenteProyecto) {
		getObrasTGGerenteProyecto().remove(obrasTGGerenteProyecto);
		obrasTGGerenteProyecto.setTablaGeneralGerenteProyecto(null);

		return obrasTGGerenteProyecto;
	}

	public List<Obra> getObrasTGGestorProyecto() {
		return this.obrasTGGestorProyecto;
	}

	public void setObrasTGGestorProyecto(List<Obra> obrasTGGestorProyecto) {
		this.obrasTGGestorProyecto = obrasTGGestorProyecto;
	}

	public Obra addObrasTGGestorProyecto(Obra obrasTGGestorProyecto) {
		getObrasTGGestorProyecto().add(obrasTGGestorProyecto);
		obrasTGGestorProyecto.setTablaGeneralGestorProyecto(this);

		return obrasTGGestorProyecto;
	}

	public Obra removeObrasTGGestorProyecto(Obra obrasTGGestorProyecto) {
		getObrasTGGestorProyecto().remove(obrasTGGestorProyecto);
		obrasTGGestorProyecto.setTablaGeneralGestorProyecto(null);

		return obrasTGGestorProyecto;
	}

	public List<OfertaLiquidacionObra> getOfertaLiquidacionObrasTGTipoEnvio() {
		return this.ofertaLiquidacionObrasTGTipoEnvio;
	}

	public void setOfertaLiquidacionObrasTGTipoEnvio(List<OfertaLiquidacionObra> ofertaLiquidacionObrasTGTipoEnvio) {
		this.ofertaLiquidacionObrasTGTipoEnvio = ofertaLiquidacionObrasTGTipoEnvio;
	}

	public OfertaLiquidacionObra addOfertaLiquidacionObrasTGTipoEnvio(OfertaLiquidacionObra ofertaLiquidacionObrasTGTipoEnvio) {
		getOfertaLiquidacionObrasTGTipoEnvio().add(ofertaLiquidacionObrasTGTipoEnvio);
		ofertaLiquidacionObrasTGTipoEnvio.setTablaGeneralTipoEnvio(this);

		return ofertaLiquidacionObrasTGTipoEnvio;
	}

	public OfertaLiquidacionObra removeOfertaLiquidacionObrasTGTipoEnvio(OfertaLiquidacionObra ofertaLiquidacionObrasTGTipoEnvio) {
		getOfertaLiquidacionObrasTGTipoEnvio().remove(ofertaLiquidacionObrasTGTipoEnvio);
		ofertaLiquidacionObrasTGTipoEnvio.setTablaGeneralTipoEnvio(null);

		return ofertaLiquidacionObrasTGTipoEnvio;
	}

	public List<PagosContrata> getPagosContratasTGTipoSolicitud() {
		return this.pagosContratasTGTipoSolicitud;
	}

	public void setPagosContratasTGTipoSolicitud(List<PagosContrata> pagosContratasTGTipoSolicitud) {
		this.pagosContratasTGTipoSolicitud = pagosContratasTGTipoSolicitud;
	}

	public PagosContrata addPagosContratasTGTipoSolicitud(PagosContrata pagosContratasTGTipoSolicitud) {
		getPagosContratasTGTipoSolicitud().add(pagosContratasTGTipoSolicitud);
		pagosContratasTGTipoSolicitud.setTablaGeneralTipoSolicitud(this);

		return pagosContratasTGTipoSolicitud;
	}

	public PagosContrata removePagosContratasTGTipoSolicitud(PagosContrata pagosContratasTGTipoSolicitud) {
		getPagosContratasTGTipoSolicitud().remove(pagosContratasTGTipoSolicitud);
		pagosContratasTGTipoSolicitud.setTablaGeneralTipoSolicitud(null);

		return pagosContratasTGTipoSolicitud;
	}

	public List<PagosContrata> getPagosContratasTGEstadoPagoContrata() {
		return this.pagosContratasTGEstadoPagoContrata;
	}

	public void setPagosContratasTGEstadoPagoContrata(List<PagosContrata> pagosContratasTGEstadoPagoContrata) {
		this.pagosContratasTGEstadoPagoContrata = pagosContratasTGEstadoPagoContrata;
	}

	public PagosContrata addPagosContratasTGEstadoPagoContrata(PagosContrata pagosContratasTGEstadoPagoContrata) {
		getPagosContratasTGEstadoPagoContrata().add(pagosContratasTGEstadoPagoContrata);
		pagosContratasTGEstadoPagoContrata.setTablaGeneralEstadoPagoContrata(this);

		return pagosContratasTGEstadoPagoContrata;
	}

	public PagosContrata removePagosContratasTGEstadoPagoContrata(PagosContrata pagosContratasTGEstadoPagoContrata) {
		getPagosContratasTGEstadoPagoContrata().remove(pagosContratasTGEstadoPagoContrata);
		pagosContratasTGEstadoPagoContrata.setTablaGeneralEstadoPagoContrata(null);

		return pagosContratasTGEstadoPagoContrata;
	}

	public List<PresupuestoObra> getPresupuestoObrasTGTipoMoneda() {
		return this.presupuestoObrasTGTipoMoneda;
	}

	public void setPresupuestoObrasTGTipoMoneda(List<PresupuestoObra> presupuestoObrasTGTipoMoneda) {
		this.presupuestoObrasTGTipoMoneda = presupuestoObrasTGTipoMoneda;
	}

	public PresupuestoObra addPresupuestoObrasTGTipoMoneda(PresupuestoObra presupuestoObrasTGTipoMoneda) {
		getPresupuestoObrasTGTipoMoneda().add(presupuestoObrasTGTipoMoneda);
		presupuestoObrasTGTipoMoneda.setTablaGeneralTipoMoneda(this);

		return presupuestoObrasTGTipoMoneda;
	}

	public PresupuestoObra removePresupuestoObrasTGTipoMoneda(PresupuestoObra presupuestoObrasTGTipoMoneda) {
		getPresupuestoObrasTGTipoMoneda().remove(presupuestoObrasTGTipoMoneda);
		presupuestoObrasTGTipoMoneda.setTablaGeneralTipoMoneda(null);

		return presupuestoObrasTGTipoMoneda;
	}

	public List<PresupuestoObra> getPresupuestoObrasTGActaCampo() {
		return this.presupuestoObrasTGActaCampo;
	}

	public void setPresupuestoObrasTGActaCampo(List<PresupuestoObra> presupuestoObrasTGActaCampo) {
		this.presupuestoObrasTGActaCampo = presupuestoObrasTGActaCampo;
	}

	public PresupuestoObra addPresupuestoObrasTGActaCampo(PresupuestoObra presupuestoObrasTGActaCampo) {
		getPresupuestoObrasTGActaCampo().add(presupuestoObrasTGActaCampo);
		presupuestoObrasTGActaCampo.setTablaGeneralActaCampo(this);

		return presupuestoObrasTGActaCampo;
	}

	public PresupuestoObra removePresupuestoObrasTGActaCampo(PresupuestoObra presupuestoObrasTGActaCampo) {
		getPresupuestoObrasTGActaCampo().remove(presupuestoObrasTGActaCampo);
		presupuestoObrasTGActaCampo.setTablaGeneralActaCampo(null);

		return presupuestoObrasTGActaCampo;
	}

	public List<PresupuestoObra> getPresupuestoObrasTGActaFinal() {
		return this.presupuestoObrasTGActaFinal;
	}

	public void setPresupuestoObrasTGActaFinal(List<PresupuestoObra> presupuestoObrasTGActaFinal) {
		this.presupuestoObrasTGActaFinal = presupuestoObrasTGActaFinal;
	}

	public PresupuestoObra addPresupuestoObrasTGActaFinal(PresupuestoObra presupuestoObrasTGActaFinal) {
		getPresupuestoObrasTGActaFinal().add(presupuestoObrasTGActaFinal);
		presupuestoObrasTGActaFinal.setTablaGeneralActaFinal(this);

		return presupuestoObrasTGActaFinal;
	}

	public PresupuestoObra removePresupuestoObrasTGActaFinal(PresupuestoObra presupuestoObrasTGActaFinal) {
		getPresupuestoObrasTGActaFinal().remove(presupuestoObrasTGActaFinal);
		presupuestoObrasTGActaFinal.setTablaGeneralActaFinal(null);

		return presupuestoObrasTGActaFinal;
	}

	public List<PresupuestoObra> getPresupuestoObrasTGEstadoFinanzas() {
		return this.presupuestoObrasTGEstadoFinanzas;
	}

	public void setPresupuestoObrasTGEstadoFinanzas(List<PresupuestoObra> presupuestoObrasTGEstadoFinanzas) {
		this.presupuestoObrasTGEstadoFinanzas = presupuestoObrasTGEstadoFinanzas;
	}

	public PresupuestoObra addPresupuestoObrasTGEstadoFinanza(PresupuestoObra presupuestoObrasTGEstadoFinanza) {
		getPresupuestoObrasTGEstadoFinanzas().add(presupuestoObrasTGEstadoFinanza);
		presupuestoObrasTGEstadoFinanza.setTablaGeneralEstadoFinanzas(this);

		return presupuestoObrasTGEstadoFinanza;
	}

	public PresupuestoObra removePresupuestoObrasTGEstadoFinanza(PresupuestoObra presupuestoObrasTGEstadoFinanza) {
		getPresupuestoObrasTGEstadoFinanzas().remove(presupuestoObrasTGEstadoFinanza);
		presupuestoObrasTGEstadoFinanza.setTablaGeneralEstadoFinanzas(null);

		return presupuestoObrasTGEstadoFinanza;
	}

	public List<Rendicion> getRendicionesTGTipoRendicion() {
		return this.rendicionesTGTipoRendicion;
	}

	public void setRendicionesTGTipoRendicion(List<Rendicion> rendicionesTGTipoRendicion) {
		this.rendicionesTGTipoRendicion = rendicionesTGTipoRendicion;
	}

	public Rendicion addRendicionesTGTipoRendicion(Rendicion rendicionesTGTipoRendicion) {
		getRendicionesTGTipoRendicion().add(rendicionesTGTipoRendicion);
		rendicionesTGTipoRendicion.setTablaGeneralTipoRendicion(this);

		return rendicionesTGTipoRendicion;
	}

	public Rendicion removeRendicionesTGTipoRendicion(Rendicion rendicionesTGTipoRendicion) {
		getRendicionesTGTipoRendicion().remove(rendicionesTGTipoRendicion);
		rendicionesTGTipoRendicion.setTablaGeneralTipoRendicion(null);

		return rendicionesTGTipoRendicion;
	}

	public List<Rendicion> getRendicionesTGTipoComprobante() {
		return this.rendicionesTGTipoComprobante;
	}

	public void setRendicionesTGTipoComprobante(List<Rendicion> rendicionesTGTipoComprobante) {
		this.rendicionesTGTipoComprobante = rendicionesTGTipoComprobante;
	}

	public Rendicion addRendicionesTGTipoComprobante(Rendicion rendicionesTGTipoComprobante) {
		getRendicionesTGTipoComprobante().add(rendicionesTGTipoComprobante);
		rendicionesTGTipoComprobante.setTablaGeneralTipoComprobante(this);

		return rendicionesTGTipoComprobante;
	}

	public Rendicion removeRendicionesTGTipoComprobante(Rendicion rendicionesTGTipoComprobante) {
		getRendicionesTGTipoComprobante().remove(rendicionesTGTipoComprobante);
		rendicionesTGTipoComprobante.setTablaGeneralTipoComprobante(null);

		return rendicionesTGTipoComprobante;
	}

	public List<Rendicion> getRendicionesTGTipoGasto() {
		return this.rendicionesTGTipoGasto;
	}

	public void setRendicionesTGTipoGasto(List<Rendicion> rendicionesTGTipoGasto) {
		this.rendicionesTGTipoGasto = rendicionesTGTipoGasto;
	}

	public Rendicion addRendicionesTGTipoGasto(Rendicion rendicionesTGTipoGasto) {
		getRendicionesTGTipoGasto().add(rendicionesTGTipoGasto);
		rendicionesTGTipoGasto.setTablaGeneralTipoGasto(this);

		return rendicionesTGTipoGasto;
	}

	public Rendicion removeRendicionesTGTipoGasto(Rendicion rendicionesTGTipoGasto) {
		getRendicionesTGTipoGasto().remove(rendicionesTGTipoGasto);
		rendicionesTGTipoGasto.setTablaGeneralTipoGasto(null);

		return rendicionesTGTipoGasto;
	}

	public List<ResumenRendicionCajaChica> getResumenRendicionCajaChicasTGEstadoRendicion() {
		return this.resumenRendicionCajaChicasTGEstadoRendicion;
	}

	public void setResumenRendicionCajaChicasTGEstadoRendicion(List<ResumenRendicionCajaChica> resumenRendicionCajaChicasTGEstadoRendicion) {
		this.resumenRendicionCajaChicasTGEstadoRendicion = resumenRendicionCajaChicasTGEstadoRendicion;
	}

	public ResumenRendicionCajaChica addResumenRendicionCajaChicasTGEstadoRendicion(ResumenRendicionCajaChica resumenRendicionCajaChicasTGEstadoRendicion) {
		getResumenRendicionCajaChicasTGEstadoRendicion().add(resumenRendicionCajaChicasTGEstadoRendicion);
		resumenRendicionCajaChicasTGEstadoRendicion.setTablaGeneralEstadoRendicion(this);

		return resumenRendicionCajaChicasTGEstadoRendicion;
	}

	public ResumenRendicionCajaChica removeResumenRendicionCajaChicasTGEstadoRendicion(ResumenRendicionCajaChica resumenRendicionCajaChicasTGEstadoRendicion) {
		getResumenRendicionCajaChicasTGEstadoRendicion().remove(resumenRendicionCajaChicasTGEstadoRendicion);
		resumenRendicionCajaChicasTGEstadoRendicion.setTablaGeneralEstadoRendicion(null);

		return resumenRendicionCajaChicasTGEstadoRendicion;
	}

	public TablaGeneral getTablaGeneralPadre() {
		return this.tablaGeneralPadre;
	}

	public void setTablaGeneralPadre(TablaGeneral tablaGeneralPadre) {
		this.tablaGeneralPadre = tablaGeneralPadre;
	}

	public List<TablaGeneral> getTablaGeneralTGPadre() {
		return this.tablaGeneralTGPadre;
	}

	public void setTablaGeneralTGPadre(List<TablaGeneral> tablaGeneralTGPadre) {
		this.tablaGeneralTGPadre = tablaGeneralTGPadre;
	}

	public TablaGeneral addTablaGeneralTGPadre(TablaGeneral tablaGeneralTGPadre) {
		getTablaGeneralTGPadre().add(tablaGeneralTGPadre);
		tablaGeneralTGPadre.setTablaGeneralPadre(this);

		return tablaGeneralTGPadre;
	}

	public TablaGeneral removeTablaGeneralTGPadre(TablaGeneral tablaGeneralTGPadre) {
		getTablaGeneralTGPadre().remove(tablaGeneralTGPadre);
		tablaGeneralTGPadre.setTablaGeneralPadre(null);

		return tablaGeneralTGPadre;
	}

	public List<TipoDocumentoAdjunto> getTipoDocumentoAdjuntosTGGrupo() {
		return this.tipoDocumentoAdjuntosTGGrupo;
	}

	public void setTipoDocumentoAdjuntosTGGrupo(List<TipoDocumentoAdjunto> tipoDocumentoAdjuntosTGGrupo) {
		this.tipoDocumentoAdjuntosTGGrupo = tipoDocumentoAdjuntosTGGrupo;
	}

	public TipoDocumentoAdjunto addTipoDocumentoAdjuntosTGGrupo(TipoDocumentoAdjunto tipoDocumentoAdjuntosTGGrupo) {
		getTipoDocumentoAdjuntosTGGrupo().add(tipoDocumentoAdjuntosTGGrupo);
		tipoDocumentoAdjuntosTGGrupo.setTablaGeneralGrupo(this);

		return tipoDocumentoAdjuntosTGGrupo;
	}

	public TipoDocumentoAdjunto removeTipoDocumentoAdjuntosTGGrupo(TipoDocumentoAdjunto tipoDocumentoAdjuntosTGGrupo) {
		getTipoDocumentoAdjuntosTGGrupo().remove(tipoDocumentoAdjuntosTGGrupo);
		tipoDocumentoAdjuntosTGGrupo.setTablaGeneralGrupo(null);

		return tipoDocumentoAdjuntosTGGrupo;
	}

	public List<ResumenRendicionCajaChica> getResumenRendicionCajaChicasTGEstado() {
		return resumenRendicionCajaChicasTGEstado;
	}

	public void setResumenRendicionCajaChicasTGEstado(List<ResumenRendicionCajaChica> resumenRendicionCajaChicasTGEstado) {
		this.resumenRendicionCajaChicasTGEstado = resumenRendicionCajaChicasTGEstado;
	}

	public List<TablaGeneral> getTablaGeneralRol() {
		return tablaGeneralRol;
	}

	public void setTablaGeneralRol(List<TablaGeneral> tablaGeneralRol) {
		this.tablaGeneralRol = tablaGeneralRol;
	}
}