package com.dsite.rest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsite.constants.DSiteCoreConstants;
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
import com.dsite.dto.model.PanelContrata;
import com.dsite.dto.model.ReporteEconomico;
import com.dsite.dto.model.views.VwAdelantoContrataFilter;
import com.dsite.dto.model.views.VwAdelantoPagadoContrataFilter;
import com.dsite.dto.model.views.VwBandejaAprobadoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaAsignacionCierreEconomicoFilter;
import com.dsite.dto.model.views.VwBandejaBudgetFilter;
import com.dsite.dto.model.views.VwBandejaCierreEconomicoFilter;
import com.dsite.dto.model.views.VwBandejaCustomerServiceFilter;
import com.dsite.dto.model.views.VwBandejaDepositoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaRechazoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaReembolsoDescuentoCajaChicaFilter;
import com.dsite.dto.model.views.VwBandejaRendicionCajaChicaFilter;
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
import com.dsite.service.intf.VistasService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/vistas")
public class VistasController {

	@Autowired
	VistasService vistasService;

	@RequestMapping(value = "/findBandejaBudget", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaBudget>> findBandejaBudget(@RequestBody VwBandejaBudgetFilter vwBandejaBudgetFilter) {
		List<VwBandejaBudget> result;
		result = vistasService.findBandejaBudget(vwBandejaBudgetFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findContratasAsignadas", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwListaContratasAsignada>> findContratasAsignadas(@RequestBody VwListaContratasAsignadaFilter vwListaContratasAsignadaFilter) {
		List<VwListaContratasAsignada> result;
		result = vistasService.findContratasAsignadas(vwListaContratasAsignadaFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaCustomerService", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaCustomerService>> findBandejaCustomerService(@RequestBody VwBandejaCustomerServiceFilter vwBandejaCustomerServiceFilter) {
		List<VwBandejaCustomerService> result;
		result = vistasService.findBandejaCustomerService(vwBandejaCustomerServiceFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findCajaChicaSolicitada", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwListaCajaChica>> findCajaChicaSolicitada(@RequestBody VwListaCajaChicaFilter vwListaCajaChicaFilter) {
		List<VwListaCajaChica> result;
		result = vistasService.findCajaChicaSolicitada(vwListaCajaChicaFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBudget", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBudget>> findBudget(@RequestBody VwBudgetFilter vwBudgetFilter) {
		List<VwBudget> result;
		result = vistasService.findBudget(vwBudgetFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findLiquidacionCustomerService", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwLiquidacionCustomerService>> findLiquidacionCustomerService(
			@RequestBody VwLiquidacionCustomerServiceFilter vwLiquidacionCustomerServiceFilter) {
		List<VwLiquidacionCustomerService> result;
		result = vistasService.findLiquidacionCustomerService(vwLiquidacionCustomerServiceFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findListaActasContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwListaActasContrata>> findListaActasContrata(@RequestBody VwListaActasContrataFilter vwListaActasContrataFilter) {
		List<VwListaActasContrata> result;
		result = vistasService.findListaActasContrata(vwListaActasContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findListaPagosContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwListaPagosContrata>> findListaPagosContrata(@RequestBody VwListaPagosContrataFilter vwListaPagosContrataFilter) {
		List<VwListaPagosContrata> result;
		result = vistasService.findListaPagosContrata(vwListaPagosContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findOfertaCustomerService", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwOfertaCustomerService>> findOfertaCustomerService(@RequestBody VwOfertaCustomerServiceFilter vwOfertaCustomerServiceFilter) {
		List<VwOfertaCustomerService> result;
		result = vistasService.findOfertaCustomerService(vwOfertaCustomerServiceFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findUbigeo", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwUbigeo>> findUbigeo(@RequestBody VwUbigeoFilter vwUbigeoFilter) {
		List<VwUbigeo> result;
		result = vistasService.findUbigeo(vwUbigeoFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findConcursoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwConcursoContrata>> findConcursoContrata(@RequestBody VwConcursoContrataFilter vwConcursoContrataFilter) {
		List<VwConcursoContrata> result;
		result = vistasService.findConcursoContrata(vwConcursoContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaPagoAdelantoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaPagoAdelantoContrata>> findBandejaPagoAdelantoContrata() {
		List<VwBandejaPagoAdelantoContrata> result;
		result = vistasService.findBandejaPagoAdelantoContrata(null);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaAdelantoRechazadoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaAdelantoRechazadoContrata>> findBandejaAdelantoRechazadoContrata() {
		List<VwBandejaAdelantoRechazadoContrata> result;
		result = vistasService.findBandejaAdelantoRechazadoContrata(null);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaSolicitudAdelantoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaSolicitudAdelantoContrata>> findBandejaSolicitudAdelantoContrata() {
		List<VwBandejaSolicitudAdelantoContrata> result;
		result = vistasService.findBandejaSolicitudAdelantoContrata(null);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaLiquidacionContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaLiquidacionContrata>> findBandejaLiquidacionContrata() {
		List<VwBandejaLiquidacionContrata> result;
		result = vistasService.findBandejaLiquidacionContrata(null);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findSeguimientoActaContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwSeguimientoActaContrata>> findSeguimientoActaContrata(@RequestBody VwSeguimientoActaContrataFilter vwSeguimientoActaContrataFilter) {
		List<VwSeguimientoActaContrata> result;
		result = vistasService.findSeguimientoActaContrata(vwSeguimientoActaContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAdelantoPagadoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwAdelantoPagadoContrata>> findAdelantoPagadoContrata(@RequestBody VwAdelantoPagadoContrataFilter vwAdelantoPagadoContrataFilter) {
		List<VwAdelantoPagadoContrata> result;
		result = vistasService.findAdelantoPagadoContrata(vwAdelantoPagadoContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findPagoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwPagoContrata>> findPagoContrata(@RequestBody VwPagoContrataFilter vwPagoContrataFilter) {
		List<VwPagoContrata> result;
		result = vistasService.findPagoContrata(vwPagoContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findLiquidacionContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwLiquidacionContrata>> findLiquidacionContrata(@RequestBody VwLiquidacionContrataFilter vwLiquidacionContrataFilter) {
		List<VwLiquidacionContrata> result;
		result = vistasService.findLiquidacionContrata(vwLiquidacionContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAdelantoContrata", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwAdelantoContrata>> findAdelantoContrata(@RequestBody VwAdelantoContrataFilter vwAdelantoContrataFilter) {
		List<VwAdelantoContrata> result;
		result = vistasService.findAdelantoContrata(vwAdelantoContrataFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaCrm", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaCrm>> findBandejaCrm() {
		List<VwBandejaCrm> result;
		result = vistasService.findBandejaCrm(null);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findCrm", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwCrm>> findCrm(@RequestBody VwCrmFilter vwCrmFilter) {
		List<VwCrm> result;
		result = vistasService.findCrm(vwCrmFilter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaSolicitudCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaSolicitudCajaChica>> findBandejaSolicitudCajaChica(@RequestBody VwBandejaSolicitudCajaChicaFilter filter) {
		List<VwBandejaSolicitudCajaChica> result;
		result = vistasService.findBandejaSolicitudCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaDepositoCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaDepositoCajaChica>> findBandejaDepositoCajaChica(@RequestBody VwBandejaDepositoCajaChicaFilter filter) {
		List<VwBandejaDepositoCajaChica> result;
		result = vistasService.findBandejaDepositoCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaRendicionCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaRendicionCajaChica>> findBandejaRendicionCajaChica(@RequestBody VwBandejaRendicionCajaChicaFilter filter) {
		List<VwBandejaRendicionCajaChica> result;
		result = vistasService.findBandejaRendicionCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findRendicionCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwRendicionCajaChica>> findRendicionCajaChica(@RequestBody VwRendicionCajaChicaFilter filter) {
		List<VwRendicionCajaChica> result;
		result = vistasService.findRendicionCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findDetalleRendicionCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwDetalleRendicionCajaChica>> findDetalleRendicionCajaChica(@RequestBody VwDetalleRendicionCajaChicaFilter filter) {
		List<VwDetalleRendicionCajaChica> result;
		result = vistasService.findDetalleRendicionCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaReembolsoDescuentoCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaReembolsoDescuentoCajaChica>> findBandejaReembolsoDescuentoCajaChica(
			@RequestBody VwBandejaReembolsoDescuentoCajaChicaFilter filter) {
		List<VwBandejaReembolsoDescuentoCajaChica> result;
		result = vistasService.findBandejaReembolsoDescuentoCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaAprobadoCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaAprobadoCajaChica>> findBandejaAprobadoCajaChica(@RequestBody VwBandejaAprobadoCajaChicaFilter filter) {
		List<VwBandejaAprobadoCajaChica> result;
		result = vistasService.findBandejaAprobadoCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaRechazoCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaRechazoCajaChica>> findBandejaRechazoCajaChica(@RequestBody VwBandejaRechazoCajaChicaFilter filter) {
		List<VwBandejaRechazoCajaChica> result;
		result = vistasService.findBandejaRechazoCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaAsignacionCierreEconomico", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaAsignacionCierreEconomico>> findBandejaAsignacionCierreEconomico(
			@RequestBody VwBandejaAsignacionCierreEconomicoFilter filter) {
		List<VwBandejaAsignacionCierreEconomico> result;
		result = vistasService.findBandejaAsignacionCierreEconomico(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaCierreEconomico", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaCierreEconomico>> findBandejaCierreEconomico(@RequestBody VwBandejaCierreEconomicoFilter filter) {
		List<VwBandejaCierreEconomico> result;
		result = vistasService.findBandejaCierreEconomico(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findControlDocumentario", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwControlDocumentario>> findControlDocumentario(@RequestBody VwControlDocumentarioFilter filter) {
		List<VwControlDocumentario> result;
		result = vistasService.findControlDocumentario(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findReporteEconomico", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<ReporteEconomico> findReporteEconomico(@RequestBody VwReporteEconomicoFilter filter) {
		ReporteEconomico reporteEconomico = new ReporteEconomico();
		List<VwReporteEconomico> vwReporteEconomico = vistasService.findReporteEconomico(filter);
		VwReporteEconomicoDetalleContrataFilter vwReporteEconomicoDetalleContrataFilter = new VwReporteEconomicoDetalleContrataFilter();
		vwReporteEconomicoDetalleContrataFilter.setCodigoDSite(filter.getCodigoDSite());
		List<VwReporteEconomicoDetalleContrata> vwDetalleReporteEconomico = new ArrayList<VwReporteEconomicoDetalleContrata>();
		vwDetalleReporteEconomico = vistasService.findReporteEconomicoDetalleContrata(vwReporteEconomicoDetalleContrataFilter);

		reporteEconomico.setReporteEconomico(vwReporteEconomico.get(0));
		reporteEconomico.setDetalleReporteEconomico(vwDetalleReporteEconomico);

		return new ResponseEntity<>(reporteEconomico, HttpStatus.OK);
	}

	@RequestMapping(value = "/findPanelContratas", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<PanelContrata> findPanelContratas() {
		PanelContrata panelContrata = new PanelContrata();
		VwPanelContratasFilter vwPanelContratasFilter = null;
		VwPanelContratas vwPanelContratasTotalesBean = new VwPanelContratas();
		List<VwPanelContratas> vwPanelContratasDetallesEntity = vistasService.findPanelContratas(vwPanelContratasFilter);
		List<VwPanelContratas> vwPanelContratasDetallesBean = new ArrayList<VwPanelContratas>();
		int count = 0;

		String categoriaTemp = DSiteCoreConstants.VACIO;
		BigDecimal categoriaTotalAdjudicacion = BigDecimal.ZERO;
		BigDecimal categoriaAvanceTotal = BigDecimal.ZERO;
		BigDecimal categoriaPorcentajeAvanceTotal = BigDecimal.ZERO;
		BigDecimal categoriaTotalRestante = BigDecimal.ZERO;
		BigDecimal categoriaTotalLiquidado = BigDecimal.ZERO;
		BigDecimal categoriaTotalCancelado = BigDecimal.ZERO;
		BigDecimal categoriaTotalPendiente = BigDecimal.ZERO;
		BigDecimal categoriaTotalProyectado = BigDecimal.ZERO;
		BigDecimal totalAdjudicacion = BigDecimal.ZERO;
		BigDecimal avanceTotal = BigDecimal.ZERO;
		BigDecimal porcentajeAvanceTotal = BigDecimal.ZERO;
		BigDecimal totalRestante = BigDecimal.ZERO;
		BigDecimal totalLiquidado = BigDecimal.ZERO;
		BigDecimal totalCancelado = BigDecimal.ZERO;
		BigDecimal totalPendiente = BigDecimal.ZERO;
		BigDecimal totalProyectado = BigDecimal.ZERO;

		for (VwPanelContratas vwPanelContratasEntity : vwPanelContratasDetallesEntity) {
			count++;
			if (count == 1)
				categoriaTemp = vwPanelContratasEntity.getCategoria();

			/*
			 * Se generan los registros de detalle contrata
			 */
			VwPanelContratas vwPanelContratasBean = new VwPanelContratas();
			vwPanelContratasBean.setCategoria(vwPanelContratasEntity.getCategoria());
			vwPanelContratasBean.setNombreCorto(vwPanelContratasEntity.getNombreCorto());
			vwPanelContratasBean.setImporteAbjudicado(vwPanelContratasEntity.getImporteAbjudicado());
			vwPanelContratasBean.setImporteAvanceTotal(vwPanelContratasEntity.getImporteAvanceTotal());
			vwPanelContratasBean.setImporteCancelado(vwPanelContratasEntity.getImporteCancelado());
			vwPanelContratasBean.setImporteLiquidado(vwPanelContratasEntity.getImporteLiquidado());
			vwPanelContratasBean.setImportePendiente(vwPanelContratasEntity.getImportePendiente());
			vwPanelContratasBean.setImporteProyectado(vwPanelContratasEntity.getImporteProyectado());
			vwPanelContratasBean.setImporteRestante(vwPanelContratasEntity.getImporteRestante());
			vwPanelContratasBean.setPorcentaje(vwPanelContratasEntity.getPorcentaje());

			switch (vwPanelContratasEntity.getCategoria()) {
			case DSiteCoreConstants.CATEGORIA_CONTRATA_GRANDE_DESCRIPCION:
				vwPanelContratasBean.setCategoria("GRANDES");
				break;
			case DSiteCoreConstants.CATEGORIA_CONTRATA_MEDIANO_DESCRIPCION:
				vwPanelContratasBean.setCategoria("MEDIANAS");
				break;
			case DSiteCoreConstants.CATEGORIA_CONTRATA_PEQUENO_DESCRIPCION:
				vwPanelContratasBean.setCategoria("PEQUENAS");
				break;
			default:
				break;
			}
			vwPanelContratasDetallesBean.add(vwPanelContratasBean);

			/*
			 * Se van sumarizando los totales de categorias contrata
			 */
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImporteAbjudicado()))
				categoriaTotalAdjudicacion = categoriaTotalAdjudicacion.add(vwPanelContratasEntity.getImporteAbjudicado());
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImporteAvanceTotal()))
				categoriaAvanceTotal = categoriaAvanceTotal.add(vwPanelContratasEntity.getImporteAvanceTotal());
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImporteRestante()))
				categoriaTotalRestante = categoriaTotalRestante.add(vwPanelContratasEntity.getImporteRestante());
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImporteLiquidado()))
				categoriaTotalLiquidado = categoriaTotalLiquidado.add(vwPanelContratasEntity.getImporteLiquidado());
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImporteCancelado()))
				categoriaTotalCancelado = categoriaTotalCancelado.add(vwPanelContratasEntity.getImporteCancelado());
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImportePendiente()))
				categoriaTotalPendiente = categoriaTotalPendiente.add(vwPanelContratasEntity.getImportePendiente());
			if (ValidateUtil.isNotEmpty(vwPanelContratasEntity.getImporteProyectado()))
				categoriaTotalProyectado = categoriaTotalProyectado.add(vwPanelContratasEntity.getImporteProyectado());

			/*
			 * Se generan los registros totales de categorias contrata
			 */
			if (categoriaTemp.compareTo(vwPanelContratasEntity.getCategoria()) != 0 || count == vwPanelContratasDetallesEntity.size()) {
				VwPanelContratas vwPanelContratasCategoriaTotalesBean = new VwPanelContratas();
				categoriaTemp = vwPanelContratasEntity.getCategoria();
				switch (vwPanelContratasEntity.getCategoria()) {
				case DSiteCoreConstants.CATEGORIA_CONTRATA_GRANDE_DESCRIPCION:
					vwPanelContratasCategoriaTotalesBean.setCategoria("TOTAL GRANDES");
					vwPanelContratasCategoriaTotalesBean.setNombreCorto("TOTAL GRANDES");
					break;
				case DSiteCoreConstants.CATEGORIA_CONTRATA_MEDIANO_DESCRIPCION:
					vwPanelContratasCategoriaTotalesBean.setCategoria("TOTAL MEDIANAS");
					vwPanelContratasCategoriaTotalesBean.setNombreCorto("TOTAL MEDIANAS");
					break;
				case DSiteCoreConstants.CATEGORIA_CONTRATA_PEQUENO_DESCRIPCION:
					vwPanelContratasCategoriaTotalesBean.setCategoria("TOTAL PEQUE\u00d1AS");
					vwPanelContratasCategoriaTotalesBean.setNombreCorto("TOTAL PEQUE\u00d1AS");
					break;
				default:
					break;
				}
				vwPanelContratasCategoriaTotalesBean.setImporteAbjudicado(categoriaTotalAdjudicacion);
				vwPanelContratasCategoriaTotalesBean.setImporteAvanceTotal(categoriaAvanceTotal);
				if (ValidateUtil.isNotEmpty(categoriaAvanceTotal) && ValidateUtil.isNotEmpty(categoriaTotalAdjudicacion)) {
					if (categoriaAvanceTotal.compareTo(BigDecimal.ZERO) == 0)
						categoriaPorcentajeAvanceTotal = BigDecimal.ZERO;
					else
						categoriaPorcentajeAvanceTotal = categoriaAvanceTotal.multiply(new BigDecimal(DSiteCoreConstants.CIEN_CADENA)).divide(categoriaTotalAdjudicacion, 4,
								RoundingMode.HALF_UP);
				}
				vwPanelContratasCategoriaTotalesBean.setPorcentaje(categoriaPorcentajeAvanceTotal);
				vwPanelContratasCategoriaTotalesBean.setImporteRestante(categoriaTotalRestante);
				vwPanelContratasCategoriaTotalesBean.setImporteLiquidado(categoriaTotalLiquidado);
				vwPanelContratasCategoriaTotalesBean.setImporteCancelado(categoriaTotalCancelado);
				vwPanelContratasCategoriaTotalesBean.setImportePendiente(categoriaTotalPendiente);
				vwPanelContratasCategoriaTotalesBean.setImporteProyectado(categoriaTotalProyectado);

				vwPanelContratasDetallesBean.add(vwPanelContratasCategoriaTotalesBean);

				if (ValidateUtil.isNotEmpty(categoriaTotalAdjudicacion))
					totalAdjudicacion = totalAdjudicacion.add(categoriaTotalAdjudicacion);
				if (ValidateUtil.isNotEmpty(categoriaAvanceTotal))
					avanceTotal = avanceTotal.add(categoriaAvanceTotal);
				if (ValidateUtil.isNotEmpty(categoriaTotalRestante))
					totalRestante = totalRestante.add(categoriaTotalRestante);
				if (ValidateUtil.isNotEmpty(categoriaTotalLiquidado))
					totalLiquidado = totalLiquidado.add(categoriaTotalLiquidado);
				if (ValidateUtil.isNotEmpty(categoriaTotalCancelado))
					totalCancelado = totalCancelado.add(categoriaTotalCancelado);
				if (ValidateUtil.isNotEmpty(categoriaTotalPendiente))
					totalPendiente = totalPendiente.add(categoriaTotalPendiente);
				if (ValidateUtil.isNotEmpty(categoriaTotalProyectado))
					totalProyectado = totalProyectado.add(categoriaTotalProyectado);

				categoriaTotalAdjudicacion = BigDecimal.ZERO;
				categoriaAvanceTotal = BigDecimal.ZERO;
				categoriaPorcentajeAvanceTotal = BigDecimal.ZERO;
				categoriaTotalRestante = BigDecimal.ZERO;
				categoriaTotalLiquidado = BigDecimal.ZERO;
				categoriaTotalCancelado = BigDecimal.ZERO;
				categoriaTotalPendiente = BigDecimal.ZERO;
				categoriaTotalProyectado = BigDecimal.ZERO;
			}

			categoriaTemp = vwPanelContratasEntity.getCategoria();

		}

		/*
		 * Se genera el registro unico de totales generales
		 */
		if (vwPanelContratasDetallesBean.size() > 0) {
			vwPanelContratasTotalesBean.setCategoria("TOTALES");
			vwPanelContratasTotalesBean.setNombreCorto("TOTALES");
			vwPanelContratasTotalesBean.setImporteAbjudicado(totalAdjudicacion);
			vwPanelContratasTotalesBean.setImporteAvanceTotal(avanceTotal);
			if (ValidateUtil.isNotEmpty(avanceTotal) && ValidateUtil.isNotEmpty(totalAdjudicacion))
				if (avanceTotal.compareTo(BigDecimal.ZERO) == 0)
					porcentajeAvanceTotal = BigDecimal.ZERO;
				else
					porcentajeAvanceTotal = avanceTotal.multiply(new BigDecimal(DSiteCoreConstants.CIEN_CADENA)).divide(totalAdjudicacion, 4, RoundingMode.HALF_UP);
			vwPanelContratasTotalesBean.setPorcentaje(porcentajeAvanceTotal);
			vwPanelContratasTotalesBean.setImporteRestante(totalRestante);
			vwPanelContratasTotalesBean.setImporteLiquidado(totalLiquidado);
			vwPanelContratasTotalesBean.setImporteCancelado(totalCancelado);
			vwPanelContratasTotalesBean.setImportePendiente(totalPendiente);
			vwPanelContratasTotalesBean.setImporteProyectado(totalProyectado);

			panelContrata.setDetalle(vwPanelContratasDetallesBean);
			panelContrata.setTotal(vwPanelContratasTotalesBean);
		}
		else {
			panelContrata = null;
		}

		return new ResponseEntity<>(panelContrata, HttpStatus.OK);
	}

	@RequestMapping(value = "/findDocumentosAdjuntos", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwDocumentosAdjuntos>> findDocumentosAdjuntos(@RequestBody VwDocumentosAdjuntosFilter filter) {
		List<VwDocumentosAdjuntos> result;
		result = vistasService.findDocumentosAdjuntos(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findDepositosViatico", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwDepositosViatico>> findDepositosViatico(@RequestBody VwDepositosViaticoFilter filter) {
		List<VwDepositosViatico> result;
		result = vistasService.findDepositosViatico(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findDepositosCaja", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwDepositosCaja>> findDepositosCaja(@RequestBody VwDepositosCajaFilter filter) {
		List<VwDepositosCaja> result;
		result = vistasService.findDepositosCaja(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findResumenRendicionCajaChica", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwResumenRendicionCajaChica>> findResumenRendicionCajaChica(@RequestBody VwResumenRendicionCajaChicaFilter filter) {
		List<VwResumenRendicionCajaChica> result;
		result = vistasService.findResumenRendicionCajaChica(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBandejaSolicitudRendicion", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<VwBandejaSolicitudRendicion>> findBandejaSolicitudRendicion() {
		List<VwBandejaSolicitudRendicion> result;
		VwBandejaSolicitudRendicionFilter filter = null;
		result = vistasService.findBandejaSolicitudRendicion(filter);
		if (result == null)
			result = new ArrayList<>();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
