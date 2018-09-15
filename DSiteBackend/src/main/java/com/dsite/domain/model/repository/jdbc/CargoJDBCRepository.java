package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.CargoDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class CargoJDBCRepository implements CargoRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	CargoJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CargoDTO> findCargoByCriteria(CargoDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findEmpleadoByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<CargoDTO>(CargoDTO.class));
	}
	
	private String findEmpleadoByCriteriaQuery(CargoDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" c.idCargo, c.nombre, c.idArea, c.activo, c.idTGTipoTrabajador, c.fechaCreacion, c.usuarioCreacion, ");
		sql.append(" c.fechaModificacion, c.usuarioModificacion ");
		sql.append(" FROM cargo c ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdArea()))
			sql.append(params.filter(" AND c.idArea = :idArea ", dto.getIdArea()));
		return sql.toString();
	}
}
