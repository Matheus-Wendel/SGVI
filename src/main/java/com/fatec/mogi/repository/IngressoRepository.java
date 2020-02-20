package com.fatec.mogi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
	
	@Query("SELECT COUNT(*) FROM Ingresso ingresso WHERE ingresso.cliente.id = :id AND ingresso.dataCompra BETWEEN :umAnoAtras AND current_date()")
	int countIngressoDoAno(@Param("id")Long id,@Param("umAnoAtras") Date umAnoAtras);
	
	
	@Query("SELECT ingresso "
			+ "FROM Ingresso ingresso "
			+ "WHERE ingresso.cliente.id = :idCliente "
			+ "AND ingresso.dataCompra BETWEEN :umAnoAtras AND current_date() "
			+ "AND ingresso.tipoCompraBonus = 0 "
			+ "AND ingresso.contagemParaBonus = 0 " 
			+ "ORDER BY ingresso.dataCompra ASC ")
	List<Ingresso> findIngressosParaBonus(@Param("idCliente")Long id,@Param("umAnoAtras") Date umAnoAtras);
	
	
	
	@Query("SELECT ingresso "
			+ "FROM Ingresso ingresso "
			+ "WHERE ingresso.cliente.usuario.email = :emailUsuario " 
			+ "ORDER BY ingresso.dataCompra DESC ")
	List<Ingresso> findIngressosCliente(@Param("emailUsuario")String emailUsuario);

	

}
