package bg.softuni.bookshop.service.implementations;

import bg.softuni.bookshop.data.entities.Author;
import bg.softuni.bookshop.data.entities.Book;
import bg.softuni.bookshop.data.entities.enums.AgeRestriction;
import bg.softuni.bookshop.data.entities.enums.EditionType;
import bg.softuni.bookshop.data.repositories.BookRepository;
import bg.softuni.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_PATH = "src/main/resources/Files/books.txt";
    private final BookRepository bookRepository;
    private final AuthorServiceImpl authorServiceImpl;
    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorServiceImpl authorServiceImpl, CategoryServiceImpl categoryServiceImpl) {
        this.bookRepository = bookRepository;
        this.authorServiceImpl = authorServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
    }


    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {
                    String[] dataLine = line.split("\\s+");

                    String title =  Arrays.stream(dataLine).skip(5).collect(Collectors.joining(" "));
                    EditionType editionType = EditionType.values()[Integer.parseInt(dataLine[0])];
                    BigDecimal price = BigDecimal.valueOf(Double.parseDouble(dataLine[3]));
                    LocalDate releaseDate = LocalDate.parse(dataLine[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(dataLine[4])];
                    int copies = Integer.parseInt(dataLine[2]);

                    Book book = new Book(title, editionType, price, releaseDate, ageRestriction,copies);

                    book.setAuthor( authorServiceImpl.getRandomAuthor());
                    book.setCategories(categoryServiceImpl.getRandomCategory());
                    //book.setDescription("");

                    bookRepository.saveAndFlush(book);
                });
        System.out.printf("Count of imported Books - %d%n", this.bookRepository.count());
    }

    @Override
    public boolean areBooksImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void printAllBooksAfterYear2000() {
        this.bookRepository.findBookByReleaseDateIsAfter(LocalDate.of(2000,12,31))
                .forEach(book -> System.out.println(book.getTitle()));
    }

    @Override
    public void printAllBooksFromAuthorByReleaseDateDecsAndTitleAsc() {
        Author author = this.authorServiceImpl.getAuthorByFirstAndLastName();
        this.bookRepository
                .findAllByAuthorIsOrderByReleaseDateDescTitleAsc(author)
                .forEach(book ->
                        System.out.printf("%s %s %d%n", book.getTitle(), book.getReleaseDate(), book.getCopies()));
    }

    @Override
    public void printAllBooksFromGeorgeReleaseDateDecsAndTitleAsc() {
        this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
                .forEach(book ->
                        System.out.printf("%s %s %d%n", book.getTitle(), book.getReleaseDate(), book.getCopies()));
    }
}
