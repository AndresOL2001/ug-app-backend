package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Articulo_Maestro;

public interface IArticuloMaestroService {
    public CompletableFuture<Articulo_Maestro> guardarArticuloMaestro(Articulo_Maestro articulo);


    public boolean eliminarArticuloMaestro(Long id);
}
