package proyecto.integrador.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proyecto.integrador.entity.Odontologo;
import proyecto.integrador.exceptions.ResourceNotFoundException;
import proyecto.integrador.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j
public class OdontologoService {

    private final static Logger logger = LoggerFactory.getLogger(OdontologoService.class);

    @Autowired
    OdontologoRepository repository;

    public Odontologo crear(Odontologo odontologo){
        log.info("Odontologo creado correctamente");
        return repository.save(odontologo);
    }
    public Optional<Odontologo> buscar(Long id){
        return repository.findById(id);
    }
    public List<Odontologo> listar(){return repository.findAll();}
    public Odontologo actualizar(Odontologo odontologo){
        if (buscar(odontologo.getId()).isPresent()){
            log.info("Odontologo actualizado correctamente");
            return repository.save(odontologo);
        }
        else {
            log.error("Error al actualizar Odontologo");
            return null;
        }

    }
    public void eliminar(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado=buscar(id);
        if (odontologoBuscado.isPresent()){
            log.info("Odontologo eliminado correctamente");
            repository.deleteById(id);
        }
        else {
            log.error("Error al intentar eliminar el Odontologo con id ="+id);
            throw new ResourceNotFoundException("No existe el odontologo con el id="+id+". Ingresar un id correcto");
        }
    }

}
