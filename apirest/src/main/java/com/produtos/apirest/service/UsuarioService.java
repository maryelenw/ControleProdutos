package com.produtos.apirest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.models.Usuario;
import com.produtos.apirest.repository.UsuarioRepository;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Collection<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        for (Usuario k : usuarioRepository.findAll()) {
            usuarios.add(k);
        }
        return usuarios;
    }

    public Usuario findOne(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElse(null);

        return usuario;
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario findUserByLoginAndPassword(String login, String senha)
    {
        return usuarioRepository.findUsuarioByLoginEqualsAndSenha(login, senha);
    }
}