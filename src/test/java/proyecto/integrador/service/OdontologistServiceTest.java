package proyecto.integrador.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import proyecto.integrador.entity.Odontologo;
import proyecto.integrador.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.MethodName.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class OdontologistServiceTest {

    private final static Logger logger = LoggerFactory.getLogger(OdontologistServiceTest.class);

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void a_cargarOdontologo(){
        logger.info("YO CARO");
        odontologoService.crear(new Odontologo("Elias","Garcia","AB0111"));
    }

    @Test
    public void b_listarOdontologos(){
        logger.info("YO LISTO");
        Assert.assertNotNull(odontologoService.listar());}

    @Test
    public void c_buscarOdontologo(){
        logger.info("YO BUSCO");
        Assert.assertNotNull(odontologoService.buscar(1l));}

    @Test
    public void d_eliminarOdontologo() throws ResourceNotFoundException {
        logger.info("YO ELIMINO");
        Odontologo odontologo = odontologoService.crear(new Odontologo("Elias","Garcia","AB0111"));
        odontologoService.eliminar(odontologo.getId());
        Assert.assertFalse(odontologoService.buscar(odontologo.getId()).isPresent());
    }
}