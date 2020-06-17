package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Classe que vai receber as requisições HTTP
@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

    //    Ponto de injeção pra utilizar os métodos pra se conectar ao banco de dados
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario listaUsuarioUnico(@PathVariable(value = "id") long id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario salvaUsuario(
            @RequestBody Usuario usuario
    ){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario")
    public void deletaUsuario(@RequestBody Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    @PutMapping("/usuario")
    public Usuario atualizaUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
