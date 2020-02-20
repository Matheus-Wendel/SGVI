package com.fatec.mogi.util;

import java.util.Date;

public class Util {

	public static final String FORMATO_DATA = "yyyy-MM-dd";
	public static final String FORMATO_DATA_VALIDADE_CARTAO = "MM-yyyy";
	public static final String FORMATO_DATA_HORA = "yyyy-MM-dd-HH:mm";
	
	public static final String[] RECURSOS_LIVRE_ACESSO = {
			"/", //PAGINA INICIAL
			"/compra", //TODO REMOVER , ADICIONAR PERMISSAO DE USUARIO
			"/layout/**", //JAVASCRIPT E CSS
			"/inicial/senha/**", //MEDOTO PARA ENCRIPTAR SENHA E INSERIR NO BANCO TODO REMOVER
			"/usuario/cadastro", //PAGINA DE LOGIN
			"/componentes/**", // NAVBAR E HEADER
			//"/administrativo/**",
			"/cliente/cadastro",
			"/livre/**",
			"/evento/getAllEventos",
			"/evento/getEventos/**"
		};
	
	public static final String PAGINA_LOGIN = "/inicial/login";
	
	public static final String PAGINA_SUCESSO_LOGIN = "/inicial";
	
	public static final String PAGINA_SUCESSO_LOGOUT = "/inicial";
	
	public static final String RECURSOS_ADMINISTRADOR = "/administrativo/**";

	public static final String RECURSOS_USUARIO = "/compra";
	
	
	public static final  Date getDataAnoAnterior() {
		return java.sql.Date.valueOf(java.time.LocalDate.now().minusYears(1));		
	}
	public static final  Date getDataHoje() {
		return java.sql.Date.valueOf(java.time.LocalDate.now());		
	}

	
	
	
	
}

