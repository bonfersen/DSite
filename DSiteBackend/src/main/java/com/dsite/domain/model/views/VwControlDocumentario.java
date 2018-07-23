package com.dsite.domain.model.views;

import java.io.Serializable;
import java.math.BigDecimal;

public class VwControlDocumentario implements Serializable {

	private static final long serialVersionUID = 1486351203186139955L;
	private Integer idObra;
	private String codigoDSite;
	private String area;
	private String contrata;
	private String tipoTrabajo;
	private BigDecimal porcentajeActasAprobadas;
	private String nombreReal;
	private Integer cierre;
	private String comentarioCierreEconomico;
	private String codigoCierre;
	private String estadoActaCampo;
	private String estadoActaFinal;
	private String estadoRptFoto;
	private String estadoSga;
	private Integer idActaCampo;
	private Integer idActaFinal;
	private Integer idRptFoto;
	private Integer idSga;
	private String idMotivoRechazoActaCampo;
	private String idMotivoRechazoActaFinal;
	private String idMotivoRechazoRptFoto;
	private String idMotivoRechazoSga;
	private String idTGEstadoCierreEconomico;
	private String estadoCierreEconomico;
	private Integer idContratasObra;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContrata() {
		return contrata;
	}

	public void setContrata(String contrata) {
		this.contrata = contrata;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public BigDecimal getPorcentajeActasAprobadas() {
		return porcentajeActasAprobadas;
	}

	public void setPorcentajeActasAprobadas(BigDecimal porcentajeActasAprobadas) {
		this.porcentajeActasAprobadas = porcentajeActasAprobadas;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public String getComentarioCierreEconomico() {
		return comentarioCierreEconomico;
	}

	public void setComentarioCierreEconomico(String comentarioCierreEconomico) {
		this.comentarioCierreEconomico = comentarioCierreEconomico;
	}

	public String getCodigoCierre() {
		return codigoCierre;
	}

	public void setCodigoCierre(String codigoCierre) {
		this.codigoCierre = codigoCierre;
	}

	public String getEstadoActaCampo() {
		return estadoActaCampo;
	}

	public void setEstadoActaCampo(String estadoActaCampo) {
		this.estadoActaCampo = estadoActaCampo;
	}

	public String getEstadoActaFinal() {
		return estadoActaFinal;
	}

	public void setEstadoActaFinal(String estadoActaFinal) {
		this.estadoActaFinal = estadoActaFinal;
	}

	public String getEstadoRptFoto() {
		return estadoRptFoto;
	}

	public void setEstadoRptFoto(String estadoRptFoto) {
		this.estadoRptFoto = estadoRptFoto;
	}

	public String getEstadoSga() {
		return estadoSga;
	}

	public void setEstadoSga(String estadoSga) {
		this.estadoSga = estadoSga;
	}

	public Integer getIdActaCampo() {
		return idActaCampo;
	}

	public void setIdActaCampo(Integer idActaCampo) {
		this.idActaCampo = idActaCampo;
	}

	public Integer getIdActaFinal() {
		return idActaFinal;
	}

	public void setIdActaFinal(Integer idActaFinal) {
		this.idActaFinal = idActaFinal;
	}

	public Integer getIdRptFoto() {
		return idRptFoto;
	}

	public void setIdRptFoto(Integer idRptFoto) {
		this.idRptFoto = idRptFoto;
	}

	public Integer getIdSga() {
		return idSga;
	}

	public void setIdSga(Integer idSga) {
		this.idSga = idSga;
	}

	public String getIdMotivoRechazoActaCampo() {
		return idMotivoRechazoActaCampo;
	}

	public void setIdMotivoRechazoActaCampo(String idMotivoRechazoActaCampo) {
		this.idMotivoRechazoActaCampo = idMotivoRechazoActaCampo;
	}

	public String getIdMotivoRechazoActaFinal() {
		return idMotivoRechazoActaFinal;
	}

	public void setIdMotivoRechazoActaFinal(String idMotivoRechazoActaFinal) {
		this.idMotivoRechazoActaFinal = idMotivoRechazoActaFinal;
	}

	public String getIdMotivoRechazoRptFoto() {
		return idMotivoRechazoRptFoto;
	}

	public void setIdMotivoRechazoRptFoto(String idMotivoRechazoRptFoto) {
		this.idMotivoRechazoRptFoto = idMotivoRechazoRptFoto;
	}

	public String getIdMotivoRechazoSga() {
		return idMotivoRechazoSga;
	}

	public void setIdMotivoRechazoSga(String idMotivoRechazoSga) {
		this.idMotivoRechazoSga = idMotivoRechazoSga;
	}

	public Integer getCierre() {
		return cierre;
	}

	public void setCierre(Integer cierre) {
		this.cierre = cierre;
	}

	public String getIdTGEstadoCierreEconomico() {
		return idTGEstadoCierreEconomico;
	}

	public void setIdTGEstadoCierreEconomico(String idTGEstadoCierreEconomico) {
		this.idTGEstadoCierreEconomico = idTGEstadoCierreEconomico;
	}

	public String getEstadoCierreEconomico() {
		return estadoCierreEconomico;
	}

	public void setEstadoCierreEconomico(String estadoCierreEconomico) {
		this.estadoCierreEconomico = estadoCierreEconomico;
	}

	public Integer getIdContratasObra() {
		return idContratasObra;
	}

	public void setIdContratasObra(Integer idContratasObra) {
		this.idContratasObra = idContratasObra;
	}
}
