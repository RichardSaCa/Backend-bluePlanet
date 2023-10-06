package gm.enventarios.repositorio;

import gm.enventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
//capa de acceso a datos
public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {
}
