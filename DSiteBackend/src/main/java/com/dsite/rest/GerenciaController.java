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

import com.dsite.dto.model.GerenciaDTO;
import com.dsite.service.intf.GerenciaService;
import com.dsite.util.ValidateUtil;

//Internamente se usa la libreria jackson para devolver un JSON
//anotacion exclusiva para rest (exponer y consumir JSON)
@RestController
@RequestMapping(value = "/api/gerencia")
public class GerenciaController {

	@Autowired
	private GerenciaService gerenciaService;

	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GerenciaDTO>> findAll() {
		List<GerenciaDTO> gerencias = gerenciaService.findAllGerencias();
		if (gerencias.isEmpty()) {
			return new ResponseEntity<List<GerenciaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<GerenciaDTO>>(gerencias, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<GerenciaDTO> findById(@PathVariable Integer id) {
		GerenciaDTO gerenciaDTO;
		gerenciaDTO = gerenciaService.findById(id);
		if (ValidateUtil.isEmpty(gerenciaDTO)) {
			return new ResponseEntity<GerenciaDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<GerenciaDTO>(gerenciaDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> createGerencia(@RequestBody GerenciaDTO dto, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando Gerencia " + dto.getNombre());

		if (gerenciaService.isGerenciaExist(dto)) {
			System.out.println("La gerencia de nombre " + dto.getNombre() + " ya existe");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		gerenciaService.saveGerencia(dto);
		// Delvover el id generado con ucBuilder, exponiendo una URL
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/gerencia/{id}").buildAndExpand(dto.getIdGerencia()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GerenciaDTO> updateGerencia(@PathVariable("id") int id, @RequestBody GerenciaDTO gerencia) {
		System.out.println("Actualizando Gerencia Id " + id);

		// La validacion del empleado debe ir en el service
		GerenciaDTO currentGerencia = gerenciaService.findById(id);

		if (currentGerencia == null) {
			System.out.println("La gerencia con el id " + id + " no se encuentra");
			return new ResponseEntity<GerenciaDTO>(HttpStatus.NOT_FOUND);
		}

		currentGerencia.setNombre(gerencia.getNombre());

		gerenciaService.updateGerencia(currentGerencia);
		return new ResponseEntity<GerenciaDTO>(currentGerencia, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GerenciaDTO> deleteGerencia(@PathVariable("id") int id) {
		System.out.println("Eliminado Gerencia con Id " + id);

		GerenciaDTO dto = gerenciaService.findById(id);
		if (dto == null) {
			System.out.println("No se puede eliminar. La gerencia con " + id + " no se encuentra");
			return new ResponseEntity<GerenciaDTO>(HttpStatus.NOT_FOUND);
		}

		gerenciaService.deleteGerenciaById(id);
		return new ResponseEntity<GerenciaDTO>(HttpStatus.NO_CONTENT);
	}
}
