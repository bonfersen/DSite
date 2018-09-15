package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the contrata database table.
 * 
 */
@Entity
@Table(name = "contrata")
@NamedQuery(name = "Contrata.findAll", query = "SELECT c FROM Contrata c")
public class Contrata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrata;

	private String activo;

	private String contacto;

	private String correo;

	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private BigDecimal importeTotalPendientePago;

	private String nombreCorto;

	private String razonSocial;

	private String ruc;

	private String telefono;

	private String usuarioCreacion;

	private String usuarioModificacion;

	// bi-directional many-to-one association to ConcursoContrata
	@OneToMany(mappedBy = "contrata")
	private List<ConcursoContrata> concursoContratas;

	// bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name = "idTGCategoria")
	private TablaGeneral tablaGeneralCategoria;

	// bi-directional many-to-one association to ContratasObra
	@OneToMany(mappedBy = "contrata")
	private List<ContratasObra> contratasObras;

	// bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy = "contrata")
	private List<Empleado> empleados;

	public Contrata() {
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public int getIdContrata() {
		return this.idContrata;
	}

	public void setIdContrata(int idContrata) {
		this.idContrata = idContrata;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public BigDecimal getImporteTotalPendientePago() {
		return this.importeTotalPendientePago;
	}

	public void setImporteTotalPendientePago(BigDecimal importeTotalPendientePago) {
		this.importeTotalPendientePago = importeTotalPendientePago;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public List<ConcursoContrata> getConcursoContratas() {
		return this.concursoContratas;
	}

	public void setConcursoContratas(List<ConcursoContrata> concursoContratas) {
		this.concursoContratas = concursoContratas;
	}

	public ConcursoContrata addConcursoContrata(ConcursoContrata concursoContrata) {
		getConcursoContratas().add(concursoContrata);
		concursoContrata.setContrata(this);

		return concursoContrata;
	}

	public ConcursoContrata removeConcursoContrata(ConcursoContrata concursoContrata) {
		getConcursoContratas().remove(concursoContrata);
		concursoContrata.setContrata(null);

		return concursoContrata;
	}

	public TablaGeneral getTablaGeneralCategoria() {
		return this.tablaGeneralCategoria;
	}

	public void setTablaGeneralCategoria(TablaGeneral tablaGeneralCategoria) {
		this.tablaGeneralCategoria = tablaGeneralCategoria;
	}

	public List<ContratasObra> getContratasObras() {
		return this.contratasObras;
	}

	public void setContratasObras(List<ContratasObra> contratasObras) {
		this.contratasObras = contratasObras;
	}

	public ContratasObra addContratasObra(ContratasObra contratasObra) {
		getContratasObras().add(contratasObra);
		contratasObra.setContrata(this);

		return contratasObra;
	}

	public ContratasObra removeContratasObra(ContratasObra contratasObra) {
		getContratasObras().remove(contratasObra);
		contratasObra.setContrata(null);

		return contratasObra;
	}

}