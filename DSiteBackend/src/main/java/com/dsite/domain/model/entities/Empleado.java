package com.dsite.domain.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@Table(name = "empleado")
@NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;

	private String activo;

	private String apellidoMaterno;

	private String apellidoPaterno;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private String nombre;

	private String numeroDocumento;

	private String responsableObra;

	private String usuarioCreacion;

	private String usuarioModificacion;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "empleadoSustentador")
	private List<CajaChicaObra> cajaChicaObrasEmpleadoSustentador;

	// bi-directional many-to-one association to CajaChicaObra
	@OneToMany(mappedBy = "empleadoBeneficiario")
	private List<CajaChicaObra> cajaChicaObrasEmpleadoBeneficiario;

	// bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name = "idCargo")
	private Cargo cargo;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGTipoDocumento")
	private TablaGeneral tablaGeneralTipoDocumento;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	// bi-directional many-to-one association to Obra
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Access(value = AccessType.FIELD)
	private List<Obra> obras;

	// bi-directional many-to-one association to Empleadoareaobra
	@OneToMany(mappedBy = "empleado")
	private List<EmpleadoAreaObra> empleadoAreaObras;

	// bi-directional many-to-one association to ResumenRendicionCajaChica
	@OneToMany(mappedBy = "empleadoSustentador")
	private List<ResumenRendicionCajaChica> resumenRendicionCajaChicas;
	
	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGNivelUsuario")
	private TablaGeneral tablaGeneralNivelUsuario;
	
	// bi-directional many-to-one association to Contrata
	@ManyToOne
	@JoinColumn(name = "idContrata")
	private Contrata contrata;

	public Empleado() {
	}

	public Contrata getContrata() {
		return contrata;
	}

	public void setContrata(Contrata contrata) {
		this.contrata = contrata;
	}

	public TablaGeneral getTablaGeneralNivelUsuario() {
		return tablaGeneralNivelUsuario;
	}

	public void setTablaGeneralNivelUsuario(TablaGeneral tablaGeneralNivelUsuario) {
		this.tablaGeneralNivelUsuario = tablaGeneralNivelUsuario;
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getResponsableObra() {
		return this.responsableObra;
	}

	public void setResponsableObra(String responsableObra) {
		this.responsableObra = responsableObra;
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

	public List<CajaChicaObra> getCajaChicaObrasEmpleadoSustentador() {
		return this.cajaChicaObrasEmpleadoSustentador;
	}

	public void setCajaChicaObrasEmpleadoSustentador(List<CajaChicaObra> cajaChicaObrasEmpleadoSustentador) {
		this.cajaChicaObrasEmpleadoSustentador = cajaChicaObrasEmpleadoSustentador;
	}

	public CajaChicaObra addCajaChicaObrasEmpleadoSustentador(CajaChicaObra cajaChicaObrasEmpleadoSustentador) {
		getCajaChicaObrasEmpleadoSustentador().add(cajaChicaObrasEmpleadoSustentador);
		cajaChicaObrasEmpleadoSustentador.setEmpleadoSustentador(this);

		return cajaChicaObrasEmpleadoSustentador;
	}

	public CajaChicaObra removeCajaChicaObrasEmpleadoSustentador(CajaChicaObra cajaChicaObrasEmpleadoSustentador) {
		getCajaChicaObrasEmpleadoSustentador().remove(cajaChicaObrasEmpleadoSustentador);
		cajaChicaObrasEmpleadoSustentador.setEmpleadoSustentador(null);

		return cajaChicaObrasEmpleadoSustentador;
	}

	public List<CajaChicaObra> getCajaChicaObrasEmpleadoBeneficiario() {
		return this.cajaChicaObrasEmpleadoBeneficiario;
	}

	public void setCajaChicaObrasEmpleadoBeneficiario(List<CajaChicaObra> cajaChicaObrasEmpleadoBeneficiario) {
		this.cajaChicaObrasEmpleadoBeneficiario = cajaChicaObrasEmpleadoBeneficiario;
	}

	public CajaChicaObra addCajaChicaObrasEmpleadoBeneficiario(CajaChicaObra cajaChicaObrasEmpleadoBeneficiario) {
		getCajaChicaObrasEmpleadoBeneficiario().add(cajaChicaObrasEmpleadoBeneficiario);
		cajaChicaObrasEmpleadoBeneficiario.setEmpleadoBeneficiario(this);

		return cajaChicaObrasEmpleadoBeneficiario;
	}

	public CajaChicaObra removeCajaChicaObrasEmpleadoBeneficiario(CajaChicaObra cajaChicaObrasEmpleadoBeneficiario) {
		getCajaChicaObrasEmpleadoBeneficiario().remove(cajaChicaObrasEmpleadoBeneficiario);
		cajaChicaObrasEmpleadoBeneficiario.setEmpleadoBeneficiario(null);

		return cajaChicaObrasEmpleadoBeneficiario;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TablaGeneral getTablaGeneralTipoDocumento() {
		return this.tablaGeneralTipoDocumento;
	}

	public void setTablaGeneralTipoDocumento(TablaGeneral tablaGeneralTipoDocumento) {
		this.tablaGeneralTipoDocumento = tablaGeneralTipoDocumento;
	}

	public List<Obra> getObras() {
		return this.obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

	public Obra addObra(Obra obra) {
		getObras().add(obra);
		obra.setEmpleado(this);

		return obra;
	}

	public Obra removeObra(Obra obra) {
		getObras().remove(obra);
		obra.setEmpleado(null);

		return obra;
	}

	public List<EmpleadoAreaObra> getEmpleadoAreaObras() {
		return empleadoAreaObras;
	}

	public void setEmpleadoAreaObras(List<EmpleadoAreaObra> empleadoAreaObras) {
		this.empleadoAreaObras = empleadoAreaObras;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<ResumenRendicionCajaChica> getResumenRendicionCajaChicas() {
		return this.resumenRendicionCajaChicas;
	}

	public void setResumenRendicionCajaChicas(List<ResumenRendicionCajaChica> resumenRendicionCajaChicas) {
		this.resumenRendicionCajaChicas = resumenRendicionCajaChicas;
	}

	public ResumenRendicionCajaChica addResumenRendicionCajaChica(ResumenRendicionCajaChica resumenRendicionCajaChica) {
		getResumenRendicionCajaChicas().add(resumenRendicionCajaChica);
		resumenRendicionCajaChica.setEmpleadoSustentador(this);

		return resumenRendicionCajaChica;
	}

	public ResumenRendicionCajaChica removeResumenRendicionCajaChica(ResumenRendicionCajaChica resumenRendicionCajaChica) {
		getResumenRendicionCajaChicas().remove(resumenRendicionCajaChica);
		resumenRendicionCajaChica.setEmpleadoSustentador(null);

		return resumenRendicionCajaChica;
	}
}