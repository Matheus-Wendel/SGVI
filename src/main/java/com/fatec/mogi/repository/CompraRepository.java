package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	@Query("SELECT compra "
			+ "FROM Compra compra "
			+ "WHERE compra.cliente.usuario.email = :emailUsuario " 
			+ "ORDER BY compra.dataCompra DESC ")
	List<Compra> findComprasCliente(@Param("emailUsuario")String emailUsuario);

}
