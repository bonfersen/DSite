package com.dsite.dto.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PresupuestoObraDTO {

	private int idPresupuestoObra;

	private Date fechaCreacion;

	private Date fechaEnvioActaCampo;

	private Date fechaEnvioActaFinal;

	private Date fechaEnvioPresupuestoLiquidacion;

	private Date fechaEnvioPresupuestoOferta;

	private Date fechaLiquidacion;

	private Date fechaModificacion;

	private Date fechaOfertado;

	private BigDecimal importePresupuestoLiquidacion;

	private BigDecimal importePresupuestoOferta;

	private String observacionFinanzas;

	private String usuarioCreacion;

	private String usuarioModificacion;

	private List<OfertaLiquidacionObraDTO> ofertaLiquidacionObrasDTO;

	private int idObra;

	private String idTGTipoMoneda;

	private String idTGActaCampo;

	private String idTGActaFinal;

	private String idTGEstadoFinanzas;

	private int idUsuarioEnvioPresupuestoOferta;

	private int idUsuarioEnvioPresupuestoLiquidacion;

	private int idUsuarioEnvioActaCampo;

	private int idUsuarioEnvioActaFinal;

	private int idUsuarioOfertado;

	private int idUsuarioLiquidacion;

	public int getIdPresupuestoObra() {
		return idPresupuestoObra;
	}

	public void setIdPresupuestoObra(int idPresupuestoObra) {
		this.idPresupuestoObra = idPresupuestoObra;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEnvioActaCampo() {
		return fechaEnvioActaCampo;
	}

	public void setFechaEnvioActaCampo(Date fechaEnvioActaCampo) {
		this.fechaEnvioActaCampo = fechaEnvioActaCampo;
	}

	public Date getFechaEnvioActaFinal() {
		return fechaEnvioActaFinal;
	}

	public void setFechaEnvioActaFinal(Date fechaEnvioActaFinal) {
		this.fechaEnvioActaFinal = fechaEnvioActaFinal;
	}

	public Date getFechaEnvioPresupuestoLiquidacion() {
		return fechaEnvioPresupuestoLiquidacion;
	}

	public void setFechaEnvioPresupuestoLiquidacion(Date fechaEnvioPresupuestoLiquidacion) {
		this.fechaEnvioPresupuestoLiquidacion = fechaEnvioPresupuestoLiquidacion;
	}

	public Date getFechaEnvioPresupuestoOferta() {
		return fechaEnvioPresupuestoOferta;
	}

	public void setFechaEnvioPresupuestoOferta(Date fechaEnvioPresupuestoOferta) {
		this.fechaEnvioPresupuestoOferta = fechaEnvioPresupuestoOferta;
	}

	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaOfertado() {
		return fechaOfertado;
	}

	public void setFechaOfertado(Date fechaOfertado) {
		this.fechaOfertado = fechaOfertado;
	}

	public BigDecimal getImportePresupuestoLiquidacion() {
		return importePresupuestoLiquidacion;
	}

	public void setImportePresupuestoLiquidacion(BigDecimal importePresupuestoLiquidacion) {
		this.importePresupuestoLiquidacion = importePresupuestoLiquidacion;
	}

	public BigDecimal getImportePresupuestoOferta() {
		return importePresupuestoOferta;
	}

	public void setImportePresupuestoOferta(BigDecimal importePresupuestoOferta) {
		this.importePresupuestoOferta = importePresupuestoOferta;
	}

	public String getObservacionFinanzas() {
		return observacionFinanzas;
	}

	public void setObservacionFinanzas(String observacionFinanzas) {
		this.observacionFinanzas = observacionFinanzas;
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

	public int getIdObra() {
		return idObra;
	}

	public void setIdObra(int idObra) {
		this.idObra = idObra;
	}

	public String getIdTGTipoMoneda() {
		return idTGTipoMoneda;
	}

	public void setIdTGTipoMoneda(String idTGTipoMoneda) {
		this.idTGTipoMoneda = idTGTipoMoneda;
	}

	public String getIdTGActaCampo() {
		return idTGActaCampo;
	}

	public void setIdTGActaCampo(String idTGActaCampo) {
		this.idTGActaCampo = idTGActaCampo;
	}

	public String getIdTGActaFinal() {
		return idTGActaFinal;
	}

	public void setIdTGActaFinal(String idTGActaFinal) {
		this.idTGActaFinal = idTGActaFinal;
	}

	public String getIdTGEstadoFinanzas() {
		return idTGEstadoFinanzas;
	}

	public void setIdTGEstadoFinanzas(String idTGEstadoFinanzas) {
		this.idTGEstadoFinanzas = idTGEstadoFinanzas;
	}

	public int getIdUsuarioEnvioPresupuestoOferta() {
		return idUsuarioEnvioPresupuestoOferta;
	}

	public void setIdUsuarioEnvioPresupuestoOferta(int idUsuarioEnvioPresupuestoOferta) {
		this.idUsuarioEnvioPresupuestoOferta = idUsuarioEnvioPresupuestoOferta;
	}

	public int getIdUsuarioEnvioPresupuestoLiquidacion() {
		return idUsuarioEnvioPresupuestoLiquidacion;
	}

	public void setIdUsuarioEnvioPresupuestoLiquidacion(int idUsuarioEnvioPresupuestoLiquidacion) {
		this.idUsuarioEnvioPresupuestoLiquidacion = idUsuarioEnvioPresupuestoLiquidacion;
	}

	public int getIdUsuarioEnvioActaCampo() {
		return idUsuarioEnvioActaCampo;
	}

	public void setIdUsuarioEnvioActaCampo(int idUsuarioEnvioActaCampo) {
		this.idUsuarioEnvioActaCampo = idUsuarioEnvioActaCampo;
	}

	public int getIdUsuarioEnvioActaFinal() {
		return idUsuarioEnvioActaFinal;
	}

	public void setIdUsuarioEnvioActaFinal(int idUsuarioEnvioActaFinal) {
		this.idUsuarioEnvioActaFinal = idUsuarioEnvioActaFinal;
	}

	public int getIdUsuarioOfertado() {
		return idUsuarioOfertado;
	}

	public void setIdUsuarioOfertado(int idUsuarioOfertado) {
		this.idUsuarioOfertado = idUsuarioOfertado;
	}

	public int getIdUsuarioLiquidacion() {
		return idUsuarioLiquidacion;
	}

	public void setIdUsuarioLiquidacion(int idUsuarioLiquidacion) {
		this.idUsuarioLiquidacion = idUsuarioLiquidacion;
	}

	public List<OfertaLiquidacionObraDTO> getOfertaLiquidacionObrasDTO() {
		return ofertaLiquidacionObrasDTO;
	}

	public void setOfertaLiquidacionObrasDTO(List<OfertaLiquidacionObraDTO> ofertaLiquidacionObrasDTO) {
		this.ofertaLiquidacionObrasDTO = ofertaLiquidacionObrasDTO;
	}
}
