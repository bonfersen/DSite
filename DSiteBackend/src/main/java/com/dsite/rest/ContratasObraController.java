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

import com.dsite.dto.model.ContratasObraDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.service.intf.ContratasObraService;
import com.dsite.util.ValidateUtil;

@RestController
@RequestMapping(value = "/api/contratasobra")
public class ContratasObraController {

	@Autowired
	private ContratasObraService contrataObraService;

	/*
	 * @RequestMapping(value = "/find/{id}", method = RequestMethod.GET) public ResponseEntity<ContratasObraDTO>
	 * findById(@PathVariable Integer id) { ContratasObraDTO ContratasObraDTO; ContratasObraDTO = obraService.findById(id);
	 * if (ValidateUtil.isEmpty(ContratasObraDTO)) { return new ResponseEntity<ContratasObraDTO>(HttpStatus.NO_CONTENT); }
	 * return new ResponseEntity<ContratasObraDTO>(ContratasObraDTO, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/save/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveContratasObra(@RequestBody ContratasObraDTO dto, UriComponentsBuilder ucBuilder) {
		System.out.println("Creando ContratasObra " + dto.getIdContratasObra());

		if (ValidateUtil.isEmpty(dto.getIdContratasObra())) {
			contrataObraService.createContratasObra(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdContratasObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		else {
			contrataObraService.updateContratasObra(dto);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/save/{id}").buildAndExpand(dto.getIdContratasObra()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<NotificacionDTO> deleteContratasObraById(@PathVariable Integer id) {
		NotificacionDTO notificacion = null;		
		notificacion = contrataObraService.deleteContratasObraById(id);		
		return new ResponseEntity<NotificacionDTO>(notificacion, HttpStatus.OK);
	}
}
