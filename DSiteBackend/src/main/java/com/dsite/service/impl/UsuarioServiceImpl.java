package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.TablaGeneral;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jdbc.AutorizacionesJDBCRepository;
import com.dsite.domain.model.repository.jdbc.EmpleadoAreaObraJDBCRepository;
import com.dsite.domain.model.repository.jdbc.EmpleadoJDBCRepository;
import com.dsite.domain.model.repository.jdbc.UsuarioJDBCRepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.TablaGeneralJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
import com.dsite.dto.model.AutorizacionesDTO;
import com.dsite.dto.model.EmpleadoAreaObraDTO;
import com.dsite.dto.model.EmpleadoDTO;
import com.dsite.dto.model.UsuarioDTO;
import com.dsite.service.intf.UsuarioService;
import com.dsite.util.ValidateUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioJPARepository usuarioJPARepository;
	
	@Autowired
	UsuarioJDBCRepository usuarioJDBCRepository;

	@Autowired
	EmpleadoJPARepository empleadoJPARepository;

	@Autowired
	EmpleadoJDBCRepository empleadoJDBCRepository;

	@Autowired
	EmpleadoAreaObraJDBCRepository empleadoAreaObraJDBCRepository;

	@Autowired
	AutorizacionesJDBCRepository autorizacionesJDBCRepository;
	
	@Autowired
	TablaGeneralJPARepository tablaGeneralJpaRepository;

	@Autowired
	Mapper mapper;

	@Override
	public UsuarioDTO findById(int id) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		Usuario usuarioEntity = usuarioJPARepository.findOne(id);
		mapper.map(usuarioEntity, usuarioDTO);
		return usuarioDTO;
	}

	@Override
	public EmpleadoDTO loginUsuario(UsuarioDTO usuarioDTO) {
		List<UsuarioDTO> lstUsuarioDTOJDBC = usuarioJDBCRepository.findUsuarioByCriteria(usuarioDTO);

		if (lstUsuarioDTOJDBC.size() <= 0)
			return null;
		
		UsuarioDTO usuarioDTOJDBC = lstUsuarioDTOJDBC.get(0);
		if (usuarioDTOJDBC.getActivo().compareToIgnoreCase(DSiteCoreConstants.ACTIVO) != 0)
			return null;

		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		empleadoDTO.setIdUsuario(usuarioDTOJDBC.getIdUsuario());
		List<EmpleadoDTO> lstEmpleado = empleadoJDBCRepository.loginEmpleado(empleadoDTO);

		if (lstEmpleado.size() <= 0)
			return null;
		empleadoDTO = lstEmpleado.get(0);

		/*
		 * Areas asociadas a un empleado
		 */
		EmpleadoAreaObraDTO empleadoAreaObraDTO = new EmpleadoAreaObraDTO();
		empleadoAreaObraDTO.setIdEmpleado(empleadoDTO.getIdEmpleado());
		List<EmpleadoAreaObraDTO> lstEmpleadoAreaObraDTO = empleadoAreaObraJDBCRepository.findEmpleadoAreaObraByCriteria(empleadoAreaObraDTO);

		/*
		 * Autorizaciones asociadas a un empleado
		 */
		AutorizacionesDTO autorizacionesDTO = new AutorizacionesDTO();
		autorizacionesDTO.setIdTGRol(usuarioDTOJDBC.getIdTGRol());
		List<AutorizacionesDTO> lstAutorizacionesDTO = autorizacionesJDBCRepository.findAutorizacionesByCriteria(autorizacionesDTO);

		empleadoDTO.setEmpleadoAreaObras(lstEmpleadoAreaObraDTO);
		empleadoDTO.setAutorizaciones(lstAutorizacionesDTO);
		return empleadoDTO;
	}

	public Usuario createUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuarioEntity = new Usuario();
		mapper.map(usuarioDTO, usuarioEntity);

		/*
		 * Ingresar datos a la entidad
		 */
		createUpdateUsuario(usuarioDTO, usuarioEntity);
		return usuarioEntity;
	}

	public void updateUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuarioEntity = new Usuario();
		if (ValidateUtil.isNotEmpty(usuarioDTO.getIdUsuario())) {
			usuarioEntity = usuarioJPARepository.findOne(usuarioDTO.getIdUsuario());
		}
		/*
		 * Validar DTO
		 */
		if (ValidateUtil.isEmpty(usuarioDTO.getCuentaUsuario()))
			usuarioDTO.setCuentaUsuario(usuarioEntity.getCuentaUsuario());
		if (ValidateUtil.isEmpty(usuarioDTO.getPassword()))
			usuarioDTO.setPassword(usuarioEntity.getPassword());
		if (ValidateUtil.isEmpty(usuarioDTO.getActivo()))
			usuarioDTO.setActivo(usuarioEntity.getActivo());

		// Ingresar datos a la entidad
		mapper.map(usuarioDTO, usuarioEntity);
		createUpdateUsuario(usuarioDTO, usuarioEntity);
	}

	private void createUpdateUsuario(UsuarioDTO usuarioDTO, Usuario usuarioEntity) {
		if (ValidateUtil.isNotEmpty(usuarioDTO.getIdTGRol())) {
			TablaGeneral tablaGeneral = tablaGeneralJpaRepository.findOne(usuarioDTO.getIdTGRol());
			usuarioEntity.setTablaGeneralRol(tablaGeneral);
		}
		usuarioJPARepository.save(usuarioEntity);
		usuarioJPARepository.flush();
	}

}
