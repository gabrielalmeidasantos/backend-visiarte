package com.demoday.visiarte.services;

import java.util.List;

import com.demoday.visiarte.dto.UsuarioDTO;
import com.demoday.visiarte.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.demoday.visiarte.domain.Usuario;
import com.demoday.visiarte.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

	public boolean existe(String email, String username){
		Usuario usuarioEmail = repo.findEmail(email);
		Usuario usuariousername = repo.findUsername(username);

		return usuariousername == null && usuarioEmail == null;

	}

	public Usuario findByUsername(String username){
		Usuario usuario = repo.findUsername(username);
		if (usuario == null){
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}

	public Usuario criar(Usuario usuario){
		if (!existe(usuario.getEmail(), usuario.getNome_usuario())) {
			throw new ObjectNotFoundException("Usuário ou email já existente");
		}
			return repo.save(usuario);
	}

	public Usuario fromDTO(UsuarioDTO objDTO){
		return new Usuario(objDTO.getId(), objDTO.getNome_usuario(), objDTO.getNome_completo(), objDTO.getBio(), objDTO.getData_nascimento(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getFoto_perfil(), objDTO.getFoto_capa(), objDTO.getQuant_seguidores(), objDTO.getQuant_seguindo());
	}
}
