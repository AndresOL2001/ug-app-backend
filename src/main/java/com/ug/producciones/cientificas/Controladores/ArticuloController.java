package com.ug.producciones.cientificas.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.producciones.cientificas.DTOs.Maestro.ArticuloMaestroDTO;
import com.ug.producciones.cientificas.Entidades.Articulo;
import com.ug.producciones.cientificas.Entidades.Articulo_Maestro;
import com.ug.producciones.cientificas.Entidades.Maestro;
import com.ug.producciones.cientificas.Servicios.Implementacion.ArticuloMaestroService;
import com.ug.producciones.cientificas.Servicios.Implementacion.ArticuloService;
import com.ug.producciones.cientificas.Servicios.Implementacion.MaestroService;

@RequestMapping("/api/articulos")
@RestController
public class ArticuloController {
    private final ArticuloService articuloService;
    private final MaestroService maestroService;
    private final ArticuloMaestroService articuloMaestroService;

    @Autowired
    public ArticuloController(ArticuloService articuloService,MaestroService maestroService,ArticuloMaestroService articuloMaestroService) {
        this.articuloService = articuloService;
        this.maestroService = maestroService;
        this.articuloMaestroService = articuloMaestroService;
    }

    @PostMapping()
    public ResponseEntity<Object> crearArticulo(@Valid @RequestBody Articulo articulo, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Revise los campos e intente nuevamente", HttpStatus.BAD_REQUEST);
            
            try {
                 this.articuloService.guardarArticulo(articulo).get();
            } catch (Exception e) {
                return new ResponseEntity<>("Error: El campo articulo no puede estar vacío"+e.getMessage(), HttpStatus.BAD_REQUEST);
            }
          
        return new ResponseEntity<>("El articulo se ha creado correctamente", HttpStatus.CREATED);
    }   

    @PostMapping("/asignarMaestro/{articuloid}")
    public ResponseEntity<Object> asignarMaestro( @RequestBody ArticuloMaestroDTO maestro,@PathVariable Long articuloid) throws InterruptedException, ExecutionException {
        
        Articulo_Maestro articulo_Maestro = new Articulo_Maestro();

            try {
             Maestro maestroBD = this.maestroService.obtenerMaestroPorId(maestro.getIdMaestro()).get();
            
             Articulo articuloBD = this.articuloService.obtenerArticuloPorId(articuloid).get();
             
            articulo_Maestro.setArticulo(articuloBD);
            articulo_Maestro.setMaestro(maestroBD);
            articulo_Maestro.setParticipacion(maestro.getParticipacion());

            this.articuloMaestroService.guardarArticuloMaestro(articulo_Maestro);

            } catch (Exception e) {
                return new ResponseEntity<>("Error:"+e.getMessage(), HttpStatus.BAD_REQUEST);
            }
          
        return new ResponseEntity<>("El maestro se ha asignado correctamente", HttpStatus.CREATED);
    }   

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminarArticulo(@PathVariable Long id) {
            
        try {
            this.articuloService.eliminarArticulo(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:No encontró ningún articulo con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>("articulo eliminado correctamente", HttpStatus.OK);
}

    @GetMapping()
    public ResponseEntity<Object> obtenerArticulos() {
            List<Articulo> articulos = new ArrayList<>(); 
            try {
                articulos = articuloService.obtenerArticulos().get();
            } catch (Exception e) {
                return new ResponseEntity<>("Error"+e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
          
        return new ResponseEntity<>(articulos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> obtenerArticuloPorId(@PathVariable Long id) {
        Articulo articulo = new Articulo(); 
        try {
            articulo = articuloService.obtenerArticuloPorId(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Error no existe ningun articulo con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>(articulo, HttpStatus.OK);
    }

    

}
