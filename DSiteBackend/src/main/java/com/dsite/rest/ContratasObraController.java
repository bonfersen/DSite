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

import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.ContratasObraService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/contratasobra")
public class ContratasObraController {

	@Autowired
	private ContratasObraService contrataObraService;

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<NotificacionDTO> saveContratasObra(@RequestBody ContratasObraDTO dto, UriComponentsBuilder ucBuilder) {
		NotificacionDTO notificacion = null;

		if (ValidateUtil.isEmpty(dto.getIdContratasObra())) {
			notificacion = contrataObraService.createContratasObra(dto);
			return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
		}
		else {
			notificacion = contrataObraService.updateContratasObra(dto);
			return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<NotificacionDTO> deleteContratasObraById(@PathVariable Integer id) {
		NotificacionDTO notificacion = null;		
		notificacion = contrataObraService.deleteContratasObraById(id);		
		return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
	}
}
