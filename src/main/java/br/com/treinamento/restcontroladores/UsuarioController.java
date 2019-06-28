package br.com.treinamento.restcontroladores;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ultracar.treinamento.entidades.Usuario;
import br.com.ultracar.treinamento.servicos.UsuarioService;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> restGet(@PathVariable(name = "id", required = true) Long idUsuario) {
		Usuario usuario = service.findOne(idUsuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}


}
