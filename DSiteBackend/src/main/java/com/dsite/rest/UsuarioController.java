package com.dsite.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.UsuarioDTO;
import com.dsite.service.intf.UsuarioService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
		UsuarioDTO usuarioDTO;
		usuarioDTO = usuarioService.findById(id);
		if (ValidateUtil.isEmpty(usuarioDTO)) {
			return new ResponseEntity<UsuarioDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginUsuario/", method = RequestMethod.POST)
	public ResponseEntity<EmpleadoDTO> loginUsuario(@RequestBody UsuarioDTO dto, UriComponentsBuilder ucBuilder) {
		System.out.println("Validando Usuario " + dto.getCuentaUsuario());
		EmpleadoDTO empleadoDTO = usuarioService.loginUsuario(dto);
		if (ValidateUtil.isEmpty(empleadoDTO)) {
			return new ResponseEntity<EmpleadoDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EmpleadoDTO>(empleadoDTO, HttpStatus.OK);
	}
}
