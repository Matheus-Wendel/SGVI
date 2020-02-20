package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Evento;
import com.fatec.mogi.repository.EventoRepository;
@Service
public class EventoDAO implements IDAO {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	CustomizacaoDAO customizacaoDAO;

	@Override
	public BaseModel save(BaseModel baseModel) {
		
		Evento evento = (Evento) baseModel;
		return eventoRepository.save(evento);
	}

	@Override
	public String delete(Long id) {

		eventoRepository.deleteById(id);
		return null;

	}

	@Override
	public BaseModel update(BaseModel baseModel, Long id) {
		Evento evento = (Evento) baseModel;
		
		
		if (eventoRepository.existsById(id)) {
			evento.setId(id);
			eventoRepository.save(evento);
		}
		return null;
	}

	@Override
	public List<Evento> findAll() {
		
		return eventoRepository.findAll();
	}

	@Override
	public Optional<Evento> findById(Long id) {
		
		return eventoRepository.findById(id);
	}

	@Override
	public List<Evento> findByParameter(String parametro) {
		return eventoRepository.findByNome(parametro);
	}

	@Override
	public Evento findByParameter(Long id) {
		
		return eventoRepository.findBySetorId(id);
	}

}
