package proyecto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.integrador.entity.Odontologo;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
