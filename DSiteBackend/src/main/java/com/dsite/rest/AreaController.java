package com.dsite.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsite.dto.model.AreaDTO;
import com.dsite.service.intf.AreaService;

@RestController
@RequestMapping(value = "/api/area")
public class AreaController {
	
	@Autowired
	AreaService areaService;

	@RequestMapping(value = "/findByGerencia/{idGerencia}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AreaDTO>> findAreaByCriteria(@PathVariable Integer idGerencia) {
		AreaDTO dto = new AreaDTO();
		dto.setIdGerencia(idGerencia);
        List<AreaDTO> areasDTO = areaService.findAreaByCriteria(dto);
        return new ResponseEntity<List<AreaDTO>>(areasDTO, HttpStatus.OK);
    }
}
