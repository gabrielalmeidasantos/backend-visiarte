package com.demoday.visiarte.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoday.visiarte.domain.Usuario;
import com.demoday.visiarte.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){

		List<Usuario> usuarios = service.findAll();
		return ResponseEntity.ok().body(usuarios); // retornando usuarios e retornando status de requisicao ok 
	}
}
