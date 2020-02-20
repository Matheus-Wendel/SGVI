package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Cliente;

public interface ClienteRepository extends  JpaRepository<Cliente, Long> {
	
	@Query("SELECT cliente "
			+"FROM Cliente cliente "
			+"WHERE cliente.usuario.email = :emailUsuario")
	List<Cliente> findByEmail(@Param("emailUsuario")String emailUsuario);

}
