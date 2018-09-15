package com.dsite.service.intf;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.dsite.dto.model.NotificacionDTO;

public interface StorageService {

    void init() throws Exception;

    void store(MultipartFile file, Integer idTabla, String idTGNombreTabla, Integer idTipoDocumentoAdjunto) throws Exception;

    Stream<Path> loadAll() throws Exception;

    Path load(String filename);

    Resource loadAsResource(Integer idDocumentoAdjunto) throws Exception;

    void deleteAll();

    NotificacionDTO deleteFile(Integer id);
}