package com.ug.producciones.cientificas.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ug.producciones.cientificas.Entidades.Libro;

public interface LibroRepository extends JpaRepository<Libro,Long>{
    
}
