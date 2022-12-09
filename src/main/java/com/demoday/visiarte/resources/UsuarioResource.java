package com.demoday.visiarte.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.demoday.visiarte.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demoday.visiarte.domain.Usuario;
import com.demoday.visiarte.services.UsuarioService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){

		List<Usuario> usuarios = service.findAll();
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usuariosDTO); // retornando usuarios e retornando status de requisicao ok
	}

	@GetMapping(value = "/{username}")
	public ResponseEntity<UsuarioDTO> findByUsername(@PathVariable String username){
		 Usuario usuario = service.findByUsername(username);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario)); // retornando usuarios e retornando status de requisicao ok
	}

	@PostMapping
	public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioDTO userDTO){
		Usuario user = service.fromDTO(userDTO);
		user = service.criar(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(user.getNome_usuario()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
