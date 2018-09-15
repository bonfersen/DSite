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
import com.dsite.domain.model.views.VwMantenimientoContrata;
import com.dsite.domain.model.views.VwMantenimientoTablaGeneral;
import com.dsite.domain.model.views.VwMantenimientoUsuario;
import com.dsite.domain.model.views.VwOfertaCustomerService;
import com.dsite.domain.model.views.VwPagoContrata;
import com.dsite.domain.model.views.VwPanelContratas;
import com.dsite.domain.model.views.VwRendicionCajaChica;
import com.dsite.domain.model.views.VwReporteEconomico;
import com.dsite.domain.model.views.VwReporteEconomicoDetalleContrata;
import com.dsite.domain.model.views.VwReporteEconomicoExcel;
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
import com.dsite.dto.model.views.VwMantenimientoContrataFilter;
import com.dsite.dto.model.views.VwMantenimientoTablaGeneralFilter;
import com.dsite.dto.model.views.VwMantenimientoUsuarioFilter;
import com.dsite.dto.model.views.VwOfertaCustomerServiceFilter;
import com.dsite.dto.model.views.VwPagoContrataFilter;
import com.dsite.dto.model.views.VwPanelContratasFilter;
import com.dsite.dto.model.views.VwRendicionCajaChicaFilter;
import com.dsite.dto.model.views.VwReporteEconomicoDetalleContrataFilter;
import com.dsite.dto.model.views.VwReporteEconomicoExcelFilter;
import com.dsite.dto.model.views.VwReporteEconomicoFilter;
import com.dsite.dto.model.views.VwResumenRendicionCajaChicaFilter;
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
		List<VwBandejaAdelantoRechazadoContrata> vwBandejaAdelantoRechazadoContratas = vistasRepository
				.findBandejaAdelantoRechazadoContrata(vwBandejaAdelantoRechazadoContrataFilter);
		return vwBandejaAdelantoRechazadoContratas;
	}

	@Override
	public List<VwBandejaSolicitudAdelantoContrata> findBandejaSolicitudAdelantoContrata(VwBandejaSolicitudAdelantoContrataFilter vwBandejaSolicitudAdelantoContrataFilter) {
		List<VwBandejaSolicitudAdelantoContrata> vwBandejaSolicitudAdelantoContratas = vistasRepository
				.findBandejaSolicitudAdelantoContrata(vwBandejaSolicitudAdelantoContrataFilter);
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
	public List<VwLiquidacionContrata> findLiquidacionContrata(VwLiquidacionContrataFilter vwLiquidacionContrataFilter) throws IllegalAccessException {
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
	
	@Override
	public List<VwCrm> findCrmExcel(VwCrmFilter vwCrmFilter) {
		List<VwCrm> vwCrms = vistasRepository.findCrmExcel(vwCrmFilter);
		return vwCrms;
	}

	@Override
	public List<VwBandejaSolicitudCajaChica> findBandejaSolicitudCajaChica(VwBandejaSolicitudCajaChicaFilter vwBandejaSolicitudCajaChicaFilter) {
		List<VwBandejaSolicitudCajaChica> vwList = vistasRepository.findBandejaSolicitudCajaChica(vwBandejaSolicitudCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaDepositoCajaChica> findBandejaDepositoCajaChica(VwBandejaDepositoCajaChicaFilter vwBandejaDepositoCajaChicaFilter) {
		List<VwBandejaDepositoCajaChica> vwList = vistasRepository.findBandejaDepositoCajaChica(vwBandejaDepositoCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaRendicionCajaChica> findBandejaRendicionCajaChica(VwBandejaRendicionCajaChicaFilter vwBandejaRendicionCajaChicaFilter) {
		List<VwBandejaRendicionCajaChica> vwList = vistasRepository.findBandejaRendicionCajaChica(vwBandejaRendicionCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwRendicionCajaChica> findRendicionCajaChica(VwRendicionCajaChicaFilter vwRendicionCajaChicaFilter) {
		List<VwRendicionCajaChica> vwList = vistasRepository.findRendicionCajaChica(vwRendicionCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwDetalleRendicionCajaChica> findDetalleRendicionCajaChica(VwDetalleRendicionCajaChicaFilter vwDetalleRendicionCajaChicaFilter) {
		List<VwDetalleRendicionCajaChica> vwList = vistasRepository.findDetalleRendicionCajaChica(vwDetalleRendicionCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaReembolsoDescuentoCajaChica> findBandejaReembolsoDescuentoCajaChica(
			VwBandejaReembolsoDescuentoCajaChicaFilter vwBandejaReembolsoDescuentoCajaChicaFilter) {
		List<VwBandejaReembolsoDescuentoCajaChica> vwList = vistasRepository.findBandejaReembolsoDescuentoCajaChica(vwBandejaReembolsoDescuentoCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaAprobadoCajaChica> findBandejaAprobadoCajaChica(VwBandejaAprobadoCajaChicaFilter vwBandejaAprobadoCajaChicaFilter) {
		List<VwBandejaAprobadoCajaChica> vwList = vistasRepository.findBandejaAprobadoCajaChica(vwBandejaAprobadoCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaRechazoCajaChica> findBandejaRechazoCajaChica(VwBandejaRechazoCajaChicaFilter vwBandejaRechazoCajaChicaFilter) {
		List<VwBandejaRechazoCajaChica> vwList = vistasRepository.findBandejaRechazoCajaChica(vwBandejaRechazoCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaAsignacionCierreEconomico> findBandejaAsignacionCierreEconomico(VwBandejaAsignacionCierreEconomicoFilter vwBandejaAsignacionCierreEconomicoFilter) {
		List<VwBandejaAsignacionCierreEconomico> vwList = vistasRepository.findBandejaAsignacionCierreEconomico(vwBandejaAsignacionCierreEconomicoFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaCierreEconomico> findBandejaCierreEconomico(VwBandejaCierreEconomicoFilter vwBandejaCierreEconomicoFilter) {
		List<VwBandejaCierreEconomico> vwList = vistasRepository.findBandejaCierreEconomico(vwBandejaCierreEconomicoFilter);
		return vwList;
	}

	@Override
	public List<VwControlDocumentario> findControlDocumentario(VwControlDocumentarioFilter vwControlDocumentarioFilter) {
		List<VwControlDocumentario> vwList = vistasRepository.findControlDocumentario(vwControlDocumentarioFilter);
		return vwList;
	}

	@Override
	public List<VwDocumentosAdjuntos> findDocumentosAdjuntos(VwDocumentosAdjuntosFilter vwDocumentosAdjuntosFilter) {
		List<VwDocumentosAdjuntos> vwList = vistasRepository.findDocumentosAdjuntos(vwDocumentosAdjuntosFilter);
		return vwList;
	}

	@Override
	public List<VwReporteEconomico> findReporteEconomico(VwReporteEconomicoFilter vwReporteEconomicoFilter) {
		List<VwReporteEconomico> vwList = vistasRepository.findReporteEconomico(vwReporteEconomicoFilter);
		return vwList;
	}
	
	public List<VwReporteEconomicoDetalleContrata> findReporteEconomicoDetalleContrata(VwReporteEconomicoDetalleContrataFilter vwReporteEconomicoDetalleContrataFilter) {
		List<VwReporteEconomicoDetalleContrata> vwList = vistasRepository.findReporteEconomicoDetalleContrata(vwReporteEconomicoDetalleContrataFilter);
		return vwList;
	}

	@Override
	public List<VwPanelContratas> findPanelContratas(VwPanelContratasFilter vwPanelContratasFilter) {
		List<VwPanelContratas> vwList = vistasRepository.findPanelContratas(vwPanelContratasFilter);
		return vwList;
	}

	@Override
	public List<VwDepositosViatico> findDepositosViatico(VwDepositosViaticoFilter vwDepositosViaticoFilter) {
		List<VwDepositosViatico> vwList = vistasRepository.findDepositosViatico(vwDepositosViaticoFilter);
		return vwList;
	}

	@Override
	public List<VwDepositosCaja> findDepositosCaja(VwDepositosCajaFilter vwDepositosCajaFilter) {
		List<VwDepositosCaja> vwList = vistasRepository.findDepositosCaja(vwDepositosCajaFilter);
		return vwList;
	}

	@Override
	public List<VwResumenRendicionCajaChica> findResumenRendicionCajaChica(VwResumenRendicionCajaChicaFilter vwResumenRendicionCajaChicaFilter) {
		List<VwResumenRendicionCajaChica> vwList = vistasRepository.findResumenRendicionCajaChica(vwResumenRendicionCajaChicaFilter);
		return vwList;
	}

	@Override
	public List<VwBandejaSolicitudRendicion> findBandejaSolicitudRendicion(VwBandejaSolicitudRendicionFilter filter) {
		List<VwBandejaSolicitudRendicion> vwList = vistasRepository.findBandejaSolicitudRendicion(filter);
		return vwList;
	}

	@Override
	public List<VwReporteEconomicoExcel> findReporteEconomicoExcel(VwReporteEconomicoExcelFilter filter) {
		List<VwReporteEconomicoExcel> vwList = vistasRepository.findReporteEconomicoExcel(filter);
		return vwList;
	}

	@Override
	public List<VwMantenimientoContrata> findMantenimientoContrata(VwMantenimientoContrataFilter filter) {
		List<VwMantenimientoContrata> vwList = vistasRepository.findMantenimientoContrata(filter);
		return vwList;
	}

	@Override
	public List<VwMantenimientoUsuario> findMantenimientoUsuario(VwMantenimientoUsuarioFilter filter) {
		List<VwMantenimientoUsuario> vwList = vistasRepository.findMantenimientoUsuario(filter);
		return vwList;
	}

	@Override
	public List<VwMantenimientoTablaGeneral> findMantenimientoTablaGeneral(VwMantenimientoTablaGeneralFilter filter) {
		List<VwMantenimientoTablaGeneral> vwList = vistasRepository.findMantenimientoTablaGeneral(filter);
		return vwList;
	}
}
