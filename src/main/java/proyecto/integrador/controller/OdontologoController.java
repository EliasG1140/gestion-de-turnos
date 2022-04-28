package proyecto.integrador.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import proyecto.integrador.entity.Odontologo;
import proyecto.integrador.exceptions.ResourceNotFoundException;
import proyecto.integrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public Odontologo crearOdontologo(@RequestBody Odontologo odontologo){return service.crear(odontologo);}

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id){
        if(service.buscar(id).isPresent()){ return ResponseEntity.ok(service.buscar(id).get());}
        else{ return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
    }

    @GetMapping
    public List<Odontologo> listarOdontologos(){return service.listar();}

    @PutMapping
    public Odontologo actualizarPaciente(@RequestBody Odontologo odontologo){ return service.actualizar(odontologo);}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se elimino el odontologo sin problemas");
    }
}
