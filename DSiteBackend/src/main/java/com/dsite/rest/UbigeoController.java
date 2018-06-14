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

import com.dsite.dto.model.DepartamentoDTO;
import com.dsite.dto.model.DistritoDTO;
import com.dsite.dto.model.ProvinciaDTO;
import com.dsite.service.intf.DepartamentoService;
import com.dsite.service.intf.DistritoService;
import com.dsite.service.intf.ProvinciaService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/ubigeo")
public class UbigeoController {

	@Autowired
	DepartamentoService departamentoService;
	
	@Autowired
	ProvinciaService provinciaService;
	
	@Autowired
	DistritoService distritoService;
	
	@RequestMapping(value = "/findDepartamento/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartamentoDTO>> listAllGerencias() {
        List<DepartamentoDTO> departamentosDTO = departamentoService.findAllDepartamentos();
        if (ValidateUtil.isEmpty(departamentosDTO)) {
            return new ResponseEntity<List<DepartamentoDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DepartamentoDTO>>(departamentosDTO, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findProvincias/{idDpto}", method = RequestMethod.GET)
	public ResponseEntity<List<ProvinciaDTO>> obtenerProvincias(@PathVariable String idDpto) {
		List<ProvinciaDTO> provinciaDTO = null;
		provinciaDTO = provinciaService.obtenerProvinciasPorDepartamento(idDpto);
		if (ValidateUtil.isEmpty(provinciaDTO)) {
            return new ResponseEntity<List<ProvinciaDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProvinciaDTO>>(provinciaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findDistritos/{idProvincia}", method = RequestMethod.GET)
	public ResponseEntity<List<DistritoDTO>> obtenerDistritos(@PathVariable String idProvincia) {
		List<DistritoDTO> distritoDTO = null;
		distritoDTO = distritoService.obtenerDistritosPorProvincia(idProvincia);
		if (ValidateUtil.isEmpty(distritoDTO)) {
            return new ResponseEntity<List<DistritoDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<DistritoDTO>>(distritoDTO, HttpStatus.OK);
	}
}
