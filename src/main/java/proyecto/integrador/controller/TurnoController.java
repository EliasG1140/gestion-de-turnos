package proyecto.integrador.controller;

import proyecto.integrador.entity.Turno;
import proyecto.integrador.exceptions.ResourceNotFoundException;
import proyecto.integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService service;

    @PostMapping("/crear")
    public Turno crearTurno(@RequestBody Turno turno){return service.crear(turno);}

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id){
        if(service.buscar(id).isPresent()){return ResponseEntity.ok(service.buscar(id).get());}
        else{return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    @GetMapping
    public List<Turno> listarTurnos(){return service.listar();}

    @PutMapping
    public Turno actualizarTurno(@RequestBody Turno turno){return service.actualizar(turno);}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se elimino el turno correctamente");
    }
}
