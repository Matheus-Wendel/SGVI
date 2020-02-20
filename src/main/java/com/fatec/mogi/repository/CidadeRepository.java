package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	@Query("SELECT cidade "
			+ "FROM Cidade cidade "
			+ "WHERE cidade.estado.id = :idEstado " 
			+ "ORDER BY cidade.nome ASC ")
	List<Cidade> FindCidadePorEstado(@Param("idEstado")Long id);

}
