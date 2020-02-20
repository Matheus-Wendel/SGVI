package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;
import com.fatec.mogi.repository.ClienteRepository;

@Service
public class ClienteDAO implements IDAO {

	@Autowired
	ClienteRepository clienteRepository;
	


	@Override
	public BaseModel save(BaseModel baseModel) {
		Cliente cliente = (Cliente) baseModel;
		
		//TODO
//		Endereco endereco = cliente.getEndereco();
//		Cidade cidade = endereco.getCidade();
//		Optional<Cidade> optionalCidadeCache;
//		optionalCidadeCache = cidadeRepository.findById(cidade.getId());
//
//		Cidade cidadeCache = optionalCidadeCache.get();
//		endereco.setCidade(cidadeCache);
//		cliente.setEndereco(endereco);
//		
//		Usuario usuario = cliente.getUsuario();
//		
//		cliente.setUsuario(usuario);

		// cliente.setEndereco(enderecoRepository.save(cliente.getEndereco()));
		// cliente.setUsuario(usuarioRepository.save(cliente.getUsuario()));

		return clienteRepository.save(cliente);
	}

	@Override
	public String delete(Long id) {
		clienteRepository.deleteById(id);
		return null;

	}

	@Override
	public BaseModel update(BaseModel baseModel, Long id) {
		Cliente cliente = (Cliente) baseModel;
		
		//TODO COLOCAR IF NA STRATEGY
		
		if(clienteRepository.existsById(id)) {
			cliente.setId(id);
			return clienteRepository.save(cliente);
		}
		
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> findByParameter(String parametro) {
		
		return clienteRepository.findByEmail(parametro);
	}
	
	
	public void atualizaIngressosBonus(Long id, int quantidade) {
		Cliente cliente = clienteRepository.findById(id).get();
		cliente.setIngressoBonus(cliente.getIngressoBonus()+quantidade);
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
