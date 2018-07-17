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

import com.dsite.dto.model.TablaGeneralDTO;
import com.dsite.service.intf.TablaGeneralService;
import com.dsite.util.ValidateUtil;


@RestController
@RequestMapping(value = "/api/tablaGeneral")
public class TablaGeneralController {

	@Autowired
	TablaGeneralService tablaGeneralService;
	
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
}
