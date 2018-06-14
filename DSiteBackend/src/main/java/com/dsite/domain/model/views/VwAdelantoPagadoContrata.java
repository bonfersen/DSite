package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VwAdelantoPagadoContrata implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idTGTipoSolicitud;
	private String numeroFactura;
    private BigDecimal importeAdelanto;
    private Date fechaPago;
    private String origen;
    private Integer idContratasObra;
    private Integer idContrata;
    private Integer idObra;
    private String codigoDSite;
    
	public String getIdTGTipoSolicitud() {
		return idTGTipoSolicitud;
	}
	public void setIdTGTipoSolicitud(String idTGTipoSolicitud) {
		this.idTGTipoSolicitud = idTGTipoSolicitud;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public BigDecimal getImporteAdelanto() {
		return importeAdelanto;
	}
	public void setImporteAdelanto(BigDecimal importeAdelanto) {
		this.importeAdelanto = importeAdelanto;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Integer getIdContratasObra() {
		return idContratasObra;
	}
	public void setIdContratasObra(Integer idContratasObra) {
		this.idContratasObra = idContratasObra;
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
	public String getCodigoDSite() {
		return codigoDSite;
	}
	public void setCodigoDSite(String codigoDSite) {
		this.codigoDSite = codigoDSite;
	}
}
