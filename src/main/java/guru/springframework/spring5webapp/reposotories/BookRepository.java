package guru.springframework.spring5webapp.reposotories;

import guru.springframework.spring5webapp.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
