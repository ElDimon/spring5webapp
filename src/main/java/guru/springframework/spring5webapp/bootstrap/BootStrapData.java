package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepositoty) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepositoty;
    }

    @Override
    public void run(String... args) throws Exception {

            Author dmitry = new Author("Dmitry","Bandrovskyy");
            Book neverwritten  = new Book("Never Written Book", "11233345");

            dmitry.getBooks().add(neverwritten);
            neverwritten.getAuthors().add(dmitry);

            authorRepository.save(dmitry);
            bookRepository.save(neverwritten);

            Author rod = new Author("Rod","Johnson");
            Book noEjb  = new Book("J2EE Development", "34242424");
            Publisher nova = new Publisher("Nova Printing", "Neverland, 3");

            dmitry.getBooks().add(noEjb);
            neverwritten.getAuthors().add(rod);

            authorRepository.save(rod);
            bookRepository.save(noEjb);

            System.out.println("Started in BootStrap");
            System.out.println("Number of books:" + bookRepository.count());


    }
}
