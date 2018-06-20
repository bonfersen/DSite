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

import com.dsite.dto.model.CierreEconomicoDTO;
import com.dsite.service.intf.CierreEconomicoService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/cierreEconomico")
public class CierreEconomicoController {

	@Autowired
	private CierreEconomicoService cierreEconomicoService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<CierreEconomicoDTO> findById(@PathVariable Integer id) {
		CierreEconomicoDTO dto;
		dto = cierreEconomicoService.findById(id);
		if (ValidateUtil.isEmpty(dto)) {
			return new ResponseEntity<CierreEconomicoDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CierreEconomicoDTO>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCierreEconomico(@RequestBody CierreEconomicoDTO dto, UriComponentsBuilder ucBuilder) {
		
		if (ValidateUtil.isEmpty(dto.getIdCierreEconomico())) {
			cierreEconomicoService.createCierreEconomico(dto);
			// Delvover el id generado con ucBuilder, exponiendo una URL
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdCierreEconomico()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} else {
			cierreEconomicoService.updateCierreEconomico(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdCierreEconomico()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}
}
