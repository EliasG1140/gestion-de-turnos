package proyecto.integrador.controller;

import proyecto.integrador.entity.Domicilio;
import proyecto.integrador.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService service;

    @GetMapping
    public List<Domicilio> listarDomicilios(){return service.listarDomicilios();}

    @PostMapping("/crear")
    public Domicilio crearDomicilio(@RequestBody Domicilio domicilio){return service.crearDomicilio(domicilio);}
}
