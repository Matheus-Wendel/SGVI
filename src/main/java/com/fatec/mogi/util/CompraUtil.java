package com.fatec.mogi.util;

import java.util.ArrayList;
import java.util.List;

import com.fatec.mogi.model.Compra;
import com.fatec.mogi.model.Ingresso;

public class CompraUtil {

	public static List<Ingresso> montaIngressosCompra(Compra compra) {
		List<Ingresso> listaIngressos = new ArrayList<Ingresso>();

		for (int i = 0; i < compra.getQuantidadeIngressos(); i++) {
			listaIngressos.add(new Ingresso(compra));
		}

		return listaIngressos;

	}

	public static int calculaIngressosBonus(List<Ingresso> listaIngresso, Compra compra) {
		
		int quantidadeIngressosBonus = 0;

		if (compra.getTipoCompraBonus())
			return quantidadeIngressosBonus - compra.getQuantidadeIngressos();

		if (listaIngresso.size() < 10)
			return 0;
		quantidadeIngressosBonus = (int) (listaIngresso.size() / 10);
		
		return quantidadeIngressosBonus;

	}

	public static List<Ingresso> definirIngressosBonus(List<Ingresso> listaIngresso) {

		if (listaIngresso.size() < 10)
			return listaIngresso;

		int quantidadeIngressosBonus = (int) (listaIngresso.size() / 10);

		for (int i = 0; i < quantidadeIngressosBonus * 10; i++) {

			Ingresso ingresso = listaIngresso.get(i);
			ingresso.setContagemParaBonus(true);
			listaIngresso.set(i, ingresso);

		}

		return listaIngresso;

	}
}
