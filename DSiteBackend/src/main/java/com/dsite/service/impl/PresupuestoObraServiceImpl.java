package com.dsite.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Obra;
import com.dsite.domain.model.entities.PresupuestoObra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.ObraJPARepository;
import com.dsite.domain.model.repository.jpa.PresupuestoObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.PresupuestoObraDTO;
import com.dsite.service.intf.PresupuestoObraService;
import com.dsite.util.ValidateUtil;

@Service
public class PresupuestoObraServiceImpl implements PresupuestoObraService {

	@Autowired
	PresupuestoObraJPARepository presupuestoObraJPARepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	ObraJPARepository obraJPARepository;

	@Autowired
	Mapper mapper;

	@Override
	public PresupuestoObraDTO findById(int id) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PresupuestoObraDTO> findAllPresupuestos() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void createPresupuestoObra(PresupuestoObraDTO presupuestoObraDTO) {
		PresupuestoObra presupuestoObraEntidad = new PresupuestoObra();
		mapper.map(presupuestoObraDTO, presupuestoObraEntidad);

		// Ingresar datos a la entidad
		presupuestoObraEntidad.setFechaCreacion(new Date());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getUsuarioCreacion()))
			presupuestoObraEntidad.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdatePresupuestoObra(presupuestoObraDTO, presupuestoObraEntidad);
	}

	@Override
	public void updatePresupuestoObra(PresupuestoObraDTO presupuestoObraDTO) {
		PresupuestoObra presupuestoObraEntidad = new PresupuestoObra();
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdPresupuestoObra()))
			presupuestoObraEntidad = presupuestoObraJPARepository.findOne(presupuestoObraDTO.getIdPresupuestoObra());
		/*
		 * Validar DTO
		 */
		presupuestoObraDTO.setFechaCreacion(presupuestoObraEntidad.getFechaCreacion());
		presupuestoObraDTO.setUsuarioCreacion(presupuestoObraEntidad.getUsuarioCreacion());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getFechaEnvioActaCampo()))
			presupuestoObraDTO.setFechaEnvioActaCampo(presupuestoObraEntidad.getFechaEnvioActaCampo());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getFechaEnvioActaFinal()))
			presupuestoObraDTO.setFechaEnvioActaFinal(presupuestoObraEntidad.getFechaEnvioActaFinal());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getFechaEnvioPresupuestoLiquidacion()))
			presupuestoObraDTO.setFechaEnvioPresupuestoLiquidacion(presupuestoObraEntidad.getFechaEnvioPresupuestoLiquidacion());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getFechaEnvioPresupuestoOferta()))
			presupuestoObraDTO.setFechaEnvioPresupuestoOferta(presupuestoObraEntidad.getFechaEnvioPresupuestoOferta());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getFechaLiquidacion()))
			presupuestoObraDTO.setFechaLiquidacion(presupuestoObraEntidad.getFechaLiquidacion());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getFechaOfertado()))
			presupuestoObraDTO.setFechaOfertado(presupuestoObraEntidad.getFechaOfertado());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getImportePresupuestoLiquidacion()))
			presupuestoObraDTO.setImportePresupuestoLiquidacion(presupuestoObraEntidad.getImportePresupuestoLiquidacion());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getImportePresupuestoOferta()))
			presupuestoObraDTO.setImportePresupuestoOferta(presupuestoObraEntidad.getImportePresupuestoOferta());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getObservacionFinanzas()))
			presupuestoObraDTO.setObservacionFinanzas(presupuestoObraEntidad.getObservacionFinanzas());

		// Ingresar datos a la entidad
		mapper.map(presupuestoObraDTO, presupuestoObraEntidad);
		presupuestoObraEntidad.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(presupuestoObraDTO.getUsuarioModificacion()))
			presupuestoObraEntidad.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdatePresupuestoObra(presupuestoObraDTO, presupuestoObraEntidad);
	}

	private void createUpdatePresupuestoObra(PresupuestoObraDTO presupuestoObraDTO, PresupuestoObra presupuestoObraEntidad) {

		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdObra())) {
			Obra obra = obraJPARepository.findOne(presupuestoObraDTO.getIdObra());
			presupuestoObraEntidad.setObra(obra);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdTGTipoMoneda())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(presupuestoObraDTO.getIdTGTipoMoneda());
			presupuestoObraEntidad.setTablaGeneralTipoMoneda(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdTGActaCampo())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(presupuestoObraDTO.getIdTGActaCampo());
			presupuestoObraEntidad.setTablaGeneralActaCampo(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdTGActaFinal())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(presupuestoObraDTO.getIdTGActaFinal());
			presupuestoObraEntidad.setTablaGeneralActaFinal(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdTGEstadoFinanzas())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(presupuestoObraDTO.getIdTGEstadoFinanzas());
			presupuestoObraEntidad.setTablaGeneralEstadoFinanzas(tablaGeneral);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdUsuarioEnvioPresupuestoOferta())) {
			Usuario usuario = usuarioJPARepository.findOne(presupuestoObraDTO.getIdUsuarioEnvioPresupuestoOferta());
			presupuestoObraEntidad.setUsuarioEnvioPresupuestoOferta(usuario);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdUsuarioEnvioPresupuestoLiquidacion())) {
			Usuario usuario = usuarioJPARepository.findOne(presupuestoObraDTO.getIdUsuarioEnvioPresupuestoLiquidacion());
			presupuestoObraEntidad.setUsuarioEnvioPresupuestoLiquidacion(usuario);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdUsuarioEnvioActaCampo())) {
			Usuario usuario = usuarioJPARepository.findOne(presupuestoObraDTO.getIdUsuarioEnvioActaCampo());
			presupuestoObraEntidad.setUsuarioEnvioActaCampo(usuario);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdUsuarioEnvioActaFinal())) {
			Usuario usuario = usuarioJPARepository.findOne(presupuestoObraDTO.getIdUsuarioEnvioActaFinal());
			presupuestoObraEntidad.setUsuarioEnvioActaFinal(usuario);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdUsuarioOfertado())) {
			Usuario usuario = usuarioJPARepository.findOne(presupuestoObraDTO.getIdUsuarioOfertado());
			presupuestoObraEntidad.setUsuarioOfertado(usuario);
		}
		if (ValidateUtil.isNotEmpty(presupuestoObraDTO.getIdUsuarioLiquidacion())) {
			Usuario usuario = usuarioJPARepository.findOne(presupuestoObraDTO.getIdUsuarioLiquidacion());
			presupuestoObraEntidad.setUsuarioLiquidacion(usuario);
		}
		presupuestoObraJPARepository.save(presupuestoObraEntidad);
		presupuestoObraJPARepository.flush();

	}

	@Override
	public void deletePresupuestoObraById(int id) {
		// XXX Auto-generated method stub

	}

}
