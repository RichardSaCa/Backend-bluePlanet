package gm.enventarios.repositorio;

import gm.enventarios.modelo.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
