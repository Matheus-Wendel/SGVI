package com.fatec.mogi.security;

import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class usuarioUtil {
	
//	public Optional<Usuario> getUsuarioLogado() {
//		//RETORNA TRUE CASO O USUARIO SEJA ANONIMO - FALSE CASO ESTEJA LOGADO
//		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
//			// NAO ESTA LOGADO
//			return null;
//		}
//		//RETORNAR A PROPRIEDADE do login -- STRING / PLES -- STRING / EMAIL
////		User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		//getNoBanco(u.getUsername()) -- RETORNA USUARIO
//		return null;
//	}
	
	public static String getPermissaoUsuario() {
		@SuppressWarnings("unchecked")
		Collection<SimpleGrantedAuthority> authorities =    (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		authorities.toArray()[0].toString();
		
		return authorities.toArray()[0].toString();
	
	}
	public static String encriptaSenha(String senha) {
		BCryptPasswordEncoder encriptadorSenha = new BCryptPasswordEncoder();
		return encriptadorSenha.encode(senha);
	}
	
	public static String getUsuario() {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
			return null;
		}
		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return usuario.getUsername();
		
		
	}

}
