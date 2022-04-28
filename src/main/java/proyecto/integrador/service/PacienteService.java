package proyecto.integrador.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proyecto.integrador.entity.Paciente;
import proyecto.integrador.exceptions.ResourceNotFoundException;
import proyecto.integrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class PacienteService {

    private final static Logger logger = LoggerFactory.getLogger(PacienteService.class);

    @Autowired
    PacienteRepository repository;

    public Paciente crear(Paciente paciente){
        log.info("Paciente creado correctamente");
        return repository.save(paciente);
    }
    public Optional<Paciente> buscar(Long id){return repository.findById(id);}
    public List<Paciente> listar(){return repository.findAll();}
    public Paciente actualizar(Paciente paciente){
        log.info("Paciente actualizado correctamente");
        if(buscar(paciente.getId()).isPresent()){return repository.save(paciente);}
        else {
            log.error("Error al actualizar Paciente");
            return null;
        }
    }
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado=buscar(id);
        if (pacienteBuscado.isPresent()){
            log.info("Paciente eliminado correctamente");
            repository.deleteById(id);
        }
        else {
            log.error("Error al intentar eliminar el Paciente con id ="+id);
            throw new ResourceNotFoundException("No existe el paciente con el id="+id+". Ingresar un id correcto");
        }
    }

}
