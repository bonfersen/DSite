package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ObraDTO {

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

	private Date fechaAnulacion;

	private Date fechaCierreObra;

	// No aplica serializacion
	private Date fechaCreacion;

	private Date fechaEnEjecucion;

	private Date fechaFinalizacion;

	private Date fechaFinalizacionObra;

	private Date fechaInicioObra;

	private Date fechaModificacion;

	private Date fechaParalizacion;

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

	private List<CajaChicaObraDTO> cajaChicaObras;

	private List<CierreEconomicoObraDTO> cierreEconomicoObras;

	private List<ContratasObraDTO> contratasObras;

	private String idDistrito;

	private int idEmpleadoResponsableObra;

	private String idTGArea;

	private String idTGAreaSoporte;

	private String idTGProyecto;

	private String idTGTipoGasto;

	private String idTGEstadoObra;

	private String idTGGerenteProyecto;

	private String idTGGestorProyecto;

	private int idUsuarioCierreObra;

	private int idUsuarioEnEjecucion;

	private int idUsuarioAnulacion;

	private int idUsuarioParalizacion;

	private int idUsuarioReactivacion;

	private int idUsuarioFinalizacion;

	private List<PresupuestoObraDTO> presupuestoObras;
	
	private BigDecimal importeTotalPresupuestadoContrata;
	
	private BigDecimal importeTotalPagosContrata;

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public int getCantidadContratasAsignadas() {
		return cantidadContratasAsignadas;
	}

	public void setCantidadContratasAsignadas(int cantidadContratasAsignadas) {
		this.cantidadContratasAsignadas = cantidadContratasAsignadas;
	}

	public String getCetificado() {
		return cetificado;
	}

	public void setCetificado(String cetificado) {
		this.cetificado = cetificado;
	}

	public String getCetificadoComplementaria() {
		return cetificadoComplementaria;
	}

	public void setCetificadoComplementaria(String cetificadoComplementaria) {
		this.cetificadoComplementaria = cetificadoComplementaria;
	}

	public String getCodigoCellusat() {
		return codigoCellusat;
	}

	public void setCodigoCellusat(String codigoCellusat) {
		this.codigoCellusat = codigoCellusat;
	}

	public String getCodigoDSite() {
		return codigoDSite;
	}

	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public BigDecimal getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(BigDecimal coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public BigDecimal getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(BigDecimal coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEbc() {
		return ebc;
	}

	public void setEbc(String ebc) {
		this.ebc = ebc;
	}

	public String getFacturaDSite() {
		return facturaDSite;
	}

	public void setFacturaDSite(String facturaDSite) {
		this.facturaDSite = facturaDSite;
	}

	public String getFacturaDSiteComplementaria() {
		return facturaDSiteComplementaria;
	}

	public void setFacturaDSiteComplementaria(String facturaDSiteComplementaria) {
		this.facturaDSiteComplementaria = facturaDSiteComplementaria;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

	public Date getFechaCierreObra() {
		return fechaCierreObra;
	}

	public void setFechaCierreObra(Date fechaCierreObra) {
		this.fechaCierreObra = fechaCierreObra;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEnEjecucion() {
		return fechaEnEjecucion;
	}

	public void setFechaEnEjecucion(Date fechaEnEjecucion) {
		this.fechaEnEjecucion = fechaEnEjecucion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Date getFechaFinalizacionObra() {
		return fechaFinalizacionObra;
	}

	public void setFechaFinalizacionObra(Date fechaFinalizacionObra) {
		this.fechaFinalizacionObra = fechaFinalizacionObra;
	}

	public Date getFechaInicioObra() {
		return fechaInicioObra;
	}

	public void setFechaInicioObra(Date fechaInicioObra) {
		this.fechaInicioObra = fechaInicioObra;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaParalizacion() {
		return fechaParalizacion;
	}

	public void setFechaParalizacion(Date fechaParalizacion) {
		this.fechaParalizacion = fechaParalizacion;
	}

	public Date getFechaReactivacion() {
		return fechaReactivacion;
	}

	public void setFechaReactivacion(Date fechaReactivacion) {
		this.fechaReactivacion = fechaReactivacion;
	}

	public BigDecimal getImporteOrdenCompra() {
		return importeOrdenCompra;
	}

	public void setImporteOrdenCompra(BigDecimal importeOrdenCompra) {
		this.importeOrdenCompra = importeOrdenCompra;
	}

	public BigDecimal getImporteOrdenCompraComplementaria() {
		return importeOrdenCompraComplementaria;
	}

	public void setImporteOrdenCompraComplementaria(BigDecimal importeOrdenCompraComplementaria) {
		this.importeOrdenCompraComplementaria = importeOrdenCompraComplementaria;
	}

	public BigDecimal getImporteTotalContratas() {
		return importeTotalContratas;
	}

	public void setImporteTotalContratas(BigDecimal importeTotalContratas) {
		this.importeTotalContratas = importeTotalContratas;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getNotaCredito() {
		return notaCredito;
	}

	public void setNotaCredito(String notaCredito) {
		this.notaCredito = notaCredito;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public String getNumeroOrdenCompraComplementaria() {
		return numeroOrdenCompraComplementaria;
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
		return porcentajeRentabilidad;
	}

	public void setPorcentajeRentabilidad(BigDecimal porcentajeRentabilidad) {
		this.porcentajeRentabilidad = porcentajeRentabilidad;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<CajaChicaObraDTO> getCajaChicaObras() {
		return cajaChicaObras;
	}

	public void setCajaChicaObras(List<CajaChicaObraDTO> cajaChicaObras) {
		this.cajaChicaObras = cajaChicaObras;
	}

	public List<CierreEconomicoObraDTO> getCierreEconomicoObras() {
		return cierreEconomicoObras;
	}

	public void setCierreEconomicoObras(List<CierreEconomicoObraDTO> cierreEconomicoObras) {
		this.cierreEconomicoObras = cierreEconomicoObras;
	}

	public List<ContratasObraDTO> getContratasObras() {
		return contratasObras;
	}

	public void setContratasObras(List<ContratasObraDTO> contratasObras) {
		this.contratasObras = contratasObras;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	public int getIdEmpleadoResponsableObra() {
		return idEmpleadoResponsableObra;
	}

	public void setIdEmpleadoResponsableObra(int idEmpleadoResponsableObra) {
		this.idEmpleadoResponsableObra = idEmpleadoResponsableObra;
	}

	public String getIdTGArea() {
		return idTGArea;
	}

	public void setIdTGArea(String idTGArea) {
		this.idTGArea = idTGArea;
	}

	public String getIdTGAreaSoporte() {
		return idTGAreaSoporte;
	}

	public void setIdTGAreaSoporte(String idTGAreaSoporte) {
		this.idTGAreaSoporte = idTGAreaSoporte;
	}

	public String getIdTGProyecto() {
		return idTGProyecto;
	}

	public void setIdTGProyecto(String idTGProyecto) {
		this.idTGProyecto = idTGProyecto;
	}

	public String getIdTGTipoGasto() {
		return idTGTipoGasto;
	}

	public void setIdTGTipoGasto(String idTGTipoGasto) {
		this.idTGTipoGasto = idTGTipoGasto;
	}

	public String getIdTGEstadoObra() {
		return idTGEstadoObra;
	}

	public void setIdTGEstadoObra(String idTGEstadoObra) {
		this.idTGEstadoObra = idTGEstadoObra;
	}

	public String getIdTGGerenteProyecto() {
		return idTGGerenteProyecto;
	}

	public void setIdTGGerenteProyecto(String idTGGerenteProyecto) {
		this.idTGGerenteProyecto = idTGGerenteProyecto;
	}

	public String getIdTGGestorProyecto() {
		return idTGGestorProyecto;
	}

	public void setIdTGGestorProyecto(String idTGGestorProyecto) {
		this.idTGGestorProyecto = idTGGestorProyecto;
	}

	public int getIdUsuarioCierreObra() {
		return idUsuarioCierreObra;
	}

	public void setIdUsuarioCierreObra(int idUsuarioCierreObra) {
		this.idUsuarioCierreObra = idUsuarioCierreObra;
	}

	public int getIdUsuarioEnEjecucion() {
		return idUsuarioEnEjecucion;
	}

	public void setIdUsuarioEnEjecucion(int idUsuarioEnEjecucion) {
		this.idUsuarioEnEjecucion = idUsuarioEnEjecucion;
	}

	public int getIdUsuarioAnulacion() {
		return idUsuarioAnulacion;
	}

	public void setIdUsuarioAnulacion(int idUsuarioAnulacion) {
		this.idUsuarioAnulacion = idUsuarioAnulacion;
	}

	public int getIdUsuarioParalizacion() {
		return idUsuarioParalizacion;
	}

	public void setIdUsuarioParalizacion(int idUsuarioParalizacion) {
		this.idUsuarioParalizacion = idUsuarioParalizacion;
	}

	public int getIdUsuarioReactivacion() {
		return idUsuarioReactivacion;
	}

	public void setIdUsuarioReactivacion(int idUsuarioReactivacion) {
		this.idUsuarioReactivacion = idUsuarioReactivacion;
	}

	public int getIdUsuarioFinalizacion() {
		return idUsuarioFinalizacion;
	}

	public void setIdUsuarioFinalizacion(int idUsuarioFinalizacion) {
		this.idUsuarioFinalizacion = idUsuarioFinalizacion;
	}

	public List<PresupuestoObraDTO> getPresupuestoObras() {
		return presupuestoObras;
	}

	public void setPresupuestoObras(List<PresupuestoObraDTO> presupuestoObras) {
		this.presupuestoObras = presupuestoObras;
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
