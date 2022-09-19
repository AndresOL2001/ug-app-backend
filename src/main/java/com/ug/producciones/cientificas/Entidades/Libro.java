package com.ug.producciones.cientificas.Entidades;

public class Libro {
    private Long id;

    private String facultad;

    private String codigo_ug;

    private String titulo_libro;

    private String codigo_isbn;

    private String editor_compilador;

    private int numero_paginas;

    private String fecha_publicacion;

    private String link_publicacion;

    private int campo_detallado;

    private String filiacion_ug;

    private String revision_por_pares;

    private String dominio_cientifico;

    private String linea_investigacion;

    private String sublinea_investigacion;

    private String titulo_proyecto_fci;

    private String validado_cigc;

    private String observaciones;

    public Libro(Long id, String facultad, String codigo_ug, String titulo_libro, String codigo_isbn,
            String editor_compilador, int numero_paginas, String fecha_publicacion, String link_publicacion,
            int campo_detallado, String filiacion_ug, String revision_por_pares, String dominio_cientifico,
            String linea_investigacion, String sublinea_investigacion, String titulo_proyecto_fci, String validado_cigc,
            String observaciones) {
        this.id = id;
        this.facultad = facultad;
        this.codigo_ug = codigo_ug;
        this.titulo_libro = titulo_libro;
        this.codigo_isbn = codigo_isbn;
        this.editor_compilador = editor_compilador;
        this.numero_paginas = numero_paginas;
        this.fecha_publicacion = fecha_publicacion;
        this.link_publicacion = link_publicacion;
        this.campo_detallado = campo_detallado;
        this.filiacion_ug = filiacion_ug;
        this.revision_por_pares = revision_por_pares;
        this.dominio_cientifico = dominio_cientifico;
        this.linea_investigacion = linea_investigacion;
        this.sublinea_investigacion = sublinea_investigacion;
        this.titulo_proyecto_fci = titulo_proyecto_fci;
        this.validado_cigc = validado_cigc;
        this.observaciones = observaciones;
    }

    public Libro() {
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

    public String getTitulo_libro() {
        return titulo_libro;
    }

    public void setTitulo_libro(String titulo_libro) {
        this.titulo_libro = titulo_libro;
    }

    public String getCodigo_isbn() {
        return codigo_isbn;
    }

    public void setCodigo_isbn(String codigo_isbn) {
        this.codigo_isbn = codigo_isbn;
    }

    public String getEditor_compilador() {
        return editor_compilador;
    }

    public void setEditor_compilador(String editor_compilador) {
        this.editor_compilador = editor_compilador;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getLink_publicacion() {
        return link_publicacion;
    }

    public void setLink_publicacion(String link_publicacion) {
        this.link_publicacion = link_publicacion;
    }

    public int getCampo_detallado() {
        return campo_detallado;
    }

    public void setCampo_detallado(int campo_detallado) {
        this.campo_detallado = campo_detallado;
    }

    public String getFiliacion_ug() {
        return filiacion_ug;
    }

    public void setFiliacion_ug(String filiacion_ug) {
        this.filiacion_ug = filiacion_ug;
    }

    public String getRevision_por_pares() {
        return revision_por_pares;
    }

    public void setRevision_por_pares(String revision_por_pares) {
        this.revision_por_pares = revision_por_pares;
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

    public String getTitulo_proyecto_fci() {
        return titulo_proyecto_fci;
    }

    public void setTitulo_proyecto_fci(String titulo_proyecto_fci) {
        this.titulo_proyecto_fci = titulo_proyecto_fci;
    }

    public String getValidado_cigc() {
        return validado_cigc;
    }

    public void setValidado_cigc(String validado_cigc) {
        this.validado_cigc = validado_cigc;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
}
