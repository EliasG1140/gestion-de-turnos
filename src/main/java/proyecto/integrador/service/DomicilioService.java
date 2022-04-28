package proyecto.integrador.service;

import lombok.extern.slf4j.Slf4j;
import proyecto.integrador.entity.Domicilio;
import proyecto.integrador.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class DomicilioService {

    @Autowired
    DomicilioRepository repository;

    public Domicilio crearDomicilio(Domicilio domicilio){return repository.save(domicilio);}

    public List<Domicilio> listarDomicilios(){return repository.findAll();}
}
