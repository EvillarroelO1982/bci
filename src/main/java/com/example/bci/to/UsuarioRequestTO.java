package com.example.bci.to;

import java.io.Serializable;
import java.util.List;

public class UsuarioRequestTO implements Serializable {
	
	private static final long serialVersionUID = -8616590206081899221L;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private List<TelefonoRequestTO> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TelefonoRequestTO> getPhones() {
		return phones;
	}

	public void setPhones(List<TelefonoRequestTO> phones) {
		this.phones = phones;
	}
	
	
	
}
