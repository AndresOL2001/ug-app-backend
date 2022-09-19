package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Libro;

public interface ILibroService {
    public CompletableFuture<Libro> guardarLibro(Libro libro);

    public CompletableFuture<Libro> obtenerLibroPorId(Long id);

    public CompletableFuture<List<Libro>> obtenerLibros();

    public boolean eliminarLibro(Long id);
}

