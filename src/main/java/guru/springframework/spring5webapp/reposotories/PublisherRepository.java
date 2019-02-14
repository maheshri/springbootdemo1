package guru.springframework.spring5webapp.reposotories;

import guru.springframework.spring5webapp.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
