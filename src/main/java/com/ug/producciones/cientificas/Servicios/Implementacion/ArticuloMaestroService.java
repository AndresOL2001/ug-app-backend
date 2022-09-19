package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Articulo_Maestro;
import com.ug.producciones.cientificas.Repositorios.Articulo_Maestro_Repository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IArticuloMaestroService;

@Service
@Transactional
public class ArticuloMaestroService implements IArticuloMaestroService{

    @Autowired
    Articulo_Maestro_Repository articulo_Maestro_Repository;

    @Override
    public CompletableFuture<Articulo_Maestro> guardarArticuloMaestro(Articulo_Maestro articulo) {
        return CompletableFuture.completedFuture(this.articulo_Maestro_Repository.save(articulo));
    }

    @Override
    public boolean eliminarArticuloMaestro(Long id) {
        try {
            this.articulo_Maestro_Repository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }   
    }
    
}
