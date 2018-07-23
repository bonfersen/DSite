package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.CierreEconomicoDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class CierreEconomicoJDBCRepository implements CierreEconomicoRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	CierreEconomicoJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<CierreEconomicoDTO> findCierreEconomicoByCriteria(CierreEconomicoDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findCierreEconomicoByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<CierreEconomicoDTO>(CierreEconomicoDTO.class));
	}

	private String findCierreEconomicoByCriteriaQuery(CierreEconomicoDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" ce.idCierreEconomico, ce.codigoCierre, ce.fechaAsignacion, ce.fechaCreacion, ce.usuarioCreacion, ce.idTGEstadoCierreEconomico, ce.idUsuarioAsignacion ");		
		sql.append(" FROM cierreEconomico ce ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdCierreEconomico()))
			sql.append(params.filter(" AND ce.idCierreEconomico = :idCierreEconomico ", dto.getIdCierreEconomico()));
		return sql.toString();
	}
}
