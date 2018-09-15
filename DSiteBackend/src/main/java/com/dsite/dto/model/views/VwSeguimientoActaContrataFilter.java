package com.dsite.dto.model.views;

public class VwSeguimientoActaContrataFilter {
	private String estadoActaCampo;
    private String estadoActaFinal;
    private String estadoRptFoto;
    private String estadoSga;
    private Integer idContrata;
    
	public Integer getIdContrata() {
		return idContrata;
	}
	public void setIdContrata(Integer idContrata) {
		this.idContrata = idContrata;
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
}
