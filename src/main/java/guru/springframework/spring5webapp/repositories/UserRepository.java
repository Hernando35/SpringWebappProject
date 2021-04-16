package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
