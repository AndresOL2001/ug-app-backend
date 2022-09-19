package com.ug.producciones.cientificas.Entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @Column(name="usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dni;

    private String contraseña;

    private String correo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
            )
    private Set<Rol> roles = new HashSet<>();

    


    public Usuario() {
    }

    public Usuario(Integer id, String dni, String contraseña, String correo, Set<Rol> roles) {
        this.id = id;
        this.dni = dni;
        this.contraseña = contraseña;
        this.correo = correo;
        this.roles = roles;
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



 

    public Set<Rol> getRoles() {
        return roles;
    }



    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
}
