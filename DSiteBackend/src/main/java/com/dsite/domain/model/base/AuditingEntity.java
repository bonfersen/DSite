package com.dsite.domain.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AuditingEntity implements BaseEntity {
    
	private Integer idUsuarioCreacion;

    private Date fechaCreacion;

    @Column(name = "idUsuarioCreacion")
    public Integer getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	@Column(name = "fechaCreacion")
    public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
