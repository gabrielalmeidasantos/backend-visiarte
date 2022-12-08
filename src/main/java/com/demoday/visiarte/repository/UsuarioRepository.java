package com.demoday.visiarte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demoday.visiarte.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
