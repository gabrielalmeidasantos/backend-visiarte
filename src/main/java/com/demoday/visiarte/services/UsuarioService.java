package com.demoday.visiarte.services;

import java.util.List;
import java.util.Objects;

import com.demoday.visiarte.dto.UsuarioDTO;
import com.demoday.visiarte.services.exception.ObjectNotFoundException;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.demoday.visiarte.domain.Usuario;
import com.demoday.visiarte.repository.UsuarioRepository;

@Service //Identificador spring para service. Que seria a classe responsável por criar as funções a serem acessadas pelo controller.
public class UsuarioService {
	
	@Autowired	// o AutoWired, só serve para não ter que fazer a instanciação padrão, sem ele seria: UsuarioService service = new UsuarioService();
	private UsuarioRepository repo; //Referência a interface repositório.

	//Função responsável por mostrar todas as telas.
	public List<Usuario> findAll(){
		return repo.findAll();
	}

	//Valor boolean que retorna se um usuário existe ou não, função útil para revitar a retrabalho.
	public boolean existe(String email, String username, String id){
		Usuario usuarioEmail = repo.findEmail(email);
		Usuario usuariousername = repo.findUsername(username);
		Usuario usuarioId = repo.findUsuarioById(id);

		return usuariousername == null && usuarioEmail == null && usuarioId == null;
	}

	//Função responsável por buscar um usuário pelo username(nome_usuario - nome encontrado dentro da classe modelo Usuário).
	public Usuario findByUsername(String username){
		Usuario usuario = repo.findUsername(username);
		if (usuario == null){
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}
	//Função responsável por buscar um usuário pelo Id(id - nome encontrado dentro da classe modelo Usuário);
	public Usuario findUserById(String id){
		Usuario usuario = repo.findUsuarioById(id);
		if (usuario == null){
			throw new ObjectNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}

	//Função criar usuário, essa função talvez seja removida ou alterada, uma vez que não contra com nenhum método de
	//autenticação ou regra na criação.
	public Usuario criar(Usuario usuario){
		if (!existe(usuario.getEmail(), usuario.getNome_usuario(), usuario.getId())) {
			throw new ObjectNotFoundException("Usuário ou email já existente");
		}
			return repo.save(usuario);

	}
	//Função responsável por deletar o Usuário pelo nome(nome_usuario - nome encontrado dentro da classe modelo Usuário)
	public void deleteByUsername(String username){
		repo.delete(findByUsername(username));
	}
	//Função responsável por deletar o Usuário pelo id(id - nome encontrado dentro da classe modelo Usuário)
	public void deleteById(String username){
		repo.delete(findUserById(username));
	}
	//DTO(Data Transfer Object) é um padrão de encapsulamento para enviar data de um subsistema a outro.
	//nesse caso enviar nosso usuário para o banco de dados.
	public Usuario fromDTO(UsuarioDTO objDTO){
		return new Usuario(objDTO.getId(), objDTO.getNome_usuario(), objDTO.getNome_completo(), objDTO.getBio(), objDTO.getData_nascimento(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getFoto_perfil(), objDTO.getFoto_capa(), objDTO.getQuant_seguidores(), objDTO.getQuant_seguindo());
	}
	//Função responsável por atualizar um usuário.
	public void replace(String id, Usuario usuario) {
		deleteById(id);
		repo.save(usuario);
	}
	public Usuario login(String usuarioLogin, String senha){
		Usuario usuario = repo.findUsername(usuarioLogin);

		if (usuario != null){
			//Achou o usuário
			if (!Objects.equals(usuario.getSenha(), senha)){
				//Usuário e senha encontrados.
				throw new ObjectNotFoundException("Senha não corresponde ao usuário encontrado.");
			}
		}
		else {
			usuario = repo.findEmail(usuarioLogin);
			if (usuario != null){
				if (!Objects.equals(usuario.getSenha(), senha)){
					//Usuário e senha encontrados.
					throw new ObjectNotFoundException("Senha não corresponde ao email encontrado.");
				}
			}
			else {
				throw new ObjectNotFoundException("usuário/email não encontrado");
			}
		}
		return usuario;
	}





}
