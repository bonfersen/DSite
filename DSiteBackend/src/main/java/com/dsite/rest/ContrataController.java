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

import com.dsite.dto.model.ContrataDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.ContrataService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/contrata")
public class ContrataController {

	@Autowired
	private ContrataService contrataService;
	
	@RequestMapping(value = "/find/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContrataDTO>> listAllContratas() {
        List<ContrataDTO> contratasDTO = contrataService.findAllContratas();
        if (ValidateUtil.isEmpty(contratasDTO)) {
            return new ResponseEntity<List<ContrataDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ContrataDTO>>(contratasDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<ContrataDTO> findById(@PathVariable Integer id) {
		ContrataDTO contrataDTO;
		contrataDTO = contrataService.findById(id);
		if (ValidateUtil.isEmpty(contrataDTO)) {
			return new ResponseEntity<ContrataDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ContrataDTO>(contrataDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveContrata(@RequestBody ContrataDTO dto, UriComponentsBuilder ucBuilder) {

		if (ValidateUtil.isEmpty(dto.getIdContrata())) {
			contrataService.createContrata(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdContrata()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		else {
			contrataService.updateContrata(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdContrata()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<NotificacionDTO> deleteContrata(@PathVariable Integer id) {
		NotificacionDTO notificacion = null;
		notificacion = contrataService.deleteContrataById(id);
		return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
	}
}
