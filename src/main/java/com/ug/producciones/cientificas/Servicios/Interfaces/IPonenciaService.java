package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Ponencia;

public interface IPonenciaService {
    public CompletableFuture<Ponencia> guardarPonencia(Ponencia ponencia);

    public CompletableFuture<Ponencia> obtenerPonenciaPorId(Long id);

    public CompletableFuture<List<Ponencia>> obtenerPonencias();

    public boolean eliminarPonencia(Long id);
}
