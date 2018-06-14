package com.dsite.service.intf;

import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.UsuarioDTO;

public interface UsuarioService {

	UsuarioDTO findById(int id);
	
	EmpleadoDTO loginUsuario(UsuarioDTO usuarioDTO);
	
	void saveUsuario(UsuarioDTO usuario);
	
	void updateUsuario(UsuarioDTO usuario);
	
	void deleteUsuarioById(long id);

	public boolean isUsuarioExist(UsuarioDTO usuario);
}
