package proyecto.integrador.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import proyecto.integrador.entity.Paciente;
import proyecto.integrador.exceptions.ResourceNotFoundException;
import proyecto.integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping("/crear")
    public Paciente crearPaciente(@RequestBody Paciente paciente){return service.crear(paciente);}

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarOdontologo(@PathVariable Long id){
        if(service.buscar(id).isPresent()){ return ResponseEntity.ok(service.buscar(id).get());}
        else{ return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
    }

    @GetMapping
    public List<Paciente> listarPaciente(){return service.listar();}

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){ return service.actualizar(paciente);}

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se elimino el paciente correctamente.");
    }
}
