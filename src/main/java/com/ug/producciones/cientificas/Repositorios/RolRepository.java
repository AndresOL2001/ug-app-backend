package com.ug.producciones.cientificas.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ug.producciones.cientificas.Entidades.Rol;

public interface RolRepository extends JpaRepository<Rol,Integer>{
    Optional<Rol> findByNombre(String nombre);

}
