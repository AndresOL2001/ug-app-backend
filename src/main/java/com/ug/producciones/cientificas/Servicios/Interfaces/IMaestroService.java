package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Maestro;

public interface IMaestroService {
    public CompletableFuture<Maestro> guardarMaestro(Maestro maestro);

    public CompletableFuture<Maestro> obtenerMaestroPorId(Long id);

    public CompletableFuture<List<Maestro>> obtenerMaestros();

    public CompletableFuture<Maestro> obtenerMasestroPorNombreMaestro(String nombre);

    public CompletableFuture<List<Maestro>> obtenerMaestrosPorArticuloId(Long id);

    public boolean eliminarMaestro(Long id);

}
