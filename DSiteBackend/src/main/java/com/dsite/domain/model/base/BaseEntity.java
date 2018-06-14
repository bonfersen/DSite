package com.dsite.domain.model.base;

import java.util.Date;

public interface BaseEntity {

	public Integer getIdUsuarioCreacion();

    public void setIdUsuarioCreacion(Integer idUsuarioCreacion);

    public Date getFechaCreacion() ;

    public void setFechaCreacion(Date fechaCreacion);
}
