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

import com.dsite.dto.model.TablaGeneralDTO;
import com.dsite.service.intf.TablaGeneralService;
import com.dsite.util.ValidateUtil;


@RestController
@RequestMapping(value = "/api/tablaGeneral")
public class TablaGeneralController {

	@Autowired
	TablaGeneralService tablaGeneralService;
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<TablaGeneralDTO> findById(@PathVariable String id) {
		TablaGeneralDTO tgDTO;
		tgDTO = tablaGeneralService.findById(id);
		if (ValidateUtil.isEmpty(tgDTO)) {
			return new ResponseEntity<TablaGeneralDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<TablaGeneralDTO>(tgDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findTGCategoria/{categoria}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TablaGeneralDTO>> findTGCategoria(@PathVariable String categoria) {
        List<TablaGeneralDTO> tablaGeneralDTO = tablaGeneralService.findByCategoria(categoria);
        if (ValidateUtil.isEmpty(tablaGeneralDTO)) {
            return new ResponseEntity<List<TablaGeneralDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TablaGeneralDTO>>(tablaGeneralDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findTGCategoriaCodigoPadre/{categoria}/{idTGPadre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TablaGeneralDTO>> findByCategoriaAndCodigoPadre(@PathVariable String categoria, @PathVariable String idTGPadre) {
        List<TablaGeneralDTO> tablaGeneralDTOs = tablaGeneralService.findByCategoriaAndCodigoPadre(categoria, idTGPadre);
        if (tablaGeneralDTOs.size() == 0) {
            return new ResponseEntity<List<TablaGeneralDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TablaGeneralDTO>>(tablaGeneralDTOs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveTablaGeneral(@RequestBody TablaGeneralDTO dto, UriComponentsBuilder ucBuilder) {

		if (ValidateUtil.isEmpty(dto.getIdTablaGeneral())) {
			tablaGeneralService.createTablaGeneral(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdTablaGeneral()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		else {
			tablaGeneralService.updateTablaGeneral(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdTablaGeneral()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}
}
