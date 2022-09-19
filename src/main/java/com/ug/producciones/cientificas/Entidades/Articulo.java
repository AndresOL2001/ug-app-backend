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


@Table(name="articulos")
@Entity
public class Articulo {

    @Id
    @Column(name = "articulo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String facultad;

    private String codigo_ug;

    private String titulo_publicacion;

    private String base_datos_indexada;

    private String codigo_iss;

    private String tipo_indexacion;

    private String nombre_revista;

    private String numero_revista;

    private String quartil;

    private float SJR;

    private String fecha_publicacion;

    private int campo_detallado;

    private String estado;

    private String link_publicacion;

    private String link_revista;

    private String filiacion_ug;

    private String dominio_cientifico;

    private String linea_investigacion;

    private String sublinea_investigacion;

    private String titulo_proyecto_pci;

    private String validado_cigc;

    private String observacion_cigc;

    /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "articulos_maestros",
            joinColumns = @JoinColumn(name = "maestro_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id")
            )
    private Set<Maestro> maestros = new HashSet<>(); */

    @OneToMany(mappedBy = "articulo")
    private Set<Articulo_Maestro> articulos_masestros = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCodigo_ug() {
        return codigo_ug;
    }

    public void setCodigo_ug(String codigo_ug) {
        this.codigo_ug = codigo_ug;
    }

    public String getTitulo_publicacion() {
        return titulo_publicacion;
    }

    public void setTitulo_publicacion(String titulo_publicacion) {
        this.titulo_publicacion = titulo_publicacion;
    }

    public String getBase_datos_indexada() {
        return base_datos_indexada;
    }

    public void setBase_datos_indexada(String base_datos_indexada) {
        this.base_datos_indexada = base_datos_indexada;
    }

    public String getCodigo_iss() {
        return codigo_iss;
    }

    public void setCodigo_iss(String codigo_iss) {
        this.codigo_iss = codigo_iss;
    }

    public String getTipo_indexacion() {
        return tipo_indexacion;
    }

    public void setTipo_indexacion(String tipo_indexacion) {
        this.tipo_indexacion = tipo_indexacion;
    }

    public String getNombre_revista() {
        return nombre_revista;
    }

    public void setNombre_revista(String nombre_revista) {
        this.nombre_revista = nombre_revista;
    }

    public String getNumero_revista() {
        return numero_revista;
    }

    public void setNumero_revista(String numero_revista) {
        this.numero_revista = numero_revista;
    }

    public String getQuartil() {
        return quartil;
    }

    public void setQuartil(String quartil) {
        this.quartil = quartil;
    }

    public float getSJR() {
        return SJR;
    }

    public void setSJR(float sJR) {
        SJR = sJR;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getCampo_detallado() {
        return campo_detallado;
    }

    public void setCampo_detallado(int campo_detallado) {
        this.campo_detallado = campo_detallado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLink_publicacion() {
        return link_publicacion;
    }

    public void setLink_publicacion(String link_publicacion) {
        this.link_publicacion = link_publicacion;
    }

    public String getLink_revista() {
        return link_revista;
    }

    public void setLink_revista(String link_revista) {
        this.link_revista = link_revista;
    }

    public String getFiliacion_ug() {
        return filiacion_ug;
    }

    public void setFiliacion_ug(String filiacion_ug) {
        this.filiacion_ug = filiacion_ug;
    }

    public String getDominio_cientifico() {
        return dominio_cientifico;
    }

    public void setDominio_cientifico(String dominio_cientifico) {
        this.dominio_cientifico = dominio_cientifico;
    }

    public String getLinea_investigacion() {
        return linea_investigacion;
    }

    public void setLinea_investigacion(String linea_investigacion) {
        this.linea_investigacion = linea_investigacion;
    }

    public String getSublinea_investigacion() {
        return sublinea_investigacion;
    }

    public void setSublinea_investigacion(String sublinea_investigacion) {
        this.sublinea_investigacion = sublinea_investigacion;
    }

    public String getTitulo_proyecto_pci() {
        return titulo_proyecto_pci;
    }

    public void setTitulo_proyecto_pci(String titulo_proyecto_pci) {
        this.titulo_proyecto_pci = titulo_proyecto_pci;
    }

    public String getValidado_cigc() {
        return validado_cigc;
    }

    public void setValidado_cigc(String validado_cigc) {
        this.validado_cigc = validado_cigc;
    }

    public String getObservacion_cigc() {
        return observacion_cigc;
    }

    public void setObservacion_cigc(String observacion_cigc) {
        this.observacion_cigc = observacion_cigc;
    }

    

}
