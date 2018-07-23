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

import com.dsite.dto.model.CajaChicaObraDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.CajaChicaObraService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/cajachicaobra")
public class CajaChicaObraController {

	@Autowired
	private CajaChicaObraService cajaChicaObraService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<CajaChicaObraDTO> findById(@PathVariable Integer id) {
		CajaChicaObraDTO CajaChicaObraDTO;
		CajaChicaObraDTO = cajaChicaObraService.findById(id);
		if (ValidateUtil.isEmpty(CajaChicaObraDTO)) {
			return new ResponseEntity<CajaChicaObraDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CajaChicaObraDTO>(CajaChicaObraDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCajaChicaObra(@RequestBody CajaChicaObraDTO dto, UriComponentsBuilder ucBuilder) {

		if (ValidateUtil.isEmpty(dto.getIdCajaChicaObra())) {
			cajaChicaObraService.createCajaChicaObra(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdCajaChicaObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		else {
			cajaChicaObraService.updateCajaChicaObra(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdCajaChicaObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<NotificacionDTO> deleteCajaChicaObra(@PathVariable Integer id) {
		NotificacionDTO notificacion = null;
		notificacion = cajaChicaObraService.deleteCajaChicaObraById(id);
		return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
	}
}
