package com.dsite.service.impl;

import java.util.Date;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.DocumentosAdjunto;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.TipoDocumentoAdjunto;
import com.dsite.domain.model.repository.jpa.DocumentosAdjuntoJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.TipoDocumentoAdjuntoJPARepository;
import com.dsite.dto.model.DocumentosAdjuntoDTO;
import com.dsite.service.intf.DocumentosAdjuntoService;
import com.dsite.util.ValidateUtil;

@Service
public class DocumentosAdjuntoServiceImpl implements DocumentosAdjuntoService {

	@Autowired
	DocumentosAdjuntoJPARepository documentosAdjuntoJPARepository;

	@Autowired
	TipoDocumentoAdjuntoJPARepository tipoDocumentoAdjuntoJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	Mapper mapper;

	@Override
	public DocumentosAdjuntoDTO findById(Integer id) {
		DocumentosAdjuntoDTO documentosAdjuntoDTO = new DocumentosAdjuntoDTO();
		DocumentosAdjunto DocumentosAdjuntoEntity = documentosAdjuntoJPARepository.findOne(id);
		mapper.map(DocumentosAdjuntoEntity, documentosAdjuntoDTO);
		return documentosAdjuntoDTO;
	}

	@Transactional
	public void createDocumentosAdjunto(DocumentosAdjuntoDTO documentosAdjuntoDTO) {
		DocumentosAdjunto documentosAdjuntoEntity = new DocumentosAdjunto();
		mapper.map(documentosAdjuntoDTO, documentosAdjuntoEntity);

		// Ingresar datos a la entidad
		documentosAdjuntoEntity.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(documentosAdjuntoDTO.getUsuarioCreacion()))
			documentosAdjuntoEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateDocumentosAdjunto(documentosAdjuntoDTO, documentosAdjuntoEntity);
	}

	@Transactional
	public void updateDocumentosAdjunto(DocumentosAdjuntoDTO documentosAdjuntoDTO) {
		DocumentosAdjunto documentosAdjuntoEntity = new DocumentosAdjunto();
		if (ValidateUtil.isNotEmpty(documentosAdjuntoDTO.getIdDocumentosAdjunto()))
			documentosAdjuntoEntity = documentosAdjuntoJPARepository.findOne(documentosAdjuntoDTO.getIdDocumentosAdjunto());
		/*
		 * Validar DTO
		 */
		documentosAdjuntoDTO.setFechaCreacion(documentosAdjuntoEntity.getFechaCreacion());
		documentosAdjuntoDTO.setUsuarioCreacion(documentosAdjuntoEntity.getUsuarioCreacion());
		if (ValidateUtil.isEmpty(documentosAdjuntoDTO.getDirectorio()))
			documentosAdjuntoDTO.setDirectorio(documentosAdjuntoEntity.getDirectorio());
		if (ValidateUtil.isEmpty(documentosAdjuntoDTO.getIdTabla()))
			documentosAdjuntoDTO.setIdTabla(documentosAdjuntoEntity.getIdTabla());

		// Ingresar datos a la entidad
		mapper.map(documentosAdjuntoDTO, documentosAdjuntoEntity);
		documentosAdjuntoEntity.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(documentosAdjuntoDTO.getUsuarioModificacion()))
			documentosAdjuntoEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateDocumentosAdjunto(documentosAdjuntoDTO, documentosAdjuntoEntity);
	}

	private void createUpdateDocumentosAdjunto(DocumentosAdjuntoDTO documentosAdjuntoDTO, DocumentosAdjunto documentosAdjuntoEntity) {
		if (ValidateUtil.isNotEmpty(documentosAdjuntoDTO.getIdTGNombreTabla())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(documentosAdjuntoDTO.getIdTGNombreTabla());
			documentosAdjuntoEntity.setTablaGeneralNombreTabla(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(documentosAdjuntoDTO.getIdTipoDocumentoAdjunto())) {
			TipoDocumentoAdjunto tipoDocumentoAdjunto = tipoDocumentoAdjuntoJPARepository.findOne(documentosAdjuntoDTO.getIdTipoDocumentoAdjunto());
			documentosAdjuntoEntity.setTipoDocumentoAdjunto(tipoDocumentoAdjunto);
		}
		else {
			TipoDocumentoAdjunto tipoDocumentoAdjunto = tipoDocumentoAdjuntoJPARepository.findOne(1);// Configurar para que reciba los parametros adecuados
			documentosAdjuntoEntity.setTipoDocumentoAdjunto(tipoDocumentoAdjunto);
		}
		documentosAdjuntoJPARepository.save(documentosAdjuntoEntity);
		documentosAdjuntoJPARepository.flush();
	}

	@Override
	public void deleteDocumentosAdjuntoById(Integer id) {
		// XXX Auto-generated method stub

	}
}