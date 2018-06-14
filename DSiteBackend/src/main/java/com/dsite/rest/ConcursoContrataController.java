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

import com.dsite.dto.model.ConcursoContrataDTO;
import com.dsite.service.intf.ConcursoContrataService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/concursocontrata")
public class ConcursoContrataController {

	@Autowired
	private ConcursoContrataService concursoContrataService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<ConcursoContrataDTO> findById(@PathVariable Integer id) {
		ConcursoContrataDTO concursoContrataDTO;
		concursoContrataDTO = concursoContrataService.findById(id);
		if (ValidateUtil.isEmpty(concursoContrataDTO)) {
			return new ResponseEntity<ConcursoContrataDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ConcursoContrataDTO>(concursoContrataDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveObra(@RequestBody ConcursoContrataDTO dto, UriComponentsBuilder ucBuilder) {
		
		if (ValidateUtil.isEmpty(dto.getIdConcursoContrata())) {
			concursoContrataService.createConcursoContrata(dto);
			// Delvover el id generado con ucBuilder, exponiendo una URL
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdConcursoContrata()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} else {
			concursoContrataService.updateConcursoContrata(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdConcursoContrata()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}

	}
}
