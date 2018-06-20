package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.CierreEconomicoObraDTO;

public interface CierreEconomicoObraRepository {

	List<CierreEconomicoObraDTO> findCierreEconomicoObraByCriteria(CierreEconomicoObraDTO cierreEconomicoObraDTO);
}
