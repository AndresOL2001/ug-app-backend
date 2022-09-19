package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Articulo;
import com.ug.producciones.cientificas.Repositorios.ArticuloRepository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IArticuloService;

@Service
@Transactional
public class ArticuloService implements IArticuloService{

    @Autowired
    private ArticuloRepository articuloRepository;
    
    @Override
    public CompletableFuture<Articulo> guardarArticulo(Articulo articulo) {
        return CompletableFuture.completedFuture(this.articuloRepository.save(articulo));
    }

    @Override
    public CompletableFuture<Articulo> obtenerArticuloPorId(Long id) {
        return CompletableFuture.completedFuture(this.articuloRepository.findById(id).get());

    }

    @Override
    public CompletableFuture<List<Articulo>> obtenerArticulos() {
        return CompletableFuture.completedFuture(this.articuloRepository.findAll());
    }

    @Override
    public boolean eliminarArticulo(Long id) {
        try {
            this.articuloRepository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }   
    }
    
}
