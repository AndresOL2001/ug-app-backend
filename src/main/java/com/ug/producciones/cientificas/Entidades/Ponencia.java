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

@Entity
@Table(name="ponencias")
public class Ponencia {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="ponencia_id")
   private Long id;

   private String facultad;

   private String codigo_ug;

   private String nombre_ponencia;

   private String nombre_evento;

   private String base_datos_indexada;

   private String codigo_isbn_issn;

   private String tipo_indexacion;

   private String edicion_evento;

   private String organizador_evento;

   private String comite_organizador;

   private String pais;

   private String ciudad;

   private String fecha_publicacion;

   private String quartil;

   private String sjr;

   private int campo_detallado;

   private String link_publicacion;

   private String filiacion_ug;

   private String dominio_cientifico;

   private String linea_investigacion;

   private String sublinea_investigacion;

  /*  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(
           name = "ponencias_maestros",
           joinColumns = @JoinColumn(name = "maestro_id"),
           inverseJoinColumns = @JoinColumn(name = "ponencia_id")
           )
   private Set<Maestro> maestros = new HashSet<>(); */
   
   @OneToMany(mappedBy = "ponencia")
   private Set<Ponencia_Maestro> ponencia_maestros = new HashSet<>();
   

public Ponencia(Long id, String facultad, String codigo_ug, String nombre_ponencia, String nombre_evento,
        String base_datos_indexada, String codigo_isbn_issn, String tipo_indexacion, String edicion_evento,
        String organizador_evento, String comite_organizador, String pais, String ciudad, String fecha_publicacion,
        String quartil, String sjr, int campo_detallado, String link_publicacion, String filiacion_ug,
        String dominio_cientifico, String linea_investigacion, String sublinea_investigacion) {
    this.id = id;
    this.facultad = facultad;
    this.codigo_ug = codigo_ug;
    this.nombre_ponencia = nombre_ponencia;
    this.nombre_evento = nombre_evento;
    this.base_datos_indexada = base_datos_indexada;
    this.codigo_isbn_issn = codigo_isbn_issn;
    this.tipo_indexacion = tipo_indexacion;
    this.edicion_evento = edicion_evento;
    this.organizador_evento = organizador_evento;
    this.comite_organizador = comite_organizador;
    this.pais = pais;
    this.ciudad = ciudad;
    this.fecha_publicacion = fecha_publicacion;
    this.quartil = quartil;
    this.sjr = sjr;
    this.campo_detallado = campo_detallado;
    this.link_publicacion = link_publicacion;
    this.filiacion_ug = filiacion_ug;
    this.dominio_cientifico = dominio_cientifico;
    this.linea_investigacion = linea_investigacion;
    this.sublinea_investigacion = sublinea_investigacion;
}

public Ponencia() {
}

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

public String getNombre_ponencia() {
    return nombre_ponencia;
}

public void setNombre_ponencia(String nombre_ponencia) {
    this.nombre_ponencia = nombre_ponencia;
}

public String getNombre_evento() {
    return nombre_evento;
}

public void setNombre_evento(String nombre_evento) {
    this.nombre_evento = nombre_evento;
}

public String getBase_datos_indexada() {
    return base_datos_indexada;
}

public void setBase_datos_indexada(String base_datos_indexada) {
    this.base_datos_indexada = base_datos_indexada;
}

public String getCodigo_isbn_issn() {
    return codigo_isbn_issn;
}

public void setCodigo_isbn_issn(String codigo_isbn_issn) {
    this.codigo_isbn_issn = codigo_isbn_issn;
}

public String getTipo_indexacion() {
    return tipo_indexacion;
}

public void setTipo_indexacion(String tipo_indexacion) {
    this.tipo_indexacion = tipo_indexacion;
}

public String getEdicion_evento() {
    return edicion_evento;
}

public void setEdicion_evento(String edicion_evento) {
    this.edicion_evento = edicion_evento;
}

public String getOrganizador_evento() {
    return organizador_evento;
}

public void setOrganizador_evento(String organizador_evento) {
    this.organizador_evento = organizador_evento;
}

public String getComite_organizador() {
    return comite_organizador;
}

public void setComite_organizador(String comite_organizador) {
    this.comite_organizador = comite_organizador;
}

public String getPais() {
    return pais;
}

public void setPais(String pais) {
    this.pais = pais;
}

public String getCiudad() {
    return ciudad;
}

public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
}

public String getFecha_publicacion() {
    return fecha_publicacion;
}

public void setFecha_publicacion(String fecha_publicacion) {
    this.fecha_publicacion = fecha_publicacion;
}

public String getQuartil() {
    return quartil;
}

public void setQuartil(String quartil) {
    this.quartil = quartil;
}

public String getSjr() {
    return sjr;
}

public void setSjr(String sjr) {
    this.sjr = sjr;
}

public int getCampo_detallado() {
    return campo_detallado;
}

public void setCampo_detallado(int campo_detallado) {
    this.campo_detallado = campo_detallado;
}

public String getLink_publicacion() {
    return link_publicacion;
}

public void setLink_publicacion(String link_publicacion) {
    this.link_publicacion = link_publicacion;
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

   
}
