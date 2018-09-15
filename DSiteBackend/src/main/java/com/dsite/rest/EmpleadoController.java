package com.dsite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.EmpleadoService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoDTO>> findAll() {
		List<EmpleadoDTO> empleados = empleadoService.findAllEmpleados();
		if (empleados.isEmpty()) {
			return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpleadoDTO>>(empleados, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findResponsableObra", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoDTO>> findResponsableObra() {
		List<EmpleadoDTO> empleados = empleadoService.findResponsableObra();
		if (empleados.isEmpty()) {
			return new ResponseEntity<List<EmpleadoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpleadoDTO>>(empleados, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmpleadoDTO> findById(@PathVariable Integer id) {
		EmpleadoDTO empleadoDTO;
		empleadoDTO = empleadoService.findById(id);
		if (ValidateUtil.isEmpty(empleadoDTO)) {
			return new ResponseEntity<EmpleadoDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<EmpleadoDTO>(empleadoDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<NotificacionDTO> saveEmpleado(@RequestBody EmpleadoDTO dto, UriComponentsBuilder ucBuilder) {
		NotificacionDTO notificacion = null;

		if (ValidateUtil.isEmpty(dto.getIdEmpleado())) {
			notificacion = empleadoService.createEmpleado(dto);
			return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
		}
		else {
			notificacion = empleadoService.updateEmpleado(dto);
			return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
		}
	}
}
