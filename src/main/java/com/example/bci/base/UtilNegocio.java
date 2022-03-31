package com.example.bci.base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.example.bci.model.Telefono;
import com.example.bci.model.Usuario;
import com.example.bci.to.TelefonoRequestTO;
import com.example.bci.to.UsuarioRequestTO;
import com.example.bci.to.UsuarioResponseTO;

public class UtilNegocio {

	public static Usuario setterUsuario(UsuarioRequestTO u){		
		Usuario usuario = new Usuario();
		List<Telefono> telefonos = new ArrayList<>();		
		usuario.setNombre(u.getName());
		usuario.setEmail(u.getEmail());
		usuario.setPassword(u.getPassword());		
		for(TelefonoRequestTO t: u.getPhones()) {
			Telefono telefono = setterTelefono(t);
			telefono.setUsuario(usuario);
			telefonos.add(telefono);
		}		
		usuario.setTelefonos(telefonos);
		usuario.setToken("");
		return usuario;
	}
	
	public static Telefono setterTelefono(TelefonoRequestTO to){
		Telefono telefono = new Telefono();
		telefono.setNumero(Integer.valueOf(to.getNumber()));
		telefono.setCodigoCiudad(Integer.valueOf(to.getCitycode()));
		telefono.setCodigoPais(Integer.valueOf(to.getContrycode()));
		return telefono;
	}
	
	public static UsuarioResponseTO setterUsuario(Usuario u) {
		UsuarioResponseTO response = new UsuarioResponseTO();
		response.setId(u.getId());
		response.setCreated(u.getFechaCreacion());
		response.setModified(u.getFechaModificacion());
		response.setLast_login(u.getFechaUltimoAcceso());
		response.setToken(u.getToken());
		response.setIsactive(u.isActivo());
		return response;
	}
	
	public static MensajeValidacion validaciones(UsuarioRequestTO u) {
		MensajeValidacion mensaje = UtilNegocio.validaRegex(u.getPassword(), Constantes.PASSWORD_REGEX, Constantes.MSG_INVALID_PASSWORD);
		if(!mensaje.isOk()) 
			return mensaje;
		else {
			mensaje = UtilNegocio.validaRegex(u.getEmail(), Constantes.EMAIL_REGEX, Constantes.MSG_INVALID_EMAIL);
			if(!mensaje.isOk()) 
				return mensaje;
			
		}
		return new MensajeValidacion();
	} 

	public static MensajeValidacion validaRegex(String cadena, String regex, String msjError) {
		MensajeValidacion mensaje = new MensajeValidacion();
		if (!Pattern.matches(regex, cadena)) {
			mensaje.setOk(false);
			mensaje.setGlosa(msjError);
		}		
		return mensaje;
	}

}
