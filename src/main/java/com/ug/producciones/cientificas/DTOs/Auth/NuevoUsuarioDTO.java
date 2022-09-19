package com.ug.producciones.cientificas.DTOs.Auth;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class NuevoUsuarioDTO {
    
    @NotBlank
    private String dni;
    @NotBlank
    private String contraseña;
    private Set<String> roles = new HashSet<>();
    private String correo;
    
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
