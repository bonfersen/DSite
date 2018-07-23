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

import com.dsite.dto.model.NotificacionDTO;
import com.dsite.dto.model.PagosContrataDTO;
import com.dsite.service.intf.PagosContrataService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/pagoscontrata")
public class PagosContrataController {

	@Autowired
	private PagosContrataService pagosContrataService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<PagosContrataDTO> findById(@PathVariable Integer id) {
		PagosContrataDTO pagosContrataDTO;
		pagosContrataDTO = pagosContrataService.findById(id);
		if (ValidateUtil.isEmpty(pagosContrataDTO)) {
			return new ResponseEntity<PagosContrataDTO>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PagosContrataDTO>(pagosContrataDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<NotificacionDTO> savePagosContrata(@RequestBody PagosContrataDTO dto, UriComponentsBuilder ucBuilder) {
		NotificacionDTO notificacion = null;
		if (ValidateUtil.isEmpty(dto.getIdPagosContrata())) {
			notificacion = pagosContrataService.createPagosContrata(dto);
			// Delvover el id generado con ucBuilder, exponiendo una URL
			return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
		} else {
			notificacion = pagosContrataService.updatePagosContrata(dto);
			return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
		}

	}
}
