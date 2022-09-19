package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.Entidades.Rol;
import com.ug.producciones.cientificas.Repositorios.RolRepository;
import com.ug.producciones.cientificas.Servicios.Interfaces.IRolService;

@Service
@Transactional
public class RolService implements IRolService{

    @Autowired
    RolRepository rolRepository;
    
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CompletableFuture<Optional<Rol>> getByRolName(String roleName) {
        return CompletableFuture.completedFuture(this.rolRepository.findByNombre(roleName));
    }

    @Override
    public CompletableFuture<Rol> guardarRol(Rol rol) {
        return CompletableFuture.completedFuture(this.rolRepository.save(rol));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CompletableFuture<List<Rol>> obtenerRoles() {
        return CompletableFuture.completedFuture(this.rolRepository.findAll());
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public CompletableFuture<Rol> obtenerRolPorId(int id) {
        return CompletableFuture.completedFuture(this.rolRepository.findById(id).get());
    }

    @Override
    public boolean eliminarRol(int id) {
        try {
            this.rolRepository.deleteById(id);
            return true;
         } catch (Exception e) {
            return false;
         }   
    }
    
}
