package com.dsite.domain.model.repository.jdbc;

import java.util.List;

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

public interface VistasRepository {

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
	
	List<VwBandejaSolicitudCajaChica> findBandejaSolicitudCajaChica(VwBandejaSolicitudCajaChicaFilter vwBandejaSolicitudCajaChicaFilter);
	
	List<VwBandejaDepositoCajaChica> findBandejaDepositoCajaChica(VwBandejaDepositoCajaChicaFilter vwBandejaDepositoCajaChicaFilter);
	
	List<VwBandejaRendicionCajaChica> findBandejaRendicionCajaChica(VwBandejaRendicionCajaChicaFilter vwBandejaRendicionCajaChicaFilter);
	
	List<VwRendicionCajaChica> findRendicionCajaChica(VwRendicionCajaChicaFilter vwRendicionCajaChicaFilter);
	
	List<VwDetalleRendicionCajaChica> findDetalleRendicionCajaChica(VwDetalleRendicionCajaChicaFilter vwDetalleRendicionCajaChicaFilter);
	
	List<VwBandejaReembolsoDescuentoCajaChica> findBandejaReembolsoDescuentoCajaChica(VwBandejaReembolsoDescuentoCajaChicaFilter vwBandejaReembolsoDescuentoCajaChicaFilter);
	
	List<VwBandejaAprobadoCajaChica> findBandejaAprobadoCajaChica(VwBandejaAprobadoCajaChicaFilter vwBandejaAprobadoCajaChicaFilter);
	
	List<VwBandejaRechazoCajaChica> findBandejaRechazoCajaChica(VwBandejaRechazoCajaChicaFilter vwBandejaRechazoCajaChicaFilter);
	
	List<VwBandejaAsignacionCierreEconomico> findBandejaAsignacionCierreEconomico(VwBandejaAsignacionCierreEconomicoFilter vwBandejaAsignacionCierreEconomicoFilter);
	
	List<VwBandejaCierreEconomico> findBandejaCierreEconomico(VwBandejaCierreEconomicoFilter vwBandejaCierreEconomicoFilter);
	
	List<VwControlDocumentario> findControlDocumentario(VwControlDocumentarioFilter vwControlDocumentarioFilter);
	
	List<VwDocumentosAdjuntos> findDocumentosAdjuntos(VwDocumentosAdjuntosFilter vwDocumentosAdjuntosFilter);
	
	List<VwReporteEconomico> findReporteEconomico(VwReporteEconomicoFilter vwReporteEconomicoFilter);

	List<VwReporteEconomicoDetalleContrata> findReporteEconomicoDetalleContrata(VwReporteEconomicoDetalleContrataFilter vwReporteEconomicoDetalleContrataFilter);
	
	List<VwPanelContratas> findPanelContratas(VwPanelContratasFilter vwPanelContratasFilter);
	
	List<VwDepositosViatico> findDepositosViatico(VwDepositosViaticoFilter vwDepositosViaticoFilter);
	
	List<VwDepositosCaja> findDepositosCaja(VwDepositosCajaFilter vwDepositosCajaFilter);
	
	List<VwResumenRendicionCajaChica> findResumenRendicionCajaChica(VwResumenRendicionCajaChicaFilter vwResumenRendicionCajaChicaFilter);
	
	List<VwBandejaSolicitudRendicion> findBandejaSolicitudRendicion(VwBandejaSolicitudRendicionFilter vwBandejaSolicitudRendicionFilter);
}
