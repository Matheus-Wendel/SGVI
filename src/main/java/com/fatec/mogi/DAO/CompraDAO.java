package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Compra;
import com.fatec.mogi.repository.CompraRepository;
import com.fatec.mogi.util.CompraUtil;
import com.fatec.mogi.util.Util;

@Service
public class CompraDAO implements IDAO {

	@Autowired
	CompraRepository compraRepository;

	@Autowired
	IngressoDAO ingressoDAO;

	@Autowired
	SetorDAO setorDAO;

	@Autowired
	ClienteDAO clienteDAO;

	@Override
	@Transactional
	public BaseModel save(BaseModel baseModel) {

		Compra compra = (Compra) baseModel;

		// SALVA COMPRA
		compra = compraRepository.save(compra);

		// SALVA INGRESSOS

		ingressoDAO.saveAll(CompraUtil.montaIngressosCompra(compra));
		// SUBTRAI DE INGRESSOS DISPONIVEIS
//		
//		Setor setor = compra.getSetor();
//		setor.setIngresosDisponiveis(setor.getIngresosDisponiveis() - compra.getQuantidadeIngressos());
		setorDAO.subtraiIngressos(compra.getSetor().getId(), compra.getQuantidadeIngressos());

//		SimpleDateFormat format = new SimpleDateFormat(Util.FORMATO_DATA);

//		Date date =format.parse(LocalDateTime.now().minusYears(1).format(formatter));
		clienteDAO.atualizaIngressosBonus(compra.getCliente().getId(), 
				CompraUtil.calculaIngressosBonus(ingressoDAO.findIngressosParaBonus(compra.getCliente().getId(), Util.getDataAnoAnterior()),compra));

		ingressoDAO.saveAll(CompraUtil.definirIngressosBonus(
				ingressoDAO.findIngressosParaBonus(compra.getCliente().getId(), Util.getDataAnoAnterior())));
		// calcula ingressos bonus

//		System.err.println(ingressoDAO.findIngressosParaBonus(compra.getCliente().getId(), Util.getDataAnoAnterior()));
//		System.err.println(ingressoDAO.countIngressoDoAno(compra.getCliente().getId(), Util.getDataAnoAnterior()));

		return compra;
	}

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseModel update(BaseModel baseModel, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> findAll() {

		return null;
	}

	@Override
	public Optional<Compra> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> findByParameter(String parametro) {
		return compraRepository.findComprasCliente(parametro);

	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
