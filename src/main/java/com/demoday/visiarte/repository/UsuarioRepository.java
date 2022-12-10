package com.demoday.visiarte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demoday.visiarte.domain.Usuario;

@Repository //Identificador spring para repositório. Que seria o banco de dados, identificação, o spring entende que estamos trabalhando com um repositório.
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    //Funções responsáveis por buscar dentro de um usuário um parâmentro específico.

    @Query("{ 'nome_usuario': ?0}")
    Usuario findUsername(String username);

    @Query("{ 'email': ?0}")
    Usuario findEmail(String username);

    @Query("{ 'id': ?0}")
    Usuario findUsuarioById(String id);

    @Query("{ 'senha': ?0}")
    Usuario findSenha(String id);
}
