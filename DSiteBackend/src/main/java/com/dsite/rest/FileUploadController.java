package com.dsite.rest;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.dsite.dto.model.views.FileResult;
import com.dsite.exception.StorageFileNotFoundException;
import com.dsite.service.intf.StorageService;

@RestController
@RequestMapping(value = "/api/store")
public class FileUploadController {

	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	/***
	 * Metodo que obtiene el archivo para su descarga
	 * 
	 * @param filename
	 * @return
	 */
	@RequestMapping(value = "/getFiles/{idDocumentoAdjunto}", method = RequestMethod.GET)
	public ResponseEntity<Resource> serveFile(@PathVariable Integer idDocumentoAdjunto) {

		Resource file = null;
		try {
			file = storageService.loadAsResource(idDocumentoAdjunto);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	/**
	 * Metodo para subir archivos al servidor
	 * 
	 * @param file
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody FileResult handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("idTabla") Integer idTabla,
			@RequestParam("idTGNombreTabla") String idTGNombreTabla, @RequestParam("idTipoDocumentoAdjunto") Integer idTipoDocumentoAdjunto) {
		FileResult result = new FileResult();
		try {			
			result.setFile(file.getOriginalFilename());
			storageService.store(file, idTabla, idTGNombreTabla, idTipoDocumentoAdjunto);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo que muestra la ruta Web de los archivos almacenados en el server
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String listUploadedFiles(Model model) throws IOException {

		try {
			model.addAttribute("files",
					storageService.loadAll()
							.map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString()).build().toString())
							.collect(Collectors.toList()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return model.asMap().get("files").toString();
	}
}