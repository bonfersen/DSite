package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.domain.model.repository.jdbc.VistasRepository;
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
import com.dsite.service.intf.VistasService;

@Service
public class VistasServiceImpl implements VistasService {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	VistasRepository vistasRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public List<VwBandejaBudget> findBandejaBudget(VwBandejaBudgetFilter vwbandejaBudgetFilter) {
		List<VwBandejaBudget> vwBandejaBudgets = vistasRepository.findBandejaBudget(vwbandejaBudgetFilter);		
		return vwBandejaBudgets;
	}

	@Override
	public List<VwListaContratasAsignada> findContratasAsignadas(VwListaContratasAsignadaFilter vwListaContratasAsignadaFilter) {
		List<VwListaContratasAsignada> vwListaContratasAsignadas = vistasRepository.findContratasAsignadas(vwListaContratasAsignadaFilter);
		return vwListaContratasAsignadas;
	}

	@Override
	public List<VwBandejaCustomerService> findBandejaCustomerService(VwBandejaCustomerServiceFilter vwBandejaCustomerServiceFilter) {
		List<VwBandejaCustomerService> vwBandejaCustomerService = vistasRepository.findBandejaCustomerService(vwBandejaCustomerServiceFilter);
		return vwBandejaCustomerService;
	}

	@Override
	public List<VwListaCajaChica> findCajaChicaSolicitada(VwListaCajaChicaFilter vwListaCajaChicaFilter) {
		List<VwListaCajaChica> vwListaCajaChica = vistasRepository.findCajaChicaSolicitada(vwListaCajaChicaFilter);
		return vwListaCajaChica;
	}

	@Override
	public List<VwBudget> findBudget(VwBudgetFilter vwBudgetFilter) {
		List<VwBudget> vwBudget = vistasRepository.findBudget(vwBudgetFilter);
		return vwBudget;
	}

	@Override
	public List<VwLiquidacionCustomerService> findLiquidacionCustomerService(VwLiquidacionCustomerServiceFilter vwLiquidacionCustomerServiceFilter) {
		List<VwLiquidacionCustomerService> vwLiquidacionCustomerServices = vistasRepository.findLiquidacionCustomerService(vwLiquidacionCustomerServiceFilter);
		return vwLiquidacionCustomerServices;
	}

	@Override
	public List<VwListaActasContrata> findListaActasContrata(VwListaActasContrataFilter vwListaActasContrataFilter) {
		List<VwListaActasContrata> vwListaActasContratas = vistasRepository.findListaActasContrata(vwListaActasContrataFilter);
		return vwListaActasContratas;
	}

	@Override
	public List<VwListaPagosContrata> findListaPagosContrata(VwListaPagosContrataFilter vwListaPagosContrataFilter) {
		List<VwListaPagosContrata> vwListaPagosContratas = vistasRepository.findListaPagosContrata(vwListaPagosContrataFilter);
		return vwListaPagosContratas;
	}

	@Override
	public List<VwOfertaCustomerService> findOfertaCustomerService(VwOfertaCustomerServiceFilter vwOfertaCustomerServiceFilter) {
		List<VwOfertaCustomerService> vwOfertaCustomerServices = vistasRepository.findOfertaCustomerService(vwOfertaCustomerServiceFilter);
		return vwOfertaCustomerServices;
	}

	@Override
	public List<VwUbigeo> findUbigeo(VwUbigeoFilter vwUbigeoFilter) {
		List<VwUbigeo> vwUbigeos = vistasRepository.findUbigeo(vwUbigeoFilter);
		return vwUbigeos;
	}

	@Override
	public List<VwConcursoContrata> findConcursoContrata(VwConcursoContrataFilter vwConcursoContrataFilter) {
		List<VwConcursoContrata> vwConcursoContratas = vistasRepository.findConcursoContrata(vwConcursoContrataFilter);
		return vwConcursoContratas;
	}

