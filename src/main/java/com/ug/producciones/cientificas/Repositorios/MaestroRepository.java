package com.ug.producciones.cientificas.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ug.producciones.cientificas.Entidades.Maestro;

public interface MaestroRepository extends JpaRepository<Maestro,Long>{
    @Query("select m from Maestro m where m.nombre_maestro=?1")
    public Maestro obtenerMasestroPorNombreMaestro( String maestro);

    @Query(value = "select DISTINCT m.* from ((maestros m INNER JOIN articulos_maestros u ON m.maestro_id = u.maestro_id) INNER JOIN articulos a ON u.articulo_id = u.articulo_id and u.articulo_id=?1)",nativeQuery = true)
    public List<Maestro> obtenerMaestrosPorArticuloId(Long id);

    @Query(value = "select DISTINCT m.* from ((maestros m INNER JOIN ponencias_maestros u ON m.maestro_id = u.maestro_id) INNER JOIN ponencias p ON p.ponencia_id = u.ponencia_id and u.ponencia_id=?1)",nativeQuery = true)
    public List<Maestro> obtenerMaestrosPorPonenciaId(Long id);
}
