package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
