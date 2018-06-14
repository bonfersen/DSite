package com.dsite.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dsite.dto.model.PresupuestoObraDTO;
import com.dsite.service.intf.PresupuestoObraService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/presupuestoobra")
public class PresupuestoObraController {

	@Autowired
	private PresupuestoObraService presupuestoObraService;

	/*@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<ObraDTO> findById(@PathVariable Integer id) {
		ObraDTO ObraDTO;
		ObraDTO = obraService.findById(id);
		if (ValidateUtil.isEmpty(ObraDTO)) {
			return new ResponseEntity<ObraDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ObraDTO>(ObraDTO, HttpStatus.OK);
	}*/

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveObra(@RequestBody PresupuestoObraDTO dto, UriComponentsBuilder ucBuilder) {
		
		if (ValidateUtil.isEmpty(dto.getIdPresupuestoObra())) {
			presupuestoObraService.createPresupuestoObra(dto);
			// Delvover el id generado con ucBuilder, exponiendo una URL
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdPresupuestoObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} else {
			presupuestoObraService.updatePresupuestoObra(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdPresupuestoObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}

	}
}
