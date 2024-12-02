package bg.softuni.bookshop.service;

import java.io.IOException;

public interface BookService {
    void seedBooks() throws IOException;

    boolean areBooksImported();

    void printAllBooksAfterYear2000();

    void printAllBooksFromAuthorByReleaseDateDecsAndTitleAsc();

    void printAllBooksFromGeorgeReleaseDateDecsAndTitleAsc();
}
