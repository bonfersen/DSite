package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.AreaDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class AreaJDBCRepository implements AreaRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	AreaJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<AreaDTO> findAreaByCriteria(AreaDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findAreaByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<AreaDTO>(AreaDTO.class));
	}
	
	private String findAreaByCriteriaQuery(AreaDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" a.idArea, a.nombre, a.idGerencia, a.usuarioCreacion, a.fechaCreacion, a.usuarioModificacion, a.fechaModificacion, ");
		sql.append(" a.idArea ");
		sql.append(" FROM area a ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdArea()))
			sql.append(params.filter(" AND a.idArea = :idArea ", dto.getIdArea()));
		if (ValidateUtil.isNotEmpty(dto.getIdGerencia()))
			sql.append(params.filter(" AND a.idGerencia = :idGerencia ", dto.getIdGerencia()));
		return sql.toString();
	}

}
