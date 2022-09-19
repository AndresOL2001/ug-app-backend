package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Articulo;

public interface IArticuloService {
    public CompletableFuture<Articulo> guardarArticulo(Articulo articulo);

    public CompletableFuture<Articulo> obtenerArticuloPorId(Long id);

    public CompletableFuture<List<Articulo>> obtenerArticulos();

    public boolean eliminarArticulo(Long id);
}
