package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.ContrataDTO;
import com.dsite.support.WhereParams;

@Repository
public class ContrataJDBCRepository implements ContrataRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	ContrataJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<ContrataDTO> findContrataByCriteria(ContrataDTO dto) {
		WhereParams params = new WhereParams();
		String sql = findContrataByCriteriaQuery(dto, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<ContrataDTO>(ContrataDTO.class));
	}

	private String findContrataByCriteriaQuery(ContrataDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" c.idContrata, c.activo, c.contacto, c.correo, c.direccion, c.fechaCreacion, c.fechaModificacion, c.importeTotalPendientePago, ");
		sql.append(" c.nombreCorto, c.razonSocial, c.ruc, c.telefono, c.usuarioCreacion, c.usuarioModificacion, c.idTGCategoria ");
		sql.append(" FROM contrata c ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}
}
