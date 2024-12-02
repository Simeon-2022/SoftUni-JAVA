package bg.softuni.bookshop.service.implementations;

import bg.softuni.bookshop.data.entities.Author;
import bg.softuni.bookshop.data.entities.Book;
import bg.softuni.bookshop.data.repositories.AuthorRepository;
import bg.softuni.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_PATH = "src/main/resources/Files/authors.txt";
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {
                    String firstName = line.split("\\s+")[0];
                    String lastName = line.split("\\s+")[1];
                    Author author = new Author(firstName, lastName);

                    authorRepository.saveAndFlush(author);
                });
        System.out.printf("Count of imported Authors - %d%n", this.authorRepository.count());

    }

    @Override
    public boolean areAuthorsImported() {
        return authorRepository.count() > 0;
    }

    @Override
    public Author getRandomAuthor() {
        long id = ThreadLocalRandom.current().nextLong(1, this.authorRepository.count() + 1);
        Optional<Author> byId = authorRepository.findById(id);

        return byId.orElse(null);
    }

    @Override
    public void printAllAuthorsWithOneBookBefore1990() {
        this.authorRepository.findAllByBooksReleaseDateIsBefore(LocalDate.of(1990, 01, 01))
                .forEach(author ->
                                System.out.println("\t" + author.getFirstName() + " " + author.getLastName() + " "
                                        + author.getBooks().size())
                        //  String.join(System.lineSeparator() + "-> ", author.getBooks().stream().map(Book::getTitle).toList()))
                );
    }

    @Override
    public void printAllAuthorsWithDecsCount() {
        this.authorRepository.findAllByOrderByBooksDesc().
                stream()
                .sorted(Comparator.comparingInt((Author author) -> author.getBooks().size()).reversed())
                .forEach(author ->
                        System.out.println(author.getFirstName() + " " + author.getLastName() + " " + author.getBooks().size()));
    }

    @Override
    public Author getAuthorByFirstAndLastName() {
       return this.authorRepository.findAuthorByFirstNameAndLastName("George", "Powell");

    }
}
