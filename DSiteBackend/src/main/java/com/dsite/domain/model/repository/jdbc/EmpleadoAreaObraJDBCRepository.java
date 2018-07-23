package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.EmpleadoAreaObraDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class EmpleadoAreaObraJDBCRepository implements EmpleadoAreaObraRepository {

private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	EmpleadoAreaObraJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<EmpleadoAreaObraDTO> findEmpleadoAreaObraByCriteria(EmpleadoAreaObraDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findEmpleadoAreaObraByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<EmpleadoAreaObraDTO>(EmpleadoAreaObraDTO.class));
	}

	private String findEmpleadoAreaObraByCriteriaQuery(EmpleadoAreaObraDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" e.idEmpleadoAreaObra, e.activo, e.idTGEmpleadoAreaObra, e.idEmpleado ");
		sql.append(" FROM empleadoAreaObra e ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdEmpleado()))
			sql.append(params.filter(" AND e.idEmpleado = :idEmpleado ", dto.getIdEmpleado()));
		return sql.toString();
	}
}
