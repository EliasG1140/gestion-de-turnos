package proyecto.integrador.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import proyecto.integrador.entity.Domicilio;
import proyecto.integrador.entity.Odontologo;
import proyecto.integrador.entity.Paciente;
import proyecto.integrador.entity.Turno;
import proyecto.integrador.security.entity.Rol;
import proyecto.integrador.security.entity.Usuario;
import proyecto.integrador.security.enums.RolNombre;
import proyecto.integrador.security.service.RolService;
import proyecto.integrador.security.service.UsuarioService;
import proyecto.integrador.service.OdontologoService;
import proyecto.integrador.service.PacienteService;
import proyecto.integrador.service.TurnoService;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class CargarData implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Autowired
    UsuarioService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    OdontologoService odontologoService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    TurnoService turnoService;

    @Override
    public void run(String... args) throws Exception {
        // Roles
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);

        // Usuario Administrador
        Set<Rol> roles = new HashSet<>();
        String pass = passwordEncoder.encode("123");
        Usuario admin = new Usuario("Elias", "admin", "admin@admin.com", pass);
        Usuario user = new Usuario("Rodo", "user", "user@user.com", pass);

        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        user.setRoles(roles);
        userService.save(user);

        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        admin.setRoles(roles);
        userService.save(admin);

        // Crear Odontologo
        Odontologo odon = new Odontologo("Doctor","Manitas","AV0123");
        odontologoService.crear(odon);

        // Crear paciente
        Domicilio dom = new Domicilio("Calle",45,"Barranquilla","Colombia");
        Paciente paciente = new Paciente("Torres","Sufrido","sufrido@gmail.com",100001, LocalDate.of(2022, 04, 05),dom);
        pacienteService.crear(paciente);

        // Crear Turno
        Turno turno = new Turno(LocalDate.of(2022,05,20),paciente,odon);
        turnoService.crear(turno);

    }
}
