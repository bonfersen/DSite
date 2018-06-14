package com.dsite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<Void> saveEmpleado(@RequestBody EmpleadoDTO dto, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando Empleado " + dto.getNombre());

		if (empleadoService.isEmpleadoExist(dto)) {
			System.out.println("La empleado de nombre " + dto.getNombre() + " ya existe");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		empleadoService.saveEmpleado(dto);
		// Delvover el id generado con ucBuilder, exponiendo una URL
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/save/").buildAndExpand(dto.getIdEmpleado()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EmpleadoDTO> updateUser(@PathVariable("id") int id, @RequestBody EmpleadoDTO empleadoDTO) {
		System.out.println("Actualizando Empleado Id " + id);

		// La validacion del empleado debe ir en el service
		EmpleadoDTO currentEmpleado = empleadoService.findById(id);
		if (currentEmpleado == null) {
			System.out.println("El empleado con el id " + id + " no se encuentra");
			return new ResponseEntity<EmpleadoDTO>(HttpStatus.NOT_FOUND);
		}

		empleadoService.updateEmpleado(empleadoDTO);
		return new ResponseEntity<EmpleadoDTO>(currentEmpleado, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmpleadoDTO> deleteUser(@PathVariable("id") int id) {
		System.out.println("Eliminado Empleado con Id " + id);

		EmpleadoDTO dto = empleadoService.findById(id);
		if (dto == null) {
			System.out.println("No se puede eliminar. La empleado con " + id + " no se encuentra");
			return new ResponseEntity<EmpleadoDTO>(HttpStatus.NOT_FOUND);
		}

		empleadoService.deleteEmpleadoById(id);
		return new ResponseEntity<EmpleadoDTO>(HttpStatus.NO_CONTENT);
	}
}
