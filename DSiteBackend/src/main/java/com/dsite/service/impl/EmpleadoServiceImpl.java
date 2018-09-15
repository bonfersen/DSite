package com.dsite.service.impl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Cargo;
import com.dsite.domain.model.entities.Contrata;
import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jdbc.EmpleadoJDBCRepository;
import com.dsite.domain.model.repository.jpa.CargoJPARepository;
import com.dsite.domain.model.repository.jpa.ContrataJPARepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.EmpleadoAreaObraDTO;
import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.NotificacionDTO;
import com.dsite.dto.model.UsuarioDTO;
import com.dsite.service.intf.EmpleadoAreaObraService;
import com.dsite.service.intf.EmpleadoService;
import com.dsite.service.intf.UsuarioService;
import com.dsite.util.ValidateUtil;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoJPARepository empleadoJPARepository;

	@Autowired
	EmpleadoJDBCRepository empleadoJDBCRepository;

	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	CargoJPARepository cargoJPARepository;

	@Autowired
	UsuarioJPARepository usuarioJPARepository;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ContrataJPARepository contrataJPARepository;
	
	@Autowired
	EmpleadoAreaObraService empleadoAreaObraService;

	@Autowired
	Mapper mapper;

	public EmpleadoDTO findById(int id) {
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		Empleado empleadoEntity = empleadoJPARepository.findOne(id);
		mapper.map(empleadoEntity, empleadoDTO);
		return empleadoDTO;
	}

	public List<EmpleadoDTO> findAllEmpleados() {
		EmpleadoDTO dto = new EmpleadoDTO();
		List<EmpleadoDTO> lstDTO = empleadoJDBCRepository.findEmpleadoByCriteria(dto);
		return lstDTO;
	}

	public List<EmpleadoDTO> findResponsableObra() {
		EmpleadoDTO dto = new EmpleadoDTO();
		dto.setResponsableObra(DSiteCoreConstants.UNO);
		List<EmpleadoDTO> lstDTO = empleadoJDBCRepository.findEmpleadoByCriteria(dto);
		return lstDTO;
	}

	@Transactional
	public NotificacionDTO createEmpleado(EmpleadoDTO empleadoDTO) {
		NotificacionDTO notificacionDTO = new NotificacionDTO();
		try {
			Empleado empleadoEntity = new Empleado();
			mapper.map(empleadoDTO, empleadoEntity);
			
			/*
			 * Crear usuario
			 */
			Usuario usuarioEntityDNI = usuarioJPARepository.getUsuarioByCuenta(empleadoDTO.getNumeroDocumento());
			if (ValidateUtil.isNotEmpty(usuarioEntityDNI))
				throw new Exception("El DNI ingresado ya existe!");
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdTGRol(empleadoDTO.getIdTGRol());
			usuarioDTO.setActivo(empleadoDTO.getActivo());
			usuarioDTO.setCuentaUsuario(empleadoDTO.getNumeroDocumento());
			usuarioDTO.setPassword(empleadoDTO.getPassword());
			Usuario usuarioEntity = usuarioService.createUsuario(usuarioDTO);
			empleadoDTO.setIdUsuario(usuarioEntity.getIdUsuario());

			/*
			 * Ingresar datos a la entidad
			 */
			empleadoEntity.setFechaCreacion(new Date());
			if (ValidateUtil.isEmpty(empleadoDTO.getUsuarioCreacion()))
				empleadoEntity.setUsuarioCreacion(DSiteCoreConstants.USUARIO_ADMIN);
			createUpdateEmpleado(empleadoDTO, empleadoEntity);
			
			/*
			 * Agregar el area
			 */
			for (EmpleadoAreaObraDTO empleadoAreaObraDTO : empleadoDTO.getEmpleadoAreaObras()) {
				empleadoAreaObraDTO.setActivo(DSiteCoreConstants.ACTIVO);
				empleadoAreaObraDTO.setIdEmpleado(empleadoEntity.getIdEmpleado());
				empleadoAreaObraService.createEmpleadoAreaObra(empleadoAreaObraDTO);
			}

			notificacionDTO.setCodigo(null);
			notificacionDTO.setSeverity("success");
			notificacionDTO.setSummary("DSite success");
			notificacionDTO.setDetail("Se creo el usuario correctamente");
		}
		catch (Exception e) {
			notificacionDTO.setCodigo(null);
			notificacionDTO.setSeverity("warning");
			notificacionDTO.setSummary("DSite warning");
			notificacionDTO.setDetail(e.getMessage());
		}
		return notificacionDTO;
	}

	@Transactional
	public NotificacionDTO updateEmpleado(EmpleadoDTO empleadoDTO) {
		NotificacionDTO notificacionDTO = new NotificacionDTO();
		try {

			Empleado empleadoEntity = new Empleado();
			if (ValidateUtil.isNotEmpty(empleadoDTO.getIdEmpleado())) {
				empleadoEntity = empleadoJPARepository.findOne(empleadoDTO.getIdEmpleado());
			}
			empleadoDTO.setFechaCreacion(empleadoEntity.getFechaCreacion());
			empleadoDTO.setUsuarioCreacion(empleadoEntity.getUsuarioCreacion());
			/*
			 * Validar DTO
			 */
			if (ValidateUtil.isEmpty(empleadoDTO.getNumeroDocumento()))
				empleadoDTO.setNumeroDocumento(empleadoEntity.getNumeroDocumento());
			if (ValidateUtil.isEmpty(empleadoDTO.getNombre()))
				empleadoDTO.setNombre(empleadoEntity.getNombre());
			if (ValidateUtil.isEmpty(empleadoDTO.getApellidoPaterno()))
				empleadoDTO.setApellidoPaterno(empleadoEntity.getApellidoPaterno());
			if (ValidateUtil.isEmpty(empleadoDTO.getApellidoMaterno()))
				empleadoDTO.setApellidoMaterno(empleadoEntity.getApellidoMaterno());
			if (ValidateUtil.isEmpty(empleadoDTO.getResponsableObra()))
				empleadoDTO.setResponsableObra(empleadoEntity.getResponsableObra());
			if (ValidateUtil.isEmpty(empleadoDTO.getActivo()))
				empleadoDTO.setActivo(empleadoEntity.getActivo());

			// Ingresar datos a la entidad
			mapper.map(empleadoDTO, empleadoEntity);
			empleadoEntity.setFechaModificacion(new Date());
			if (ValidateUtil.isEmpty(empleadoDTO.getUsuarioModificacion()))
				empleadoEntity.setUsuarioModificacion(DSiteCoreConstants.USUARIO_ADMIN);

			/*
			 * Actualizar usuario
			 */
			Usuario usuarioEntityDNI = usuarioJPARepository.getUsuarioByCuenta(empleadoDTO.getNumeroDocumento());
			if (ValidateUtil.isNotEmpty(usuarioEntityDNI))
				if (usuarioEntityDNI.getIdUsuario() != empleadoDTO.getIdUsuario())
					throw new Exception("El DNI a actualizar ya existe!");
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setIdTGRol(empleadoDTO.getIdTGRol());
			usuarioDTO.setActivo(empleadoDTO.getActivo());
			usuarioDTO.setCuentaUsuario(empleadoDTO.getNumeroDocumento());
			usuarioDTO.setPassword(empleadoDTO.getPassword());
			usuarioDTO.setIdUsuario(empleadoDTO.getIdUsuario());
			usuarioService.updateUsuario(usuarioDTO);
			
			/*
			 * Actualizar el empleado area obra
			 */
			empleadoAreaObraService.deleteEmpleadoAreaObraByIdEmpleado(empleadoDTO.getIdEmpleado());
			for (EmpleadoAreaObraDTO empleadoAreaObraDTO : empleadoDTO.getEmpleadoAreaObras()) {
				empleadoAreaObraDTO.setActivo(DSiteCoreConstants.ACTIVO);
				empleadoAreaObraDTO.setIdEmpleado(empleadoDTO.getIdEmpleado());
				empleadoAreaObraService.createEmpleadoAreaObra(empleadoAreaObraDTO);
			}

			createUpdateEmpleado(empleadoDTO, empleadoEntity);
			notificacionDTO.setCodigo(null);
			notificacionDTO.setSeverity("success");
			notificacionDTO.setSummary("DSite success");
			notificacionDTO.setDetail("Se actualizo el usuario correctamente");
		}
		catch (Exception e) {
			notificacionDTO.setCodigo(null);
			notificacionDTO.setSeverity("warning");
			notificacionDTO.setSummary("DSite warning");
			notificacionDTO.setDetail(e.getMessage());
		}
		return notificacionDTO;
	}

	private void createUpdateEmpleado(EmpleadoDTO empleadoDTO, Empleado empleadoEntity) {
		// Categoria
		if (ValidateUtil.isNotEmpty(empleadoDTO.getIdTGTipoDocumento())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(empleadoDTO.getIdTGTipoDocumento());
			empleadoEntity.setTablaGeneralTipoDocumento(tablaGeneral);
		}
		TablaGeneral tablaGeneral = new TablaGeneral();
		tablaGeneral.setIdTablaGeneral(DSiteCoreConstants.NIVEL_USUARIO_SISTEMA_DEFAULT);
		empleadoEntity.setTablaGeneralNivelUsuario(tablaGeneral);
		if (ValidateUtil.isNotEmpty(empleadoDTO.getIdCargo())) {
			Cargo cargo = cargoJPARepository.findOne(empleadoDTO.getIdCargo());
			empleadoEntity.setCargo(cargo);
		}
		if (ValidateUtil.isNotEmpty(empleadoDTO.getIdUsuario())) {
			Usuario usuario = usuarioJPARepository.findOne(empleadoDTO.getIdUsuario());
			empleadoEntity.setUsuario(usuario);
		}
		if (ValidateUtil.isNotEmpty(empleadoDTO.getIdContrata())) {
			Contrata contrata = contrataJPARepository.findOne(empleadoDTO.getIdContrata());
			empleadoEntity.setContrata(contrata);
		}
		empleadoJPARepository.save(empleadoEntity);
		empleadoJPARepository.flush();
	}
}
