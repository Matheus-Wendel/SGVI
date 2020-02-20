package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Usuario;
import com.fatec.mogi.repository.UsuarioRepository;

@Service
public class UsuarioDAO implements IDAO {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public BaseModel save(BaseModel baseModel) {
		return null;
	}

	@Override
	public String delete(Long id) {
		return null;
	}

	@Override
	public BaseModel update(BaseModel baseModel, Long id) {
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> findByParameter(String parametro) {
		return null;
	}

	public Optional<Usuario> login(String email){
		return usuarioRepository.login(email);
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
