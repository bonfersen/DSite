package com.dsite.service.intf;

import java.util.List;

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

public interface VistasService {

	List<VwBandejaBudget> findBandejaBudget(VwBandejaBudgetFilter vwbandejaBudgetFilter);
	
	List<VwListaContratasAsignada> findContratasAsignadas(VwListaContratasAsignadaFilter vwListaContratasAsignadaFilter);
	
	List<VwBandejaCustomerService> findBandejaCustomerService(VwBandejaCustomerServiceFilter vwBandejaCustomerServiceFilter);
	
	List<VwListaCajaChica> findCajaChicaSolicitada(VwListaCajaChicaFilter vwListaCajaChicaFilter);
	
	List<VwBudget> findBudget(VwBudgetFilter vwBudgetFilter);
	
	List<VwLiquidacionCustomerService> findLiquidacionCustomerService(VwLiquidacionCustomerServiceFilter vwLiquidacionCustomerServiceFilter);
	
	List<VwListaActasContrata> findListaActasContrata(VwListaActasContrataFilter vwListaActasContrataFilter);
	
	List<VwListaPagosContrata> findListaPagosContrata(VwListaPagosContrataFilter vwListaPagosContrataFilter);
	
	List<VwOfertaCustomerService> findOfertaCustomerService(VwOfertaCustomerServiceFilter vwOfertaCustomerServiceFilter);
	
	List<VwUbigeo> findUbigeo(VwUbigeoFilter vwUbigeoFilter);
	
	List<VwConcursoContrata> findConcursoContrata(VwConcursoContrataFilter vwConcursoContrataFilter);
	
	List<VwBandejaPagoAdelantoContrata> findBandejaPagoAdelantoContrata(VwBandejaPagoAdelantoContrataFilter vwBandejaPagoAdelantoContrataFilter);
	
	List<VwBandejaAdelantoRechazadoContrata> findBandejaAdelantoRechazadoContrata(VwBandejaAdelantoRechazadoContrataFilter vwBandejaAdelantoRechazadoContrataFilter);
	
	List<VwBandejaSolicitudAdelantoContrata> findBandejaSolicitudAdelantoContrata(VwBandejaSolicitudAdelantoContrataFilter vwBandejaSolicitudAdelantoContrataFilter);
	
	List<VwBandejaLiquidacionContrata> findBandejaLiquidacionContrata(VwBandejaLiquidacionContrataFilter vwBandejaLiquidacionContrataFilter);
	
	List<VwSeguimientoActaContrata> findSeguimientoActaContrata(VwSeguimientoActaContrataFilter vwSeguimientoActaContrataFilter);
	
	List<VwAdelantoPagadoContrata> findAdelantoPagadoContrata(VwAdelantoPagadoContrataFilter vwAdelantoPagadoContrataFilter);
	
	List<VwPagoContrata> findPagoContrata(VwPagoContrataFilter vwPagoContrataFilter);
	
	List<VwLiquidacionContrata> findLiquidacionContrata(VwLiquidacionContrataFilter vwLiquidacionContrataFilter);
	
	List<VwAdelantoContrata> findAdelantoContrata(VwAdelantoContrataFilter vwAdelantoContrataFilter);
	
	List<VwBandejaCrm> findBandejaCrm(VwBandejaCrmFilter vwBandejaCrmFilter);
	
	List<VwCrm> findCrm(VwCrmFilter vwCrmFilter);
}
