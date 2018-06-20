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

import com.dsite.dto.model.CierreEconomicoObraDTO;
import com.dsite.service.intf.CierreEconomicoObraService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/cierreEconomicoObra")
public class CierreEconomicoObraController {

	@Autowired
	private CierreEconomicoObraService cierreEconomicoObraService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<CierreEconomicoObraDTO> findById(@PathVariable Integer id) {
		CierreEconomicoObraDTO dto;
		dto = cierreEconomicoObraService.findById(id);
		if (ValidateUtil.isEmpty(dto)) {
			return new ResponseEntity<CierreEconomicoObraDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CierreEconomicoObraDTO>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCierreEconomicoObra(@RequestBody CierreEconomicoObraDTO dto, UriComponentsBuilder ucBuilder) {
		
		if (ValidateUtil.isEmpty(dto.getIdCierreEconomicoObra())) {
			cierreEconomicoObraService.createCierreEconomicoObra(dto);
			// Delvover el id generado con ucBuilder, exponiendo una URL
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdCierreEconomicoObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} else {
			cierreEconomicoObraService.updateCierreEconomicoObra(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdCierreEconomicoObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}
}
