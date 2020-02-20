package com.fatec.mogi.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.ClienteDAO;
import com.fatec.mogi.DAO.SetorDAO;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Compra;
import com.fatec.mogi.security.usuarioUtil;
import com.fatec.mogi.util.Util;

@Service
public class CompraStrategy implements IStrategy {

	@Autowired
	SetorDAO setorDAO;

	@Autowired
	ClienteDAO ClienteDAO;

	@Override
	public String processar(BaseModel baseModel) {
		Compra compra = (Compra) baseModel;

		// valida quantidade de ingressos disponiveis

		if (setorDAO.findById(compra.getSetor().getId()).get().getIngresosDisponiveis() < compra
				.getQuantidadeIngressos())
			return "ERRO quantidade invalida de ingressos";

		compra.setDataCompra(Util.getDataHoje());
		if (ClienteDAO.findByParameter(usuarioUtil.getUsuario()) == null) {
			return "ERRO cliente nao logado";

		}
		compra.setCliente(ClienteDAO.findByParameter(usuarioUtil.getUsuario()).get(0));

		if (compra.getTipoCompraBonus()) {
			if (compra.getCliente().getIngressoBonus() < compra.getQuantidadeIngressos())
				return "ERRO nao possui ingressos suficientes para realizar a compra";

			compra.setCvvCartao(null);
			compra.setNomeTitularCartao(null);
			compra.setDataValidadeCartao(null);
			compra.setNumeroCartao(null);

		}

		return "";
	}

}
