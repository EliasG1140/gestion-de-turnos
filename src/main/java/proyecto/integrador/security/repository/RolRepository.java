package proyecto.integrador.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.integrador.security.entity.Rol;
import proyecto.integrador.security.enums.RolNombre;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
