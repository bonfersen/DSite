package com.dsite.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.OfertaLiquidacionObra;
import com.dsite.domain.model.entities.PresupuestoObra;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.repository.jpa.OfertaLiquidacionObraJPARepository;
import com.dsite.domain.model.repository.jpa.PresupuestoObraJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJpaRepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.OfertaLiquidacionObraDTO;
import com.dsite.service.intf.OfertaLiquidacionObraService;
import com.dsite.util.ValidateUtil;

@Service
public class OfertaLiquidacionObraServiceImpl implements OfertaLiquidacionObraService {

	@Autowired
	OfertaLiquidacionObraJPARepository ofertaLiquidacionObraJPARepository;

	@Autowired
	PresupuestoObraJPARepository presupuestoObraJPARepository;

	@Autowired
	TablaGeneralJpaRepository tablaGeneralJpaRepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	Mapper mapper;

	@Override
	public OfertaLiquidacionObraDTO findById(int id) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<OfertaLiquidacionObraDTO> findAllOfertaLiquidacionObras() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public void createOfertaLiquidacionObra(OfertaLiquidacionObraDTO ofertaLiquidacionObraDTO) {
		OfertaLiquidacionObra ofertaLiquidacionObraEntidad = new OfertaLiquidacionObra();
		mapper.map(ofertaLiquidacionObraDTO, ofertaLiquidacionObraEntidad);

		// Ingresar datos a la entidad
		ofertaLiquidacionObraEntidad.setFechaCreacion(new Date());
		ofertaLiquidacionObraEntidad.setFechaRecibido(new Date());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getUsuarioCreacion()))
			ofertaLiquidacionObraEntidad.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateOfertaLiquidacionObra(ofertaLiquidacionObraDTO, ofertaLiquidacionObraEntidad);
	}

	@Override
	public void updateOfertaLiquidacionObra(OfertaLiquidacionObraDTO ofertaLiquidacionObraDTO) {
		OfertaLiquidacionObra ofertaLiquidacionObraEntidad = new OfertaLiquidacionObra();
		if (ValidateUtil.isNotEmpty(ofertaLiquidacionObraDTO.getIdOfertaLiquidacionObra()))
			ofertaLiquidacionObraEntidad = ofertaLiquidacionObraJPARepository.findOne(ofertaLiquidacionObraDTO.getIdOfertaLiquidacionObra());
		ofertaLiquidacionObraDTO.setFechaCreacion(ofertaLiquidacionObraEntidad.getFechaCreacion());
		ofertaLiquidacionObraDTO.setFechaRecibido(ofertaLiquidacionObraEntidad.getFechaRecibido());
		ofertaLiquidacionObraDTO.setUsuarioCreacion(ofertaLiquidacionObraEntidad.getUsuarioCreacion());
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getActaCampoActaFinal()))
			ofertaLiquidacionObraDTO.setActaCampoActaFinal(ofertaLiquidacionObraEntidad.getActaCampoActaFinal());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getCorrelativoOfertaLiquidacion()))
			ofertaLiquidacionObraDTO.setCorrelativoOfertaLiquidacion(ofertaLiquidacionObraEntidad.getCorrelativoOfertaLiquidacion());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getFechaOfertaLiquidacionActaCampoActaFinal()))
			ofertaLiquidacionObraDTO.setFechaOfertaLiquidacionActaCampoActaFinal(ofertaLiquidacionObraEntidad.getFechaOfertaLiquidacionActaCampoActaFinal());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getImporteOfertaLiquidacion()))
			ofertaLiquidacionObraDTO.setImporteOfertaLiquidacion(ofertaLiquidacionObraEntidad.getImporteOfertaLiquidacion());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getImporteVarMas()))
			ofertaLiquidacionObraDTO.setImporteVarMas(ofertaLiquidacionObraEntidad.getImporteVarMas());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getImporteVarMenos()))
			ofertaLiquidacionObraDTO.setImporteVarMenos(ofertaLiquidacionObraEntidad.getImporteVarMenos());

		// Ingresar datos a la entida
		mapper.map(ofertaLiquidacionObraDTO, ofertaLiquidacionObraEntidad);
		ofertaLiquidacionObraEntidad.setFechaModificacion(new Date());
		if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getUsuarioModificacion()))
			ofertaLiquidacionObraEntidad.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

		createUpdateOfertaLiquidacionObra(ofertaLiquidacionObraDTO, ofertaLiquidacionObraEntidad);
	}

	private void createUpdateOfertaLiquidacionObra(OfertaLiquidacionObraDTO ofertaLiquidacionObraDTO, OfertaLiquidacionObra ofertaLiquidacionObraEntidad) {
		// Validacion para pantalla OA /OE /BS
		if (ValidateUtil.isNotEmpty(ofertaLiquidacionObraDTO.getIdTGTipoEnvio())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(ofertaLiquidacionObraDTO.getIdTGTipoEnvio());
			ofertaLiquidacionObraEntidad.setTablaGeneralTipoEnvio(tablaGeneral);

			PresupuestoObra presupuestoObra = presupuestoObraJPARepository.findOne(ofertaLiquidacionObraDTO.getIdPresupuestoObra());
			if (ValidateUtil.isNotEmpty(presupuestoObra)) {
				switch (ofertaLiquidacionObraDTO.getIdTGTipoEnvio()) {
				case DSiteCoreConstants.TIPO_ENVIO_CUSTOMER_SERVICE_OFERTA:
					presupuestoObra.setFechaEnvioPresupuestoOferta(new Date());
					presupuestoObra.setUsuarioEnvioPresupuestoOferta(null);
					break;
				case DSiteCoreConstants.TIPO_ENVIO_CUSTOMER_SERVICE_LIQUIDACION:
					presupuestoObra.setFechaEnvioPresupuestoLiquidacion(new Date());
					presupuestoObra.setUsuarioEnvioPresupuestoLiquidacion(null);
					break;
				case DSiteCoreConstants.TIPO_ENVIO_CUSTOMER_SERVICE_ACTACAMPO:
					presupuestoObra.setFechaEnvioActaCampo(new Date());
					presupuestoObra.setUsuarioEnvioActaCampo(null);
					break;
				case DSiteCoreConstants.TIPO_ENVIO_CUSTOMER_SERVICE_ACTAFINAL:
					presupuestoObra.setFechaEnvioActaFinal(new Date());
					presupuestoObra.setUsuarioEnvioActaFinal(null);
					break;
				}
				presupuestoObraJPARepository.save(presupuestoObra);
				presupuestoObraJPARepository.flush();

				// Se agrega el presupuestoObra a la oferta/liquidacion
				ofertaLiquidacionObraEntidad.setPresupuestoObra(presupuestoObra);
			}
		}
		// Validacion pantalla oferta / liquidacion
		else if (ValidateUtil.isEmpty(ofertaLiquidacionObraDTO.getIdTGTipoEnvio())) {
			PresupuestoObra presupuestoObra = ofertaLiquidacionObraEntidad.getPresupuestoObra();
			if (ValidateUtil.isNotEmpty(presupuestoObra)) {
				switch (ofertaLiquidacionObraEntidad.getTablaGeneralTipoEnvio().getIdTablaGeneral()) {
				case DSiteCoreConstants.TIPO_ENVIO_CUSTOMER_SERVICE_OFERTA:
					// Actualiza el estado de finanzas
					TablaGeneral tgEstadoFinanzasOfertado = tablaGeneralJpaRepository.findOne(DSiteCoreConstants.ESTADO_FINANZA_OFERTADO);
					presupuestoObra.setTablaGeneralEstadoFinanzas(tgEstadoFinanzasOfertado);
					break;
				case DSiteCoreConstants.TIPO_ENVIO_CUSTOMER_SERVICE_LIQUIDACION:
					// Update a la tabla presupuesto obra
					TablaGeneral tgEstadoFinanzasLiquidado = tablaGeneralJpaRepository.findOne(DSiteCoreConstants.ESTADO_FINANZA_LIQUIDADO);
					presupuestoObra.setTablaGeneralEstadoFinanzas(tgEstadoFinanzasLiquidado);
					break;
				}
				presupuestoObraJPARepository.save(presupuestoObra);
				presupuestoObraJPARepository.flush();

				// Se agrega el presupuestoObra a la oferta/liquidacion
				ofertaLiquidacionObraEntidad.setPresupuestoObra(presupuestoObra);
			}
		}

		ofertaLiquidacionObraJPARepository.save(ofertaLiquidacionObraEntidad);
		ofertaLiquidacionObraJPARepository.flush();
	}

	@Override
	public void deleteOfertaLiquidacionObraById(int id) {
		// XXX Auto-generated method stub

	}

}
