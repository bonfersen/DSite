package com.dsite.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jdbc.AutorizacionesJDBCRepository;
import com.dsite.domain.model.repository.jdbc.EmpleadoAreaObraJDBCRepository;
import com.dsite.domain.model.repository.jdbc.EmpleadoJDBCRepository;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
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
	EmpleadoJPARepository empleadoJPARepository;

	@Autowired
	EmpleadoJDBCRepository empleadoJDBCRepository;

	@Autowired
	EmpleadoAreaObraJDBCRepository empleadoAreaObraJDBCRepository;

	@Autowired
	AutorizacionesJDBCRepository autorizacionesJDBCRepository;
	
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
		Usuario usuarioEntity = usuarioJPARepository.loginUsuario(usuarioDTO.getCuentaUsuario(), usuarioDTO.getPassword());

		if (ValidateUtil.isEmpty(usuarioEntity))
			return null;
		if (usuarioEntity.getActivo().compareToIgnoreCase(DSiteCoreConstants.ACTIVO) != 0)
			return null;

		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		empleadoDTO.setIdUsuario(usuarioEntity.getIdUsuario());
		List<EmpleadoDTO> lstEmpleado = empleadoJDBCRepository.findEmpleadoByCriteria(empleadoDTO);

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
		autorizacionesDTO.setIdTGRol(usuarioEntity.getTablaGeneralRol().getIdTablaGeneral());
		List<AutorizacionesDTO> lstAutorizacionesDTO = autorizacionesJDBCRepository.findAutorizacionesByCriteria(autorizacionesDTO);
		
		empleadoDTO.setEmpleadoAreaObras(lstEmpleadoAreaObraDTO);
		empleadoDTO.setAutorizaciones(lstAutorizacionesDTO);
		return empleadoDTO;
	}
}
