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

import com.dsite.dto.model.RendicionDTO;
import com.dsite.service.intf.RendicionService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/rendicion")
public class RendicionController {

	@Autowired
	private RendicionService rendicionService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<RendicionDTO> findById(@PathVariable Integer id) {
		RendicionDTO rendicionDTO;
		rendicionDTO = rendicionService.findById(id);
		if (ValidateUtil.isEmpty(rendicionDTO)) {
			return new ResponseEntity<RendicionDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<RendicionDTO>(rendicionDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveObra(@RequestBody RendicionDTO dto, UriComponentsBuilder ucBuilder) {

		if (ValidateUtil.isEmpty(dto.getIdRendicion())) {
			rendicionService.createRendicion(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdRendicion()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
		else {
			rendicionService.updateRendicion(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdRendicion()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}
}
