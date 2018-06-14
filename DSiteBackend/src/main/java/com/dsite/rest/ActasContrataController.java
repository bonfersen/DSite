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

import com.dsite.dto.model.ActasContrataDTO;
import com.dsite.service.intf.ActasContrataService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/actascontrata")
public class ActasContrataController {

	@Autowired
	private ActasContrataService actasContrataService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<ActasContrataDTO> findById(@PathVariable Integer id) {
		ActasContrataDTO actasContrataDTO;
		actasContrataDTO = actasContrataService.findById(id);
		if (ValidateUtil.isEmpty(actasContrataDTO)) {
			return new ResponseEntity<ActasContrataDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ActasContrataDTO>(actasContrataDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveActasContrata(@RequestBody ActasContrataDTO dto, UriComponentsBuilder ucBuilder) {
		
		if (ValidateUtil.isEmpty(dto.getIdActasContrata())) {
			actasContrataService.createActasContrata(dto);
			// Delvover el id generado con ucBuilder, exponiendo una URL
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdActasContrata()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} else {
			actasContrataService.updateActasContrata(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdActasContrata()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}

	}
}
