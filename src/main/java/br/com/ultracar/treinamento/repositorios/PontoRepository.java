package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>{
	

}
