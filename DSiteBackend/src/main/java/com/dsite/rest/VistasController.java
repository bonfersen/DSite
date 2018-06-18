package com.dsite.rest;

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
import com.dsite.domain.model.views.VwBudget;
import com.dsite.domain.model.views.VwConcursoContrata;
import com.dsite.domain.model.views.VwControlDocumentario;
import com.dsite.domain.model.views.VwCrm;
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
import com.dsite.domain.model.views.VwRendicionCajaChica;
import com.dsite.domain.model.views.VwSeguimientoActaContrata;
import com.dsite.domain.model.views.VwUbigeo;
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
import com.dsite.dto.model.views.VwBudgetFilter;
import com.dsite.dto.model.views.VwConcursoContrataFilter;
import com.dsite.dto.model.views.VwControlDocumentarioFilter;
import com.dsite.dto.model.views.VwCrmFilter;
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
import com.dsite.dto.model.views.VwRendicionCajaChicaFilter;
import com.dsite.dto.model.views.VwSeguimientoActaContrataFilter;
import com.dsite.dto.model.views.VwUbigeoFilter;
import com.dsite.service.intf.VistasService;

@RestController
@RequestMapping(value = "/api/vistas")
public class VistasController {

	@Autowired 
	VistasService vistasService;	
	
	@RequestMapping(value = "/findBandejaBudget", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaBudget>> findBandejaBudget(@RequestBody VwBandejaBudgetFilter vwBandejaBudgetFilter) {
        List<VwBandejaBudget> result;
        result = vistasService.findBandejaBudget(vwBandejaBudgetFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findContratasAsignadas", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwListaContratasAsignada>> findBandejaBudget(@RequestBody VwListaContratasAsignadaFilter vwListaContratasAsignadaFilter) {
        List<VwListaContratasAsignada> result;
        result = vistasService.findContratasAsignadas(vwListaContratasAsignadaFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaCustomerService", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaCustomerService>> findBandejaCustomerService(@RequestBody VwBandejaCustomerServiceFilter vwBandejaCustomerServiceFilter) {
        List<VwBandejaCustomerService> result;
        result = vistasService.findBandejaCustomerService(vwBandejaCustomerServiceFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findCajaChicaSolicitada", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwListaCajaChica>> findCajaChicaSolicitada(@RequestBody VwListaCajaChicaFilter vwListaCajaChicaFilter) {
        List<VwListaCajaChica> result;
        result = vistasService.findCajaChicaSolicitada(vwListaCajaChicaFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBudget", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBudget>> findBudget(@RequestBody VwBudgetFilter vwBudgetFilter) {
        List<VwBudget> result;
        result = vistasService.findBudget(vwBudgetFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findLiquidacionCustomerService", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwLiquidacionCustomerService>> findLiquidacionCustomerService(@RequestBody VwLiquidacionCustomerServiceFilter vwLiquidacionCustomerServiceFilter) {
        List<VwLiquidacionCustomerService> result;
        result = vistasService.findLiquidacionCustomerService(vwLiquidacionCustomerServiceFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findListaActasContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwListaActasContrata>> findListaActasContrata(@RequestBody VwListaActasContrataFilter vwListaActasContrataFilter) {
        List<VwListaActasContrata> result;
        result = vistasService.findListaActasContrata(vwListaActasContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findListaPagosContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwListaPagosContrata>> findListaPagosContrata(@RequestBody VwListaPagosContrataFilter vwListaPagosContrataFilter) {
        List<VwListaPagosContrata> result;
        result = vistasService.findListaPagosContrata(vwListaPagosContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findOfertaCustomerService", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwOfertaCustomerService>> findOfertaCustomerService(@RequestBody VwOfertaCustomerServiceFilter vwOfertaCustomerServiceFilter) {
        List<VwOfertaCustomerService> result;
        result = vistasService.findOfertaCustomerService(vwOfertaCustomerServiceFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findUbigeo", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwUbigeo>> findUbigeo(@RequestBody VwUbigeoFilter vwUbigeoFilter) {
        List<VwUbigeo> result;
        result = vistasService.findUbigeo(vwUbigeoFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findConcursoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwConcursoContrata>> findConcursoContrata(@RequestBody VwConcursoContrataFilter vwConcursoContrataFilter) {
        List<VwConcursoContrata> result;
        result = vistasService.findConcursoContrata(vwConcursoContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaPagoAdelantoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaPagoAdelantoContrata>> findBandejaPagoAdelantoContrata() {
        List<VwBandejaPagoAdelantoContrata> result;
        result = vistasService.findBandejaPagoAdelantoContrata(null);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaAdelantoRechazadoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaAdelantoRechazadoContrata>> findBandejaAdelantoRechazadoContrata() {
        List<VwBandejaAdelantoRechazadoContrata> result;
        result = vistasService.findBandejaAdelantoRechazadoContrata(null);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaSolicitudAdelantoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaSolicitudAdelantoContrata>> findBandejaSolicitudAdelantoContrata() {
        List<VwBandejaSolicitudAdelantoContrata> result;
        result = vistasService.findBandejaSolicitudAdelantoContrata(null);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaLiquidacionContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaLiquidacionContrata>> findBandejaLiquidacionContrata() {
        List<VwBandejaLiquidacionContrata> result;
        result = vistasService.findBandejaLiquidacionContrata(null);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findSeguimientoActaContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwSeguimientoActaContrata>> findSeguimientoActaContrata(@RequestBody VwSeguimientoActaContrataFilter vwSeguimientoActaContrataFilter) {
        List<VwSeguimientoActaContrata> result;
        result = vistasService.findSeguimientoActaContrata(vwSeguimientoActaContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findAdelantoPagadoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwAdelantoPagadoContrata>> findAdelantoPagadoContrata(@RequestBody VwAdelantoPagadoContrataFilter vwAdelantoPagadoContrataFilter) {
        List<VwAdelantoPagadoContrata> result;
        result = vistasService.findAdelantoPagadoContrata(vwAdelantoPagadoContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findPagoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwPagoContrata>> findPagoContrata(@RequestBody VwPagoContrataFilter vwPagoContrataFilter) {
        List<VwPagoContrata> result;
        result = vistasService.findPagoContrata(vwPagoContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findLiquidacionContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwLiquidacionContrata>> findLiquidacionContrata(@RequestBody VwLiquidacionContrataFilter vwLiquidacionContrataFilter) {
        List<VwLiquidacionContrata> result;
        result = vistasService.findLiquidacionContrata(vwLiquidacionContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findAdelantoContrata", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwAdelantoContrata>> findAdelantoContrata(@RequestBody VwAdelantoContrataFilter vwAdelantoContrataFilter) {
        List<VwAdelantoContrata> result;
        result = vistasService.findAdelantoContrata(vwAdelantoContrataFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaCrm", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaCrm>> findBandejaCrm() {
        List<VwBandejaCrm> result;
        result = vistasService.findBandejaCrm(null);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findCrm", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwCrm>> findCrm(@RequestBody VwCrmFilter vwCrmFilter) {
        List<VwCrm> result;
        result = vistasService.findCrm(vwCrmFilter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaSolicitudCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaSolicitudCajaChica>> findBandejaSolicitudCajaChica(@RequestBody VwBandejaSolicitudCajaChicaFilter filter) {
        List<VwBandejaSolicitudCajaChica> result;
        result = vistasService.findBandejaSolicitudCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaDepositoCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaDepositoCajaChica>> findBandejaDepositoCajaChica(@RequestBody VwBandejaDepositoCajaChicaFilter filter) {
        List<VwBandejaDepositoCajaChica> result;
        result = vistasService.findBandejaDepositoCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaRendicionCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaRendicionCajaChica>> findBandejaRendicionCajaChica(@RequestBody VwBandejaRendicionCajaChicaFilter filter) {
        List<VwBandejaRendicionCajaChica> result;
        result = vistasService.findBandejaRendicionCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findRendicionCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwRendicionCajaChica>> findRendicionCajaChica(@RequestBody VwRendicionCajaChicaFilter filter) {
        List<VwRendicionCajaChica> result;
        result = vistasService.findRendicionCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findDetalleRendicionCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwDetalleRendicionCajaChica>> findDetalleRendicionCajaChica(@RequestBody VwDetalleRendicionCajaChicaFilter filter) {
        List<VwDetalleRendicionCajaChica> result;
        result = vistasService.findDetalleRendicionCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaReembolsoDescuentoCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaReembolsoDescuentoCajaChica>> findBandejaReembolsoDescuentoCajaChica(@RequestBody VwBandejaReembolsoDescuentoCajaChicaFilter filter) {
        List<VwBandejaReembolsoDescuentoCajaChica> result;
        result = vistasService.findBandejaReembolsoDescuentoCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaAprobadoCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaAprobadoCajaChica>> findBandejaAprobadoCajaChica(@RequestBody VwBandejaAprobadoCajaChicaFilter filter) {
        List<VwBandejaAprobadoCajaChica> result;
        result = vistasService.findBandejaAprobadoCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaRechazoCajaChica", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaRechazoCajaChica>> findBandejaRechazoCajaChica(@RequestBody VwBandejaRechazoCajaChicaFilter filter) {
        List<VwBandejaRechazoCajaChica> result;
        result = vistasService.findBandejaRechazoCajaChica(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaAsignacionCierreEconomico", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaAsignacionCierreEconomico>> findBandejaAsignacionCierreEconomico(@RequestBody VwBandejaAsignacionCierreEconomicoFilter filter) {
        List<VwBandejaAsignacionCierreEconomico> result;
        result = vistasService.findBandejaAsignacionCierreEconomico(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findBandejaCierreEconomico", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwBandejaCierreEconomico>> findBandejaCierreEconomico(@RequestBody VwBandejaCierreEconomicoFilter filter) {
        List<VwBandejaCierreEconomico> result;
        result = vistasService.findBandejaCierreEconomico(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findControlDocumentario", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwControlDocumentario>> findControlDocumentario(@RequestBody VwControlDocumentarioFilter filter) {
        List<VwControlDocumentario> result;
        result = vistasService.findControlDocumentario(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findDocumentosAdjuntos", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<List<VwDocumentosAdjuntos>> findDocumentosAdjuntos(@RequestBody VwDocumentosAdjuntosFilter filter) {
        List<VwDocumentosAdjuntos> result;
        result = vistasService.findDocumentosAdjuntos(filter);
        if (result == null)
            result = new ArrayList<>();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
