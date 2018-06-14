package com.dsite.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dsite.dto.model.JsonResult;
import com.dsite.dto.model.ObraDTO;
import com.dsite.service.intf.ObraService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/obra")
public class ObraController {

	@Autowired
	private ObraService obraService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<ObraDTO> findById(@PathVariable Integer id) {
		ObraDTO ObraDTO;
		ObraDTO = obraService.findById(id);
		if (ValidateUtil.isEmpty(ObraDTO)) {
			return new ResponseEntity<ObraDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ObraDTO>(ObraDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/findCodDSite/{codDSite}", method = RequestMethod.GET)
	public ResponseEntity<ObraDTO> findById(@PathVariable String codDSite) {
		ObraDTO ObraDTO;
		ObraDTO = obraService.findByCodigoDSite(codDSite);
		if (ValidateUtil.isEmpty(ObraDTO)) {
			return new ResponseEntity<ObraDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ObraDTO>(ObraDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> saveObra(@RequestBody ObraDTO dto, UriComponentsBuilder ucBuilder) {
		JsonResult jsonResult = null;

		if (ValidateUtil.isEmpty(dto.getIdObra())) {
			jsonResult = obraService.createObra(dto);
			return new ResponseEntity<JsonResult>(jsonResult, HttpStatus.OK);
		} else {
			jsonResult = obraService.updateObra(dto);
			return new ResponseEntity<JsonResult>(jsonResult, HttpStatus.OK);
		}

	}
}
