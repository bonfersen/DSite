package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ContratasObraDTO {

	private Integer idContratasObra;

	private String comentarioCierreEconomico;

	private String comentarioDescuentoOperativo;

	private String comentarioImporteAdicional;

	private Date fechaCECompletado;

	private Date fechaCEParcial;

	private Date fechaCEPendiente;

	private Date fechaCreacion;

	private Date fechaModificacion;

	private BigDecimal importeAdicional;

	private BigDecimal importeDescuentoOperativo;

	private BigDecimal importeFinal;

	private BigDecimal importeLiquidadacionObra;

	private BigDecimal importePendientePago;

	private BigDecimal importePresupuestoObra;

	private BigDecimal importeTipoCambio;

	private BigDecimal importeTotalAdelanto;
	
	private BigDecimal importeTotalPagado;

	private BigDecimal porcentajeActasAprobadas;

	private String tipoTrabajo;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<ActasContrataDTO> actasContratasDTO;

	private Integer idContrata;

	private Integer idObra;

	private String idTGTipoMoneda;

	private String idTGEstadoCierreEconomico;

	private String idTGEstadoLiquidacion;

	private Integer idUsuarioCEPendiente;

	private Integer idUsuarioCEParcial;

	private Integer idUsuarioCECompletado;
	
	private String idTGAreaObra;
	
	private List<PagosContrataDTO> pagosContratasDTO;

	public Integer getIdContratasObra() {
		return idContratasObra;
	}

	public void setIdContratasObra(Integer idContratasObra) {
		this.idContratasObra = idContratasObra;
	}

	public String getComentarioCierreEconomico() {
		return comentarioCierreEconomico;
	}

	public void setComentarioCierreEconomico(String comentarioCierreEconomico) {
		this.comentarioCierreEconomico = comentarioCierreEconomico;
	}

	public String getComentarioDescuentoOperativo() {
		return comentarioDescuentoOperativo;
	}

	public void setComentarioDescuentoOperativo(String comentarioDescuentoOperativo) {
		this.comentarioDescuentoOperativo = comentarioDescuentoOperativo;
	}

	public String getComentarioImporteAdicional() {
		return comentarioImporteAdicional;
	}

	public void setComentarioImporteAdicional(String comentarioImporteAdicional) {
		this.comentarioImporteAdicional = comentarioImporteAdicional;
	}

	public Date getFechaCECompletado() {
		return fechaCECompletado;
	}

	public void setFechaCECompletado(Date fechaCECompletado) {
		this.fechaCECompletado = fechaCECompletado;
	}

	public Date getFechaCEParcial() {
		return fechaCEParcial;
	}

	public void setFechaCEParcial(Date fechaCEParcial) {
		this.fechaCEParcial = fechaCEParcial;
	}

	public Date getFechaCEPendiente() {
		return fechaCEPendiente;
	}

	public void setFechaCEPendiente(Date fechaCEPendiente) {
		this.fechaCEPendiente = fechaCEPendiente;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigDecimal getImporteAdicional() {
		return importeAdicional;
	}

	public void setImporteAdicional(BigDecimal importeAdicional) {
		this.importeAdicional = importeAdicional;
	}

	public BigDecimal getImporteDescuentoOperativo() {
		return importeDescuentoOperativo;
	}

	public void setImporteDescuentoOperativo(BigDecimal importeDescuentoOperativo) {
		this.importeDescuentoOperativo = importeDescuentoOperativo;
	}

	public BigDecimal getImporteFinal() {
		return importeFinal;
	}

	public void setImporteFinal(BigDecimal importeFinal) {
		this.importeFinal = importeFinal;
	}

	public BigDecimal getImporteLiquidadacionObra() {
		return importeLiquidadacionObra;
	}

	public void setImporteLiquidadacionObra(BigDecimal importeLiquidadacionObra) {
		this.importeLiquidadacionObra = importeLiquidadacionObra;
	}

	public BigDecimal getImportePendientePago() {
		return importePendientePago;
	}

	public void setImportePendientePago(BigDecimal importePendientePago) {
		this.importePendientePago = importePendientePago;
	}

	public BigDecimal getImportePresupuestoObra() {
		return importePresupuestoObra;
	}

	public void setImportePresupuestoObra(BigDecimal importePresupuestoObra) {
		this.importePresupuestoObra = importePresupuestoObra;
	}

	public BigDecimal getImporteTipoCambio() {
		return importeTipoCambio;
	}

	public void setImporteTipoCambio(BigDecimal importeTipoCambio) {
		this.importeTipoCambio = importeTipoCambio;
	}

	public BigDecimal getImporteTotalAdelanto() {
		return importeTotalAdelanto;
	}

	public void setImporteTotalAdelanto(BigDecimal importeTotalAdelanto) {
		this.importeTotalAdelanto = importeTotalAdelanto;
	}

	public BigDecimal getImporteTotalPagado() {
		return importeTotalPagado;
	}

	public void setImporteTotalPagado(BigDecimal importeTotalPagado) {
		this.importeTotalPagado = importeTotalPagado;
	}

	public BigDecimal getPorcentajeActasAprobadas() {
		return porcentajeActasAprobadas;
	}

	public void setPorcentajeActasAprobadas(BigDecimal porcentajeActasAprobadas) {
		this.porcentajeActasAprobadas = porcentajeActasAprobadas;
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

	public List<ActasContrataDTO> getActasContratasDTO() {
		return actasContratasDTO;
	}

	public void setActasContratasDTO(List<ActasContrataDTO> actasContratasDTO) {
		this.actasContratasDTO = actasContratasDTO;
	}

	public Integer getIdContrata() {
		return idContrata;
	}

	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
	}

	public Integer getIdObra() {
		return idObra;
	}

	public void setIdObra(Integer idObra) {
		this.idObra = idObra;
	}

	public String getIdTGTipoMoneda() {
		return idTGTipoMoneda;
	}

	public void setIdTGTipoMoneda(String idTGTipoMoneda) {
		this.idTGTipoMoneda = idTGTipoMoneda;
	}

	public String getIdTGEstadoCierreEconomico() {
		return idTGEstadoCierreEconomico;
	}

	public void setIdTGEstadoCierreEconomico(String idTGEstadoCierreEconomico) {
		this.idTGEstadoCierreEconomico = idTGEstadoCierreEconomico;
	}

	public String getIdTGEstadoLiquidacion() {
		return idTGEstadoLiquidacion;
	}

	public void setIdTGEstadoLiquidacion(String idTGEstadoLiquidacion) {
		this.idTGEstadoLiquidacion = idTGEstadoLiquidacion;
	}

	public Integer getIdUsuarioCEPendiente() {
		return idUsuarioCEPendiente;
	}

	public void setIdUsuarioCEPendiente(Integer idUsuarioCEPendiente) {
		this.idUsuarioCEPendiente = idUsuarioCEPendiente;
	}

	public Integer getIdUsuarioCEParcial() {
		return idUsuarioCEParcial;
	}

	public void setIdUsuarioCEParcial(Integer idUsuarioCEParcial) {
		this.idUsuarioCEParcial = idUsuarioCEParcial;
	}

	public Integer getIdUsuarioCECompletado() {
		return idUsuarioCECompletado;
	}

	public void setIdUsuarioCECompletado(Integer idUsuarioCECompletado) {
		this.idUsuarioCECompletado = idUsuarioCECompletado;
	}

	public List<PagosContrataDTO> getPagosContratasDTO() {
		return pagosContratasDTO;
	}

	public void setPagosContratasDTO(List<PagosContrataDTO> pagosContratasDTO) {
		this.pagosContratasDTO = pagosContratasDTO;
	}

	public String getIdTGAreaObra() {
		return idTGAreaObra;
	}

	public void setIdTGAreaObra(String idTGAreaObra) {
		this.idTGAreaObra = idTGAreaObra;
	}
}
