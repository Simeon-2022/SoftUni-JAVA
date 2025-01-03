package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findTitlesByAgeRestriction(String input) {

        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());

        return bookRepository.findByAgeRestrictionIs(ageRestriction).stream().map(Book::getTitle).toList();
    }

    @Override
    public List<String> findByGoldEditionTypeAndLessThan5000Copies() {

        return bookRepository
                .findByEditionTypeAndCopiesLessThan(EditionType.GOLD , 5000)
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    public List<String> findByPrice() {
        return bookRepository
                .findByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream()
                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .toList();
    }

    @Override
    public List<String> findBooksNoInReleaseDateRange(int year) {

        LocalDate before = LocalDate.of(year,01,01);
        LocalDate after = LocalDate.of(year,12,31);

        return bookRepository
                .findByReleaseDateBeforeOrReleaseDateAfter(before, after)
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    @Transactional
    public List<String> findBooksBeforeReleaseDate(String date) {
        int year = Integer.parseInt(date.split("-")[2]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[0]);

      //  LocalDate before = LocalDate.of(year,month,day);
        LocalDate before = LocalDate.parse(date, DateTimeFormatter.ofPattern( "dd-MM-yyyy"));

        return bookRepository.findByReleaseDateBefore(before)
                .stream()
                .map(book -> String.format("%s %s %.2f", book.getTitle(), book.getEditionType() , book.getPrice()))
                .toList();
    }

    @Override
    public List<String> findByTitleContainingAString(String string) {
        return bookRepository.findByTitleContainingIgnoreCase(string).stream().map(Book::getTitle).toList();
    }

    @Override
    public List<String> findByAuthorWithLastNameStarting(String string) {
        return bookRepository.findByAuthorLastNameStartingWith(string)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName())).toList();
    }

    @Override
    public int countBookWithTitleLongerThan(int length) {
        return bookRepository.countBooksByTitleIsLongerThan(length);
    }

    @Override
    public BookInfo findBookWithSelectedFields(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public int addCopiesToBooksWithReleaseDateAfter(LocalDate dateAfter, int copiesToAdd) {
        return bookRepository.updateAllBooksByCopies(dateAfter,copiesToAdd);
    }

    @Override
    public int deleteBooksWithCopiesLessThan(int copies) {
        return bookRepository.deleteBookByCopiesLessThan(copies);
    }


}
