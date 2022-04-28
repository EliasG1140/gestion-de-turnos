package proyecto.integrador.service;

import lombok.extern.slf4j.Slf4j;
import proyecto.integrador.entity.Turno;
import proyecto.integrador.exceptions.ResourceNotFoundException;
import proyecto.integrador.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class TurnoService {

    @Autowired
    TurnoRepository repository;

    public Turno crear(Turno turno){return repository.save(turno);}
    public Optional<Turno> buscar(Long id){
        return repository.findById(id);
    }
    public List<Turno> listar(){return repository.findAll();}
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Turno>turnoBuscado=buscar(id);
        if(turnoBuscado.isPresent()){repository.deleteById(id);}
        else{throw new ResourceNotFoundException("No existe el turno con el id= "+id+". Ingresar un id correcto");}
    }
    public Turno actualizar(Turno turno) {
        if(buscar(turno.getId()).isPresent()){return repository.save(turno);}
        else{return null;}
    }
}
