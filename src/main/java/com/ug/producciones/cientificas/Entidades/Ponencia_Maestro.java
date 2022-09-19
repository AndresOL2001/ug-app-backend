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
@Table(name = "ponencias_maestros")
public class Ponencia_Maestro {
    @Id
    @Column(name = "ponencia_maestro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="maestro_id")
    private Maestro maestro;

    @ManyToOne
    @JoinColumn(name="ponencia_id")
    private Ponencia ponencia;

    private String participacion;

 
    public Ponencia_Maestro(Long id, Maestro maestro, Ponencia ponencia, String participacion) {
        this.id = id;
        this.maestro = maestro;
        this.ponencia = ponencia;
        this.participacion = participacion;
    }

    public Ponencia_Maestro() {
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

   

    public String getParticipacion() {
        return participacion;
    }

    public void setParticipacion(String participacion) {
        this.participacion = participacion;
    }

    public Ponencia getPonencia() {
        return ponencia;
    }

    public void setPonencia(Ponencia ponencia) {
        this.ponencia = ponencia;
    }
}
