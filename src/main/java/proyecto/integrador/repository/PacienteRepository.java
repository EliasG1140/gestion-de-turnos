package proyecto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.integrador.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
