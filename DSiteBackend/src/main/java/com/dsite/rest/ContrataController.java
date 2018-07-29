package com.dsite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsite.dto.model.ContrataDTO;
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
}
