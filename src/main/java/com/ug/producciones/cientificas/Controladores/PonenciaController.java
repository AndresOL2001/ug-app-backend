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

import com.ug.producciones.cientificas.DTOs.Maestro.PonenciaMaestroDTO;
import com.ug.producciones.cientificas.Entidades.Maestro;
import com.ug.producciones.cientificas.Entidades.Ponencia;
import com.ug.producciones.cientificas.Entidades.Ponencia_Maestro;
import com.ug.producciones.cientificas.Servicios.Implementacion.MaestroService;
import com.ug.producciones.cientificas.Servicios.Implementacion.PonenciaMaestroService;
import com.ug.producciones.cientificas.Servicios.Implementacion.PonenciaService;

@RequestMapping("/api/ponencias")
@RestController
public class PonenciaController {
    private final PonenciaService ponenciaService;
    private final MaestroService maestroService;
    private final PonenciaMaestroService ponenciaMaestroService;

    @Autowired
    public PonenciaController(PonenciaService ponenciaService,MaestroService maestroService,PonenciaMaestroService ponenciaMaestroService) {
        this.ponenciaService = ponenciaService;
        this.maestroService = maestroService;
        this.ponenciaMaestroService = ponenciaMaestroService;
    }

    @PostMapping()
    public ResponseEntity<Object> crearPonencia(@Valid @RequestBody Ponencia ponencia, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Revise los campos e intente nuevamente", HttpStatus.BAD_REQUEST);
            
            try {
                 this.ponenciaService.guardarPonencia(ponencia).get();
            } catch (Exception e) {
                return new ResponseEntity<>("Error: El campo ponencia no puede estar vacío"+e.getMessage(), HttpStatus.BAD_REQUEST);
            }
          
        return new ResponseEntity<>("La ponencia se ha creado correctamente", HttpStatus.CREATED);
    }   

    @PostMapping("/asignarMaestro/{ponenciaId}")
    public ResponseEntity<Object> asignarMaestro( @RequestBody PonenciaMaestroDTO maestro,@PathVariable Long ponenciaId) throws InterruptedException, ExecutionException {
        
        Ponencia_Maestro ponencia_Maestro = new Ponencia_Maestro();

            try {
             Maestro maestroBD = this.maestroService.obtenerMaestroPorId(maestro.getIdMaestro()).get();
            
             Ponencia ponenciaBD = this.ponenciaService.obtenerPonenciaPorId(ponenciaId).get();
             
             ponencia_Maestro.setPonencia(ponenciaBD);
             ponencia_Maestro.setMaestro(maestroBD);
             ponencia_Maestro.setParticipacion(maestro.getParticipacion());

            this.ponenciaMaestroService.guardarPonenciaMaestro(ponencia_Maestro); 

            } catch (Exception e) {
                return new ResponseEntity<>("Error:"+e.getMessage(), HttpStatus.BAD_REQUEST);
            }
          
        return new ResponseEntity<>("El maestro se ha asignado correctamente", HttpStatus.CREATED);
    }   

    @DeleteMapping("{id}")
    public ResponseEntity<Object> eliminarPonencia(@PathVariable Long id) {
            
        try {
            this.ponenciaService.eliminarPonencia(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Error:No encontró ningún articulo con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>("articulo eliminado correctamente", HttpStatus.OK);
}

    @GetMapping()
    public ResponseEntity<Object> obtenerPonencias() {
            List<Ponencia> ponencias = new ArrayList<>(); 
            try {
                ponencias = this.ponenciaService.obtenerPonencias().get();
            } catch (Exception e) {
                return new ResponseEntity<>("Error"+e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
          
        return new ResponseEntity<>(ponencias, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> obtenerPonenciaPorId(@PathVariable Long id) {
        Ponencia ponencia = new Ponencia(); 
        try {
            ponencia = this.ponenciaService.obtenerPonenciaPorId(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Error no existe ningun articulo con ese id", HttpStatus.BAD_REQUEST);
        }
      
    return new ResponseEntity<>(ponencia, HttpStatus.OK);
    }




}
