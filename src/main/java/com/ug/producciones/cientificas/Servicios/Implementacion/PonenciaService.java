package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Ponencia;
import com.ug.producciones.cientificas.Repositorios.PonenciaRepository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IPonenciaService;

@Service
@Transactional
public class PonenciaService implements IPonenciaService{

    @Autowired
    PonenciaRepository ponenciaRepository;


    @Override
    public CompletableFuture<Ponencia> guardarPonencia(Ponencia ponencia) {
        return CompletableFuture.completedFuture(this.ponenciaRepository.save(ponencia));
    }

    @Override
    public CompletableFuture<Ponencia> obtenerPonenciaPorId(Long id) {
        return CompletableFuture.completedFuture(this.ponenciaRepository.findById(id).get());
    }

    @Override
    public CompletableFuture<List<Ponencia>> obtenerPonencias() {
        return CompletableFuture.completedFuture(this.ponenciaRepository.findAll());
    }

    @Override
    public boolean eliminarPonencia(Long id) {
        try {
            this.ponenciaRepository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }   
    }
    
}
