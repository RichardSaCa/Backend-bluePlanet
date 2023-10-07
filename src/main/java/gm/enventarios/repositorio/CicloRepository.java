package gm.enventarios.repositorio;

import gm.enventarios.modelo.CicloEntity;
import gm.enventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CicloRepository extends JpaRepository<CicloEntity,Integer> {
}
