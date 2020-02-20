package com.fatec.mogi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
	

	@Query("SELECT usuario FROM Usuario usuario WHERE usuario.email = :email")
	Optional<Usuario> login(@Param("email")String email);
	
	

	
	
	//@Query("SELECT user FROM User user WHERE user.email = :email AND user.senha = ?2")
	//Optional<User> login(@Param("email")String email, String senha);

}
