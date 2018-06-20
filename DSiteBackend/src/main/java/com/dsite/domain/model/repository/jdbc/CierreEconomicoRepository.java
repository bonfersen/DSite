package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.CierreEconomicoDTO;

interface CierreEconomicoRepository {

	List<CierreEconomicoDTO> findCierreEconomicoByCriteria(CierreEconomicoDTO cierreEconomicoDTO);
}
