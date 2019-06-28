package br.com.ultracar.treinamento.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.repositorios.UsuarioRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	@Autowired
	private UsuarioNewService newService;
	
	public Usuario findOne(Long id) {
		return this.repositorio.getOne(id);
	}
	
	public void salvarUsuario(Usuario usuario) {
		this.repositorio.save(usuario);
	}
	
	public void deletarUsuario(Usuario usuario) {
		this.repositorio.deleteById(usuario.getId());
	}
	
	public void deletarMuitosUsuario(List<Long> ids) {
		ids.parallelStream().forEach(id -> {
			this.repositorio.save(this.repositorio.getOne(id));
			if(this.repositorio.existsById(id)) {
				this.newService.deletarUmUsuario(id);
			}
		});
	}
	
	

}
