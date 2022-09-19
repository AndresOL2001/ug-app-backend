package com.ug.producciones.cientificas.Servicios.Interfaces;

import java.util.concurrent.CompletableFuture;

import com.ug.producciones.cientificas.Entidades.Ponencia_Maestro;

public interface IPonenciaMaestroService {
    public CompletableFuture<Ponencia_Maestro> guardarPonenciaMaestro(Ponencia_Maestro ponencia);


    public boolean eliminarPonenciaMaestro(Long id);
}
