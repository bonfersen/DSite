package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.UsuarioDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class UsuarioJDBCRepository implements UsuarioRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	UsuarioJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<UsuarioDTO> findUsuarioByCriteria(UsuarioDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findUsuarioByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<UsuarioDTO>(UsuarioDTO.class));
	}
	
	private String findUsuarioByCriteriaQuery(UsuarioDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" u.idUsuario, u.cuentaUsuario, u.password, u.activo, u.idTGRol ");
		sql.append(" FROM usuario u ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getCuentaUsuario()))
			sql.append(params.filter(" AND u.cuentaUsuario = :cuentaUsuario ", dto.getCuentaUsuario()));
		if (ValidateUtil.isNotEmpty(dto.getPassword()))
			sql.append(params.filter(" AND u.password = :password ", dto.getPassword()));
		return sql.toString();
	}

}
