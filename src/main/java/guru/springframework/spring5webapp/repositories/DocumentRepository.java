package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
