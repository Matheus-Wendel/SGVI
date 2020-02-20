package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	@Query("SELECT evento "
			+"FROM Evento evento "
			+"LEFT JOIN evento.artista artista "
			+"WHERE evento.nome  like %:nomeEvento% "
			+ "OR artista.nome  like %:nomeEvento% ")
	List<Evento> findByNome(@Param("nomeEvento")String nomeEvento);
	
	@Query("SELECT evento "
			+"FROM Evento evento "
			+ "LEFT JOIN evento.setor setor "
			+ "WHERE setor.id = :idSetor")
	Evento findBySetorId(@Param("idSetor")Long idSetor);
	
	
	
	

}
