package com.dsite.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsite.dto.model.JsonResult;
import com.dsite.dto.model.RendicionCajaChicaDTO;
import com.dsite.dto.model.RendicionesAsignadasDTO;
import com.dsite.service.intf.RendicionCajaChicaService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/rendicioncajachica")
public class RendicionCajaChicaController {

	@Autowired
	private RendicionCajaChicaService rendicionCajaChicaService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<RendicionCajaChicaDTO> findById(@PathVariable Integer id) {
		RendicionCajaChicaDTO rendicionCajaChicaDTO;
		rendicionCajaChicaDTO = rendicionCajaChicaService.findById(id);
		if (ValidateUtil.isEmpty(rendicionCajaChicaDTO)) {
			return new ResponseEntity<RendicionCajaChicaDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RendicionCajaChicaDTO>(rendicionCajaChicaDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/asignarRendicion/", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> asignarRendicion(@RequestBody RendicionesAsignadasDTO rendiciones) {
		JsonResult jsonResult = null;

		if (ValidateUtil.isNotEmpty(rendiciones)) {
			jsonResult = rendicionCajaChicaService.asignarRendicion(rendiciones);
			return new ResponseEntity<JsonResult>(jsonResult, HttpStatus.OK);
		}
		return new ResponseEntity<JsonResult>(jsonResult, HttpStatus.NO_CONTENT);
	}
}
