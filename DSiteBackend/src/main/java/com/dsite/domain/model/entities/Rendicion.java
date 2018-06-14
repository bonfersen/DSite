package com.dsite.domain.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the rendicion database table.
 * 
 */
@Entity
@Table(name = "rendicion")
@NamedQuery(name="Rendicion.findAll", query="SELECT r FROM Rendicion r")
public class Rendicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRendicion;

	private String descripcionCajaViatico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaComprobanteCajaViatico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	private BigDecimal importeRendidoCajaViatico;

	private String numeroComprobanteCajaViatico;

	private String usuarioCreacion;

	private String usuarioModificacion;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoRendicion")
	private TablaGeneral tablaGeneralTipoRendicion;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoComprobante")
	private TablaGeneral tablaGeneralTipoComprobante;

	//bi-directional many-to-one association to TablaGeneral
	@ManyToOne
	@JoinColumn(name="idTGTipoGasto")
	private TablaGeneral tablaGeneralTipoGasto;

	//bi-directional many-to-one association to ResumenRendicionCajaChica
	@ManyToOne
	@JoinColumn(name="idResumenRendicionCajaChica")
	private ResumenRendicionCajaChica resumenRendicionCajaChica;

	public Rendicion() {
	}

	public int getIdRendicion() {
		return this.idRendicion;
	}

	public void setIdRendicion(int idRendicion) {
		this.idRendicion = idRendicion;
	}

	public String getDescripcionCajaViatico() {
		return this.descripcionCajaViatico;
	}

	public void setDescripcionCajaViatico(String descripcionCajaViatico) {
		this.descripcionCajaViatico = descripcionCajaViatico;
	}

	public Date getFechaComprobanteCajaViatico() {
		return this.fechaComprobanteCajaViatico;
	}

	public void setFechaComprobanteCajaViatico(Date fechaComprobanteCajaViatico) {
		this.fechaComprobanteCajaViatico = fechaComprobanteCajaViatico;
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

	public BigDecimal getImporteRendidoCajaViatico() {
		return this.importeRendidoCajaViatico;
	}

	public void setImporteRendidoCajaViatico(BigDecimal importeRendidoCajaViatico) {
		this.importeRendidoCajaViatico = importeRendidoCajaViatico;
	}

	public String getNumeroComprobanteCajaViatico() {
		return this.numeroComprobanteCajaViatico;
	}

	public void setNumeroComprobanteCajaViatico(String numeroComprobanteCajaViatico) {
		this.numeroComprobanteCajaViatico = numeroComprobanteCajaViatico;
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

	public TablaGeneral getTablaGeneralTipoRendicion() {
		return this.tablaGeneralTipoRendicion;
	}

	public void setTablaGeneralTipoRendicion(TablaGeneral tablaGeneralTipoRendicion) {
		this.tablaGeneralTipoRendicion = tablaGeneralTipoRendicion;
	}

	public TablaGeneral getTablaGeneralTipoComprobante() {
		return this.tablaGeneralTipoComprobante;
	}

	public void setTablaGeneralTipoComprobante(TablaGeneral tablaGeneralTipoComprobante) {
		this.tablaGeneralTipoComprobante = tablaGeneralTipoComprobante;
	}

	public TablaGeneral getTablaGeneralTipoGasto() {
		return this.tablaGeneralTipoGasto;
	}

	public void setTablaGeneralTipoGasto(TablaGeneral tablaGeneralTipoGasto) {
		this.tablaGeneralTipoGasto = tablaGeneralTipoGasto;
	}

	public ResumenRendicionCajaChica getResumenRendicionCajaChica() {
		return this.resumenRendicionCajaChica;
	}

	public void setResumenRendicionCajaChica(ResumenRendicionCajaChica resumenRendicionCajaChica) {
		this.resumenRendicionCajaChica = resumenRendicionCajaChica;
	}

}