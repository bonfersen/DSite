package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.views.VwAdelantoContrata;
import com.dsite.domain.model.views.VwAdelantoPagadoContrata;
import com.dsite.domain.model.views.VwBandejaAdelantoRechazadoContrata;
import com.dsite.domain.model.views.VwBandejaAprobadoCajaChica;
import com.dsite.domain.model.views.VwBandejaAsignacionCierreEconomico;
import com.dsite.domain.model.views.VwBandejaBudget;
import com.dsite.domain.model.views.VwBandejaCierreEconomico;
import com.dsite.domain.model.views.VwBandejaCrm;
import com.dsite.domain.model.views.VwBandejaCustomerService;
import com.dsite.domain.model.views.VwBandejaDepositoCajaChica;
import com.dsite.domain.model.views.VwBandejaLiquidacionContrata;
import com.dsite.domain.model.views.VwBandejaPagoAdelantoContrata;
import com.dsite.domain.model.views.VwBandejaRechazoCajaChica;
import com.dsite.domain.model.views.VwBandejaReembolsoDescuentoCajaChica;
import com.dsite.domain.model.views.VwBandejaRendicionCajaChica;
import com.dsite.domain.model.views.VwBandejaSolicitudAdelantoContrata;
import com.dsite.domain.model.views.VwBandejaSolicitudCajaChica;
import com.dsite.domain.model.views.VwBandejaSolicitudRendicion;
import com.dsite.domain.model.views.VwBudget;
import com.dsite.domain.model.views.VwConcursoContrata;
import com.dsite.domain.model.views.VwControlDocumentario;
import com.dsite.domain.model.views.VwCrm;
import com.dsite.domain.model.views.VwDepositosCaja;
import com.dsite.domain.model.views.VwDepositosViatico;
import com.dsite.domain.model.views.VwDetalleRendicionCajaChica;
import com.dsite.domain.model.views.VwDocumentosAdjuntos;
import com.dsite.domain.model.views.VwLiquidacionContrata;
import com.dsite.domain.model.views.VwLiquidacionCustomerService;
import com.dsite.domain.model.views.VwListaActasContrata;
import com.dsite.domain.model.views.VwListaCajaChica;
import com.dsite.domain.model.views.VwListaContratasAsignada;
import com.dsite.domain.model.views.VwListaPagosContrata;
import com.dsite.domain.model.views.VwOfertaCustomerService;
import com.dsite.domain.model.views.VwPagoContrata;
import com.dsite.domain.model.views.VwPanelContratas;
import com.dsite.domain.model.views.VwRendicionCajaChica;
import com.dsite.domain.model.views.VwReporteEconomico;
import com.dsite.domain.model.views.VwReporteEconomicoDetalleContrata;
import com.dsite.domain.model.views.VwResumenRendicionCajaChica;
import com.dsite.domain.model.views.VwSeguimientoActaContrata;
import com.dsite.domain.model.views.VwUbigeo;
import com.dsite.dto.model.views.VwAdelantoContrataFilter;
import com.dsite.dto.model.views.VwAdelantoPagadoContrataFilter;
import com.dsite.dto.model.views.VwBandejaAdelantoRechazadoContrataFilter;
import com.dsite.dto.model.views.VwBandejaAprobadoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaAsignacionCierreEconomicoFilter;
import com.dsite.dto.model.views.VwBandejaBudgetFilter;
import com.dsite.dto.model.views.VwBandejaCierreEconomicoFilter;
import com.dsite.dto.model.views.VwBandejaCrmFilter;
import com.dsite.dto.model.views.VwBandejaCustomerServiceFilter;
import com.dsite.dto.model.views.VwBandejaDepositoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaLiquidacionContrataFilter;
import com.dsite.dto.model.views.VwBandejaPagoAdelantoContrataFilter;
import com.dsite.dto.model.views.VwBandejaRechazoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaReembolsoDescuentoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaRendicionCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaSolicitudAdelantoContrataFilter;
import com.dsite.dto.model.views.VwBandejaSolicitudCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaSolicitudRendicionFilter;
import com.dsite.dto.model.views.VwBudgetFilter;
import com.dsite.dto.model.views.VwConcursoContrataFilter;
import com.dsite.dto.model.views.VwControlDocumentarioFilter;
import com.dsite.dto.model.views.VwCrmFilter;
import com.dsite.dto.model.views.VwDepositosCajaFilter;
import com.dsite.dto.model.views.VwDepositosViaticoFilter;
import com.dsite.dto.model.views.VwDetalleRendicionCajaChicaFilter;
import com.dsite.dto.model.views.VwDocumentosAdjuntosFilter;
import com.dsite.dto.model.views.VwLiquidacionContrataFilter;
import com.dsite.dto.model.views.VwLiquidacionCustomerServiceFilter;
import com.dsite.dto.model.views.VwListaActasContrataFilter;
import com.dsite.dto.model.views.VwListaCajaChicaFilter;
import com.dsite.dto.model.views.VwListaContratasAsignadaFilter;
import com.dsite.dto.model.views.VwListaPagosContrataFilter;
import com.dsite.dto.model.views.VwOfertaCustomerServiceFilter;
import com.dsite.dto.model.views.VwPagoContrataFilter;
import com.dsite.dto.model.views.VwPanelContratasFilter;
import com.dsite.dto.model.views.VwRendicionCajaChicaFilter;
import com.dsite.dto.model.views.VwReporteEconomicoDetalleContrataFilter;
import com.dsite.dto.model.views.VwReporteEconomicoFilter;
import com.dsite.dto.model.views.VwResumenRendicionCajaChicaFilter;
import com.dsite.dto.model.views.VwSeguimientoActaContrataFilter;
import com.dsite.dto.model.views.VwUbigeoFilter;
import com.dsite.support.WhereParams;
import com.dsite.util.ValidateUtil;

@Repository
public class VistasJDBCRepository implements VistasRepository {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	VistasJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/***
	 * Filtro para obtener la bandeja de Budget
	 */
	@Override
	public List<VwBandejaBudget> findBandejaBudget(VwBandejaBudgetFilter vwbandejaBudgetFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaBudgetQuery(vwbandejaBudgetFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaBudget>(VwBandejaBudget.class));
	}

