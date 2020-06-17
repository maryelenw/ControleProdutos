package com.produtos.apirest.repository;

import com.produtos.apirest.models.Usuario;

//possui métodos que facilitam, fica mais fácil fazer persistência no banco de dados,
// não precisar criar DAO. O JPA facilita utilizando esse JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findById(long id);
    Usuario findUsuarioByLoginEqualsAndSenha(String login, String senha);
}
