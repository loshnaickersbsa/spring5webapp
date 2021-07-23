package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


//Spring data JPA will provide the implementation for these
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
