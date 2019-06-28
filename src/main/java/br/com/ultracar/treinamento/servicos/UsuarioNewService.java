package br.com.ultracar.treinamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.repositorios.UsuarioRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioNewService {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deletarUmUsuario(Long id) {
		this.repositorio.deleteById(id);
	}
	
}
