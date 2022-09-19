package com.ug.producciones.cientificas.Repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ug.producciones.cientificas.Entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    @Query("select u from Usuario u where u.dni=?1")
    public Usuario obtenerUsuarioPorNombreUsuario( String dni);
}
