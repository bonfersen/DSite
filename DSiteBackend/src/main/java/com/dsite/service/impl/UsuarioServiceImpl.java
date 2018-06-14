package com.dsite.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsite.constants.DSiteCoreConstants;
import com.dsite.domain.model.entities.Empleado;
import com.dsite.domain.model.entities.EmpleadoAreaObra;
import com.dsite.domain.model.entities.Usuario;
import com.dsite.domain.model.repository.jpa.EmpleadoJPARepository;
import com.dsite.domain.model.repository.jpa.UsuarioJPARepository;
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
	Mapper mapper;
	
	@Override
	public UsuarioDTO findById(int id) {
		UsuarioDTO usuarioDTO= new UsuarioDTO();
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
        
        Empleado empleadoEntity = empleadoJPARepository.findEmpleadoByUsuario(usuarioEntity.getIdUsuario());
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        mapper.map(empleadoEntity, empleadoDTO);
        
        List<EmpleadoAreaObraDTO> lstEmpleadoAreaObraDTO = new ArrayList<EmpleadoAreaObraDTO>();
        for (EmpleadoAreaObra empleadoAreaObra : empleadoEntity.getEmpleadoAreaObras()) {
        	EmpleadoAreaObraDTO empleadoAreaObraDTO = new EmpleadoAreaObraDTO();
        	empleadoAreaObraDTO.setIdEmpleado(empleadoAreaObra.getEmpleado().getIdEmpleado());
        	empleadoAreaObraDTO.setIdTGEmpleadoAreaObra(empleadoAreaObra.getTablaGeneralEmpleadoAreaObra().getIdTablaGeneral());
        	empleadoAreaObraDTO.setIdTGEmpleadoAreaObraDescripcion(empleadoAreaObra.getTablaGeneralEmpleadoAreaObra().getDescripcion());
        	lstEmpleadoAreaObraDTO.add(empleadoAreaObraDTO);
        }
        empleadoDTO.setEmpleadoAreaObras(lstEmpleadoAreaObraDTO); 
        
        return empleadoDTO;
	}

	@Override
	public void saveUsuario(UsuarioDTO usuario) {
		// XXX Auto-generated method stub

	}

	@Override
	public void updateUsuario(UsuarioDTO usuario) {
		// XXX Auto-generated method stub

	}

	@Override
	public void deleteUsuarioById(long id) {
		// XXX Auto-generated method stub

	}

	@Override
	public boolean isUsuarioExist(UsuarioDTO usuario) {
		// XXX Auto-generated method stub
		return false;
	}

}
