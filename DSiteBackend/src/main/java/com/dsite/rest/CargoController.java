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

import com.dsite.dto.model.CargoDTO;
import com.dsite.service.intf.CargoService;

@RestController
@RequestMapping(value = "/api/cargo")
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@RequestMapping(value = "/findByArea/{idArea}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CargoDTO>> findCargoByCriteria(@PathVariable Integer idArea) {
		CargoDTO cargoDTO = new CargoDTO();
		cargoDTO.setIdArea(idArea);
        List<CargoDTO> cargosDTO = cargoService.findCargoByCriteria(cargoDTO);        
        return new ResponseEntity<List<CargoDTO>>(cargosDTO, HttpStatus.OK);
    }
}
