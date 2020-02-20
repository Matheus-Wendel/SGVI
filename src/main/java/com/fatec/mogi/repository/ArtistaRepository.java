package com.fatec.mogi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.mogi.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
	
	@Query("SELECT artista FROM Artista artista WHERE artista.nome  like %:nomeArtista%")
	List<Artista> findByNome(@Param("nomeArtista")String nomeArtista);
}
