package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class ContratasObraJDBCRepository implements ContratasObraRepository {

private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	ContratasObraJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<ContratasObraDTO> findContratasObraByCriteria(ContratasObraDTO dto) {
		WhereParams params = new WhereParams();
        String sql = findContratasObraByCriteriaQuery(dto, params);

        return jdbcTemplate.query(sql.toString(),
                params.getParams(), new BeanPropertyRowMapper<ContratasObraDTO>(ContratasObraDTO.class));
	}

	private String findContratasObraByCriteriaQuery(ContratasObraDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");		
		sql.append(" co.idContratasObra, co.comentarioCierreEconomico, co.comentarioDescuentoOperativo, co.comentarioImporteAdicional, co.fechaCECompletado, "); 		
		sql.append(" co.fechaCEParcial, co.fechaCEPendiente, co.fechaCreacion, co.fechaModificacion, co.importeAdicional, co.importeDescuentoOperativo, co.importeFinal, ");
		sql.append(" co.importeLiquidadacionObra, co.importePendientePago, co.importePresupuestoObra, co.importeTipoCambio, co.importeTotalAdelanto, co.porcentajeActasAprobadas, ");
		sql.append(" co.tipoTrabajo, co.usuarioCreacion, co.usuarioModificacion, co.idContrata, co.idObra, co.idTGTipoMoneda, co.idTGEstadoCierreEconomico, co.idTGEstadoLiquidacion, "); 
		sql.append(" co.idUsuarioCEPendiente, co.idUsuarioCEParcial, co.idUsuarioCECompletado ");
		sql.append(" FROM contratasObra co ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdObra()))
			sql.append(params.filter(" AND co.idObra = :idObra ", dto.getIdObra()));
		return sql.toString();
	}
}
