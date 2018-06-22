package com.dsite.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dsite.config.StorageProperties;
import com.dsite.constants.DSiteCoreConstants;
import com.dsite.dto.model.DocumentosAdjuntoDTO;
import com.dsite.exception.StorageException;
import com.dsite.exception.StorageFileNotFoundException;
import com.dsite.service.intf.DocumentosAdjuntoService;
import com.dsite.service.intf.StorageService;
import com.dsite.util.DateUtil;
import com.dsite.util.FileManagerUtil;
import com.dsite.util.StringUtil;

@Service
public class StorageServiceImpl implements StorageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

	@Autowired
	DocumentosAdjuntoService documentosAdjuntoService;

	private Path rootLocation;

	private String directorio;

	@Autowired
	public StorageServiceImpl(StorageProperties properties) {
		this.directorio = properties.getLocation();
	}

	@Override
	public void store(MultipartFile file, Integer idTabla, String idTGNombreTabla, Integer idTipoDocumentoAdjunto) throws Exception {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		filename = StringUtil.getFileName(filename) + DSiteCoreConstants.GUION_ABAJO + StringUtils.replace(DateUtil.getHourFromDate(new Date()), DSiteCoreConstants.DOS_PUNTOS, "")
				+ DSiteCoreConstants.GUION_ABAJO + idTabla + DSiteCoreConstants.GUION_ABAJO + idTGNombreTabla + DSiteCoreConstants.GUION_ABAJO + idTipoDocumentoAdjunto
				+ DSiteCoreConstants.PUNTO + StringUtil.getExtension(filename);

		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + filename);
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new StorageException("Cannot store file with relative path outside current directory " + filename);
			}
			try (InputStream inputStream = file.getInputStream()) {
				FileManagerUtil.createFoldersWithAnyoMesDia(directorio);
				this.rootLocation = Paths.get(directorio + StringUtil.getFoldersWithAnyoMesDia());

				Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
				LOGGER.info("Se guardo el archivo: " + filename);

				DocumentosAdjuntoDTO dto = new DocumentosAdjuntoDTO();
				dto.setNombreArchivo(filename);
				dto.setDirectorio(directorio + StringUtil.getFoldersWithAnyoMesDia());
				dto.setIdTabla(idTabla);
				dto.setIdTGNombreTabla(idTGNombreTabla);
				dto.setIdTipoDocumentoAdjunto(idTipoDocumentoAdjunto);
				documentosAdjuntoService.createDocumentosAdjunto(dto);
			}
		}
		catch (IOException e) {
			throw new StorageException("Failed to store file " + filename, e);
		}
	}

	@Override
	public Stream<Path> loadAll() throws Exception {
		try {
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
		}
		catch (IOException e) {
			throw new StorageException("Failed to read stored files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(Integer idDocumentoAdjunto) throws Exception {
		String filename = null;
		try {
			DocumentosAdjuntoDTO documentosAdjuntoDTO = documentosAdjuntoService.findById(idDocumentoAdjunto);
			this.rootLocation = Paths.get(documentosAdjuntoDTO.getDirectorio());
			filename = documentosAdjuntoDTO.getNombreArchivo();
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageFileNotFoundException("Could not read file: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() throws Exception {
		try {
			this.rootLocation = Paths.get(directorio);
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new StorageException("Could not initialize storage", e);
		}
	}
}
