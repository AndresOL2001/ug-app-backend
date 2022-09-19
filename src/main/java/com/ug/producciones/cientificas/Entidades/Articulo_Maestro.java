package com.ug.producciones.cientificas.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="articulos_maestros")
public class Articulo_Maestro {
    @Id
    @Column(name = "articulo_maestro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="maestro_id")
    private Maestro maestro;

    @ManyToOne
    @JoinColumn(name="articulo_id")
    private Articulo articulo;

    private String participacion;

    public Articulo_Maestro(Long id, Maestro maestro, Articulo articulo, String participacion) {
        this.id = id;
        this.maestro = maestro;
        this.articulo = articulo;
        this.participacion = participacion;
    }

    public Articulo_Maestro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getParticipacion() {
        return participacion;
    }

    public void setParticipacion(String participacion) {
        this.participacion = participacion;
    }

    
}
