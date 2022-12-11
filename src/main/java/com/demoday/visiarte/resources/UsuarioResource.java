package com.demoday.visiarte.resources;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.demoday.visiarte.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demoday.visiarte.domain.Usuario;
import com.demoday.visiarte.services.UsuarioService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//Almeida pelo amor de deus, comenta esse código meu fi kkkkkkkkkkkkkk.

@RestController //Identificador para o spring saber que estamos lidando com um controller, fazendo ele herdar todas as funções de um controller.
@RequestMapping(value="/usuarios") //outro identificador. Para rodar todas as funções dentro do controller, vamos ter que acessar por esse path.
public class UsuarioResource {
	//--------------------------------------------Instanciações------------------------------------------------------------------------------------
	//Está instanciando a class Usuario service.
	@Autowired // o AutoWired, só serve para não ter que fazer a instanciação padrão, sem ele seria: UsuarioService service = new UsuarioService();
	private UsuarioService service;//No service, toda a parte de criação de funções e parte da lógica delas, pode ser encontrada.
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	//Esse como é possível observar, é o GetMapping padrão, ao entrar no local host, com o get, ele vai retornar essa função.

	@GetMapping //Retorno padrão da função Get.
	//Função responsável por listar todos os usuários, no método get.
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> usuarios = service.findAll();
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(usuariosDTO); // retornando usuarios e retornando status de requisicao ok
	}

	//Essa é uma função que tem como objetivo retornar um usuário em específico, passar o username do próprio.
	@GetMapping(value = "/{username}")
	public ResponseEntity<UsuarioDTO> findByUsername(@PathVariable String username){
		 Usuario usuario = service.findByUsername(username);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario)); // retornando usuarios e retornando status de requisicao ok
	}

	//Função responsável por realizar o método post, ou "Criar".
	@PostMapping
	public ResponseEntity<Void> criarUsuario(@RequestBody UsuarioDTO userDTO){
		Usuario user = service.fromDTO(userDTO);
		user = service.criar(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(user.getNome_usuario()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//DeleteMapping padrão.
	@DeleteMapping(path = "/{id}")
	//Função responsável por deletar um usuário pelo Id
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//Put padrão.
	@PutMapping(path = "/update/{id}")//ESse é o path do mapping, o path contém uma variável chamada {id}, o @PathVariable serve para especificar que tipo de variável
	//está sendo passada.
	//Função responsável por atualizar um usuário sendo buscado pelo ID.
	public ResponseEntity<Void> replace(@PathVariable String id, @RequestBody Usuario usuario){
		service.replace(id, usuario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	//Função responsável pelo login da plataforma.
	//O objeto Map, foi de extrema importância para conluir essa função de login, ele é responsável por quebrar o @ResquestBody
	//em diferentes strings.
	@PostMapping(path = "/login")
	public Usuario login(@RequestBody Map<String, String> userMap){
		String username = userMap.get("usuarioLogin");
		String senha = userMap.get("senha");
		return service.login(username, senha);
	}

}
