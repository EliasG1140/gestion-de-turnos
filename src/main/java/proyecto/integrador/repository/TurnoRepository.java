package proyecto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.integrador.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno,Long> {
}
