package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Ponencia_Maestro;
import com.ug.producciones.cientificas.Repositorios.Ponencia_Maestro_Repository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IPonenciaMaestroService;

@Service
@Transactional
public class PonenciaMaestroService implements IPonenciaMaestroService{

    @Autowired
    Ponencia_Maestro_Repository ponencia_Maestro_Repository;

    @Override
    public CompletableFuture<Ponencia_Maestro> guardarPonenciaMaestro(Ponencia_Maestro ponencia) {
        return CompletableFuture.completedFuture(this.ponencia_Maestro_Repository.save(ponencia));
    }

    @Override
    public boolean eliminarPonenciaMaestro(Long id) {
        try {
            this.ponencia_Maestro_Repository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }  
    }
    
}
