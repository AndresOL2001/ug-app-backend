package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Usuario;
import com.ug.producciones.cientificas.Repositorios.UsuarioRepository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IUsuarioService;

@Transactional
@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    UsuarioRepository userRepository;

    @Override
    public CompletableFuture<Usuario> obtenerUsuarioPorCelular(String celular) {
        return null;
    }

    @Override
    public CompletableFuture<Usuario> guardarUsuario(Usuario usuario) {
        return CompletableFuture.completedFuture(this.userRepository.save(usuario));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CompletableFuture<Usuario> obtenerUsuarioPorId(Integer id) {
        return CompletableFuture.completedFuture(this.userRepository.findById(id).get());
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CompletableFuture<List<Usuario>> obtenerUsuarios() {
        return CompletableFuture.completedFuture(this.userRepository.findAll());
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CompletableFuture<Usuario> obtenerUsuarioPorNombre(String username) {
        return CompletableFuture.completedFuture(this.userRepository.obtenerUsuarioPorNombreUsuario(username));
    }


}
