package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Artista;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.repository.ArtistaRepository;

@Service
public class ArtistaDAO implements IDAO {

	@Autowired
	ArtistaRepository artistaRepository;

	public Artista save(Artista artista) {

		return artistaRepository.save(artista);

	}

	public List<Artista> findAll() {

		return artistaRepository.findAll();

	}

	public List<Artista> findByParameter(String nomeArtista) {

		return artistaRepository.findByNome(nomeArtista);
	}

	@Override
	public BaseModel save(BaseModel baseModel) {
		Artista artista = (Artista) baseModel;

		return artistaRepository.save(artista);
	}

	@Override
	public String delete(Long id) {

		try {
			artistaRepository.deleteById(id);			
		} 
		catch (Exception e) {
			return "ERRO";			
		}

		return "SUCESSO";
	}

	@Override
	public Artista update(BaseModel baseModel, Long id) {
		// TODO
		if (artistaRepository.existsById(id)) {
			Artista artista = (Artista) baseModel;
			artista.setId(id);
			return artistaRepository.save(artista);

		}
		return null;
	}

	@Override
	public Optional<Artista> findById(Long id) {

		return artistaRepository.findById(id);
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}