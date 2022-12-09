package com.demoday.visiarte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demoday.visiarte.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    @Query("{ 'nome_usuario': ?0}")
    Usuario findUsername(String username);

    @Query("{ 'email': ?0}")
    Usuario findEmail(String username);
}
