package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Usuario;

public interface IUsuarioService {
    public CompletableFuture<Usuario> obtenerUsuarioPorCelular( String celular);

    public CompletableFuture<Usuario> guardarUsuario(Usuario usuario);

    public CompletableFuture<Usuario> obtenerUsuarioPorId(Integer id);

    public CompletableFuture<List<Usuario>> obtenerUsuarios();

    public CompletableFuture<Usuario> obtenerUsuarioPorNombre(String username);
}
