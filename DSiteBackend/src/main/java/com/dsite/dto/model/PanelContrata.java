package com.dsite.dto.model;

import java.util.List;

import com.dsite.domain.model.views.VwPanelContratas;

public class PanelContrata {

	private List<VwPanelContratas> detalle;
	
	private VwPanelContratas total;

	public List<VwPanelContratas> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<VwPanelContratas> detalle) {
		this.detalle = detalle;
	}

	public VwPanelContratas getTotal() {
		return total;
	}

	public void setTotal(VwPanelContratas total) {
		this.total = total;
	}
}
