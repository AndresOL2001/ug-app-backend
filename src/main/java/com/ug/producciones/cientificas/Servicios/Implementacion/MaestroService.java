package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Maestro;
import com.ug.producciones.cientificas.Repositorios.MaestroRepository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IMaestroService;

@Service
@Transactional
public class MaestroService implements IMaestroService {

    @Autowired
    private MaestroRepository maestroRepository;

    @Override
    public CompletableFuture<Maestro> guardarMaestro(Maestro maestro) {

        return CompletableFuture.completedFuture(this.maestroRepository.save(maestro));
    }

    @Override
    public CompletableFuture<Maestro> obtenerMaestroPorId(Long long1) {
        return CompletableFuture.completedFuture(this.maestroRepository.findById(long1).get());
    }

    @Override
    public CompletableFuture<List<Maestro>> obtenerMaestros() {
        return CompletableFuture.completedFuture(this.maestroRepository.findAll());
    }

    @Override
    public boolean eliminarMaestro(Long id) {
        try {
            this.maestroRepository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }   
    }

    @Override
    public CompletableFuture<Maestro> obtenerMasestroPorNombreMaestro(String nombre) {
        return CompletableFuture.completedFuture(this.maestroRepository.obtenerMasestroPorNombreMaestro(nombre));
    }

    @Override
    public CompletableFuture<List<Maestro>> obtenerMaestrosPorArticuloId(Long id) {
        return CompletableFuture.completedFuture(this.maestroRepository.obtenerMaestrosPorArticuloId(id));
    }
    
}
