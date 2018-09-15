package com.dsite.domain.model.repository.jdbc;

import java.util.List;

import com.dsite.dto.model.UsuarioDTO;

public interface UsuarioRepository {

	List<UsuarioDTO> findUsuarioByCriteria(UsuarioDTO dto);
}
