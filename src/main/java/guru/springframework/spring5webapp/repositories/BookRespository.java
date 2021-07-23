package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

//Spring data JPA will provide the implementation for these
public interface BookRespository extends CrudRepository<Book, Long> {
}
