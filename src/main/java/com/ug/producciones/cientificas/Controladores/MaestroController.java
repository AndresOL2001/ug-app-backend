package com.ug.producciones.cientificas.Controladores;

import java.util.ArrayList;
import java.util.List;

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

import com.ug.producciones.cientificas.Entidades.Maestro;
import com.ug.producciones.cientificas.Servicios.Implementacion.MaestroService;

@RequestMapping("/api/maestros")
@RestController
public class MaestroController {
    
    private final MaestroService maestroService;

    @Autowired
    public MaestroController(MaestroService maestroService) {
        this.maestroService = maestroService;
    }

    @PostMapping()
    public ResponseEntity<Object> crearMaestro(@Valid @RequestBody Maestro maestro, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Revise los campos e intente nuevamente", HttpStatus.BAD_REQUEST);
            
            try {
                 this.maestroService.guardarMaestro(maestro).get();
            } catch (Exception e) {
                return new ResponseEntity<>("Error: El campo maestro no puede estar vacío"+e.getMessage(), HttpStatus.BAD_REQUEST);
            }
          
        return new ResponseEntity<>("El maestro se ha creado correctamente", HttpStatus.CREATED);
    }   

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminarMaestro(@PathVariable Long id) {
            
        try {
            this.maestroService.eliminarMaestro(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:No encontró ningún maestro con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>("maestro eliminado correctamente", HttpStatus.OK);
}

    @GetMapping()
    public ResponseEntity<Object> obtenerMaestros() {
            List<Maestro> maestros = new ArrayList<>(); 
            try {
                maestros = maestroService.obtenerMaestros().get();
            } catch (Exception e) {
                return new ResponseEntity<>("Error"+e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
          
        return new ResponseEntity<>(maestros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerMaestroPorId(@PathVariable Long id) {
        Maestro maestro = new Maestro(); 
        try {
            maestro = maestroService.obtenerMaestroPorId(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Error no existe ningun maestro con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>(maestro, HttpStatus.OK);
    }

    @GetMapping("/articulo/{articuloId}")
    public ResponseEntity<Object> obtenerMaestrosPorIdArticulo(@PathVariable Long articuloId){
        List<Maestro> maestros = new ArrayList<>();
        try {
            maestros = maestroService.obtenerMaestrosPorArticuloId(articuloId).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Error no existe ningun maestro asociado al articulo con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>(maestros, HttpStatus.OK);
    }

}
