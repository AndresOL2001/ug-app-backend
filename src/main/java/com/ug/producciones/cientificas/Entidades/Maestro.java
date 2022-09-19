package com.ug.producciones.cientificas.Entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="maestros")
@Entity
public class Maestro {
    @Id
    @Column(name = "maestro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cedula;

    private String nombre_maestro;

    private String modalidad_contrato;

    private String facultad;

    @OneToMany(mappedBy = "maestro")
    private Set<Articulo_Maestro> articulos_maestros = new HashSet<>();

    @OneToMany(mappedBy = "maestro")
    private Set<Ponencia_Maestro> ponencia_maestros = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_maestro() {
        return nombre_maestro;
    }

    public void setNombre_maestro(String nombre_maestro) {
        this.nombre_maestro = nombre_maestro;
    }

    public String getModalidad_contrato() {
        return modalidad_contrato;
    }

    public void setModalidad_contrato(String modalidad_contrato) {
        this.modalidad_contrato = modalidad_contrato;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    

   
}
