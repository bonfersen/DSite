package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dsite.domain.model.views.VwAdelantoContrata;
import com.dsite.domain.model.views.VwAdelantoPagadoContrata;
import com.dsite.domain.model.views.VwBandejaAdelantoRechazadoContrata;
import com.dsite.domain.model.views.VwBandejaBudget;
import com.dsite.domain.model.views.VwBandejaCrm;
import com.dsite.domain.model.views.VwBandejaCustomerService;
import com.dsite.domain.model.views.VwBandejaLiquidacionContrata;
import com.dsite.domain.model.views.VwBandejaPagoAdelantoContrata;
import com.dsite.domain.model.views.VwBandejaSolicitudAdelantoContrata;
import com.dsite.domain.model.views.VwBudget;
import com.dsite.domain.model.views.VwConcursoContrata;
import com.dsite.domain.model.views.VwCrm;
import com.dsite.domain.model.views.VwLiquidacionContrata;
import com.dsite.domain.model.views.VwLiquidacionCustomerService;
import com.dsite.domain.model.views.VwListaActasContrata;
import com.dsite.domain.model.views.VwListaCajaChica;
import com.dsite.domain.model.views.VwListaContratasAsignada;
import com.dsite.domain.model.views.VwListaPagosContrata;
import com.dsite.domain.model.views.VwOfertaCustomerService;
import com.dsite.domain.model.views.VwPagoContrata;
import com.dsite.domain.model.views.VwSeguimientoActaContrata;
import com.dsite.domain.model.views.VwUbigeo;
import com.dsite.dto.model.views.VwAdelantoContrataFilter;
import com.dsite.dto.model.views.VwAdelantoPagadoContrataFilter;
import com.dsite.dto.model.views.VwBandejaAdelantoRechazadoContrataFilter;
import com.dsite.dto.model.views.VwBandejaBudgetFilter;
import com.dsite.dto.model.views.VwBandejaCrmFilter;
import com.dsite.dto.model.views.VwBandejaCustomerServiceFilter;
import com.dsite.dto.model.views.VwBandejaLiquidacionContrataFilter;
import com.dsite.dto.model.views.VwBandejaPagoAdelantoContrataFilter;
import com.dsite.dto.model.views.VwBandejaSolicitudAdelantoContrataFilter;
import com.dsite.dto.model.views.VwBudgetFilter;
import com.dsite.dto.model.views.VwConcursoContrataFilter;
import com.dsite.dto.model.views.VwCrmFilter;
import com.dsite.dto.model.views.VwLiquidacionContrataFilter;
import com.dsite.dto.model.views.VwLiquidacionCustomerServiceFilter;
import com.dsite.dto.model.views.VwListaActasContrataFilter;
import com.dsite.dto.model.views.VwListaCajaChicaFilter;
import com.dsite.dto.model.views.VwListaContratasAsignadaFilter;
import com.dsite.dto.model.views.VwListaPagosContrataFilter;
import com.dsite.dto.model.views.VwOfertaCustomerServiceFilter;
import com.dsite.dto.model.views.VwPagoContrataFilter;
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
		sql.append(" v.importeTipoCambio, v.idObra, v.idContratasObra ");
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
		sql.append(" v.idContrata, v.idContratasObra, v.idPagosContrata ");
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
}
