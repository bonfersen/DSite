package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.CierreEconomicoObraDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class CierreEconomicoObraJDBCRepository implements CierreEconomicoObraRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CierreEconomicoObraJDBCRepository.class);

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	CierreEconomicoObraJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CierreEconomicoObraDTO> findCierreEconomicoObraByCriteria(CierreEconomicoObraDTO dto) {
		WhereParams params = new WhereParams();
		String sql = findCierreEconomicoObraByCriteriaQuery(dto, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<CierreEconomicoObraDTO>(CierreEconomicoObraDTO.class));
	}

	private String findCierreEconomicoObraByCriteriaQuery(CierreEconomicoObraDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" ceo.idCierreEconomicoObra, ceo.idCierreEconomico, ceo.idObra ");
		sql.append(" FROM cierreEconomicoObra ceo ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdCierreEconomicoObra()))
			sql.append(params.filter(" AND ceo.idCierreEconomicoObra = :idCierreEconomicoObra ", dto.getIdCierreEconomicoObra()));
		return sql.toString();
	}

}
