package com.dsite.service.intf;

import com.dsite.domain.model.entities.Usuario;
import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.UsuarioDTO;

public interface UsuarioService {

	UsuarioDTO findById(int id);
	
	EmpleadoDTO loginUsuario(UsuarioDTO usuarioDTO);
	
	Usuario createUsuario(UsuarioDTO usuarioDTO);
	
	void updateUsuario(UsuarioDTO usuarioDTO);
}
