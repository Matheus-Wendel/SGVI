package com.fatec.mogi.util;

import java.util.ArrayList;
import java.util.List;

import com.fatec.mogi.model.Artista;
import com.fatec.mogi.model.Evento;
import com.fatec.mogi.model.Setor;

public class EventoUtil {

	public static Evento montaEvento(Evento evento, List<Artista> artistas, 
			List<String> descricoes, List<Float> valores, List<Integer> ingresosDisponiveis ) {
		
		
		evento.setArtista(artistas);
		List<Setor> setor = new ArrayList<Setor>();
		for (int i = 0; i < descricoes.size(); i++) {
			setor.add(new Setor(descricoes.get(i), valores.get(i), ingresosDisponiveis.get(i)));
		}
		
		evento.setSetor(setor);
		
		return evento;
		
		
		
		
		
	}
}