	@Override
	public List<VwBandejaPagoAdelantoContrata> findBandejaPagoAdelantoContrata(VwBandejaPagoAdelantoContrataFilter vwBandejaPagoAdelantoContrataFilter) {
		List<VwBandejaPagoAdelantoContrata> vwBandejaPagoAdelantoContratas = vistasRepository.findBandejaPagoAdelantoContrata(vwBandejaPagoAdelantoContrataFilter);
		return vwBandejaPagoAdelantoContratas;
	}

	@Override
	public List<VwBandejaAdelantoRechazadoContrata> findBandejaAdelantoRechazadoContrata(VwBandejaAdelantoRechazadoContrataFilter vwBandejaAdelantoRechazadoContrataFilter) {
		List<VwBandejaAdelantoRechazadoContrata> vwBandejaAdelantoRechazadoContratas = vistasRepository.findBandejaAdelantoRechazadoContrata(vwBandejaAdelantoRechazadoContrataFilter);
		return vwBandejaAdelantoRechazadoContratas;
	}

	@Override
	public List<VwBandejaSolicitudAdelantoContrata> findBandejaSolicitudAdelantoContrata(VwBandejaSolicitudAdelantoContrataFilter vwBandejaSolicitudAdelantoContrataFilter) {
		List<VwBandejaSolicitudAdelantoContrata> vwBandejaSolicitudAdelantoContratas = vistasRepository.findBandejaSolicitudAdelantoContrata(vwBandejaSolicitudAdelantoContrataFilter);
		return vwBandejaSolicitudAdelantoContratas;
	}

	@Override
	public List<VwBandejaLiquidacionContrata> findBandejaLiquidacionContrata(VwBandejaLiquidacionContrataFilter vwBandejaLiquidacionContrataFilter) {
		List<VwBandejaLiquidacionContrata> vwBandejaLiquidacionContratas = vistasRepository.findBandejaLiquidacionContrata(vwBandejaLiquidacionContrataFilter);
		return vwBandejaLiquidacionContratas;
	}

	@Override
	public List<VwSeguimientoActaContrata> findSeguimientoActaContrata(VwSeguimientoActaContrataFilter vwSeguimientoActaContrataFilter) {
		List<VwSeguimientoActaContrata> vwSeguimientoActaContratas = vistasRepository.findSeguimientoActaContrata(vwSeguimientoActaContrataFilter);
		return vwSeguimientoActaContratas;
	}

	@Override
	public List<VwAdelantoPagadoContrata> findAdelantoPagadoContrata(VwAdelantoPagadoContrataFilter vwAdelantoPagadoContrataFilter) {
		List<VwAdelantoPagadoContrata> vwAdelantoPagadoContratas = vistasRepository.findAdelantoPagadoContrata(vwAdelantoPagadoContrataFilter);
		return vwAdelantoPagadoContratas;
	}

	@Override
	public List<VwPagoContrata> findPagoContrata(VwPagoContrataFilter vwPagoContrataFilter) {
		List<VwPagoContrata> vwPagoContratas = vistasRepository.findPagoContrata(vwPagoContrataFilter);
		return vwPagoContratas;
	}

	@Override
	public List<VwLiquidacionContrata> findLiquidacionContrata(VwLiquidacionContrataFilter vwLiquidacionContrataFilter) {
		List<VwLiquidacionContrata> vwLiquidacionContratas = vistasRepository.findLiquidacionContrata(vwLiquidacionContrataFilter);
		return vwLiquidacionContratas;
	}

	@Override
	public List<VwAdelantoContrata> findAdelantoContrata(VwAdelantoContrataFilter vwAdelantoContrataFilter) {
		List<VwAdelantoContrata> vwAdelantoContratas = vistasRepository.findAdelantoContrata(vwAdelantoContrataFilter);
		return vwAdelantoContratas;
	}

	@Override
	public List<VwBandejaCrm> findBandejaCrm(VwBandejaCrmFilter vwBandejaCrmFilter) {
		List<VwBandejaCrm> vwBandejaCrms = vistasRepository.findBandejaCrm(vwBandejaCrmFilter);
		return vwBandejaCrms;
	}

	@Override
	public List<VwCrm> findCrm(VwCrmFilter vwCrmFilter) {
		List<VwCrm> vwCrms = vistasRepository.findCrm(vwCrmFilter);
		return vwCrms;
	}
}
