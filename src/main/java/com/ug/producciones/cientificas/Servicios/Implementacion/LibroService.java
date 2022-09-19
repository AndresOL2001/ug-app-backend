package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Libro;
import com.ug.producciones.cientificas.Repositorios.LibroRepository;
import com.ug.producciones.cientificas.Servicios.Interfaces.ILibroService;

@Service
@Transactional
public class LibroService implements ILibroService{

    @Autowired
    LibroRepository libroRepository;

    @Override
    public CompletableFuture<Libro> guardarLibro(Libro libro) {
        return CompletableFuture.completedFuture(this.libroRepository.save(libro));
    }

    @Override
    public CompletableFuture<Libro> obtenerLibroPorId(Long id) {
        return CompletableFuture.completedFuture(this.libroRepository.findById(id).get());
    }

    @Override
    public CompletableFuture<List<Libro>> obtenerLibros() {
        return CompletableFuture.completedFuture(this.libroRepository.findAll());
    }

    @Override
    public boolean eliminarLibro(Long id) {
        try {
            this.libroRepository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }      
        }
    
}
