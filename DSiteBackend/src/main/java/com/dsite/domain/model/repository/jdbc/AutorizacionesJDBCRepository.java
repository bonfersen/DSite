package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.AutorizacionesDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class AutorizacionesJDBCRepository implements AutorizacionesRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	AutorizacionesJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<AutorizacionesDTO> findAutorizacionesByCriteria(AutorizacionesDTO dto) {
		WhereParams params = new WhereParams();
		String sql = findAutorizacionesByCriteriaQuery(dto, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<AutorizacionesDTO>(AutorizacionesDTO.class));
	}

	private String findAutorizacionesByCriteriaQuery(AutorizacionesDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" a.idTGRol, a.idTGPermiso, a.idTGNivelAcceso ");
		sql.append(" FROM autorizaciones a ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdTGRol()))
			sql.append(params.filter(" AND a.idTGRol = :idTGRol ", dto.getIdTGRol()));
		return sql.toString();
	}
}
