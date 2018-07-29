package com.dsite.service.intf;

import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.UsuarioDTO;

public interface UsuarioService {

	UsuarioDTO findById(int id);
	
	EmpleadoDTO loginUsuario(UsuarioDTO usuarioDTO);
}
