package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class EmpleadoJDBCRepository implements EmpleadoRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	EmpleadoJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<EmpleadoDTO> findEmpleadoByCriteria(EmpleadoDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findEmpleadoByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<EmpleadoDTO>(EmpleadoDTO.class));
	}
	
	private String findEmpleadoByCriteriaQuery(EmpleadoDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" e.idEmpleado, e.idTGTipoDocumento, e.numeroDocumento, e.nombre, e.apellidoPaterno, e.apellidoMaterno, e.idCargo, ");
		sql.append(" e.responsableObra, e.activo, e.idUsuario, e.idTGNivelUsuario, e.fechaCreacion, e.usuarioCreacion, e.fechaModificacion, ");
		sql.append(" e.usuarioModificacion ");
		sql.append(" FROM empleado e ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdUsuario()))
			sql.append(params.filter(" AND e.idUsuario = :idUsuario ", dto.getIdUsuario()));
		return sql.toString();
	}
}
