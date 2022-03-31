package com.example.bci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bci.base.Constantes;
import com.example.bci.base.MensajeValidacion;
import com.example.bci.base.UtilNegocio;
import com.example.bci.service.UsuarioService;
import com.example.bci.to.ResponseTO;
import com.example.bci.to.UsuarioRequestTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	public ResponseTO guardarUsuario(@RequestBody UsuarioRequestTO usuario) {
		ResponseTO response = new ResponseTO();
		MensajeValidacion validacion = UtilNegocio.validaciones(usuario);
		if(validacion.isOk()) {
			if(!usuarioService.existeUsuarioByEmail(usuario.getEmail())) {
				response.setUsuario(UtilNegocio.setterUsuario(usuarioService.guardarUsuario(UtilNegocio.setterUsuario(usuario))));
			}else {
				response.setMensaje(Constantes.MSG_EMAIL_EXIST);
			}
		}else {
			response.setMensaje(validacion.getGlosa());
		}

		return response;		
	}
	
	

}
