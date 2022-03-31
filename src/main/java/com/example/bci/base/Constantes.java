package com.example.bci.base;

public class Constantes {
	
	/*EXPRESION REGULAR PARA EMAIL*/
	public static final String EMAIL_REGEX = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
	
	/*EXPRESION REGULAR PARA PASSWORD(acepta letras minusculas,digitos,largo minimo 6 largo maximo 18*/ 
	public static final String PASSWORD_REGEX = "^[a-z0-9]{6,18}$";
	
	
	public static final String MSG_INVALID_EMAIL = "Formato de Email Inválido";
	public static final String MSG_INVALID_PASSWORD = "Formato de Password Inválido";
	public static final String MSG_EMAIL_EXIST = "El correo ya registrado";
}
