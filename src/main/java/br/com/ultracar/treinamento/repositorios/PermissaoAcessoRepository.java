package br.com.ultracar.treinamento.repositorios;

import java.util.concurrent.Future;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.GrupoAcesso;
import br.com.ultracar.treinamento.entidades.PermissaoAcesso;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface PermissaoAcessoRepository extends JpaRepository<PermissaoAcesso, Long>{

	@Query("Select e From PermissaoAcesso e Where e.usuario = ?1 ")
	public Page<PermissaoAcesso> findByUsuario(Usuario usuario, Pageable pageable);
	
	
	@Async
	@Query("Select e From PermissaoAcesso e Where e.usuario = ?1 ")
	public Future<PermissaoAcesso> findByGrupoAcesso(GrupoAcesso grupoAcesso);
	
}
