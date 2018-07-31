package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.ConcursoContrataDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class ConcursoContrataJDBCRepository implements ConcursoContrataRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	ConcursoContrataJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ConcursoContrataDTO> findConcursoContrataByCriteria(ConcursoContrataDTO dto) {
		WhereParams params = new WhereParams();
		String sql = findConcursoContrataByCriteriaQuery(dto, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<ConcursoContrataDTO>(ConcursoContrataDTO.class));
	}

	private String findConcursoContrataByCriteriaQuery(ConcursoContrataDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" cc.idConcursoContrata, cc.codigoConcurso, cc.fechaCreacion, cc.fechaFinAbjudicacion, cc.fechaInicioAbjudicacion, cc.fechaModificacion, ");
		sql.append(" cc.importeAbjudicado, cc.porcentajeFondoGarantia, cc.tiempoFondoGarantia, cc.usuarioCreacion, cc.usuarioModificacion, cc.idContrata, cc.idTGArea ");
		sql.append(" FROM concursoContrata cc ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getFechaCreacionContrataObra()))
			sql.append(" AND ").append(params.formatDate_LIM(dto.getFechaCreacionContrataObra())).append(" between cc.fechaInicioAbjudicacion and cc.fechaFinAbjudicacion ");
		if (ValidateUtil.isNotEmpty(dto.getIdTGAreaContrataObra()))
			sql.append(params.filter(" AND cc.idTGArea = :idTGArea ", dto.getIdTGAreaContrataObra()));
		if (ValidateUtil.isNotEmpty(dto.getIdContrata()))
			sql.append(params.filter(" AND cc.idContrata = :idContrata ", dto.getIdContrata()));
		return sql.toString();
	}
}
