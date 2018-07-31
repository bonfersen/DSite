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

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<ContratasObraDTO>(ContratasObraDTO.class));
	}

	private String findContratasObraByCriteriaQuery(ContratasObraDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" co.idContratasObra, co.comentarioCierreEconomico, co.comentarioDescuentoOperativo, co.comentarioImporteAdicional, co.fechaCECompletado, ");
		sql.append(" co.fechaCEParcial, co.fechaCEPendiente, co.fechaCreacion, co.fechaModificacion, co.importeAdicional, co.importeDescuentoOperativo, co.importeFinal, ");
		sql.append(
				" co.importeLiquidadacionObra, co.importePendientePago, co.importePresupuestoObra, co.importeTipoCambio, co.importeTotalAdelanto, co.porcentajeActasAprobadas, ");
		sql.append(
				" co.tipoTrabajo, co.usuarioCreacion, co.usuarioModificacion, co.idContrata, co.idObra, co.idTGTipoMoneda, co.idTGEstadoCierreEconomico, co.idTGEstadoLiquidacion, ");
		sql.append(" co.idUsuarioCEPendiente, co.idUsuarioCEParcial, co.idUsuarioCECompletado ");
		sql.append(" FROM contratasObra co ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(dto.getIdObra()))
			sql.append(params.filter(" AND co.idObra = :idObra ", dto.getIdObra()));
		if (ValidateUtil.isNotEmpty(dto.getIdContratasObra()))
			sql.append(params.filter(" AND co.idContratasObra = :idContratasObra ", dto.getIdContratasObra()));
		return sql.toString();
	}

	public List<ContratasObraDTO> findAllContratasObra(ContratasObraDTO dto) {
		WhereParams params = new WhereParams();
		String sql = findAllContratasObraQuery(dto, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<ContratasObraDTO>(ContratasObraDTO.class));
	}

	private String findAllContratasObraQuery(ContratasObraDTO dto, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  co.idContratasObra, co.idContrata, co.idObra, co.importePresupuestoObra, co.importeFinal, co.idTGEstadoLiquidacion ");
		sql.append(" FROM contratasObra co ");
		sql.append(" inner join obra o on o.idObra= co.idObra ");
		sql.append(" where o.idTGEstadoObra != 'ESOB003' and co.idContrata = ").append(dto.getIdContrata());
		sql.append(" AND o.idTGArea = '").append(dto.getIdTGAreaObra()).append("'");
		return sql.toString();
	}
}
