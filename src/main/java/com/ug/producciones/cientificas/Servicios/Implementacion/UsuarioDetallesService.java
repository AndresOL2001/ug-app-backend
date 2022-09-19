package com.ug.producciones.cientificas.Servicios.Implementacion;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ug.producciones.cientificas.DTOs.Seguridad.UsuarioDetalles;
import com.ug.producciones.cientificas.Entidades.Usuario;

@Service
public class UsuarioDetallesService implements UserDetailsService{
    private final UsuarioService userService;
    private Logger logger = LoggerFactory.getLogger(UsuarioDetallesService.class);
    
    @Autowired
    public UsuarioDetallesService(UsuarioService userService) {
        this.userService = userService;
    }
    
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario user = new Usuario();
        try {
            user = userService.obtenerUsuarioPorNombre(usuario).get();
        } catch (InterruptedException e) {
            logger.info(e.getMessage());            
        } catch (ExecutionException e) {
            logger.info(e.getMessage());            
        }
        return UsuarioDetalles.build(user);
    
    }
    
}
