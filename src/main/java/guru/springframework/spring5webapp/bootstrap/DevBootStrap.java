package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.entities.Author;
import guru.springframework.spring5webapp.entities.Book;
import guru.springframework.spring5webapp.entities.Publisher;
import guru.springframework.spring5webapp.reposotories.AuthorRepository;
import guru.springframework.spring5webapp.reposotories.BookRepository;
import guru.springframework.spring5webapp.reposotories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setPublisherName("PEARSON");
        publisher.setPublisherAddress("New York");

        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        /*rod.setFirstName("Rod");
        rod.setLastName("Johnson");*/

        Book spring = new Book("Spring 5", "252586484960", publisher);
        /*spring.setTitle("Spring 5");
        spring.setIsbn("21654");
        spring.setPublisher("McGrawHills");
*/
        rod.getBooks().add(spring);
        spring.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(spring);


        Author James = new Author("James", "Gosling");
        /*rod.setFirstName("Rod");
        rod.setLastName("Johnson");*/

        Book java = new Book("Java", "21651346465", publisher);

        /*Author James = new Author();
        rod.setFirstName("James");
        rod.setLastName("Gosling");

        Book java = new Book();
        java.setTitle("Java");
        java.setIsbn("21653546335");
        java.setPublisher("Sun Microsystem");*/

        rod.getBooks().add(java);
        java.getAuthors().add(James);

        authorRepository.save(James);
        bookRepository.save(java);


    }


}
