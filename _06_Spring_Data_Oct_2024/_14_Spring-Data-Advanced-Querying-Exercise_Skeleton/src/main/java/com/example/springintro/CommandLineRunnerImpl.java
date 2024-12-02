package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInfo;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BookRepository bookRepository) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // seedData();
        // zad_01_(scanner);
        // zad_02_();
        // zad_03_();
        // zad_04_(scanner);
        // zad_05_(scanner);
        // zad_06_(scanner);
        // zad_07_(scanner);
        // zad_08_(scanner);
        // zad_09_(scanner);
        // zad_10_();
        // zad_10v2_();
        // zad_11_(scanner);
        // zad_12_(scanner);
        // zad_13_(scanner);
        zad_14_(scanner);

    }

    private void zad_14_(Scanner scanner) {
        String[] name = scanner.nextLine().split(" ");

        int writtenBooks = authorService.findNumberOfBooksWrittenBy(name[0], name[1]);
        System.out.println(name[0] + " " + name[1] + " has written " + writtenBooks + " books");
    }

    private void zad_13_(Scanner scanner) {

        int copies = Integer.parseInt(scanner.nextLine());
        System.out.println(bookService.deleteBooksWithCopiesLessThan(copies));
    }

    private void zad_12_(Scanner scanner) {
        String date = scanner.nextLine();
        int copyCount = Integer.parseInt(scanner.nextLine());

        LocalDate dateAfter = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd MMM yyyy"));

        int booksUpdated = bookService.addCopiesToBooksWithReleaseDateAfter(dateAfter,copyCount);
        System.out.println(booksUpdated * copyCount);
    }

    private void zad_11_(Scanner scanner) {

        BookInfo bookInfo = bookService.findBookWithSelectedFields(scanner.nextLine());
        System.out.printf("%s %s %s %.2f%n",
                bookInfo.getTitle(),
                bookInfo.getEditionType().toString(),
                bookInfo.getAgeRestriction().toString(),
                bookInfo.getPrice());
    };

    private void zad_10v2_() {
        authorService.findAllAuthorsAndTheirBookCopySum()
                .forEach(a-> System.out.printf("%s - %d%n"
                        , a.getFullName(), a.getCopiesSum()));

    }

    private void zad_10_() {
        authorService.getAllAuthorsSortedByBookCopies().forEach(System.out::println);
    }

    private void zad_09_(Scanner scanner) {
        int charLength = Integer.parseInt(scanner.nextLine());

        System.out.println();
        System.out.printf("There are %d books with longer titles than %d symbols.%n",
                bookService.countBookWithTitleLongerThan(charLength),
                charLength);

    }

    private void zad_08_(Scanner scanner) {
        String string = scanner.nextLine();
        bookService.findByAuthorWithLastNameStarting(string).forEach(System.out::println);

    }

    private void zad_07_(Scanner scanner) {
        String string = scanner.nextLine();

        bookService.findByTitleContainingAString(string).forEach(System.out::println);
    }

    private void zad_06_(Scanner scanner) {

        String start = scanner.nextLine();

        authorService.getAllAuthorsStartingWith(start).forEach(author ->
                System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

    private void zad_05_(Scanner scanner) {
        String date = scanner.nextLine();

        bookService.findBooksBeforeReleaseDate(date).forEach(System.out::println);

    }

    private void zad_04_(Scanner scanner) {

        int year = Integer.parseInt(scanner.nextLine());

        bookService.findBooksNoInReleaseDateRange(year).forEach(System.out::println);

    }

    private void zad_03_() {
        bookService.findByPrice().forEach(System.out::println);
    }

    private void zad_02_() {

        bookService.findByGoldEditionTypeAndLessThan5000Copies().forEach(System.out::println);

    }

    private void zad_01_(Scanner scanner) {
        String input = scanner.nextLine();
        bookService
                .findTitlesByAgeRestriction(input)
                .forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