	private String findBandejaBudgetQuery(VwBandejaBudgetFilter vwbandejaBudgetFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.idTGProyecto, v.proyecto, v.nombreReal, ");
		sql.append(" v.departamento, v.idTGEstadoObra, v.estadoObra ");
		sql.append(" FROM vwBandejaBudget v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwbandejaBudgetFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwbandejaBudgetFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwbandejaBudgetFilter.getIdTGArea()))
			sql.append(params.filter(" AND v.idTGArea = :idTGArea ", vwbandejaBudgetFilter.getIdTGArea()));
		if (ValidateUtil.isNotEmpty(vwbandejaBudgetFilter.getIdTGEstadoObra()))
			sql.append(params.filter(" AND v.idTGEstadoObra = :idTGEstadoObra ", vwbandejaBudgetFilter.getIdTGEstadoObra()));
		if (ValidateUtil.isNotEmpty(vwbandejaBudgetFilter.getIdTGProyecto()))
			sql.append(params.filter(" AND v.idTGProyecto = :idTGProyecto ", vwbandejaBudgetFilter.getIdTGProyecto()));
		if (ValidateUtil.isNotEmpty(vwbandejaBudgetFilter.getNombreReal()))
			sql.append(params.filter(" AND v.nombreReal LIKE '%' :nombreReal '%' ", vwbandejaBudgetFilter.getNombreReal()));

		return sql.toString();
	}

	/**
	 * Listas de contratas asignadas a una obra
	 */
	@Override
	public List<VwListaContratasAsignada> findContratasAsignadas(VwListaContratasAsignadaFilter vwListaContratasAsignadaFilter) {
		WhereParams params = new WhereParams();
		String sql = findContratasAsignadasQuery(vwListaContratasAsignadaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwListaContratasAsignada>(VwListaContratasAsignada.class));
	}

	private String findContratasAsignadasQuery(VwListaContratasAsignadaFilter vwListaContratasAsignadaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.nombreCorto, v.tipoTrabajo, v.actasContrata, v.importePresupuestoObra, v.moneda, ");
		sql.append(" v.importeTipoCambio, v.idObra, v.idContratasObra, v.idTGEstadoLiquidacion ");
		sql.append(" FROM vwListaContratasAsignadas v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwListaContratasAsignadaFilter.getIdObra()))
			sql.append(params.filter(" AND v.idObra = :idObra ", vwListaContratasAsignadaFilter.getIdObra()));
		if (ValidateUtil.isNotEmpty(vwListaContratasAsignadaFilter.getIdContratasObra()))
			sql.append(params.filter(" AND v.idContratasObra = :idContratasObra ", vwListaContratasAsignadaFilter.getIdContratasObra()));
		return sql.toString();
	}

	/**
	 * Lista para obtener la bandeja de Customer Service
	 */
	@Override
	public List<VwBandejaCustomerService> findBandejaCustomerService(VwBandejaCustomerServiceFilter vwBandejaCustomerServiceFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaCustomerServiceQuery(vwBandejaCustomerServiceFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaCustomerService>(VwBandejaCustomerService.class));
	}

	private String findBandejaCustomerServiceQuery(VwBandejaCustomerServiceFilter vwBandejaCustomerServiceFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.nombreReal, v.fechaRecibido, ");
		sql.append(" v.importeOfertaLiquidacion, v.idTGTipoEnvio, v.tipoEnvio ");
		sql.append(" FROM vwBandejaCustomerService v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwBandejaCustomerServiceFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwBandejaCustomerServiceFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwBandejaCustomerServiceFilter.getIdTGArea()))
			sql.append(params.filter(" AND v.idTGArea = :idTGArea ", vwBandejaCustomerServiceFilter.getIdTGArea()));
		if (ValidateUtil.isNotEmpty(vwBandejaCustomerServiceFilter.getNombreReal()))
			sql.append(params.filter(" AND v.nombreReal LIKE '%' :nombreReal '%' ", vwBandejaCustomerServiceFilter.getNombreReal()));
		return sql.toString();
	}

	/**
	 * Lista de caja chica solicitada
	 */
	@Override
	public List<VwListaCajaChica> findCajaChicaSolicitada(VwListaCajaChicaFilter vwListaCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findCajaChicaSolicitadaQuery(vwListaCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwListaCajaChica>(VwListaCajaChica.class));
	}

	private String findCajaChicaSolicitadaQuery(VwListaCajaChicaFilter vwListaCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.empleadoSustentador, v.empleadoBeneficiario, v.tipoCaja, v.importeCaja, v.importeViatico, ");
		sql.append(" v.importeTotal, v.detalle, v.fechaSolicitud, v.fechaAprobacion, v.fechaPago, v.fechaRechazo,");
		sql.append(" v.motivoRechazo, v.idTGEstadoCajaChica, v.idCajaChicaObra, v.idObra ");
		sql.append(" FROM vwListaCajaChica v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwListaCajaChicaFilter.getIdObra()))
			sql.append(params.filter(" AND v.idObra = :idObra ", vwListaCajaChicaFilter.getIdObra()));
		if (ValidateUtil.isNotEmpty(vwListaCajaChicaFilter.getIdTGEstadoCajaChica()))
			sql.append(params.filter(" AND v.idTGEstadoCajaChica = :idTGEstadoCajaChica ", vwListaCajaChicaFilter.getIdTGEstadoCajaChica()));
		return sql.toString();
	}

	/**
	 * Busqueda de Budget
	 */
	@Override
	public List<VwBudget> findBudget(VwBudgetFilter vwBudgetFilter) {
		WhereParams params = new WhereParams();
		String sql = findBudgetQuery(vwBudgetFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBudget>(VwBudget.class));
	}

	private String findBudgetQuery(VwBudgetFilter vwBudgetFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area,	v.idTGProyecto,	v.proyecto,	v.gestorProyecto, v.empleadoResponsableObra, ");
		sql.append(" v.idTGAreaSoporte, v.areaSoporte, v.idTGEstadoObra, v.estadoObra, v.fechaCreacion, v.fechaInicioObra, ");
		sql.append(" v.fechaFinalizacionObra, v.departamento, v.nombreReal, v.moneda, v.importePresupuestoOferta, ");
		sql.append(" v.importePresupuestoLiquidacion, v.idTGActaCampo, v.idTGActaFinal, v.numeroOrdenCompra, v.numeroOrdenCompraComplementaria, ");
		sql.append(" v.idTGTipoMoneda, v.idPresupuestoObra, v.fechaEnvioActaCampo, v.fechaEnvioActaFinal, v.fechaEnvioPresupuestoLiquidacion, ");
		sql.append(" v.fechaEnvioPresupuestoOferta, v.importeVarMas ");
		sql.append(" FROM vwBudget v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwBudgetFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwBudgetFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwBudgetFilter.getIdTGArea()))
			sql.append(params.filter(" AND v.idTGArea = :idTGArea ", vwBudgetFilter.getIdTGArea()));
		if (ValidateUtil.isNotEmpty(vwBudgetFilter.getIdTGEstadoObra()))
			sql.append(params.filter(" AND v.idTGEstadoObra = :idTGEstadoObra ", vwBudgetFilter.getIdTGEstadoObra()));
		if (ValidateUtil.isNotEmpty(vwBudgetFilter.getIdTGProyecto()))
			sql.append(params.filter(" AND v.idTGProyecto = :idTGProyecto ", vwBudgetFilter.getIdTGProyecto()));
		if (ValidateUtil.isNotEmpty(vwBudgetFilter.getNombreReal()))
			sql.append(params.filter(" AND v.nombreReal LIKE '%' :nombreReal '%' ", vwBudgetFilter.getNombreReal()));
		return sql.toString();
	}

	/***
	 * Buscar Liquidacion customer Service
	 */
	@Override
	public List<VwLiquidacionCustomerService> findLiquidacionCustomerService(VwLiquidacionCustomerServiceFilter vwLiquidacionCustomerServiceFilter) {
		WhereParams params = new WhereParams();
		String sql = findLiquidacionCustomerServiceQuery(vwLiquidacionCustomerServiceFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwLiquidacionCustomerService>(VwLiquidacionCustomerService.class));
	}

	private String findLiquidacionCustomerServiceQuery(VwLiquidacionCustomerServiceFilter vwLiquidacionCustomerServiceFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.idTGProyecto, v.proyecto, v.OTAutogenerada, v.gestorProyecto, v.departamento, ");
		sql.append(" v.idTGEstadoObra, v.estadoObra, v.fechaCreacion, v.nombreReal, v.numeroOrdenCompra, v.importeOferta, ");
		sql.append(" v.fechaOferta, v.moneda, v.importeLiquidacion, v.fechaLiquidacion, v.importeVarMas, v.importeVarMenos, ");
		sql.append(" v.actaFinal, v.fechaActaCampo, v.fechaActaFinal, v.correlativoLiquidacion, v.correlativoOferta, v.estadoFinanzas, ");
		sql.append(" v.observacionFinanzas, v.idEnvioOferta, v.idEnvioLiquidacion, v.idEnvioActaCampo, v.idEnvioActaFinal, v.actaCampo ");
		sql.append(" FROM vwLiquidacionCustomerService v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwLiquidacionCustomerServiceFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwLiquidacionCustomerServiceFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwLiquidacionCustomerServiceFilter.getIdTGArea()))
			sql.append(params.filter(" AND v.idTGArea = :idTGArea ", vwLiquidacionCustomerServiceFilter.getIdTGArea()));
		if (ValidateUtil.isNotEmpty(vwLiquidacionCustomerServiceFilter.getIdTGEstadoObra()))
			sql.append(params.filter(" AND v.idTGEstadoObra = :idTGEstadoObra ", vwLiquidacionCustomerServiceFilter.getIdTGEstadoObra()));
		if (ValidateUtil.isNotEmpty(vwLiquidacionCustomerServiceFilter.getIdTGProyecto()))
			sql.append(params.filter(" AND v.idTGProyecto = :idTGProyecto ", vwLiquidacionCustomerServiceFilter.getIdTGProyecto()));
		if (ValidateUtil.isNotEmpty(vwLiquidacionCustomerServiceFilter.getNombreReal()))
			sql.append(params.filter(" AND v.nombreReal LIKE '%' :nombreReal '%' ", vwLiquidacionCustomerServiceFilter.getNombreReal()));
		return sql.toString();
	}

	/**
	 * Buscar lista de actas por contrata
	 */
	@Override
	public List<VwListaActasContrata> findListaActasContrata(VwListaActasContrataFilter vwListaActasContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findListaActasContrataQuery(vwListaActasContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwListaActasContrata>(VwListaActasContrata.class));
	}

	private String findListaActasContrataQuery(VwListaActasContrataFilter vwListaActasContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idContratasObra, v.actasContrata ");
		sql.append(" FROM vwListaActasContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwListaActasContrataFilter.getIdContratasObra()))
			sql.append(params.filter(" AND v.idContratasObra = :idContratasObra ", vwListaActasContrataFilter.getIdContratasObra()));
		return sql.toString();
	}

	/***
	 * Pagos realizados por contrata
	 */
	@Override
	public List<VwListaPagosContrata> findListaPagosContrata(VwListaPagosContrataFilter vwListaPagosContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findListaPagosContrataQuery(vwListaPagosContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwListaPagosContrata>(VwListaPagosContrata.class));
	}

	private String findListaPagosContrataQuery(VwListaPagosContrataFilter vwListaPagosContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.porcentajeAdelanto, v.importeAdelanto, v.fechaPago, v.fechaAprobacion, v.fechaSolicitud, ");
		sql.append(" v.estadoPagoContrata, v.idContratasObra ");
		sql.append(" FROM vwListaPagosContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwListaPagosContrataFilter.getIdContratasObra()))
			sql.append(params.filter(" AND v.idContratasObra = :idContratasObra ", vwListaPagosContrataFilter.getIdContratasObra()));
		if (ValidateUtil.isNotEmpty(vwListaPagosContrataFilter.getEstadoPagoContrata()))
			sql.append(params.filter(" AND v.estadoPagoContrata = :estadoPagoContrata ", vwListaPagosContrataFilter.getEstadoPagoContrata()));
		return sql.toString();
	}

	/**
	 * 
	 */
	@Override
	public List<VwOfertaCustomerService> findOfertaCustomerService(VwOfertaCustomerServiceFilter vwOfertaCustomerServiceFilter) {
		WhereParams params = new WhereParams();
		String sql = findOfertaCustomerServiceQuery(vwOfertaCustomerServiceFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwOfertaCustomerService>(VwOfertaCustomerService.class));
	}

	private String findOfertaCustomerServiceQuery(VwOfertaCustomerServiceFilter vwOfertaCustomerServiceFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.idTGProyecto, v.proyecto, v.OTAutogenerada, v.gestorProyecto, ");
		sql.append(" v.departamento, v.fechaCreacion, v.nombreReal, v.importeOferta, v.fechaOferta, v.moneda, ");
		sql.append(" v.correlativoOferta, v.estadoFinanzas, v.observacionFinanzas, v.idOfertaLiquidacionObra ");
		sql.append(" FROM vwOfertaCustomerService v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwOfertaCustomerServiceFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwOfertaCustomerServiceFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwOfertaCustomerServiceFilter.getIdTGArea()))
			sql.append(params.filter(" AND v.idTGArea = :idTGArea ", vwOfertaCustomerServiceFilter.getIdTGArea()));
		if (ValidateUtil.isNotEmpty(vwOfertaCustomerServiceFilter.getIdTGProyecto()))
			sql.append(params.filter(" AND v.idTGProyecto = :idTGProyecto ", vwOfertaCustomerServiceFilter.getIdTGProyecto()));
		if (ValidateUtil.isNotEmpty(vwOfertaCustomerServiceFilter.getNombreReal()))
			sql.append(params.filter(" AND v.nombreReal LIKE '%' :nombreReal '%' ", vwOfertaCustomerServiceFilter.getNombreReal()));

		return sql.toString();
	}

	@Override
	public List<VwUbigeo> findUbigeo(VwUbigeoFilter vwUbigeoFilter) {
		WhereParams params = new WhereParams();
		String sql = findUbigeoQuery(vwUbigeoFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwUbigeo>(VwUbigeo.class));
	}

	private String findUbigeoQuery(VwUbigeoFilter vwUbigeoFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idDepartamento, v.departamento, v.idProvincia, v.provincia, v.idDistrito, ");
		sql.append(" v.distrito ");
		sql.append(" FROM vwUbigeo v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwUbigeoFilter.getIdDistrito()))
			sql.append(params.filter(" AND v.idDistrito = :idDistrito ", vwUbigeoFilter.getIdDistrito()));
		if (ValidateUtil.isNotEmpty(vwUbigeoFilter.getDistrito()))
			sql.append(params.filter(" AND v.distrito LIKE '%' :distrito '%' ", vwUbigeoFilter.getDistrito()));
		return sql.toString();
	}

	@Override
	public List<VwConcursoContrata> findConcursoContrata(VwConcursoContrataFilter vwConcursoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findConcursoContrataQuery(vwConcursoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwConcursoContrata>(VwConcursoContrata.class));
	}

	private String findConcursoContrataQuery(VwConcursoContrataFilter vwConcursoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.categoria, v.nombreCorto, v.importeAbjudicado, v.codigoConcurso, v.porcentajeFondoGarantia, v.tiempoFondoGarantia, ");
		sql.append(" v.idConcursoContrata, v.idContrata, v.idTGCategoria, v.idTGArea, v.fechaInicioAbjudicacion, v.fechaFinAbjudicacion ");
		sql.append(" FROM vwConcursoContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwConcursoContrataFilter.getIdConcursoContrata()))
			sql.append(params.filter(" AND v.idConcursoContrata = :idConcursoContrata ", vwConcursoContrataFilter.getIdConcursoContrata()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaPagoAdelantoContrata> findBandejaPagoAdelantoContrata(VwBandejaPagoAdelantoContrataFilter vwBandejaPagoAdelantoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaPagoAdelantoContrataQuery(vwBandejaPagoAdelantoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaPagoAdelantoContrata>(VwBandejaPagoAdelantoContrata.class));
	}

	private String findBandejaPagoAdelantoContrataQuery(VwBandejaPagoAdelantoContrataFilter vwBandejaPagoAdelantoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.area, v.ebc, v.contrata, v.tipoTrabajo, v.importeAdelanto, v.ordenServicio, ");
		sql.append(" v.numeroFactura, v.fechaPago,  v.importeTotalPendientePago, v.importeAplicadoPendientePago, v.solicitadoAcumulado, ");
		sql.append(" v.idContrata, v.idContratasObra, v.idPagosContrata, v.idTGTipoSolicitud ");
		sql.append(" FROM vwBandejaPagoAdelantoContrata v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwBandejaAdelantoRechazadoContrata> findBandejaAdelantoRechazadoContrata(VwBandejaAdelantoRechazadoContrataFilter vwBandejaAdelantoRechazadoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaAdelantoRechazadoContrataQuery(vwBandejaAdelantoRechazadoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaAdelantoRechazadoContrata>(VwBandejaAdelantoRechazadoContrata.class));
	}

	private String findBandejaAdelantoRechazadoContrataQuery(VwBandejaAdelantoRechazadoContrataFilter vwBandejaAdelantoRechazadoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.area, v.contrata, v.tipoTrabajo, v.importePresupuestoObra, v.importeTotalAdelanto, ");
		sql.append(" v.importeAdelanto, v.solicitadoAcumulado, v.motivoRechazo, v.idContrata, v.idContratasObra, v.idPagosContrata ");
		sql.append(" FROM vwBandejaAdelantoRechazadoContrata v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwBandejaSolicitudAdelantoContrata> findBandejaSolicitudAdelantoContrata(VwBandejaSolicitudAdelantoContrataFilter vwBandejaSolicitudAdelantoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaSolicitudAdelantoContrataQuery(vwBandejaSolicitudAdelantoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaSolicitudAdelantoContrata>(VwBandejaSolicitudAdelantoContrata.class));
	}

	private String findBandejaSolicitudAdelantoContrataQuery(VwBandejaSolicitudAdelantoContrataFilter vwBandejaSolicitudAdelantoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.area, v.contrata, v.tipoTrabajo, v.importePresupuestoObra, v.importeTotalAdelanto, ");
		sql.append(" v.importeAdelanto, v.solicitadoAcumulado, v.idContrata, v.idContratasObra, v.idPagosContrata ");
		sql.append(" FROM vwBandejaSolicitudAdelantoContrata v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwBandejaLiquidacionContrata> findBandejaLiquidacionContrata(VwBandejaLiquidacionContrataFilter vwBandejaLiquidacionContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaLiquidacionContrataQuery(vwBandejaLiquidacionContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaLiquidacionContrata>(VwBandejaLiquidacionContrata.class));
	}

	private String findBandejaLiquidacionContrataQuery(VwBandejaLiquidacionContrataFilter vwBandejaLiquidacionContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.area, v.contrata, v.idContrata, v.idContratasObra, v.nombreReal ");
		sql.append(" FROM vwBandejaLiquidacionContrata v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwSeguimientoActaContrata> findSeguimientoActaContrata(VwSeguimientoActaContrataFilter vwSeguimientoActaContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findSeguimientoActaContrataQuery(vwSeguimientoActaContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwSeguimientoActaContrata>(VwSeguimientoActaContrata.class));
	}

	private String findSeguimientoActaContrataQuery(VwSeguimientoActaContrataFilter vwSeguimientoActaContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.area, v.contrata, v.tipoTrabajo, v.porcentajeActasAprobadas, v.estadoActaCampo, ");
		sql.append(" v.estadoActaFinal, v.estadoRptFoto, v.estadoSga, v.idActaCampo, v.idActaFinal, v.idRptFoto, v.idSga, v.idMotivoRechazoActaCampo, ");
		sql.append(" v.idMotivoRechazoActaFinal, v.idMotivoRechazoRptFoto, v.idMotivoRechazoSga, v.nombreReal ");
		sql.append(" FROM vwSeguimientoActaContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwSeguimientoActaContrataFilter.getEstadoActaCampo()))
			sql.append(params.filter(" AND v.estadoActaCampo = :estadoActaCampo ", vwSeguimientoActaContrataFilter.getEstadoActaCampo()));
		if (ValidateUtil.isNotEmpty(vwSeguimientoActaContrataFilter.getEstadoActaFinal()))
			sql.append(params.filter(" AND v.estadoActaFinal = :estadoActaFinal ", vwSeguimientoActaContrataFilter.getEstadoActaFinal()));
		if (ValidateUtil.isNotEmpty(vwSeguimientoActaContrataFilter.getEstadoRptFoto()))
			sql.append(params.filter(" AND v.estadoRptFoto = :estadoRptFoto ", vwSeguimientoActaContrataFilter.getEstadoRptFoto()));
		if (ValidateUtil.isNotEmpty(vwSeguimientoActaContrataFilter.getEstadoSga()))
			sql.append(params.filter(" AND v.estadoSga = :estadoSga ", vwSeguimientoActaContrataFilter.getEstadoSga()));
		return sql.toString();
	}

	@Override
	public List<VwAdelantoPagadoContrata> findAdelantoPagadoContrata(VwAdelantoPagadoContrataFilter vwAdelantoPagadoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findAdelantoPagadoContrataQuery(vwAdelantoPagadoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwAdelantoPagadoContrata>(VwAdelantoPagadoContrata.class));
	}

	private String findAdelantoPagadoContrataQuery(VwAdelantoPagadoContrataFilter vwAdelantoPagadoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idTGTipoSolicitud, v.numeroFactura, v.importeAdelanto, v.fechaPago, v.origen, v.idContratasObra, v.idContrata, ");
		sql.append(" v.idObra, v.codigoDSite ");
		sql.append(" FROM vwAdelantoPagadoContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwAdelantoPagadoContrataFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwAdelantoPagadoContrataFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwAdelantoPagadoContrataFilter.getIdContrata()))
			sql.append(params.filter(" AND v.idContrata = :idContrata ", vwAdelantoPagadoContrataFilter.getIdContrata()));
		if (ValidateUtil.isNotEmpty(vwAdelantoPagadoContrataFilter.getIdContratasObra()))
			sql.append(params.filter(" AND v.idContratasObra = :idContratasObra ", vwAdelantoPagadoContrataFilter.getIdContratasObra()));
		return sql.toString();
	}

	@Override
	public List<VwPagoContrata> findPagoContrata(VwPagoContrataFilter vwPagoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findPagoContrataQuery(vwPagoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwPagoContrata>(VwPagoContrata.class));
	}

	private String findPagoContrataQuery(VwPagoContrataFilter vwPagoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idContrata, v.idObra, v.codigoDSite, v.contrata, v.importeFinal, v.tipoTrabajo ");
		sql.append(" FROM vwPagoContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwPagoContrataFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwPagoContrataFilter.getCodigoDSite()));
		return sql.toString();
	}

	@Override
	public List<VwLiquidacionContrata> findLiquidacionContrata(VwLiquidacionContrataFilter vwLiquidacionContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findLiquidacionContrataQuery(vwLiquidacionContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwLiquidacionContrata>(VwLiquidacionContrata.class));
	}

	private String findLiquidacionContrataQuery(VwLiquidacionContrataFilter vwLiquidacionContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.idContratasObra, v.idContrata, v.contrata, v.tipoTrabajo, v.importePresupuestoObra, ");
		sql.append(" v.importeLiquidadacionObra, v.importeAdicional, v.comentarioImporteAdicional, v.importeDescuentoOperativo, ");
		sql.append(" v.comentarioDescuentoOperativo, v.importeFinal, v.importePendientePago, v.estadoPagoContrata, v.importeTotalContratas, ");
		sql.append(" v.importeObra, v.porcentajeCostos, v.importeTotalAdelanto, v.porcentajePagado ");
		sql.append(" FROM vwLiquidacionContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwLiquidacionContrataFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwLiquidacionContrataFilter.getCodigoDSite()));
		if (ValidateUtil.isNotEmpty(vwLiquidacionContrataFilter.getTipoTrabajo()))
			sql.append(params.filter(" AND v.tipoTrabajo = :tipoTrabajo ", vwLiquidacionContrataFilter.getTipoTrabajo()));
		if (ValidateUtil.isNotEmpty(vwLiquidacionContrataFilter.getIdContrata()))
			sql.append(params.filter(" AND v.idContrata = :idContrata ", vwLiquidacionContrataFilter.getIdContrata()));
		return sql.toString();
	}

	@Override
	public List<VwAdelantoContrata> findAdelantoContrata(VwAdelantoContrataFilter vwAdelantoContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findAdelantoContrataQuery(vwAdelantoContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwAdelantoContrata>(VwAdelantoContrata.class));
	}

	private String findAdelantoContrataQuery(VwAdelantoContrataFilter vwAdelantoContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idContratasObra, v.porcentajeAdelanto, v.importeAdelanto, v.fechaRechazo, v.fechaSolicitud, v.fechaAprobacion, ");
		sql.append(" v.fechaPago, v.idTGEstadoPagoContrata, v.estado, v.importeTotalAdelanto ");
		sql.append(" FROM vwAdelantoContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwAdelantoContrataFilter.getIdContratasObra()))
			sql.append(params.filter(" AND v.idContratasObra = :idContratasObra ", vwAdelantoContrataFilter.getIdContratasObra()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaCrm> findBandejaCrm(VwBandejaCrmFilter vwBandejaCrmFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaCrmQuery(vwBandejaCrmFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaCrm>(VwBandejaCrm.class));
	}

	private String findBandejaCrmQuery(VwBandejaCrmFilter vwBandejaCrmFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.idTGProyecto, v.idTGEstadoFinanzas, v.nombreReal, v.idObra, ");
		sql.append(" v.idPresupuestoObra, v.proyecto, v.area, v.estadoFinanzas ");
		sql.append(" FROM vwBandejaCrm v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwCrm> findCrm(VwCrmFilter vwCrmFilter) {
		WhereParams params = new WhereParams();
		String sql = findCrmQuery(vwCrmFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwCrm>(VwCrm.class));
	}

	private String findCrmQuery(VwCrmFilter vwCrmFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idObra, v.idPresupuestoObra, v.correlativoOfertaLiquidacion, v.idTGArea, v.area, v.idTGProyecto, ");
		sql.append(" v.proyecto, v.idTGGestorProyecto, v.gestorProyecto, v.idTGGerenteProyecto, v.gerenteProyecto, v.OTAutogenerada, ");
		sql.append(" v.departamento, v.idTGTipoGasto, v.tipoGasto, v.fechaCreacion, v.nombreReal, v.numeroOrdenCompra, v.idTGEstadoFinanzas, ");
		sql.append(" v.estadoFinanzas, v.fechaLiquidacion, v.importePresupuestoOferta, v.importePresupuestoLiquidacion, v.idEnvioOferta, ");
		sql.append(" v.importeOferta, v.idEnvioLiquidacion, v.importeLiquidacion, v.importeVarMas, v.importeVarMenos, v.idEnvioActaCampo, ");
		sql.append(" v.actaCampo, v.fechaActaCampo, v.idEnvioActaFinal, v.actaFinal, v.fechaActaFinal, v.estadoActaAdministracion, ");
		sql.append(" v.importeOrdenCompra, v.cetificado, v.facturaDSite, v.importeOrdenCompraComplementaria, v.numeroOrdenCompraComplementaria, ");
		sql.append(" v.cetificadoComplementaria, v.facturaDSiteComplementaria, v.notaCredito, v.idTGEstadoObra, v.estadoObra, ");
		sql.append(" estadoActaCampo, estadoActaFinal ");
		sql.append(" FROM vwCrm v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwCrmFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwCrmFilter.getCodigoDSite()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaSolicitudCajaChica> findBandejaSolicitudCajaChica(VwBandejaSolicitudCajaChicaFilter vwBandejaSolicitudCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaSolicitudCajaChicaQuery(vwBandejaSolicitudCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaSolicitudCajaChica>(VwBandejaSolicitudCajaChica.class));
	}

	private String findBandejaSolicitudCajaChicaQuery(VwBandejaSolicitudCajaChicaFilter vwBandejaSolicitudCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.nombreReal, v.idTGProyecto, v.idTGArea, v.codigoDSite, v.proyecto, v.area, v.idEmpleadoSustentador, v.idTGTipoCaja, ");
		sql.append(" v.idEmpleadoBeneficiario, v.importeCaja, v.importeViatico, v.importeTotal, v.detalle, v.idTGEstadoCajaChica, v.fechaAprobacion, ");
		sql.append(" v.motivoRechazo, v.empleadoSustentador, v.empleadoBeneficiario, v.tipoCaja, v.estadoCajaChica, v.idCajaChicaObra, v.idObra");
		sql.append(" FROM vwBandejaSolicitudCajaChica v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwBandejaDepositoCajaChica> findBandejaDepositoCajaChica(VwBandejaDepositoCajaChicaFilter vwBandejaDepositoCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaDepositoCajaChicaQuery(vwBandejaDepositoCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaDepositoCajaChica>(VwBandejaDepositoCajaChica.class));
	}

	private String findBandejaDepositoCajaChicaQuery(VwBandejaDepositoCajaChicaFilter vwBandejaDepositoCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.nombreReal, v.idTGProyecto, v.idTGArea, v.codigoDSite, v.proyecto, v.area, v.idEmpleadoSustentador, v.idTGTipoCaja, ");
		sql.append(" v.idEmpleadoBeneficiario, v.importeCaja, v.importeViatico, v.importeTotal, v.detalle, v.idTGEstadoCajaChica, v.fechaAprobacion, ");
		sql.append(" v.motivoRechazo, v.fechaPago, v.empleadoSustentador, v.empleadoBeneficiario, v.tipoCaja, v.estadoCajaChica, v.idCajaChicaObra, v.idObra ");
		sql.append(" FROM vwBandejaDepositoCajaChica v ");
		sql.append(" WHERE 1=1");
		sql.append(params.filterDateFrom_LIM(" AND v.fechaPago ", vwBandejaDepositoCajaChicaFilter.getFechaPagoInicio()));
		sql.append(params.filterDateTo_LIM(" AND v.fechaPago ", vwBandejaDepositoCajaChicaFilter.getFechaPagoFin()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaRendicionCajaChica> findBandejaRendicionCajaChica(VwBandejaRendicionCajaChicaFilter vwBandejaRendicionCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaRendicionCajaChicaQuery(vwBandejaRendicionCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaRendicionCajaChica>(VwBandejaRendicionCajaChica.class));
	}

	private String findBandejaRendicionCajaChicaQuery(VwBandejaRendicionCajaChicaFilter vwBandejaRendicionCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.nombreReal, v.idTGProyecto, v.idTGArea, v.codigoDSite, v.proyecto, v.area, v.idEmpleadoSustentador, v.idTGTipoCaja, ");
		sql.append(" v.idEmpleadoBeneficiario, v.importeCaja, v.rendirCaja, v.importeViatico, v.rendirViatico, v.importeTotal, v.detalle, ");
		sql.append(" v.idTGEstadoCajaChica, v.fechaAprobacion, v.motivoRechazo, v.fechaPago, v.empleadoSustentador, v.empleadoBeneficiario, ");
		sql.append(" v.tipoCaja, v.estadoCajaChica, v.idCajaChicaObra, v.idObra, v.codigoRendicionCaja, v.codigoRendicionViatico  ");
		sql.append(" FROM vwBandejaRendicionCajaChica v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwBandejaRendicionCajaChicaFilter.getIdEmpleadoSustentador()))
			sql.append(params.filter(" AND v.idEmpleadoSustentador = :idEmpleadoSustentador ", vwBandejaRendicionCajaChicaFilter.getIdEmpleadoSustentador()));
		return sql.toString();
	}

	@Override
	public List<VwRendicionCajaChica> findRendicionCajaChica(VwRendicionCajaChicaFilter vwRendicionCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findRendicionCajaChicaQuery(vwRendicionCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwRendicionCajaChica>(VwRendicionCajaChica.class));
	}

	private String findRendicionCajaChicaQuery(VwRendicionCajaChicaFilter vwRendicionCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.importeCaja, v.importeViatico, v.fechaPago, v.importeAbonoCaja, v.importeRendidoCaja, v.importeReembolsoCaja, v.importeDescuentoCaja, ");
		sql.append(" v.importeAbonoViatico, v.importeRendidoViatico, v.importeDescuentoViatico, v.idResumenRendicionCajaChica, v.idRendicionCajaChica, v.codigoRendicion, ");
		sql.append(" v.idCajaChicaObra ");
		sql.append(" FROM vwRendicionCajaChica v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwRendicionCajaChicaFilter.getCodigoRendicion()))
			sql.append(params.filter(" AND v.codigoRendicion = :codigoRendicion ", vwRendicionCajaChicaFilter.getCodigoRendicion()));
		return sql.toString();
	}

	@Override
	public List<VwDetalleRendicionCajaChica> findDetalleRendicionCajaChica(VwDetalleRendicionCajaChicaFilter vwDetalleRendicionCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findDetalleRendicionCajaChicaQuery(vwDetalleRendicionCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwDetalleRendicionCajaChica>(VwDetalleRendicionCajaChica.class));
	}

	private String findDetalleRendicionCajaChicaQuery(VwDetalleRendicionCajaChicaFilter vwDetalleRendicionCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.fechaComprobanteCajaViatico, v.idTGTipoComprobante, v.tipoComprobante, v.idTGTipoGasto, v.tipoGasto, v.numeroComprobanteCajaViatico, ");
		sql.append(" v.descripcionCajaViatico, v.importeRendidoCaja, v.importeRendidoViatico, v.idCajaChicaObra, v.idRendicionCajaChica, v.idResumenRendicionCajaChica, ");
		sql.append(" v.idRendicion, v.codigoRendicion, v.idTGTipoRendicion ");
		sql.append(" FROM vwDetalleRendicionCajaChica v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwDetalleRendicionCajaChicaFilter.getCodigoRendicion()))
			sql.append(params.filter(" AND v.codigoRendicion = :codigoRendicion ", vwDetalleRendicionCajaChicaFilter.getCodigoRendicion()));
		if (ValidateUtil.isNotEmpty(vwDetalleRendicionCajaChicaFilter.getCodigoRendicion()))
			sql.append(params.filter(" AND v.idTGTipoRendicion = :idTGTipoRendicion ", vwDetalleRendicionCajaChicaFilter.getIdTGTipoRendicion()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaReembolsoDescuentoCajaChica> findBandejaReembolsoDescuentoCajaChica(
			VwBandejaReembolsoDescuentoCajaChicaFilter vwBandejaReembolsoDescuentoCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaReembolsoDescuentoCajaChicaQuery(vwBandejaReembolsoDescuentoCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaReembolsoDescuentoCajaChica>(VwBandejaReembolsoDescuentoCajaChica.class));
	}

	private String findBandejaReembolsoDescuentoCajaChicaQuery(VwBandejaReembolsoDescuentoCajaChicaFilter vwBandejaReembolsoDescuentoCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoRendicion, v.idTGTipoRendicion, v.tipoRendicion, v.tipoOperacion, v.idTGEstadoRendicion, v.estadoRendicion, v.importeReembolsoDescuento, ");
		sql.append(" v.fechaReembolso, v.fechaDescuento, v.idEmpleadoSustentador, v.empleadoSustentador, v.idTGTipoCaja, v.tipoCaja, v.idRendicionCajaChica, ");
		sql.append(" v.idResumenRendicionCajaChica, v.idCajaChicaObra, v.codigoDSite ");
		sql.append(" FROM vwBandejaReembolsoDescuentoCajaChica v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwBandejaReembolsoDescuentoCajaChicaFilter.getIdTGEstadoRendicion()))
			sql.append(params.filter(" AND v.idTGEstadoRendicion = :idTGEstadoRendicion ", vwBandejaReembolsoDescuentoCajaChicaFilter.getIdTGEstadoRendicion()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaAprobadoCajaChica> findBandejaAprobadoCajaChica(VwBandejaAprobadoCajaChicaFilter vwBandejaAprobadoCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaAprobadoCajaChicaQuery(vwBandejaAprobadoCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaAprobadoCajaChica>(VwBandejaAprobadoCajaChica.class));
	}

	private String findBandejaAprobadoCajaChicaQuery(VwBandejaAprobadoCajaChicaFilter vwBandejaAprobadoCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.idTGProyecto, v.proyecto, v.nombreReal, v.idEmpleadoSustentador, v.empleadoSustentador, v.idTGTipoCaja, ");
		sql.append(" v.tipoCaja, v.idEmpleadoBeneficiario, v.empleadoBeneficiario, v.importeCaja, v.importeViatico, v.importeTotal, v.detalle, ");
		sql.append(" v.fechaAprobacion, v.idUsuarioAprobacion, v.empleadoAprobacion, v.idCajaChicaObra, v.idTGEstadoCajaChica, v.idObra ");
		sql.append(" FROM vwBandejaAprobadoCajaChica v ");
		sql.append(" WHERE 1=1");
		sql.append(params.filterDateFrom_LIM(" AND v.fechaAprobacion ", vwBandejaAprobadoCajaChicaFilter.getFechaAprobacionInicio()));
		sql.append(params.filterDateTo_LIM(" AND v.fechaAprobacion ", vwBandejaAprobadoCajaChicaFilter.getFechaAprobacionFin()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaRechazoCajaChica> findBandejaRechazoCajaChica(VwBandejaRechazoCajaChicaFilter vwBandejaRechazoCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaRechazoCajaChicaQuery(vwBandejaRechazoCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaRechazoCajaChica>(VwBandejaRechazoCajaChica.class));
	}

	private String findBandejaRechazoCajaChicaQuery(VwBandejaRechazoCajaChicaFilter vwBandejaRechazoCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.idTGProyecto, v.proyecto, v.nombreReal, v.idEmpleadoSustentador, v.empleadoSustentador, ");
		sql.append(" v.idTGTipoCaja, v.tipoCaja, v.idEmpleadoBeneficiario, v.empleadoBeneficiario, v.importeCaja, v.importeViatico, v.importeTotal, ");
		sql.append(" v.detalle, v.fechaRechazo, v.motivoRechazo, v.idUsuarioRechazo, v.empleadoRechazo, v.idCajaChicaObra, v.idTGEstadoCajaChica, ");
		sql.append(" v.estadoCajaChica, v.idObra ");
		sql.append(" FROM vwBandejaRechazoCajaChica v ");
		sql.append(" WHERE 1=1");
		sql.append(params.filterDateFrom_LIM(" AND v.fechaRechazo ", vwBandejaRechazoCajaChicaFilter.getFechaRechazoInicio()));
		sql.append(params.filterDateTo_LIM(" AND v.fechaRechazo ", vwBandejaRechazoCajaChicaFilter.getFechaRechazoFin()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaAsignacionCierreEconomico> findBandejaAsignacionCierreEconomico(VwBandejaAsignacionCierreEconomicoFilter vwBandejaAsignacionCierreEconomicoFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaAsignacionCierreEconomicoQuery(vwBandejaAsignacionCierreEconomicoFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaAsignacionCierreEconomico>(VwBandejaAsignacionCierreEconomico.class));
	}

	private String findBandejaAsignacionCierreEconomicoQuery(VwBandejaAsignacionCierreEconomicoFilter vwBandejaAsignacionCierreEconomicoFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.idTGArea, v.area, v.nombreReal, v.tipoTrabajo, v.cantidadContratasAsignadas, v.idObra, v.fechaFinalizacion ");
		sql.append(" FROM vwBandejaAsignacionCierreEconomico v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwBandejaAsignacionCierreEconomicoFilter.getIdTGArea()))
			sql.append(params.filter(" AND v.idTGArea = :idTGArea ", vwBandejaAsignacionCierreEconomicoFilter.getIdTGArea()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaCierreEconomico> findBandejaCierreEconomico(VwBandejaCierreEconomicoFilter vwBandejaCierreEconomicoFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaCierreEconomicoQuery(vwBandejaCierreEconomicoFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaCierreEconomico>(VwBandejaCierreEconomico.class));
	}
	
	private String findBandejaCierreEconomicoQuery(VwBandejaCierreEconomicoFilter vwBandejaCierreEconomicoFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idTGEstadoCierreEconomico, v.estadoCierreEconomico, v.codigoCierre, v.ebc, v.fechaAsignacion ");
		sql.append(" FROM vwBandejaCierreEconomico v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwBandejaCierreEconomicoFilter.getIdTGEstadoCierreEconomico()))
			sql.append(params.filter(" AND v.idTGEstadoCierreEconomico = :idTGEstadoCierreEconomico ", vwBandejaCierreEconomicoFilter.getIdTGEstadoCierreEconomico()));
		return sql.toString();
	}

	@Override
	public List<VwControlDocumentario> findControlDocumentario(VwControlDocumentarioFilter vwControlDocumentarioFilter) {
		WhereParams params = new WhereParams();
		String sql = findControlDocumentarioQuery(vwControlDocumentarioFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwControlDocumentario>(VwControlDocumentario.class));
	}

	private String findControlDocumentarioQuery(VwControlDocumentarioFilter vwControlDocumentarioFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idObra, v.codigoDSite, v.area, v.contrata, v.tipoTrabajo, v.porcentajeActasAprobadas, v.nombreReal, v.cierre, ");
		sql.append(" v.comentarioCierreEconomico, v.codigoCierre, v.estadoActaCampo, v.estadoActaFinal, v.estadoRptFoto, v.estadoSga, ");
		sql.append(" v.idActaCampo, v.idActaFinal, v.idRptFoto, v.idSga, v.idMotivoRechazoActaCampo, v.idMotivoRechazoActaFinal, ");
		sql.append(" v.idMotivoRechazoRptFoto, v.idMotivoRechazoSga ");
		sql.append(" FROM vwControlDocumentario v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwControlDocumentarioFilter.getCodigoCierre()))
			sql.append(params.filter(" AND v.codigoCierre = :codigoCierre ", vwControlDocumentarioFilter.getCodigoCierre()));
		return sql.toString();
	}

	@Override
	public List<VwDocumentosAdjuntos> findDocumentosAdjuntos(VwDocumentosAdjuntosFilter vwDocumentosAdjuntosFilter) {
		WhereParams params = new WhereParams();
		String sql = findDocumentosAdjuntosQuery(vwDocumentosAdjuntosFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwDocumentosAdjuntos>(VwDocumentosAdjuntos.class));
	}

	private String findDocumentosAdjuntosQuery(VwDocumentosAdjuntosFilter vwDocumentosAdjuntosFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idDocumentosAdjunto, v.directorio, v.nombreArchivo, v.idTabla, v.idTGNombreTabla, v.idTipoDocumentoAdjunto,  ");
		sql.append(" v.fechaCreacion, v.usuarioCreacion, v.fechaModificacion, v.usuarioModificacion ");
		sql.append(" FROM vwDocumentosAdjuntos v ");
		sql.append(" WHERE 1=1");
		sql.append(params.filter(" AND v.idTabla = :idTabla ", vwDocumentosAdjuntosFilter.getIdTabla()));
		sql.append(params.filter(" AND v.idTGNombreTabla = :idTGNombreTabla ", vwDocumentosAdjuntosFilter.getIdTGNombreTabla()));
		return sql.toString();
	}

	@Override
	public List<VwReporteEconomico> findReporteEconomico(VwReporteEconomicoFilter vwReporteEconomicoFilter) {
		WhereParams params = new WhereParams();
		String sql = findReporteEconomicoQuery(vwReporteEconomicoFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwReporteEconomico>(VwReporteEconomico.class));
	}

	private String findReporteEconomicoQuery(VwReporteEconomicoFilter vwReporteEconomicoFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.nombreReal, v.area, v.proyecto, v.gestor, v.departamento, v.asignacion, v.importePresupuestoOferta, v.importeIngresoOferta, ");
		sql.append(" v.ordenCompra, v.facturado, v.importeLiquidacionOferta, v.importeIngresoLiquidacion, v.actas, v.fechaLiquidacion, v.estatusGep, v.variacionMas, ");
		sql.append(" v.numeroOrdenCompraComplementaria, v.variacionMenos, v.notaCredito, v.importeGastos, v.importeRentabilidad, v.porcentajeRentabilidad, ");
		sql.append(" v.importeTotalPresupuestadoContrata, v.importeTotalPagosContrata, v.importeCajas, v.importeViaticos, v.importeTotalCajas ");
		sql.append(" FROM vwReporteEconomico v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwReporteEconomicoFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwReporteEconomicoFilter.getCodigoDSite()));
		return sql.toString();
	}

	public List<VwReporteEconomicoDetalleContrata> findReporteEconomicoDetalleContrata(VwReporteEconomicoDetalleContrataFilter vwReporteEconomicoDetalleContrataFilter) {
		WhereParams params = new WhereParams();
		String sql = findReporteEconomicoDetalleContrataQuery(vwReporteEconomicoDetalleContrataFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwReporteEconomicoDetalleContrata>(VwReporteEconomicoDetalleContrata.class));
	}

	private String findReporteEconomicoDetalleContrataQuery(VwReporteEconomicoDetalleContrataFilter vwReporteEconomicoDetalleContrataFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoDSite, v.nombreCorto, v.tipoTrabajo, v.importePresupuestoObra, v.importeTotalAdelanto, v.porcentajeActasAprobadas ");
		sql.append(" FROM vwReporteEconomicoDetalleContrata v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwReporteEconomicoDetalleContrataFilter.getCodigoDSite()))
			sql.append(params.filter(" AND v.codigoDSite = :codigoDSite ", vwReporteEconomicoDetalleContrataFilter.getCodigoDSite()));
		return sql.toString();
	}

	@Override
	public List<VwPanelContratas> findPanelContratas(VwPanelContratasFilter vwPanelContratasFilter) {
		WhereParams params = new WhereParams();
		String sql = findPanelContratasQuery(vwPanelContratasFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwPanelContratas>(VwPanelContratas.class));
	}

	private String findPanelContratasQuery(VwPanelContratasFilter vwPanelContratasFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.categoria, v.nombreCorto, v.importeAbjudicado, v.importeAvanceTotal, v.porcentaje, v.importeRestante, v.importeLiquidado, ");
		sql.append(" v.importeCancelado, v.importePendiente, v.importeProyectado ");
		sql.append(" FROM vwPanelContratas v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}

	@Override
	public List<VwDepositosViatico> findDepositosViatico(VwDepositosViaticoFilter vwDepositosViaticoFilter) {
		WhereParams params = new WhereParams();
		String sql = findDepositosViaticoQuery(vwDepositosViaticoFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwDepositosViatico>(VwDepositosViatico.class));
	}

	private String findDepositosViaticoQuery(VwDepositosViaticoFilter vwDepositosViaticoFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoRendicion, v.codigoDSite, v.importeViatico, v.fechaPago ");
		sql.append(" FROM vwDepositosViatico v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwDepositosViaticoFilter.getCodigoRendicion()))
			sql.append(params.filter(" AND v.codigoRendicion = :codigoRendicion ", vwDepositosViaticoFilter.getCodigoRendicion()));
		return sql.toString();
	}

	@Override
	public List<VwDepositosCaja> findDepositosCaja(VwDepositosCajaFilter vwDepositosCajaFilter) {
		WhereParams params = new WhereParams();
		String sql = findDepositosCajaQuery(vwDepositosCajaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwDepositosCaja>(VwDepositosCaja.class));
	}

	private String findDepositosCajaQuery(VwDepositosCajaFilter vwDepositosCajaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.codigoRendicion, v.codigoDSite, v.importeCaja, v.fechaPago ");
		sql.append(" FROM vwDepositosCaja v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwDepositosCajaFilter.getCodigoRendicion()))
			sql.append(params.filter(" AND v.codigoRendicion = :codigoRendicion ", vwDepositosCajaFilter.getCodigoRendicion()));
		return sql.toString();
	}

	@Override
	public List<VwResumenRendicionCajaChica> findResumenRendicionCajaChica(VwResumenRendicionCajaChicaFilter vwResumenRendicionCajaChicaFilter) {
		WhereParams params = new WhereParams();
		String sql = findResumenRendicionCajaChicaQuery(vwResumenRendicionCajaChicaFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwResumenRendicionCajaChica>(VwResumenRendicionCajaChica.class));
	}

	private String findResumenRendicionCajaChicaQuery(VwResumenRendicionCajaChicaFilter vwResumenRendicionCajaChicaFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.importeAbonoCaja, v.importeRendidoCaja, v.importeReembolsoCaja, v.importeDescuentoCaja, v.importeAbonoViatico, v.importeRendidoViatico, ");
		sql.append(" v.importeDescuentoViatico, v.idResumenRendicionCajaChica, v.codigoRendicion ");
		sql.append(" FROM vwResumenRendicionCajaChica v ");
		sql.append(" WHERE 1=1");
		if (ValidateUtil.isNotEmpty(vwResumenRendicionCajaChicaFilter.getCodigoRendicion()))
			sql.append(params.filter(" AND v.codigoRendicion = :codigoRendicion ", vwResumenRendicionCajaChicaFilter.getCodigoRendicion()));
		return sql.toString();
	}

	@Override
	public List<VwBandejaSolicitudRendicion> findBandejaSolicitudRendicion(VwBandejaSolicitudRendicionFilter vwBandejaSolicitudRendicionFilter) {
		WhereParams params = new WhereParams();
		String sql = findBandejaSolicitudRendicionQuery(vwBandejaSolicitudRendicionFilter, params);

		return jdbcTemplate.query(sql.toString(), params.getParams(), new BeanPropertyRowMapper<VwBandejaSolicitudRendicion>(VwBandejaSolicitudRendicion.class));
	}

	private String findBandejaSolicitudRendicionQuery(VwBandejaSolicitudRendicionFilter vwBandejaSolicitudRendicionFilter, WhereParams params) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" v.idResumenRendicionCajaChica, v.codigoRendicion, v.idEmpleadoSustentador, v.empleadoSustentador, v.importeRendido, v.fechaCreacion ");
		sql.append(" FROM vwBandejaSolicitudRendicion v ");
		sql.append(" WHERE 1=1");
		return sql.toString();
	}
}
