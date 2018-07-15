package com.dsite.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dsite.dto.model.ResumenRendicionCajaChicaDTO;
import com.dsite.service.intf.ResumenRendicionCajaChicaService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/resumenrendicioncajachica")
public class ResumenRendicionCajaChicaController {

	@Autowired
	private ResumenRendicionCajaChicaService resumenRendicionCajaChicaService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResumenRendicionCajaChicaDTO> findById(@PathVariable Integer id) {
		ResumenRendicionCajaChicaDTO resumenRendicionCajaChicaDTO;
		resumenRendicionCajaChicaDTO = resumenRendicionCajaChicaService.findById(id);
		if (ValidateUtil.isEmpty(resumenRendicionCajaChicaDTO)) {
			return new ResponseEntity<ResumenRendicionCajaChicaDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ResumenRendicionCajaChicaDTO>(resumenRendicionCajaChicaDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveObra(@RequestBody ResumenRendicionCajaChicaDTO dto, UriComponentsBuilder ucBuilder) {

		if (ValidateUtil.isEmpty(dto.getIdResumenRendicionCajaChica())) {
			resumenRendicionCajaChicaService.createResumenRendicionCajaChica(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdResumenRendicionCajaChica()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
		else {
			resumenRendicionCajaChicaService.updateResumenRendicionCajaChica(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdResumenRendicionCajaChica()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}
}
