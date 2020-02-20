package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	@Query("SELECT administrador "
			+ "FROM Administrador administrador "
			+ "WHERE administrador.nome like %:nomeOuEmail% "
			+ "OR administrador.usuario.email like %:nomeOuEmail% ")
	List<Administrador> findByNome(@Param("nomeOuEmail")String nomeOuEmail);

}
